package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.gl.model.JournalEntryEntity;
import com.smartsolutions.eschool.gl.model.JournalEntryLineEntity;
import com.smartsolutions.eschool.gl.service.GLAccountService;
import com.smartsolutions.eschool.gl.service.JournalEntryService;
import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.model.InstituteEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.school.repository.InstituteRepository;
import com.smartsolutions.eschool.student.dtos.studentFeePayment.requestDto.StudentFeePaymentRequestDTO;
import com.smartsolutions.eschool.student.dtos.studentFeePayment.requestDto.LateFeeWaiverRequestDTO;
import com.smartsolutions.eschool.student.dtos.studentFeePayment.responseDto.StudentFeePaymentResponseDTO;
import com.smartsolutions.eschool.student.error.StudentFeeAssignmentErrors;
import com.smartsolutions.eschool.student.model.*;
import com.smartsolutions.eschool.student.repository.*;
import com.smartsolutions.eschool.student.enums.PaymentMode;
import com.smartsolutions.eschool.institute.enums.LateFeeFrequency;
import com.smartsolutions.eschool.institute.enums.LateFeeType;
import com.smartsolutions.eschool.institute.repository.CampusFinancialSettingsRepository;
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
    private final CampusFinancialSettingsRepository campusFinancialSettingsRepository;
    private final StudentFeeInvoiceRepository studentFeeInvoiceRepository;
    private final LateFeeCalculationService lateFeeCalculationService;
    private final com.smartsolutions.eschool.lookups.repository.TaxTypeRepository taxTypeRepository;
    private final FeeReceiptService feeReceiptService;
    private final JournalEntryService journalEntryService;
    private final GLAccountService glAccountService;

    public StudentFeePaymentsService(StudentRepository studentRepository, 
            StudentFeeAssignmentRepository studentFeeAssignmentRepository, 
            StudentFeeSummaryService studentFeeSummaryService, 
            AcademicYearRepository academicYearRepository, 
            StudentFeePaymentsRepository studentFeePaymentsRepository,
            InstituteRepository instituteRepository,
            CampusFinancialSettingsRepository campusFinancialSettingsRepository,
            StudentFeeInvoiceRepository studentFeeInvoiceRepository,
            com.smartsolutions.eschool.lookups.repository.TaxTypeRepository taxTypeRepository,
            FeeReceiptService feeReceiptService,
            LateFeeCalculationService lateFeeCalculationService,
            JournalEntryService journalEntryService,
            GLAccountService glAccountService) {
        this.studentRepository = studentRepository;
        this.studentFeeAssignmentRepository = studentFeeAssignmentRepository;
        this.studentFeeSummaryService = studentFeeSummaryService;
        this.academicYearRepository = academicYearRepository;
        this.studentFeePaymentsRepository = studentFeePaymentsRepository;
        this.instituteRepository = instituteRepository;
        this.campusFinancialSettingsRepository = campusFinancialSettingsRepository;
        this.studentFeeInvoiceRepository = studentFeeInvoiceRepository;
        this.taxTypeRepository = taxTypeRepository;
        this.feeReceiptService = feeReceiptService;
        this.lateFeeCalculationService = lateFeeCalculationService;
        this.journalEntryService = journalEntryService;
        this.glAccountService = glAccountService;
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
        StudentEntity student = studentRepository.findByIdAndOrganizationId(studentId, organizationId).orElseThrow(() -> {
            log.error("[Service:StudentFeePaymentsService] Student with id {} not found in organization {}", studentId, organizationId);
            return new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, "Student not found", HttpStatus.NOT_FOUND);
        });

        // Fetch academic year
        AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrueAndOrganizationId(organizationId).orElseThrow(() -> {
            log.error("[Service:StudentFeePaymentsService] Current academic year not found for organization {}", organizationId);
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
                .findByCampusIdAndAcademicYearId(student.getCampus().getId(), currentYear.getId());
        
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
        }

        // Fetch Invoice for Due Date validation
        com.smartsolutions.eschool.student.model.StudentFeeInvoiceEntity invoice = studentFeeInvoiceRepository
                .findByStudentIdAndAcademicYearIdAndMonthAndYearAndDeletedFalse(
                        studentId, currentYear.getId(), requestDTO.getPaymentMonth(), requestDTO.getPaymentYear())
                .orElse(null);

        // Invoice Enforcement - Temporarily disabled by user request
        // if (Boolean.TRUE.equals(invoiceMandatory) && invoice == null) {
        //     log.warn("[Service:StudentFeePaymentsService] Payment rejected - No mandatory invoice found | studentId={}, month={}, year={}",
        //             studentId, requestDTO.getPaymentMonth(), requestDTO.getPaymentYear());
        //     throw new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, 
        //             "An invoice/voucher must be generated before recording a payment for this period.", HttpStatus.BAD_REQUEST);
        // }

        // Late Fee Calculation
        BigDecimal calculatedLateFee = BigDecimal.ZERO;
        
        if (Boolean.TRUE.equals(lateFeeApplicable)) {
            if (invoice != null && invoice.getDueDate() != null && campusSettings.isPresent()) {
                // Use the dedicated service for consistency
                calculatedLateFee = lateFeeCalculationService.calculateLateFee(
                        invoice.getTotalAmount(), 
                        invoice.getDueDate(), 
                        requestDTO.getPaymentDate(), 
                        campusSettings.get());
                
                // Update Invoice with late fee
                if (calculatedLateFee.compareTo(invoice.getLateFeeAmount()) > 0) {
                    invoice.setLateFeeAmount(calculatedLateFee);
                    invoice.setBalance(invoice.getTotalAmount().add(calculatedLateFee)
                            .subtract(invoice.getPaidAmount())
                            .subtract(invoice.getDiscountAmount()));
                    studentFeeInvoiceRepository.save(invoice);
                }
            } else {
                // Assignment-level late fee calculation removed - all late fees are now per-invoice
                /*
                if (campusSettings.isPresent()) {
                    for (StudentFeeAssignmentEntity assignment : assignments) {
                        BigDecimal lateFee = lateFeeCalculationService.calculateLateFee(assignment, campusSettings.get());
                        // No longer saving to assignment
                    }
                }
                */
            }
            
            if (calculatedLateFee.compareTo(BigDecimal.ZERO) > 0) {
                log.info("[Service:StudentFeePaymentsService] Total late fee calculated: {}", calculatedLateFee);
            }
        }

        // Overpayment Validation
        com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO summary = studentFeeSummaryService
                .updateSummary(studentId, currentYear.getId(), organizationId);
        
        BigDecimal currentBalance = summary.getBalance();
        BigDecimal totalPaying = requestDTO.getAmountPaid().add(requestDTO.getLateFeePaid() != null ? requestDTO.getLateFeePaid() : calculatedLateFee);

        if (totalPaying.compareTo(currentBalance) > 0) {
            log.warn("[Service:StudentFeePaymentsService] Overpayment rejected | studentId={}, totalPaying={}, balance={}",
                    studentId, totalPaying, currentBalance);
            throw new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, 
                    "Total payment amount (" + totalPaying + ") exceeds the outstanding balance of " + currentBalance, HttpStatus.BAD_REQUEST);
        }

        // Duplicate Payment Prevention
        if (Boolean.FALSE.equals(allowPartialPayments)) {
            if (studentFeePaymentsRepository.existsByStudentIdAndAcademicYearIdAndPaymentMonthAndPaymentYearAndDeletedFalse(
                    studentId, currentYear.getId(), requestDTO.getPaymentMonth(), requestDTO.getPaymentYear())) {
                log.warn("[Service:StudentFeePaymentsService] Duplicate payment rejected | studentId={}, month={}, year={}",
                        studentId, requestDTO.getPaymentMonth(), requestDTO.getPaymentYear());
                throw new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, 
                        "Payment for " + requestDTO.getPaymentMonth() + " " + requestDTO.getPaymentYear() + " has already been recorded.", HttpStatus.CONFLICT);
            }
        } else {
            // If partial payments are allowed, prevent exact identical duplicates to avoid accidental double-clicks
            if (studentFeePaymentsRepository.existsByStudentIdAndAcademicYearIdAndPaymentMonthAndPaymentYearAndAmountPaidAndDeletedFalse(
                    studentId, currentYear.getId(), requestDTO.getPaymentMonth(), requestDTO.getPaymentYear(), requestDTO.getAmountPaid())) {
                log.warn("[Service:StudentFeePaymentsService] Identical duplicate payment rejected | studentId={}, amount={}, month={}",
                        studentId, requestDTO.getAmountPaid(), requestDTO.getPaymentMonth());
                throw new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, 
                        "An identical payment for this month and year has already been recorded.", HttpStatus.CONFLICT);
            }
        }

        if (Boolean.FALSE.equals(allowPartialPayments)) {
            // Calculate what should be the monthly installment
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
        
        // Tax Calculation for Payment
        BigDecimal taxPaid = BigDecimal.ZERO;
        if (campusSettings.isPresent() && campusSettings.get().getTaxTypeId() != null) {
            var taxType = taxTypeRepository.findById(campusSettings.get().getTaxTypeId());
            if (taxType.isPresent()) {
                // Calculate tax on the amountPaid (assumed exclusive for calculation)
                taxPaid = requestDTO.getAmountPaid().multiply(taxType.get().getTaxPercentage().divide(BigDecimal.valueOf(100), 4, java.math.RoundingMode.HALF_UP));
            }
        }
        payment.setTaxPaid(taxPaid);
        
        payment.setReceiptNumber("RCP-" + currentYear.getName().substring(0, 4) + "-" + System.currentTimeMillis() % 100000);

        studentFeePaymentsRepository.save(payment);
        log.info("[Service:StudentFeePaymentsService] Fee payment recorded successfully | paymentId={}", payment.getId());

        // --- GL Integration ---
        try {
            postFeePaymentToGL(payment, currentYear);
        } catch (Exception e) {
            log.error("[Service:StudentFeePaymentsService] GL Posting failed for paymentId {}: {}", payment.getId(), e.getMessage());
            // Optional: throw exception if GL posting is mandatory
        }
        // -----------------------

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

    public byte[] generateReceipt(Long paymentId) {
        StudentFeePaymentEntity payment = studentFeePaymentsRepository.findById(paymentId)
                .orElseThrow(() -> new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, "Payment not found", HttpStatus.NOT_FOUND));
        return feeReceiptService.generateReceiptPdf(payment);
    }

    @Transactional
    public void waiveLateFee(LateFeeWaiverRequestDTO requestDTO) {
        log.info("[Service:StudentFeePaymentsService] waiveLateFee() called for invoiceId={}", requestDTO.getInvoiceId());
        
        StudentFeeInvoiceEntity invoice = studentFeeInvoiceRepository.findById(requestDTO.getInvoiceId())
                .orElseThrow(() -> new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, "Invoice not found", HttpStatus.NOT_FOUND));
        
        if (requestDTO.getWaivedAmount().compareTo(invoice.getLateFeeAmount()) > 0) {
            throw new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, "Waived amount cannot exceed current late fee", HttpStatus.BAD_REQUEST);
        }
        
        invoice.setWaivedAmount(requestDTO.getWaivedAmount());
        invoice.setWaivedReason(requestDTO.getReason());
        
        // Recalculate balance
        BigDecimal netLateFee = invoice.getLateFeeAmount().subtract(requestDTO.getWaivedAmount());
        invoice.setBalance(invoice.getTotalAmount().add(netLateFee).subtract(invoice.getPaidAmount()).subtract(invoice.getDiscountAmount()));
        
        studentFeeInvoiceRepository.save(invoice);
        
        // Update summary to reflect the change
        studentFeeSummaryService.updateSummary(invoice.getStudent().getId(), invoice.getAcademicYear().getId(), invoice.getOrganizationId());
        
        log.info("[Service:StudentFeePaymentsService] Late fee waived successfully | invoiceId={}", invoice.getId());
    }

    private void postFeePaymentToGL(StudentFeePaymentEntity payment, AcademicYearEntity academicYear) {
        log.info("[Service:StudentFeePaymentsService] Posting to GL for paymentId={}", payment.getId());
        
        JournalEntryEntity entry = new JournalEntryEntity();
        entry.setOrganizationId(payment.getOrganizationId());
        entry.setCampusId(payment.getStudent().getCampus().getId());
        entry.setAcademicYear(academicYear);
        entry.setEntryDate(payment.getPaymentDate());
        entry.setReferenceNumber(payment.getReceiptNumber());
        entry.setDescription("Fee payment received from student: " + payment.getStudent().getFullName());
        entry.setEntryType("FEE_PAYMENT");

        // DEBIT: Cash or Bank
        JournalEntryLineEntity debitLine = new JournalEntryLineEntity();
        String cashAccountCode = "1111"; // Default Cash in Hand
        if (PaymentMode.BANK_TRANSFER.equals(payment.getPaymentMode()) || PaymentMode.ONLINE.equals(payment.getPaymentMode())) {
            cashAccountCode = "1113"; // Bank Account
        }
        debitLine.setAccount(glAccountService.getAccountByCode(payment.getOrganizationId(), cashAccountCode));
        debitLine.setDebit(payment.getAmountPaid().add(payment.getLateFeePaid() != null ? payment.getLateFeePaid() : BigDecimal.ZERO));
        debitLine.setCredit(BigDecimal.ZERO);
        debitLine.setDescription("Fee received - Receipt: " + payment.getReceiptNumber());
        debitLine.setCampusId(entry.getCampusId());
        debitLine.setReferenceId(payment.getStudent().getId());
        entry.addLine(debitLine);

        // CREDIT: Student Receivable
        JournalEntryLineEntity creditLine = new JournalEntryLineEntity();
        creditLine.setAccount(glAccountService.getAccountByCode(payment.getOrganizationId(), "1121")); // Student Fee Receivable
        creditLine.setDebit(BigDecimal.ZERO);
        creditLine.setCredit(debitLine.getDebit());
        creditLine.setDescription("Fee receivable cleared for student: " + payment.getStudent().getFullName());
        creditLine.setCampusId(entry.getCampusId());
        creditLine.setReferenceId(payment.getStudent().getId());
        entry.addLine(creditLine);

        journalEntryService.postJournalEntry(entry);
        log.info("[Service:StudentFeePaymentsService] GL Journal Entry posted successfully for paymentId={}", payment.getId());
    }
}
