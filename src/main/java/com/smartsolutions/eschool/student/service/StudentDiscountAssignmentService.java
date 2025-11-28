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
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class StudentDiscountAssignmentService {

    private final StudentDiscountAssignmentRepository assignmentRepository;
    private final StudentRepository studentRepository;
    private final DiscountRateRepository discountRateRepository;
    private final CampusRepository campusRepository;
    private final AcademicYearRepository academicYearRepository;

    public StudentDiscountAssignmentService(StudentDiscountAssignmentRepository assignmentRepository,
                                            StudentRepository studentRepository,
                                            DiscountRateRepository discountRateRepository,
                                            CampusRepository campusRepository,
                                            AcademicYearRepository academicYearRepository) {
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

            StudentDiscountAssignmentEntity entity = MapperUtil.mapObject(requestDTO, StudentDiscountAssignmentEntity.class);
            entity.setStudent(student);
            entity.setDiscountRate(discountRate);
            entity.setCampus(campus);
            entity.setAcademicYear(academicYear);
            entity.setId(null);
            assignmentRepository.save(entity);

            log.info("Successfully assigned discount, id: {}", entity.getId());
            return MapperUtil.mapObject(entity, StudentDiscountAssignmentResponseDTO.class);
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
        StudentDiscountAssignmentEntity entity = assignmentRepository.findByIdAndDeletedFalse(assignmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student discount assignment not found with id: " + assignmentId));
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
        StudentDiscountAssignmentEntity entity = assignmentRepository.findByIdAndDeletedFalse(assignmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student discount assignment not found with id: " + assignmentId));
        MapperUtil.mapObject(requestDTO, entity); // update fields from DTO
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
}
