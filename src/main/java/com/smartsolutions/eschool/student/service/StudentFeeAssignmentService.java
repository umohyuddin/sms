package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeAssignmentDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.FeeAssignmentDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.StudentFeeAssignmentsResponseDTO;
import com.smartsolutions.eschool.student.dtos.studentDiscountAssignment.requestDto.StudentDiscountAssignmentRequestDTO;
import com.smartsolutions.eschool.student.model.FeeRateEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.model.StudentFeeAssignmentEntity;
import com.smartsolutions.eschool.student.model.StudentFeeSummaryEntity;
import com.smartsolutions.eschool.student.repository.*;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentFeeAssignmentService {


    private final StudentRepository studentRepository;
    private final FeeRateRepository feeRateRepository;
    private final StudentFeeAssignmentRepository studentFeeAssignmentRepository;
    private final StudentFeeSummaryRepository studentFeeSummaryRepository;
    private final AcademicYearRepository academicYearRepository;
    private final StudentDiscountAssignmentService studentDiscountAssignmentService;

    public StudentFeeAssignmentService(StudentRepository studentRepository, FeeRateRepository feeRateRepository, StudentFeeAssignmentRepository studentFeeAssignmentRepository, StudentFeeSummaryRepository studentFeeSummaryRepository, AcademicYearRepository academicYearRepository, StudentDiscountAssignmentService studentDiscountAssignmentService) {
        this.studentRepository = studentRepository;
        this.feeRateRepository = feeRateRepository;
        this.studentFeeAssignmentRepository = studentFeeAssignmentRepository;
        this.studentFeeSummaryRepository = studentFeeSummaryRepository;
        this.academicYearRepository = academicYearRepository;

        this.studentDiscountAssignmentService = studentDiscountAssignmentService;
    }

    @Transactional
    public StudentFeeSummaryDTO assignStudentFee(Long studentId, @Valid StudentFeeAssignmentRequestDTO dto) {
        log.info("Assigning fees to studentId={} for academicYearId={} with components={}", studentId, dto.getAcademicYearId(), dto.getComponentIds());
        try {
            // Fetch student
            StudentEntity student = studentRepository.findById(studentId).orElseThrow(() -> {
                log.error("Student with id {} not found", studentId);
                return new ResourceNotFoundException("Student not found with id " + studentId);
            });

            // Fetch fee rates
            List<FeeRateEntity> feeRates = feeRateRepository.findApplicableFeeRatesForStudent(dto.getComponentIds(), dto.getCampusId(), dto.getStandardId(), dto.getAcademicYearId());

            if (feeRates.isEmpty()) {
                log.warn("No fee rates found for studentId={} and academicYearId={}", studentId, dto.getAcademicYearId());
                throw new ResourceNotFoundException("No fee rates available for the given criteria");
            }

            // Map fee rates to assignments
            List<StudentFeeAssignmentEntity> assignments = feeRates.stream().map(feeRate -> {
                StudentFeeAssignmentEntity assignment = new StudentFeeAssignmentEntity();
                assignment.setStudent(student);
                assignment.setFeeRate(feeRate);
                assignment.setTotalAmount(feeRate.getAmount().doubleValue());
                assignment.setAssignedDate(LocalDate.now());
                assignment.setDueDate(dto.getDueDate());
                return assignment;
            }).collect(Collectors.toList());

            List<StudentFeeAssignmentEntity> savedAssignments = studentFeeAssignmentRepository.saveAll(assignments);
            log.info("Saved {} fee assignments for studentId={}", savedAssignments.size(), studentId);

            // Total assigned fee
            Double totalAssigned = studentFeeAssignmentRepository.findTotalAssignedFee(studentId, dto.getAcademicYearId());
            log.debug("Total assigned fee for studentId={} is {}", studentId, totalAssigned);

            // Fetch academic year
            AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElseThrow(() -> {
                log.error("Current academic year not found");
                return new ResourceNotFoundException("Current academic year not found");
            });

            // Fetch existing summary or create new
            StudentFeeSummaryEntity summary = studentFeeSummaryRepository.findByStudentId(studentId).orElseGet(() -> {
                StudentFeeSummaryEntity s = new StudentFeeSummaryEntity();
                s.setStudent(student);
                s.setAcademicYear(currentYear);
                s.setTotalPaid(BigDecimal.ZERO);
                return s;
            });

            summary.setTotalAssignedFee(BigDecimal.valueOf(totalAssigned));
            summary.setBalance(summary.getTotalAssignedFee().subtract(summary.getTotalPaid()));

            StudentFeeSummaryEntity savedSummary = studentFeeSummaryRepository.save(summary);
            log.info("Saved StudentFeeSummaryEntity for studentId={} with totalAssignedFee={}", studentId, savedSummary.getTotalAssignedFee());

            StudentDiscountAssignmentRequestDTO requestDTO = new StudentDiscountAssignmentRequestDTO();
            requestDTO.setStudentId(studentId);
            requestDTO.setCampusId(dto.getCampusId());
            requestDTO.setDiscountRateId(dto.getDiscountComponentId());
            requestDTO.setAcademicYearId(dto.getAcademicYearId());
            if(dto.getDiscountComponentId() != null) {
                studentDiscountAssignmentService.assignDiscount(requestDTO);
            }

            return MapperUtil.mapObject(savedSummary, StudentFeeSummaryDTO.class);

        } catch (ResourceNotFoundException e) {
            // Already logged, rethrow to propagate
            throw e;
        } catch (Exception e) {
            log.error("Failed to assign fees for studentId={}", studentId, e);
            throw new RuntimeException("Failed to assign fees. Transaction rolled back.", e);
        }
    }

    public StudentFeeAssignmentsResponseDTO getFeeAssignmentByStudentId(Long studentId, Long academicYearId) {
        try {
            // Fetch assignments from repository
            List<StudentFeeAssignmentEntity> assignments = studentFeeAssignmentRepository.findAllByStudentAndAcademicYear(studentId, academicYearId);

            if (assignments.isEmpty()) {
                log.warn("No fee assignments found for studentId={} and academicYearId={}", studentId, academicYearId);
                throw new ResourceNotFoundException("No fee assignments found for studentId={" + studentId + "} and academicYearId={" + academicYearId + "}");
            }

//            // Map to DTO
//            //List<StudentFeeAssignmentDTO> assignmentDTOs = MapperUtil.mapList(assignments, StudentFeeAssignmentDTO.class);
//            ModelMapper modelMapper = new ModelMapper();
//
//            // Define custom mapping
//            modelMapper.addMappings(new PropertyMap<StudentFeeAssignmentEntity, StudentFeeAssignmentDTO>() {
//                @Override
//                protected void configure() {
//                    // Student info
//                    map().setStudentId(source.getStudent().getId());
//                    map().setFirstName(source.getStudent().getFirstName());
//                    map().setLastName(source.getStudent().getLastName());
//                    map().setFullName(source.getStudent().getFullName());
//
//                    // FeeRate & FeeComponent info
//                    map().setFeeRateId(source.getFeeRate().getId());
//                    map().setComponentId(source.getFeeRate().getFeeComponent().getId());
//                    map().setComponentName(source.getFeeRate().getFeeComponent().getComponentName());
//
//                    // Assignment info
//                    map().setAmount(source.getTotalAmount());
//                    map().setAssignedDate(source.getAssignedDate());
//                    map().setDueDate(source.getDueDate());
//                }
//            });
//            List<StudentFeeAssignmentDTO> assignmentDTOs = assignments.stream()
//                    .map(entity -> modelMapper.map(entity, StudentFeeAssignmentDTO.class))
//                    .collect(Collectors.toList());

            StudentEntity student = assignments.get(0).getStudent();

            List<FeeAssignmentDTO> feeList = assignments.stream()
                    .map(sf -> {
                        FeeAssignmentDTO dto = new FeeAssignmentDTO();
                        dto.setFeeRateId(sf.getFeeRate().getId());
                        dto.setComponentId(sf.getFeeRate().getFeeComponent().getId());
                        dto.setComponentName(sf.getFeeRate().getFeeComponent().getComponentName());
                        dto.setAmount(sf.getTotalAmount());
                        dto.setAssignedDate(sf.getAssignedDate());
                        dto.setDueDate(sf.getDueDate());
                        return dto;
                    })
                    .collect(Collectors.toList());

            StudentFeeAssignmentsResponseDTO responseDTO = new StudentFeeAssignmentsResponseDTO();
            responseDTO.setStudentId(student.getId());
            responseDTO.setFullName(student.getFullName());
            responseDTO.setFirstName(student.getFirstName());
            responseDTO.setLastName(student.getLastName());
            responseDTO.setFeeAssignments(feeList);
            log.info("Fetched fee assignments for studentId={}", studentId);

            return responseDTO;

        } catch (Exception e) {
            log.error("Failed to fetch fee assignments for studentId={} and academicYearId={}", studentId, academicYearId, e);
            throw new RuntimeException("Error occurred while fetching fee assignments.", e);
        }


    }


}
