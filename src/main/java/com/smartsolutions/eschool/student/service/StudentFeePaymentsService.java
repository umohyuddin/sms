package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.student.dtos.studentFeePayment.requestDto.StudentFeePaymentRequestDTO;
import com.smartsolutions.eschool.student.dtos.studentFeePayment.responseDto.StudentFeePaymentResponseDTO;
import com.smartsolutions.eschool.student.error.StudentFeeAssignmentErrors;
import com.smartsolutions.eschool.student.model.*;
import com.smartsolutions.eschool.student.repository.*;
import com.smartsolutions.eschool.institute.enums.LateFeeFrequency;
import com.smartsolutions.eschool.institute.enums.LateFeeType;
import com.smartsolutions.eschool.institute.repository.CampusFinancialSettingsRepository;
import com.smartsolutions.eschool.school.repository.InstituteFinancialSettingsRepository;
import com.smartsolutions.eschool.student.repository.StudentFeeInvoiceRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import com.smartsolutions.eschool.util.SecurityUtils;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Slf4j
public class StudentFeePaymentsService {
    private final StudentRepository studentRepository;
    private final StudentFeeAssignmentRepository studentFeeAssignmentRepository;
    private final StudentFeeSummaryService studentFeeSummaryService;
    private final AcademicYearRepository academicYearRepository;
    private final StudentFeePaymentsRepository studentFeePaymentsRepository;
    private final InstituteRepository instituteRepository;
    private final InstituteFinancialSettingsRepository instituteFinancialSettingsRepository;
    private final CampusFinancialSettingsRepository campusFinancialSettingsRepository;
    private final StudentFeeInvoiceRepository studentFeeInvoiceRepository;

    public StudentFeePaymentsService(StudentRepository studentRepository, 
            StudentFeeAssignmentRepository studentFeeAssignmentRepository, 
            StudentFeeSummaryService studentFeeSummaryService, 
            AcademicYearRepository academicYearRepository, 
            StudentFeePaymentsRepository studentFeePaymentsRepository,
            InstituteRepository instituteRepository,
            InstituteFinancialSettingsRepository instituteFinancialSettingsRepository,
            CampusFinancialSettingsRepository campusFinancialSettingsRepository,
            StudentFeeInvoiceRepository studentFeeInvoiceRepository) {
        this.studentRepository = studentRepository;
        this.studentFeeAssignmentRepository = studentFeeAssignmentRepository;
        this.studentFeeSummaryService = studentFeeSummaryService;
        this.academicYearRepository = academicYearRepository;
        this.studentFeePaymentsRepository = studentFeePaymentsRepository;
        this.instituteRepository = instituteRepository;
        this.instituteFinancialSettingsRepository = instituteFinancialSettingsRepository;
        this.campusFinancialSettingsRepository = campusFinancialSettingsRepository;
        this.studentFeeInvoiceRepository = studentFeeInvoiceRepository;
    }

    @Transactional
    public StudentFeePaymentRequestDTO studentFeePayment(Long studentId, @Valid StudentFeePaymentRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeePaymentsService] studentFeePayment() called - studentId={}, amount={}, institute={}", 
                studentId, requestDTO.getAmountPaid(), organizationId);

        // Fetch student
        StudentEntity student = studentRepository.findById(studentId).orElseThrow(() -> {
            log.error("[Service:StudentFeePaymentsService] Student with id {} not found", studentId);
            return new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, "Student not found", HttpStatus.NOT_FOUND);
        });

        // Fetch academic year
        AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElseThrow(() -> {
            log.error("[Service:StudentFeePaymentsService] Current academic year not found");
            return new ApiException(StudentFeeAssignmentErrors.CURRENT_ACADEMIC_YEAR_NOT_FOUND, HttpStatus.NOT_FOUND);
        });

        // Validate fee assignment
        List<StudentFeeAssignmentEntity> assignments = studentFeeAssignmentRepository.findAllByStudentAndAcademicYear(studentId, currentYear.getId(), organizationId);

        if (assignments.isEmpty()) {
            throw new ApiException(StudentFeeAssignmentErrors.ASSIGNMENT_NOT_FOUND, "No fee assignments found for this student", HttpStatus.NOT_FOUND);
        }

        InstituteEntity institute = instituteRepository.findById(organizationId)
                .orElseThrow(() -> new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN));

        // Enforce Partial Payment Policy
        Boolean allowPartialPayments = true; // Default behavior
        Boolean invoiceMandatory = false; // Default behavior
        
        // Late Fee Settings
        Boolean lateFeeApplicable = false;
        LateFeeType lateFeeType = LateFeeType.FIXED;
        BigDecimal lateFeeFixedAmount = BigDecimal.ZERO;
        BigDecimal lateFeePercentage = BigDecimal.ZERO;
        Integer graceDays = 0;
        LateFeeFrequency lateFeeFrequency = LateFeeFrequency.ONE_TIME;
        BigDecimal lateFeeMaxAmount = BigDecimal.ZERO;
        
        // Check Campus Settings first (more specific)
        var campusSettings = campusFinancialSettingsRepository
                .findByCampusIdAndAcademicYearIdAndDeletedFalse(student.getCampus().getId(), currentYear.getId());
        
        if (campusSettings.isPresent()) {
            var settings = campusSettings.get();
            allowPartialPayments = settings.getAllowPartialPayments();
            invoiceMandatory = settings.getInvoiceMandatory();
            lateFeeApplicable = settings.getLateFeeApplicable();
            lateFeeType = settings.getLateFeeType();
            lateFeeFixedAmount = settings.getLateFeeFixedAmount();
            lateFeePercentage = settings.getLateFeePercentage();
            graceDays = settings.getGraceDays();
            lateFeeFrequency = settings.getLateFeeFrequency();
            lateFeeMaxAmount = settings.getLateFeeMaxAmount();
        } else {
            // Fallback to Institute Settings (currently using InstituteFinancialSettingsEntity which has fewer late fee fields)
            var instituteSettings = instituteFinancialSettingsRepository
                    .findByInstituteIdAndAcademicYearIdAndDeletedFalse(organizationId, currentYear.getId());
            if (instituteSettings.isPresent()) {
                var settings = instituteSettings.get();
                allowPartialPayments = settings.getAllowPartialPayments();
                invoiceMandatory = settings.getInvoiceMandatory();
                // Institute settings have simplified late fee fields
                lateFeeApplicable = settings.getLateFeeType() != null;
                if (settings.getLateFeeType() != null) {
                    try {
                        lateFeeType = LateFeeType.valueOf(settings.getLateFeeType());
                    } catch (Exception e) {
                        lateFeeType = LateFeeType.FIXED;
                    }
                }
                lateFeeFixedAmount = settings.getLateFeeAmount();
            }
        }

        // Fetch Invoice for Due Date validation
        com.smartsolutions.eschool.student.model.StudentFeeInvoiceEntity invoice = studentFeeInvoiceRepository
                .findByStudentIdAndAcademicYearIdAndMonthAndYearAndDeletedFalse(
                        studentId, currentYear.getId(), requestDTO.getPaymentMonth(), requestDTO.getPaymentYear())
                .orElse(null);

        // Invoice Enforcement
        if (Boolean.TRUE.equals(invoiceMandatory) && invoice == null) {
            log.warn("[Service:StudentFeePaymentsService] Payment rejected - No mandatory invoice found | studentId={}, month={}, year={}",
                    studentId, requestDTO.getPaymentMonth(), requestDTO.getPaymentYear());
            throw new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, 
                    "An invoice/voucher must be generated before recording a payment for this period.", HttpStatus.BAD_REQUEST);
        }

        // Late Fee Calculation
        BigDecimal calculatedLateFee = BigDecimal.ZERO;
        if (Boolean.TRUE.equals(lateFeeApplicable) && invoice != null && invoice.getDueDate() != null) {
            LocalDate dueDateWithGrace = invoice.getDueDate().plusDays(graceDays != null ? graceDays : 0);
            if (requestDTO.getPaymentDate().isAfter(dueDateWithGrace)) {
                long overdueDays = ChronoUnit.DAYS.between(dueDateWithGrace, requestDTO.getPaymentDate());
                
                if (LateFeeType.FIXED.equals(lateFeeType)) {
                    calculatedLateFee = lateFeeFixedAmount != null ? lateFeeFixedAmount : BigDecimal.ZERO;
                } else if (LateFeeType.PERCENTAGE.equals(lateFeeType)) {
                    BigDecimal baseAmount = invoice.getTotalAmount();
                    calculatedLateFee = baseAmount.multiply(lateFeePercentage.divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP));
                }

                if (LateFeeFrequency.PER_DAY.equals(lateFeeFrequency)) {
                    calculatedLateFee = calculatedLateFee.multiply(BigDecimal.valueOf(overdueDays));
                }

                if (lateFeeMaxAmount != null && lateFeeMaxAmount.compareTo(BigDecimal.ZERO) > 0) {
                    calculatedLateFee = calculatedLateFee.min(lateFeeMaxAmount);
                }
                
                // Update Invoice with late fee if not already recorded or if it increased
                if (invoice != null && calculatedLateFee.compareTo(invoice.getLateFeeAmount()) > 0) {
                    invoice.setLateFeeAmount(calculatedLateFee);
                    // New Balance = (Total + LateFee) - Paid - Discount
                    invoice.setBalance(invoice.getTotalAmount().add(calculatedLateFee)
                            .subtract(invoice.getPaidAmount())
                            .subtract(invoice.getDiscountAmount()));
                    studentFeeInvoiceRepository.save(invoice);
                }

                log.info("[Service:StudentFeePaymentsService] Late fee calculated: {} | overdueDays={}", calculatedLateFee, overdueDays);
            }
        }

        if (Boolean.FALSE.equals(allowPartialPayments)) {
            // Calculate what should be the monthly installment
            com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO summary = studentFeeSummaryService
                    .updateSummary(studentId, currentYear.getId(), organizationId);
            
            BigDecimal totalAssigned = summary.getTotalAssignedFee();
            long totalMonths = summary.getAcademicTotalMonths();
            
            if (totalMonths > 0) {
                BigDecimal monthlyInstallment = totalAssigned.divide(BigDecimal.valueOf(totalMonths), 2, RoundingMode.HALF_UP);
                
                if (requestDTO.getAmountPaid().compareTo(monthlyInstallment) < 0) {
                    log.warn("[Service:StudentFeePaymentsService] Partial payment rejected | studentId={}, amountPaid={}, required={}",
                            studentId, requestDTO.getAmountPaid(), monthlyInstallment);
                    throw new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, 
                            "Partial payments are not allowed. Minimum required: " + monthlyInstallment, HttpStatus.BAD_REQUEST);
                }
            }
        }

        StudentFeePaymentEntity payment = new StudentFeePaymentEntity();
        payment.setStudent(student);
        payment.setOrganizationId(organizationId);
        payment.setPaymentDate(requestDTO.getPaymentDate());
        payment.setAmountPaid(requestDTO.getAmountPaid());
        payment.setPaymentMonth(requestDTO.getPaymentMonth());
        payment.setPaymentYear(requestDTO.getPaymentYear());
        payment.setPaymentMode(requestDTO.getPaymentMode());
        payment.setAcademicYear(currentYear);
        payment.setLateFeePaid(requestDTO.getLateFeePaid() != null ? requestDTO.getLateFeePaid() : calculatedLateFee);

        studentFeePaymentsRepository.save(payment);
        log.info("[Service:StudentFeePaymentsService] Fee payment recorded successfully | paymentId={}", payment.getId());

        // Update Summary
        studentFeeSummaryService.updateSummary(studentId, currentYear.getId(), organizationId);
        
        return MapperUtil.mapObject(payment, StudentFeePaymentRequestDTO.class);
    }

    public List<StudentFeePaymentResponseDTO> getStudentPaymentsByAcademicYear(Long studentId, Long academicYearId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeePaymentsService] getStudentPaymentsByAcademicYear() called - studentId={}, academicYearId={}, institute={}", 
                studentId, academicYearId, organizationId);

        List<StudentFeePaymentEntity> payments = studentFeePaymentsRepository.findPaymentsByStudentAndAcademicYear(studentId, academicYearId, organizationId);
        log.info("[Service:StudentFeePaymentsService] Found {} payments", payments.size());
        
        return MapperUtil.mapList(payments, StudentFeePaymentResponseDTO.class);
    }

    public BigDecimal getTotalFeeCollected(Long academicYearId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeePaymentsService] getTotalFeeCollected() called - academicYearId={}, institute={}", academicYearId, organizationId);

        if (academicYearId == null) {
            AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElseThrow(() ->
                    new ApiException(StudentFeeAssignmentErrors.CURRENT_ACADEMIC_YEAR_NOT_FOUND, HttpStatus.NOT_FOUND));
            academicYearId = currentYear.getId();
        }
        return studentFeePaymentsRepository.getTotalFeeCollected(academicYearId, organizationId);
    }

    public BigDecimal getCollectedUpToCurrentMonth() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:StudentFeePaymentsService] getCollectedUpToCurrentMonth() called - institute={}", organizationId);

        AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElseThrow(() ->
                new ApiException(StudentFeeAssignmentErrors.CURRENT_ACADEMIC_YEAR_NOT_FOUND, HttpStatus.NOT_FOUND));
        
        LocalDate endOfCurrentMonth = YearMonth.now().atEndOfMonth();
        return studentFeePaymentsRepository.getTotalCollectedUpToMonth(currentYear.getId(), endOfCurrentMonth, organizationId);
    }
}
