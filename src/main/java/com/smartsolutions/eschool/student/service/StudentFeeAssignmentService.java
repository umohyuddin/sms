package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.FeeAssignmentDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.StudentFeeAssignmentsResponseDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentFeeAssignmentFlatDTO;
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


    public boolean isFeeAssigned(Long studentId, Long academicYearId) {
        try {
            boolean exists = studentFeeAssignmentRepository.isFeeAssigned(studentId, academicYearId);
            log.info("Fee assigned check for studentId={} and academicYearId={}: {}", studentId, academicYearId, exists);
            return exists;
        } catch (Exception e) {
            log.error("Error checking fee assignment for studentId={} and academicYearId={}", studentId, academicYearId, e);
            throw new RuntimeException("Failed to check fee assignment.", e);
        }
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
            // Fetch academic year
            AcademicYearEntity academicYear = academicYearRepository.findById(dto.getAcademicYearId()).orElseThrow(() -> new ResourceNotFoundException("Academic year not found with id " + dto.getAcademicYearId()));

            long totalMonths = academicYear.getTotalMonths();

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

                // Calculate total amount based on recurrence
                String recurrenceRule = feeRate.getFeeComponent().getFeeCatalog().getRecurrenceRule();
                double baseAmount = feeRate.getAmount().doubleValue();
                double totalAmount = baseAmount * getRecurrenceMultiplier(recurrenceRule, (int) totalMonths);

                assignment.setTotalAmount(totalAmount);
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
            if (dto.getDiscountComponentId() != null) {
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

    @Transactional
    public StudentFeeSummaryDTO updateStudentFee(Long studentId, @Valid StudentFeeAssignmentRequestDTO dto) {
        log.info("Updating fees for studentId={} for academicYearId={} with components={}",
                studentId, dto.getAcademicYearId(), dto.getComponentIds());

        try {
            // Fetch student
            StudentEntity student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));

            // Fetch academic year
            AcademicYearEntity academicYear = academicYearRepository.findById(dto.getAcademicYearId())
                    .orElseThrow(() -> new ResourceNotFoundException("Academic year not found with id " + dto.getAcademicYearId()));

            long totalMonths = academicYear.getTotalMonths();

            // Fetch existing assignments for the student and academic year
            List<StudentFeeAssignmentEntity> existingAssignments = studentFeeAssignmentRepository
                    .findAssignedFeesForStudentAndYear(studentId, dto.getAcademicYearId());

            // Delete or adjust existing assignments if needed
            if (!existingAssignments.isEmpty()) {
                log.info("Deleting {} existing assignments for studentId={}", existingAssignments.size(), studentId);
                studentFeeAssignmentRepository.deleteAll(existingAssignments);
            }

            // Fetch fee rates for update
            List<FeeRateEntity> feeRates = feeRateRepository.findApplicableFeeRatesForStudent(
                    dto.getComponentIds(), dto.getCampusId(), dto.getStandardId(), dto.getAcademicYearId());

            if (feeRates.isEmpty()) {
                log.warn("No fee rates found for studentId={} and academicYearId={}", studentId, dto.getAcademicYearId());
                throw new ResourceNotFoundException("No fee rates available for the given criteria");
            }

            // Map fee rates to new assignments
            List<StudentFeeAssignmentEntity> updatedAssignments = feeRates.stream().map(feeRate -> {
                StudentFeeAssignmentEntity assignment = new StudentFeeAssignmentEntity();
                assignment.setStudent(student);
                assignment.setFeeRate(feeRate);

                String recurrenceRule = feeRate.getFeeComponent().getFeeCatalog().getRecurrenceRule();
                double baseAmount = feeRate.getAmount().doubleValue();
                double totalAmount = baseAmount * getRecurrenceMultiplier(recurrenceRule, (int) totalMonths);

                assignment.setTotalAmount(totalAmount);
                assignment.setAssignedDate(LocalDate.now());
                assignment.setDueDate(dto.getDueDate());
                return assignment;
            }).collect(Collectors.toList());

            List<StudentFeeAssignmentEntity> savedAssignments = studentFeeAssignmentRepository.saveAll(updatedAssignments);
            log.info("Saved {} updated fee assignments for studentId={}", savedAssignments.size(), studentId);

            // Update summary
            Double totalAssigned = studentFeeAssignmentRepository.findTotalAssignedFee(studentId, dto.getAcademicYearId());

            StudentFeeSummaryEntity summary = studentFeeSummaryRepository.findByStudentId(studentId)
                    .orElseThrow(() -> new ResourceNotFoundException("Fee summary not found for studentId " + studentId));

            summary.setTotalAssignedFee(BigDecimal.valueOf(totalAssigned));
            summary.setBalance(summary.getTotalAssignedFee().subtract(summary.getTotalPaid()));

            StudentFeeSummaryEntity savedSummary = studentFeeSummaryRepository.save(summary);
            log.info("Updated StudentFeeSummaryEntity for studentId={} with totalAssignedFee={}", studentId, savedSummary.getTotalAssignedFee());

            // ====== Handle discount assignment update ======
            StudentDiscountAssignmentRequestDTO discountRequest = new StudentDiscountAssignmentRequestDTO();
            discountRequest.setStudentId(studentId);
            discountRequest.setCampusId(dto.getCampusId());
            discountRequest.setDiscountRateId(dto.getDiscountComponentId());
            discountRequest.setAcademicYearId(dto.getAcademicYearId());

            if (dto.getDiscountComponentId() != null) {
                log.info("Updating discount for studentId={} with discountComponentId={}", studentId, dto.getDiscountComponentId());
                studentDiscountAssignmentService.updateDiscount(discountRequest); // can handle update internally
            }else { log.info("No discount selected, deleting existing discount for studentId={} and academicYearId={}", studentId, dto.getAcademicYearId());

            // delete existing discount if any
            studentDiscountAssignmentService.deleteDiscount(studentId, dto.getAcademicYearId(), dto.getCampusId());
        }

            return MapperUtil.mapObject(savedSummary, StudentFeeSummaryDTO.class);

        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Failed to update fees for studentId={}", studentId, e);
            throw new RuntimeException("Failed to update fees. Transaction rolled back.", e);
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


            StudentEntity student = assignments.get(0).getStudent();

            List<FeeAssignmentDTO> feeList = assignments.stream().map(sf -> {
                FeeAssignmentDTO dto = new FeeAssignmentDTO();
                dto.setFeeRateId(sf.getFeeRate().getId());
                dto.setComponentId(sf.getFeeRate().getFeeComponent().getId());
                dto.setComponentName(sf.getFeeRate().getFeeComponent().getComponentName());
                dto.setAmount(sf.getTotalAmount());
                dto.setAssignedDate(sf.getAssignedDate());
                dto.setDueDate(sf.getDueDate());
                return dto;
            }).collect(Collectors.toList());

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

    public Double getTotalFeeAssigned(Long academicYearId) {
        if (academicYearId == null) {
            // Fetch academic year
            AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElseThrow(() -> {
                log.error("Current academic year not found");
                return new ResourceNotFoundException("Current academic year not found");
            });
            academicYearId = currentYear.getId();
        }
        return studentFeeAssignmentRepository.getTotalFeeAssigned(academicYearId);
    }

    public int getRecurrenceMultiplier(String rule, int totalMonths) {
        if (rule == null) return 1;

        switch (rule.toUpperCase()) {
            case "ONE_TIME":
                return 1;
            case "MONTHLY":
                return totalMonths; // usually 12 or as per AcademicYearEntity
            case "BI_MONTHLY":
                return totalMonths / 2; // every 2 months
            case "QUARTERLY":
                return totalMonths / 4; // every 3 months
            case "HALF_YEARLY":
                return totalMonths / 2; // 2 times a year
            case "YEARLY":
                return 1;
            default:
                return 1; // fallback to 1
        }
    }


    public List<StudentFeeAssignmentFlatDTO> getAssignedFeesForStudent(Long studentId, Long academicYearId) {
        try {
            // Fetch assignments using repository with JOIN FETCH for all related entities
            List<StudentFeeAssignmentEntity> assignments =
                    studentFeeAssignmentRepository.findAssignedFeesForStudentAndYear(studentId, academicYearId);

            if (assignments.isEmpty()) {
                log.warn("No fee assignments found for studentId={} and academicYearId={}", studentId, academicYearId);
                return List.of();
            }

            // Map entities to flat DTOs
            return assignments.stream()
                    .map(this::toFlatDTO)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            log.error("Failed to fetch assigned fees for studentId={} and academicYearId={}", studentId, academicYearId, e);
            throw new RuntimeException("Error fetching assigned student fees", e);
        }
    }

    public StudentFeeAssignmentFlatDTO toFlatDTO(StudentFeeAssignmentEntity assignment) {
        if (assignment == null) return null;

        var student = assignment.getStudent();
        var feeRate = assignment.getFeeRate();
        var feeComponent = feeRate.getFeeComponent();
        var feeCatalog = feeComponent.getFeeCatalog();

        return StudentFeeAssignmentFlatDTO.builder()
                // Student
                .studentId(student.getId())
                .studentCode(student.getStudentCode())
                .fullName(student.getFullName())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .phone(student.getPhone())
                .campusId(student.getCampus() != null ? student.getCampus().getId() : null)
                .campusName(student.getCampus() != null ? student.getCampus().getCampusName() : null)
                .standardId(student.getStandard() != null ? student.getStandard().getId() : null)
                .standardName(student.getStandard() != null ? student.getStandard().getStandardName() : null)
                .sectionId(student.getSection() != null ? student.getSection().getId() : null)
                .sectionName(student.getSection() != null ? student.getSection().getSectionName(): null)
                .academicYearId(student.getAcademicYear() != null ? student.getAcademicYear().getId() : null)
                .academicYearName(student.getAcademicYear() != null ? student.getAcademicYear().getName() : null)

                // Assignment
                .assignmentId(assignment.getId())
                .totalAmount(assignment.getTotalAmount())
                .assignedDate(assignment.getAssignedDate())
                .dueDate(assignment.getDueDate())

                // Fee Rate
                .feeRateId(feeRate.getId())
                .feeAmount(feeRate.getAmount())
                .currency(feeRate.getCurrency())
                .feeEffectiveFrom(feeRate.getEffectiveFrom())
                .feeEffectiveTo(feeRate.getEffectiveTo())

                // Fee Component
                .feeComponentId(feeComponent.getId())
                .feeComponentCode(feeComponent.getComponentCode())
                .feeComponentName(feeComponent.getComponentName())
                .discountable(feeComponent.isDiscountable())
                .taxable(feeComponent.isTaxable())

                // Fee Catalog
                .feeCatalogId(feeCatalog.getId())
                .feeCatalogCode(feeCatalog.getCode())
                .feeCatalogName(feeCatalog.getName())
                .feeCatalogChargeType(feeCatalog.getChargeType())
                .feeCatalogRecurrenceRule(feeCatalog.getRecurrenceRule())
                .build();
    }


}
