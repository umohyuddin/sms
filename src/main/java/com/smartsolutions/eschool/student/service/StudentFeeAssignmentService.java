package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.DiscountRateRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.FeeAssignmentDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.StudentFeeAssignmentsResponseDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentFeeAssignmentFlatDTO;
import com.smartsolutions.eschool.student.dtos.studentDiscountAssignment.requestDto.StudentDiscountAssignmentRequestDTO;
import com.smartsolutions.eschool.student.error.StudentFeeAssignmentErrors;
import com.smartsolutions.eschool.student.mapper.StudentFeeAssignmentMapper;
import com.smartsolutions.eschool.student.model.FeeRateEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.model.StudentFeeAssignmentEntity;
import com.smartsolutions.eschool.student.model.StudentFeeSummaryEntity;
import com.smartsolutions.eschool.institute.entity.CampusFinancialSettings;
import com.smartsolutions.eschool.institute.repository.CampusFinancialSettingsRepository;
import com.smartsolutions.eschool.lookups.model.FeeRecurrenceRuleEntity;
import com.smartsolutions.eschool.lookups.repository.FeeRecurrenceRuleRepository;
import com.smartsolutions.eschool.student.repository.*;
import com.smartsolutions.eschool.util.SecurityUtils;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentFeeAssignmentService {

    private final StudentRepository studentRepository;
    private final FeeRateRepository feeRateRepository;
    private final StudentFeeAssignmentRepository studentFeeAssignmentRepository;
    private final StudentFeeSummaryService studentFeeSummaryService;
    private final AcademicYearRepository academicYearRepository;
    private final InstituteRepository instituteRepository;
    private final DiscountRateRepository discountRateRepository;
    private final StudentDiscountAssignmentService studentDiscountAssignmentService;
    private final CampusFinancialSettingsRepository campusFinancialSettingsRepository;
    private final FeeRecurrenceRuleRepository feeRecurrenceRuleRepository;
    private final StudentFeeInvoiceRepository studentFeeInvoiceRepository;

    public StudentFeeAssignmentService(StudentRepository studentRepository, 
            FeeRateRepository feeRateRepository, 
            StudentFeeAssignmentRepository studentFeeAssignmentRepository, 
            StudentFeeSummaryService studentFeeSummaryService, 
            AcademicYearRepository academicYearRepository,
            InstituteRepository instituteRepository,
            DiscountRateRepository discountRateRepository,
            StudentDiscountAssignmentService studentDiscountAssignmentService,
            CampusFinancialSettingsRepository campusFinancialSettingsRepository,
            FeeRecurrenceRuleRepository feeRecurrenceRuleRepository,
            StudentFeeInvoiceRepository studentFeeInvoiceRepository) {
        this.studentRepository = studentRepository;
        this.feeRateRepository = feeRateRepository;
        this.studentFeeAssignmentRepository = studentFeeAssignmentRepository;
        this.studentFeeSummaryService = studentFeeSummaryService;
        this.academicYearRepository = academicYearRepository;
        this.instituteRepository = instituteRepository;
        this.discountRateRepository = discountRateRepository;
        this.studentDiscountAssignmentService = studentDiscountAssignmentService;
        this.campusFinancialSettingsRepository = campusFinancialSettingsRepository;
        this.feeRecurrenceRuleRepository = feeRecurrenceRuleRepository;
        this.studentFeeInvoiceRepository = studentFeeInvoiceRepository;
    }

    public boolean isFeeAssigned(Long studentId, Long academicYearId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeeAssignmentService] isFeeAssigned() called - studentId={}, academicYearId={}, institute={}",
                studentId, academicYearId, organizationId);
        boolean exists = studentFeeAssignmentRepository.isFeeAssigned(studentId, academicYearId, organizationId);
        log.info("[Service:StudentFeeAssignmentService] isFeeAssigned() succeeded - exists: {}", exists);
        return exists;
    }

    @Transactional
    public StudentFeeSummaryDTO assignStudentFee(Long studentId, @Valid StudentFeeAssignmentRequestDTO dto) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeeAssignmentService] assignStudentFee() called - studentId={}, institute={}", studentId, organizationId);

        // Fetch student
        StudentEntity student = studentRepository.findById(studentId).orElseThrow(() -> {
            log.error("[Service:StudentFeeAssignmentService] Student with id {} not found", studentId);
            return new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, "Student not found", HttpStatus.NOT_FOUND);
        });

        // Fetch Academic Year details
        AcademicYearEntity academicYear = academicYearRepository.findById(dto.getAcademicYearId())
                .orElseThrow(() -> new ApiException(StudentFeeAssignmentErrors.CURRENT_ACADEMIC_YEAR_NOT_FOUND, HttpStatus.NOT_FOUND));

        long totalMonths = academicYear.getTotalMonths();
        if (totalMonths <= 0) totalMonths = 12; // fallback

        // Fetch applicable fee rates
        List<FeeRateEntity> feeRates = feeRateRepository.findApplicableFeeRatesForStudent(dto.getComponentIds(),
                dto.getCampusId(), dto.getStandardId(), dto.getAcademicYearId());

        if (feeRates.isEmpty()) {
            log.warn("[Service:StudentFeeAssignmentService] No fee rates found for criteria");
            throw new ApiException(StudentFeeAssignmentErrors.NO_FEE_RATES_AVAILABLE, HttpStatus.NOT_FOUND);
        }

        // Map fee rates to assignments
        InstituteEntity institute = instituteRepository.findById(organizationId)
                .orElseThrow(() -> new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN));

        long finalTotalMonths = totalMonths;
        List<StudentFeeAssignmentEntity> assignments = feeRates.stream().map(feeRate -> {
            StudentFeeAssignmentEntity assignment = new StudentFeeAssignmentEntity();
            assignment.setStudent(student);
            assignment.setFeeRate(feeRate);
            assignment.setOrganizationId(organizationId);
            assignment.setAcademicYear(academicYear);

            Integer interval = getCatalogRecurrenceInterval(feeRate);
            
            BigDecimal baseAmount = feeRate.getFixedAmount() != null ? feeRate.getFixedAmount() : BigDecimal.ZERO;
            BigDecimal multiplier = BigDecimal.valueOf(getRecurrenceMultiplier(interval, (int) finalTotalMonths));
            BigDecimal totalAmount = baseAmount.multiply(multiplier);

            assignment.setTotalAmount(totalAmount);
            assignment.setAssignedDate(LocalDate.now());
            return assignment;
        }).collect(Collectors.toList());

        List<StudentFeeAssignmentEntity> savedAssignments = studentFeeAssignmentRepository.saveAll(assignments);
        studentFeeAssignmentRepository.flush();
        log.info("[Service:StudentFeeAssignmentService] Saved {} fee assignments", savedAssignments.size());

        // Total assigned fee
        BigDecimal totalAssigned = studentFeeAssignmentRepository.findTotalAssignedFee(studentId, dto.getAcademicYearId(), organizationId);
        if (totalAssigned == null) totalAssigned = BigDecimal.ZERO;

        // Handle Discount if provided
        if (dto.getDiscountComponentId() != null) {
            log.info("[Service:StudentFeeAssignmentService] Applying discount componentId: {}", dto.getDiscountComponentId());
            
            com.smartsolutions.eschool.school.model.DiscountRateEntity discountRate = discountRateRepository.findApplicableDiscountRate(
                    dto.getDiscountComponentId(), dto.getCampusId(), dto.getAcademicYearId())
                    .orElseThrow(() -> new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, 
                            "No applicable discount rate found for the selected component, campus and academic year", HttpStatus.NOT_FOUND));

            StudentDiscountAssignmentRequestDTO discountRequest = new StudentDiscountAssignmentRequestDTO();
            discountRequest.setStudentId(studentId);
            discountRequest.setAcademicYearId(dto.getAcademicYearId());
            discountRequest.setCampusId(dto.getCampusId());
            discountRequest.setDiscountRateId(discountRate.getId());
            discountRequest.setTotalAssignedFee(totalAssigned);
            studentDiscountAssignmentService.assignDiscount(discountRequest);
        }

        // Summary Handling
        return updateSummary(student, academicYear, institute, totalAssigned);
    }

    private StudentFeeSummaryDTO updateSummary(StudentEntity student, AcademicYearEntity academicYear, 
            InstituteEntity institute, BigDecimal totalAssigned) {
        return studentFeeSummaryService.updateSummary(student.getId(), academicYear.getId(), institute.getId());
    }

    @Transactional
    public StudentFeeSummaryDTO updateStudentFee(Long studentId, @Valid StudentFeeAssignmentRequestDTO dto) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeeAssignmentService] updateStudentFee() called - studentId={}, institute={}", studentId, organizationId);

        StudentEntity student = studentRepository.findById(studentId).orElseThrow(() ->
                new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, "Student not found", HttpStatus.NOT_FOUND));

        AcademicYearEntity academicYear = academicYearRepository.findById(dto.getAcademicYearId())
                .orElseThrow(() -> new ApiException(StudentFeeAssignmentErrors.CURRENT_ACADEMIC_YEAR_NOT_FOUND, HttpStatus.NOT_FOUND));

        long totalMonths = academicYear.getTotalMonths();
        if (totalMonths <= 0) totalMonths = 12;

        // Delete existing assignments for this student and academic year
        List<StudentFeeAssignmentEntity> existingAssignments = studentFeeAssignmentRepository.findAllByStudentAndAcademicYear(studentId, dto.getAcademicYearId(), organizationId);
        if (!existingAssignments.isEmpty()) {
            studentFeeAssignmentRepository.deleteAll(existingAssignments);
            studentFeeAssignmentRepository.flush();
            log.info("[Service:StudentFeeAssignmentService] Deleted and flushed {} existing fee assignments", existingAssignments.size());
        }

        // Fetch new applicable fee rates
        List<FeeRateEntity> feeRates = feeRateRepository.findApplicableFeeRatesForStudent(dto.getComponentIds(),
                dto.getCampusId(), dto.getStandardId(), dto.getAcademicYearId());

        if (feeRates.isEmpty()) {
            throw new ApiException(StudentFeeAssignmentErrors.NO_FEE_RATES_AVAILABLE, HttpStatus.NOT_FOUND);
        }

        // Map and save new assignments
        InstituteEntity institute = instituteRepository.findById(organizationId)
                .orElseThrow(() -> new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN));

        long finalTotalMonths = totalMonths;
        List<StudentFeeAssignmentEntity> updatedAssignments = feeRates.stream().map(feeRate -> {
            StudentFeeAssignmentEntity assignment = new StudentFeeAssignmentEntity();
            assignment.setStudent(student);
            assignment.setFeeRate(feeRate);
            assignment.setOrganizationId(organizationId);
            assignment.setAcademicYear(academicYear);

            Integer interval = getCatalogRecurrenceInterval(feeRate);
            
            BigDecimal baseAmount = feeRate.getFixedAmount() != null ? feeRate.getFixedAmount() : BigDecimal.ZERO;
            BigDecimal multiplier = BigDecimal.valueOf(getRecurrenceMultiplier(interval, (int) finalTotalMonths));
            BigDecimal totalAmount = baseAmount.multiply(multiplier);

            assignment.setTotalAmount(totalAmount);
            assignment.setAssignedDate(LocalDate.now());
            return assignment;
        }).collect(Collectors.toList());

        studentFeeAssignmentRepository.saveAll(updatedAssignments);
        studentFeeAssignmentRepository.flush();

        // Calculate Total assigned AFTER saving so it includes newly saved records
        BigDecimal totalAssigned = studentFeeAssignmentRepository.findTotalAssignedFee(studentId, dto.getAcademicYearId(), organizationId);
        if (totalAssigned == null) totalAssigned = BigDecimal.ZERO;

        // Handle Discount update
        if (dto.getDiscountComponentId() != null) {
            log.info("[Service:StudentFeeAssignmentService] Updating discount componentId: {}", dto.getDiscountComponentId());
            
            com.smartsolutions.eschool.school.model.DiscountRateEntity discountRate = discountRateRepository.findApplicableDiscountRate(
                    dto.getDiscountComponentId(), dto.getCampusId(), dto.getAcademicYearId())
                    .orElseThrow(() -> new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, 
                            "No applicable discount rate found for the selected component, campus and academic year", HttpStatus.NOT_FOUND));

            StudentDiscountAssignmentRequestDTO discountRequest = new StudentDiscountAssignmentRequestDTO();
            discountRequest.setStudentId(studentId);
            discountRequest.setAcademicYearId(dto.getAcademicYearId());
            discountRequest.setCampusId(dto.getCampusId());
            discountRequest.setDiscountRateId(discountRate.getId());
            discountRequest.setTotalAssignedFee(totalAssigned);
            studentDiscountAssignmentService.updateDiscount(discountRequest);
        } else {
            log.info("[Service:StudentFeeAssignmentService] No discount provided, removing existing discount for studentId: {}", studentId);
            studentDiscountAssignmentService.deleteDiscount(studentId, dto.getAcademicYearId(), dto.getCampusId());
        }

        return updateSummary(student, academicYear, institute, totalAssigned);
    }


    public StudentFeeAssignmentsResponseDTO getFeeAssignmentByStudentId(Long studentId, Long academicYearId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeeAssignmentService] getFeeAssignmentByStudentId() called - studentId={}, academicYearId={}, institute={}",
                studentId, academicYearId, organizationId);

        StudentEntity student = studentRepository.findById(studentId).orElseThrow(() ->
                new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, "Student not found", HttpStatus.NOT_FOUND));

        List<StudentFeeAssignmentEntity> assignments = studentFeeAssignmentRepository.findAllByStudentAndAcademicYear(studentId, academicYearId, organizationId);

        List<FeeAssignmentDTO> assignmentDTOs = assignments.stream().map(a -> {
            FeeAssignmentDTO adto = new FeeAssignmentDTO();
            if (a.getFeeRate() != null) {
                adto.setFeeRateId(a.getFeeRate().getId());
                if (a.getFeeRate().getFeeComponent() != null) {
                    adto.setComponentId(a.getFeeRate().getFeeComponent().getId());
                    adto.setComponentName(a.getFeeRate().getFeeComponent().getComponentName());
                }
            }
            adto.setAmount(a.getTotalAmount());
            adto.setAssignedDate(a.getAssignedDate());
            return adto;
        }).collect(Collectors.toList());

        StudentFeeAssignmentsResponseDTO responseDTO = new StudentFeeAssignmentsResponseDTO();
        responseDTO.setStudentId(studentId);
        responseDTO.setFullName(student.getFullName());
        responseDTO.setFirstName(student.getFirstName());
        responseDTO.setLastName(student.getLastName());
        responseDTO.setFeeAssignments(assignmentDTOs);

        log.info("[Service:StudentFeeAssignmentService] getFeeAssignmentByStudentId() succeeded - Found {} assignments", assignmentDTOs.size());
        return responseDTO;
    }

    public BigDecimal getTotalFeeAssigned(Long academicYearId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeeAssignmentService] getTotalFeeAssigned() called - academicYearId={}, institute={}",
                academicYearId, organizationId);

        if (academicYearId == null) {
            AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElseThrow(() ->
                    new ApiException(StudentFeeAssignmentErrors.CURRENT_ACADEMIC_YEAR_NOT_FOUND, HttpStatus.NOT_FOUND));
            academicYearId = currentYear.getId();
        }
        return studentFeeAssignmentRepository.getTotalFeeAssigned(academicYearId, organizationId);
    }

    public List<StudentFeeAssignmentFlatDTO> getAssignedFeesForStudent(Long studentId, Long academicYearId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeeAssignmentService] getAssignedFeesForStudent() called - studentId={}, academicYearId={}, institute={}",
                studentId, academicYearId, organizationId);

        if (academicYearId == null) {
            AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElseThrow(() ->
                    new ApiException(StudentFeeAssignmentErrors.CURRENT_ACADEMIC_YEAR_NOT_FOUND, HttpStatus.NOT_FOUND));
            academicYearId = currentYear.getId();
            log.info("[Service:StudentFeeAssignmentService] Null academicYearId provided, defaulting to current: {}", academicYearId);
        }

        List<StudentFeeAssignmentEntity> assignments = studentFeeAssignmentRepository
                .findAssignedFeesForStudentAndYear(studentId, academicYearId, organizationId);

        return StudentFeeAssignmentMapper.toFlatDTOList(assignments);
    }

    public List<StudentFeeAssignmentFlatDTO> getAllAssignments() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeeAssignmentService] getAllAssignments() called - institute={}", organizationId);

        List<StudentFeeAssignmentEntity> assignments = studentFeeAssignmentRepository.findAllWithStudent(organizationId);
        return StudentFeeAssignmentMapper.toFlatDTOList(assignments);
    }

    public List<StudentFeeAssignmentFlatDTO> searchAssignments(String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeeAssignmentService] searchAssignments() called - keyword={}, institute={}", keyword, organizationId);

        if (keyword == null || keyword.trim().isEmpty()) {
            return List.of();
        }
        List<StudentFeeAssignmentEntity> assignments = studentFeeAssignmentRepository.searchByStudentKeyword(keyword.trim(), organizationId);
        return StudentFeeAssignmentMapper.toFlatDTOList(assignments);
    }

    public Map<String, Object> getStatistics() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeeAssignmentService] getStatistics() called - institute={}", organizationId);

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalAssignments", studentFeeAssignmentRepository.countTotalAssignments(organizationId));
        
        AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElse(null);
        Long academicYearId = currentYear != null ? currentYear.getId() : null;
        
        if (academicYearId != null) {
            stats.put("totalFeeAmount", studentFeeAssignmentRepository.getTotalFeeAssigned(academicYearId, organizationId));
            stats.put("overdueAssignments", studentFeeInvoiceRepository.countOverdueInvoices(organizationId));
            stats.put("overdueAmount", studentFeeInvoiceRepository.sumOverdueAmount(academicYearId, organizationId));
        } else {
            stats.put("totalFeeAmount", BigDecimal.ZERO);
            stats.put("overdueAssignments", 0L);
            stats.put("overdueAmount", BigDecimal.ZERO);
        }

        log.info("[Service:StudentFeeAssignmentService] getStatistics() succeeded");
        return stats;
    }

    @Transactional
    public void deleteAssignment(Long assignmentId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeeAssignmentService] deleteAssignment() called - assignmentId={}, institute={}", assignmentId, organizationId);

        StudentFeeAssignmentEntity assignment = studentFeeAssignmentRepository.findByIdAndInstituteId(assignmentId, organizationId)
                .orElseThrow(() -> new ApiException(StudentFeeAssignmentErrors.ASSIGNMENT_NOT_FOUND, HttpStatus.NOT_FOUND));

        studentFeeAssignmentRepository.delete(assignment);
        log.info("[Service:StudentFeeAssignmentService] deleteAssignment() succeeded");
    }

    private Integer getCatalogRecurrenceInterval(FeeRateEntity feeRate) {
        if (feeRate.getFeeComponent() != null && 
            feeRate.getFeeComponent().getFeeCatalog() != null && 
            feeRate.getFeeComponent().getFeeCatalog().getRecurrenceRule() != null) {
            return feeRate.getFeeComponent().getFeeCatalog().getRecurrenceRule().getOccurrenceInterval();
        }
        return 0;
    }

    private int getRecurrenceMultiplier(Integer interval, int totalMonths) {
        if (interval == null || interval <= 0)
            return 1;
        return totalMonths / interval;
    }
}
