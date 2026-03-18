package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.school.model.DiscountRateEntity;
import com.smartsolutions.eschool.school.repository.*;
import com.smartsolutions.eschool.student.dtos.studentDiscountAssignment.requestDto.StudentDiscountAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.studentDiscountAssignment.responseDto.StudentDiscountAssignmentResponseDTO;
import com.smartsolutions.eschool.student.model.StudentDiscountAssignmentEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.StudentDiscountAssignmentRepository;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class StudentDiscountAssignmentService {

    private final StudentDiscountAssignmentRepository assignmentRepository;
    private final StudentRepository studentRepository;
    private final DiscountRateRepository discountRateRepository;
    private final CampusRepository campusRepository;
    private final AcademicYearRepository academicYearRepository;

    public StudentDiscountAssignmentService(StudentDiscountAssignmentRepository assignmentRepository, StudentRepository studentRepository, DiscountRateRepository discountRateRepository, CampusRepository campusRepository, AcademicYearRepository academicYearRepository) {
        this.assignmentRepository = assignmentRepository;
        this.studentRepository = studentRepository;
        this.discountRateRepository = discountRateRepository;
        this.campusRepository = campusRepository;
        this.academicYearRepository = academicYearRepository;
    }

    // -------------------------------------------------------------------------
    // ASSIGN DISCOUNT
    // -------------------------------------------------------------------------
    @Transactional
    public StudentDiscountAssignmentResponseDTO assignDiscount(@Valid StudentDiscountAssignmentRequestDTO requestDTO) {
        log.info("Assigning discount to student: {}", requestDTO.getStudentId());
        try {
            StudentEntity student = studentRepository.findByIdAndDeletedFalse(requestDTO.getStudentId()).orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + requestDTO.getStudentId()));

            DiscountRateEntity discountRate = discountRateRepository.findById(requestDTO.getDiscountRateId()).orElseThrow(() -> new ResourceNotFoundException("Discount rate not found with id: " + requestDTO.getDiscountRateId()));

            CampusEntity campus = null;
            if (requestDTO.getCampusId() != null) {
                campus = campusRepository.findById(requestDTO.getCampusId()).orElseThrow(() -> new ResourceNotFoundException("Campus not found with id: " + requestDTO.getCampusId()));
            }

            AcademicYearEntity academicYear = academicYearRepository.findById(requestDTO.getAcademicYearId()).orElseThrow(() -> new ResourceNotFoundException("Academic year not found with id: " + requestDTO.getAcademicYearId()));


            StudentDiscountAssignmentEntity entity = new StudentDiscountAssignmentEntity();
            entity.setStudent(student);
            entity.setDiscountRate(discountRate);
            entity.setCampus(campus);
            entity.setAcademicYear(academicYear);
            entity.setAppliedAmount(requestDTO.getAppliedAmount());
            entity.setAppliedPercentage(requestDTO.getAppliedPercentage());
            entity.setReason(requestDTO.getReason());
            entity.setIsActive(true);
            entity.setDeleted(false);
            entity.setId(null);
            assignmentRepository.save(entity);


            log.info("Successfully assigned discount, id: {}", entity.getId());
            return mapToResponseDto(entity);
        } catch (DataAccessException dae) {
            log.error("Database error while assigning discount", dae);
            throw new CustomServiceException("Failed to assign discount due to database error");
        } catch (MappingException me) {
            log.error("Error mapping entity to DTO", me);
            throw new CustomServiceException("Error converting discount assignment data", me);
        } catch (Exception e) {
            log.error("Unexpected error while assigning discount", e);
            throw new CustomServiceException("Unexpected error occurred while assigning discount");
        }
    }


    @Transactional
    public StudentDiscountAssignmentResponseDTO updateDiscount(@Valid StudentDiscountAssignmentRequestDTO requestDTO) {
        log.info("Updating discount for student: {} for academicYearId={}", requestDTO.getStudentId(), requestDTO.getAcademicYearId());

        try {
            StudentEntity student = studentRepository.findByIdAndDeletedFalse(requestDTO.getStudentId())
                    .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + requestDTO.getStudentId()));

            DiscountRateEntity discountRate = discountRateRepository.findById(requestDTO.getDiscountRateId())
                    .orElseThrow(() -> new ResourceNotFoundException("Discount rate not found with id: " + requestDTO.getDiscountRateId()));

            CampusEntity campus = null;
            if (requestDTO.getCampusId() != null) {
                campus = campusRepository.findById(requestDTO.getCampusId())
                        .orElseThrow(() -> new ResourceNotFoundException("Campus not found with id: " + requestDTO.getCampusId()));
            }

            AcademicYearEntity academicYear = academicYearRepository.findById(requestDTO.getAcademicYearId())
                    .orElseThrow(() -> new ResourceNotFoundException("Academic year not found with id: " + requestDTO.getAcademicYearId()));

            // Check for existing discount assignment
            assignmentRepository
                    .findDiscountByAcademic_Campus_stundentId(student.getId(), academicYear.getId(), campus != null ? campus.getId() : null)
                    .ifPresent(existing -> {
                        log.info("Deleting existing discount assignment with id: {}", existing.getId());
                        assignmentRepository.delete(existing);
                    });

            // Create new assignment
            StudentDiscountAssignmentEntity entity = new StudentDiscountAssignmentEntity();
            entity.setStudent(student);
            entity.setDiscountRate(discountRate);
            entity.setCampus(campus);
            entity.setAcademicYear(academicYear);
            entity.setAppliedAmount(requestDTO.getAppliedAmount());
            entity.setAppliedPercentage(requestDTO.getAppliedPercentage());
            entity.setReason(requestDTO.getReason());
            entity.setIsActive(true);
            entity.setDeleted(false);
            entity.setId(null);

            assignmentRepository.save(entity);
            log.info("Successfully created discount assignment, id: {}", entity.getId());

            return mapToResponseDto(entity);

        } catch (DataAccessException dae) {
            log.error("Database error while updating discount", dae);
            throw new CustomServiceException("Failed to update discount due to database error");
        } catch (MappingException me) {
            log.error("Error mapping entity to DTO", me);
            throw new CustomServiceException("Error converting discount assignment data", me);
        } catch (Exception e) {
            log.error("Unexpected error while updating discount", e);
            throw new CustomServiceException("Unexpected error occurred while updating discount");
        }
    }

    // -------------------------------------------------------------------------
    // GET ALL ASSIGNMENTS
    // -------------------------------------------------------------------------
    public List<StudentDiscountAssignmentResponseDTO> getAll() {
        try {
            List<StudentDiscountAssignmentEntity> result = assignmentRepository.findAllDeletedFalse();
            return MapperUtil.mapList(result, StudentDiscountAssignmentResponseDTO.class);
        } catch (Exception e) {
            log.error("Error fetching all student discount assignments", e);
            throw new CustomServiceException("Failed to fetch student discount assignments");
        }
    }

    // -------------------------------------------------------------------------
    // GET BY ID
    // -------------------------------------------------------------------------
    public StudentDiscountAssignmentResponseDTO getById(Long assignmentId) {
        StudentDiscountAssignmentEntity entity = assignmentRepository.findByIdAndDeletedFalse(assignmentId).orElseThrow(() -> new ResourceNotFoundException("Student discount assignment not found with id: " + assignmentId));
        return MapperUtil.mapObject(entity, StudentDiscountAssignmentResponseDTO.class);
    }

    // -------------------------------------------------------------------------
    // GET BY STUDENT
    // -------------------------------------------------------------------------
    public List<StudentDiscountAssignmentResponseDTO> getByStudent(Long studentId) {
        List<StudentDiscountAssignmentEntity> result = assignmentRepository.findAllByStudent(studentId);
        return MapperUtil.mapList(result, StudentDiscountAssignmentResponseDTO.class);
    }

    // -------------------------------------------------------------------------
    // UPDATE ASSIGNMENT
    // -------------------------------------------------------------------------
    @Transactional
    public StudentDiscountAssignmentResponseDTO updateAssignment(Long assignmentId, @Valid StudentDiscountAssignmentRequestDTO requestDTO) {
        StudentDiscountAssignmentEntity entity = assignmentRepository.findByIdAndDeletedFalse(assignmentId).orElseThrow(() -> new ResourceNotFoundException("Student discount assignment not found with id: " + assignmentId));
        //MapperUtil.mapObject(requestDTO, entity); // update fields from DTO
        assignmentRepository.save(entity);
        return MapperUtil.mapObject(entity, StudentDiscountAssignmentResponseDTO.class);
    }

    // -------------------------------------------------------------------------
    // SOFT DELETE
    // -------------------------------------------------------------------------
    @Transactional
    public int softDelete(Long assignmentId) {
        return assignmentRepository.softDeleteById(assignmentId);
    }

    // -------------------------------------------------------------------------
    // SOFT DELETE ALL
    // -------------------------------------------------------------------------
    @Transactional
    public int softDeleteAll() {
        return assignmentRepository.softDeleteAll();
    }

    // -------------------------------------------------------------------------
    // ACTIVATE
    // -------------------------------------------------------------------------
    @Transactional
    public int markAsActive(Long assignmentId) {
        return assignmentRepository.markAsActive(assignmentId);
    }

    // -------------------------------------------------------------------------
    // DEACTIVATE
    // -------------------------------------------------------------------------
    @Transactional
    public int markAsInactive(Long assignmentId) {
        return assignmentRepository.markAsInactive(assignmentId);
    }

//    // -------------------------------------------------------------------------
//    // SEARCH
//    // -------------------------------------------------------------------------
//    public List<StudentDiscountAssignmentResponseDTO> search(String keyword) {
//        List<StudentDiscountAssignmentEntity> result = assignmentRepository.searchByKeyword(keyword);
//        return MapperUtil.mapList(result, StudentDiscountResponseDTO.class);
//    }

    @Transactional(readOnly = true)
    public List<StudentDiscountAssignmentResponseDTO> getAssignedDiscount(Long studentId, Long academicYearId) {
        try {
            // Fetch all discount assignments for the student & academic year
            List<StudentDiscountAssignmentEntity> assignments = assignmentRepository.findByStudentAndAcademicYear(studentId, academicYearId); // returns empty list if none
            return assignments.stream().map(this::mapToResponseDto).toList();
        } catch (Exception e) {
            log.error("Error fetching assigned discount for studentId={} and academicYearId={}", studentId, academicYearId, e);
            throw new CustomServiceException("Failed to fetch assigned discount");
        }
    }

    private StudentDiscountAssignmentResponseDTO mapToResponseDto(StudentDiscountAssignmentEntity sda) {
        StudentDiscountAssignmentResponseDTO dto = new StudentDiscountAssignmentResponseDTO();
        dto.setId(sda.getId());
        dto.setStudentId(sda.getStudent().getId());
        dto.setStudentName(sda.getStudent().getFirstName() + " " + sda.getStudent().getLastName());

        dto.setAppliedAmount(sda.getAppliedAmount());
        dto.setAppliedPercentage(sda.getAppliedPercentage());
        dto.setAssignmentActive(sda.getIsActive());
        dto.setReason(sda.getReason());
        dto.setCreatedAt(sda.getCreatedAt());

        // ===== Campus =====
        dto.setCampusId(sda.getCampus().getId());

        // ===== Academic Year =====
        dto.setAcademicYearId(sda.getAcademicYear().getId());
        dto.setAcademicYearName(sda.getAcademicYear().getName());

        // ===== Discount Rate =====
        var discountRate = sda.getDiscountRate();
        dto.setDiscountRateId(discountRate.getId());
        dto.setDiscountValue(discountRate.getValue());
        dto.setIsPercentage(discountRate.getIsPercentage());
        dto.setEffectiveFrom(discountRate.getEffectiveFrom());
        dto.setEffectiveTo(discountRate.getEffectiveTo());
        dto.setDiscountRateActive(discountRate.getIsActive());

        // ===== Discount Sub Type =====
        var subType = discountRate.getDiscountSubType();
        dto.setDiscountSubTypeId(subType.getId());
        dto.setDiscountSubTypeCode(subType.getCode());
        dto.setDiscountSubTypeName(subType.getName());
        dto.setDiscountSubTypeDisplayOrder(subType.getDisplayOrder());

        // ===== Discount Type =====
        var type = subType.getDiscountType();
        dto.setDiscountTypeId(type.getId());
        dto.setDiscountTypeCode(type.getCode());
        dto.setDiscountTypeName(type.getName());
        dto.setDiscountTypeDisplayOrder(type.getDisplayOrder());

        return dto;
    }


    @Transactional
    public void deleteDiscount(Long studentId, Long academicYearId, Long campusId) {
        try {
            assignmentRepository
                    .findDiscountByAcademic_Campus_stundentId(studentId, academicYearId, campusId)
                    .ifPresent(existing -> {
                        log.info("Deleting existing discount assignment with id={} for studentId={}, academicYearId={}, campusId={}",
                                existing.getId(), studentId, academicYearId, campusId);
                        assignmentRepository.delete(existing);
                    });
        } catch (DataAccessException dae) {
            log.error("Database error while deleting discount for studentId={}, academicYearId={}, campusId={}", studentId, academicYearId, campusId, dae);
            throw new CustomServiceException("Failed to delete discount due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while deleting discount for studentId={}, academicYearId={}, campusId={}", studentId, academicYearId, campusId, e);
            throw new CustomServiceException("Unexpected error occurred while deleting discount");
        }
    }

}
