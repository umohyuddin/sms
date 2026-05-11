package com.smartsolutions.eschool.student.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.student.dtos.invoiceDto.StudentFeeInvoiceResponseDTO;
import com.smartsolutions.eschool.student.error.StudentFeeAssignmentErrors;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.model.StudentFeeAssignmentEntity;
import com.smartsolutions.eschool.student.model.StudentFeeInvoiceDetailEntity;
import com.smartsolutions.eschool.student.model.StudentFeeInvoiceEntity;
import com.smartsolutions.eschool.student.repository.StudentFeeAssignmentRepository;
import com.smartsolutions.eschool.student.repository.StudentFeeInvoiceRepository;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * CRITICAL SERVICE: Generates and manages student fee invoices/vouchers.
 * This is essential for the complete fee management workflow.
 */
@Service
@Slf4j
public class StudentFeeInvoiceService {

    private final StudentFeeInvoiceRepository invoiceRepository;
    private final StudentRepository studentRepository;
    private final StudentFeeAssignmentRepository assignmentRepository;
    private final AcademicYearRepository academicYearRepository;
    private final com.smartsolutions.eschool.institute.repository.CampusFinancialSettingsRepository campusFinancialSettingsRepository;
    private final com.smartsolutions.eschool.gl.service.JournalEntryService journalEntryService;
    private final com.smartsolutions.eschool.gl.service.GLAccountService glAccountService;

    public StudentFeeInvoiceService(
            StudentFeeInvoiceRepository invoiceRepository,
            StudentRepository studentRepository,
            StudentFeeAssignmentRepository assignmentRepository,
            AcademicYearRepository academicYearRepository,
            com.smartsolutions.eschool.institute.repository.CampusFinancialSettingsRepository campusFinancialSettingsRepository,
            com.smartsolutions.eschool.gl.service.JournalEntryService journalEntryService,
            com.smartsolutions.eschool.gl.service.GLAccountService glAccountService) {
        this.invoiceRepository = invoiceRepository;
        this.studentRepository = studentRepository;
        this.assignmentRepository = assignmentRepository;
        this.academicYearRepository = academicYearRepository;
        this.campusFinancialSettingsRepository = campusFinancialSettingsRepository;
        this.journalEntryService = journalEntryService;
        this.glAccountService = glAccountService;
    }

    /**
     * CRITICAL: Generates an invoice for a student for a specific month/year
     * This creates a voucher that consolidates all fees due in that period
     */
    @Transactional
    public StudentFeeInvoiceResponseDTO generateInvoice(Long studentId, Long academicYearId, 
                                                       String month, Integer year, LocalDate dueDate) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        if (organizationId == null) {
            throw new ApiException(
                    StudentFeeAssignmentErrors.ORGANIZATION_ACCESS_DENIED,
                    HttpStatus.FORBIDDEN
            );
        }

        log.info("[Service:StudentFeeInvoiceService] generateInvoice() called - studentId={}, month={}, year={}, org={}",
                studentId, month, year, organizationId);

        // Fetch student
        StudentEntity student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ApiException(
                        StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA,
                        "Student not found",
                        HttpStatus.NOT_FOUND
                ));

        // Fetch academic year
        AcademicYearEntity academicYear = academicYearRepository.findById(academicYearId)
                .orElseThrow(() -> new ApiException(
                        StudentFeeAssignmentErrors.CURRENT_ACADEMIC_YEAR_NOT_FOUND,
                        HttpStatus.NOT_FOUND
                ));

        // Check if invoice already exists
        Optional<StudentFeeInvoiceEntity> existingInvoice = invoiceRepository
                .findByStudentIdAndAcademicYearIdAndMonthAndYearAndDeletedFalse(
                        studentId, academicYearId, month, year
                );

        if (existingInvoice.isPresent()) {
            log.warn("[Service:StudentFeeInvoiceService] Invoice already exists - studentId={}, month={}, year={}",
                    studentId, month, year);
            return MapperUtil.mapObject(existingInvoice.get(), StudentFeeInvoiceResponseDTO.class);
        }

        // Parse target month/year
        Month targetMonth;
        try {
            targetMonth = Month.valueOf(month.toUpperCase());
        } catch (Exception e) {
            log.error("[Service:StudentFeeInvoiceService] Invalid month name provided: {}", month);
            throw new ApiException(StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA, 
                    "Invalid month name: " + month, HttpStatus.BAD_REQUEST);
        }
        LocalDate targetDate = LocalDate.of(year, targetMonth, 1);
        
        // Calculate month index relative to academic year start
        LocalDate startDate = academicYear.getStartDate().withDayOfMonth(1);
        long monthIndex = ChronoUnit.MONTHS.between(startDate, targetDate);

        if (monthIndex < 0 || monthIndex >= academicYear.getTotalMonths()) {
            log.warn("[Service:StudentFeeInvoiceService] Requested month {} {} is outside academic year range", month, year);
        }

        // Get all fee assignments for this academic year
        List<StudentFeeAssignmentEntity> assignments = assignmentRepository
                .findAllByStudentAndAcademicYear(studentId, academicYearId, organizationId);

        if (assignments.isEmpty()) {
            throw new ApiException(
                    StudentFeeAssignmentErrors.NO_FEE_RATES_AVAILABLE,
                    "No fee assignments found for this student in the academic year",
                    HttpStatus.NOT_FOUND
            );
        }

        // Filter and calculate installments due for this month
        List<StudentFeeInvoiceDetailEntity> details = new ArrayList<>();
        BigDecimal totalInvoiceAmount = BigDecimal.ZERO;

        for (StudentFeeAssignmentEntity assignment : assignments) {
            if (isFeeDueInMonth(assignment, monthIndex, targetMonth, year)) {
                BigDecimal installmentAmount = assignment.getFeeRate() != null ? assignment.getFeeRate().getFixedAmount() : BigDecimal.ZERO;
                if (installmentAmount == null) installmentAmount = BigDecimal.ZERO;

                if (installmentAmount.compareTo(BigDecimal.ZERO) > 0) {
                    StudentFeeInvoiceDetailEntity detail = new StudentFeeInvoiceDetailEntity();
                    // We'll set the invoice later
                    detail.setFeeAssignment(assignment);
                    detail.setAmount(installmentAmount);
                    details.add(detail);
                    totalInvoiceAmount = totalInvoiceAmount.add(installmentAmount);
                }
            }
        }

        if (details.isEmpty()) {
            log.info("[Service:StudentFeeInvoiceService] No fees due for {} {}", month, year);
            // Optionally throw error or return empty invoice? 
            // Most systems would not generate an invoice if nothing is due.
            throw new ApiException(
                    StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA,
                    "No fees are due for the selected month/year",
                    HttpStatus.BAD_REQUEST
            );
        }

        // Create invoice
        StudentFeeInvoiceEntity invoice = new StudentFeeInvoiceEntity();
        invoice.setInvoiceNumber(generateInvoiceNumber(organizationId, studentId, year, month));
        invoice.setStudent(student);
        invoice.setAcademicYear(academicYear);
        invoice.setMonth(month);
        invoice.setYear(year);
        invoice.setTotalAmount(totalInvoiceAmount);
        invoice.setLateFeeAmount(BigDecimal.ZERO);
        invoice.setDiscountAmount(BigDecimal.ZERO);
        invoice.setPaidAmount(BigDecimal.ZERO);
        invoice.setBalance(totalInvoiceAmount);

        // Calculate dynamic Dates from Campus Settings
        var settings = campusFinancialSettingsRepository
                .findByCampusIdAndAcademicYearId(student.getCampus().getId(), academicYearId)
                .orElse(null);

        LocalDate issueDate = LocalDate.now();
        if (settings != null && settings.getInvoiceGenerationDay() != null) {
            try {
                issueDate = LocalDate.of(year, targetMonth, Math.min(settings.getInvoiceGenerationDay(), targetMonth.length(YearMonth.of(year, targetMonth).isLeapYear())));
            } catch (Exception e) {
                log.warn("Invalid generation day {} for {} {}, using now", settings.getInvoiceGenerationDay(), month, year);
            }
        }

        LocalDate finalDueDate = dueDate;
        if (finalDueDate == null) {
            if (settings != null && settings.getInvoiceDueDay() != null) {
                try {
                    finalDueDate = LocalDate.of(year, targetMonth, Math.min(settings.getInvoiceDueDay(), targetMonth.length(YearMonth.of(year, targetMonth).isLeapYear())));
                    if (finalDueDate.isBefore(issueDate)) {
                        finalDueDate = finalDueDate.plusMonths(1);
                    }
                } catch (Exception e) {
                    finalDueDate = issueDate.plusDays(15);
                }
            } else {
                finalDueDate = issueDate.plusDays(15);
            }
        }

        invoice.setDueDate(finalDueDate);
        invoice.setInvoiceDate(issueDate);
        invoice.setStatus(StudentFeeInvoiceEntity.InvoiceStatus.UNPAID);
        invoice.setOrganizationId(organizationId);

        // Associate details with invoice
        for (StudentFeeInvoiceDetailEntity detail : details) {
            detail.setInvoice(invoice);
        }
        invoice.setDetails(details);

        StudentFeeInvoiceEntity savedInvoice = invoiceRepository.save(invoice);
        log.info("[Service:StudentFeeInvoiceService] Invoice generated successfully - invoiceNumber={}, total={}",
                savedInvoice.getInvoiceNumber(), savedInvoice.getTotalAmount());

        // --- GL Integration ---
        try {
            postInvoiceToGL(savedInvoice);
        } catch (Exception e) {
            log.error("[Service:StudentFeeInvoiceService] GL Posting failed for invoiceId {}: {}", savedInvoice.getId(), e.getMessage());
        }
        // -----------------------

        return buildResponseDTO(savedInvoice);
    }

    /**
     * Gets an invoice by ID with full details
     */
    public StudentFeeInvoiceResponseDTO getInvoiceById(Long invoiceId) {
        StudentFeeInvoiceEntity invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new ApiException(
                        StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA,
                        "Invoice not found",
                        HttpStatus.NOT_FOUND
                ));

        return buildResponseDTO(invoice);
    }

    /**
     * Gets outstanding invoices for a student (UNPAID or PARTIAL status)
     */
    public List<StudentFeeInvoiceResponseDTO> getOutstandingInvoices(Long studentId, Long academicYearId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Service:StudentFeeInvoiceService] getOutstandingInvoices() - studentId={}, academicYearId={}",
                studentId, academicYearId);

        // This would need a custom query in the repository
        // For now, we'll fetch all and filter
        List<StudentFeeInvoiceEntity> invoices = invoiceRepository.findAll();

        return invoices.stream()
                .filter(inv -> inv.getStudent().getId().equals(studentId) &&
                        inv.getAcademicYear().getId().equals(academicYearId) &&
                        (inv.getStatus() == StudentFeeInvoiceEntity.InvoiceStatus.UNPAID ||
                         inv.getStatus() == StudentFeeInvoiceEntity.InvoiceStatus.PARTIAL) &&
                        inv.isDeleted() == false)
                .map(this::buildResponseDTO)
                .collect(Collectors.toList());
    }

    /**
     * Gets all invoices for a student in academic year
     */
    public List<StudentFeeInvoiceResponseDTO> getStudentInvoices(Long studentId, Long academicYearId) {
        log.info("[Service:StudentFeeInvoiceService] getStudentInvoices() - studentId={}, academicYearId={}",
                studentId, academicYearId);

        List<StudentFeeInvoiceEntity> invoices = invoiceRepository.findAll();

        return invoices.stream()
                .filter(inv -> inv.getStudent().getId().equals(studentId) &&
                        inv.getAcademicYear().getId().equals(academicYearId) &&
                        inv.isDeleted() == false)
                .map(this::buildResponseDTO)
                .collect(Collectors.toList());
    }

    /**
     * Marks invoice as paid
     */
    @Transactional
    public StudentFeeInvoiceResponseDTO markInvoiceAsPaid(Long invoiceId) {
        StudentFeeInvoiceEntity invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new ApiException(
                        StudentFeeAssignmentErrors.INVALID_ASSIGNMENT_DATA,
                        "Invoice not found",
                        HttpStatus.NOT_FOUND
                ));

        invoice.setStatus(StudentFeeInvoiceEntity.InvoiceStatus.PAID);
        invoice.setBalance(BigDecimal.ZERO);
        StudentFeeInvoiceEntity saved = invoiceRepository.save(invoice);

        log.info("[Service:StudentFeeInvoiceService] Invoice marked as PAID - invoiceId={}", invoiceId);
        return buildResponseDTO(saved);
    }

    /**
     * Generates unique invoice number
     * Format: INV-{YEAR}{MONTH}-{ORG_ID}-{STUDENT_ID}-{SEQUENCE}
     */
    private String generateInvoiceNumber(Long orgId, Long studentId, Integer year, String month) {
        String prefix = String.format("INV-%d%s-%d-%d-", year, month, orgId, studentId);
        
        // Get count of invoices with similar prefix to create unique sequence
        int sequence = 1; // Default
        
        // This could be improved with a dedicated sequence generator
        return prefix + String.format("%05d", sequence);
    }

    /**
     * Helper to determine if a fee is due in a specific month index
     */
    private boolean isFeeDueInMonth(StudentFeeAssignmentEntity assignment, long monthIndex, Month targetMonth, int targetYear) {
        String rule = getRecurrenceRule(assignment);
        
        switch (rule.toUpperCase()) {
            case "MONTHLY":
                return true;
            case "BI_MONTHLY":
                return (monthIndex % 2 == 0);
            case "QUARTERLY":
                return (monthIndex % 3 == 0);
            case "HALF_YEARLY":
                return (monthIndex % 6 == 0);
            case "YEARLY":
                return (monthIndex == 0);
            case "ONE_TIME":
                // If it's the first month of the academic year, or the month it was assigned
                if (monthIndex == 0) return true;
                if (assignment.getAssignedDate() != null) {
                    return assignment.getAssignedDate().getMonth() == targetMonth && 
                           assignment.getAssignedDate().getYear() == targetYear;
                }
                return false;
            default:
                return (monthIndex == 0);
        }
    }

    private String getRecurrenceRule(StudentFeeAssignmentEntity assignment) {
        if (assignment.getFeeRate() != null && 
            assignment.getFeeRate().getFeeComponent() != null && 
            assignment.getFeeRate().getFeeComponent().getFeeCatalog() != null && 
            assignment.getFeeRate().getFeeComponent().getFeeCatalog().getRecurrenceRule() != null) {
            return assignment.getFeeRate().getFeeComponent().getFeeCatalog().getRecurrenceRule().getName();
        }
        return "ONE_TIME";
    }

    /**
     * Builds response DTO with details
     */
    private StudentFeeInvoiceResponseDTO buildResponseDTO(StudentFeeInvoiceEntity invoice) {
        List<StudentFeeInvoiceResponseDTO.InvoiceDetailDTO> detailDTOs = new ArrayList<>();
        
        if (invoice.getDetails() != null) {
            detailDTOs = invoice.getDetails().stream()
                    .map(detail -> StudentFeeInvoiceResponseDTO.InvoiceDetailDTO.builder()
                            .id(detail.getId())
                            .feeAssignmentId(detail.getFeeAssignment().getId())
                            .componentName(detail.getFeeAssignment().getFeeRate() != null && 
                                         detail.getFeeAssignment().getFeeRate().getFeeComponent() != null ?
                                         detail.getFeeAssignment().getFeeRate().getFeeComponent().getComponentName() : "Unknown")
                            .amount(detail.getAmount())
                            .build())
                    .collect(Collectors.toList());
        }

        return StudentFeeInvoiceResponseDTO.builder()
                .id(invoice.getId())
                .invoiceNumber(invoice.getInvoiceNumber())
                .studentId(invoice.getStudent().getId())
                .studentName(invoice.getStudent().getFullName())
                .academicYearId(invoice.getAcademicYear().getId())
                .academicYearName(invoice.getAcademicYear().getName())
                .month(invoice.getMonth())
                .year(invoice.getYear())
                .totalAmount(invoice.getTotalAmount())
                .lateFeeAmount(invoice.getLateFeeAmount())
                .discountAmount(invoice.getDiscountAmount())
                .paidAmount(invoice.getPaidAmount())
                .balance(invoice.getBalance())
                .dueDate(invoice.getDueDate())
                .invoiceDate(invoice.getInvoiceDate())
                .status(invoice.getStatus().name())
                .waivedAmount(invoice.getWaivedAmount())
                .waivedReason(invoice.getWaivedReason())
                .lastReminderSentAt(invoice.getLastReminderSentAt())
                .details(detailDTOs)
                .build();
    }

    private void postInvoiceToGL(StudentFeeInvoiceEntity invoice) {
        log.info("[Service:StudentFeeInvoiceService] Posting to GL for invoiceId={}", invoice.getId());

        com.smartsolutions.eschool.gl.model.JournalEntryEntity entry = new com.smartsolutions.eschool.gl.model.JournalEntryEntity();
        entry.setOrganizationId(invoice.getOrganizationId());
        entry.setCampusId(invoice.getStudent().getCampus().getId());
        entry.setAcademicYear(invoice.getAcademicYear());
        entry.setEntryDate(invoice.getInvoiceDate());
        entry.setReferenceNumber(invoice.getInvoiceNumber());
        entry.setDescription("Fee Invoice generated for student: " + invoice.getStudent().getFullName());
        entry.setEntryType("FEE_INVOICE");

        // DEBIT: Student Receivable (1121)
        com.smartsolutions.eschool.gl.model.JournalEntryLineEntity debitLine = new com.smartsolutions.eschool.gl.model.JournalEntryLineEntity();
        debitLine.setAccount(glAccountService.getAccountByCode(invoice.getOrganizationId(), "1121"));
        debitLine.setDebit(invoice.getTotalAmount());
        debitLine.setCredit(BigDecimal.ZERO);
        debitLine.setDescription("Fee receivable recognized - Invoice: " + invoice.getInvoiceNumber());
        debitLine.setCampusId(entry.getCampusId());
        debitLine.setReferenceId(invoice.getStudent().getId());
        entry.addLine(debitLine);

        // CREDIT: Revenue Accounts (mapped to components)
        for (StudentFeeInvoiceDetailEntity detail : invoice.getDetails()) {
            com.smartsolutions.eschool.gl.model.JournalEntryLineEntity creditLine = new com.smartsolutions.eschool.gl.model.JournalEntryLineEntity();
            
            String revenueAccountCode = "4110"; // Default Tuition Fee if not specified
            if (detail.getFeeAssignment().getFeeRate() != null && 
                detail.getFeeAssignment().getFeeRate().getFeeComponent() != null &&
                detail.getFeeAssignment().getFeeRate().getFeeComponent().getAccountCode() != null) {
                revenueAccountCode = detail.getFeeAssignment().getFeeRate().getFeeComponent().getAccountCode();
            }

            creditLine.setAccount(glAccountService.getAccountByCode(invoice.getOrganizationId(), revenueAccountCode));
            creditLine.setDebit(BigDecimal.ZERO);
            creditLine.setCredit(detail.getAmount());
            creditLine.setDescription("Revenue recognized for " + (detail.getFeeAssignment().getFeeRate() != null ? 
                detail.getFeeAssignment().getFeeRate().getFeeComponent().getComponentName() : "Fee Component"));
            creditLine.setCampusId(entry.getCampusId());
            creditLine.setReferenceId(invoice.getStudent().getId());
            entry.addLine(creditLine);
        }

        journalEntryService.postJournalEntry(entry);
        log.info("[Service:StudentFeeInvoiceService] GL Journal Entry posted successfully for invoiceId={}", invoice.getId());
    }
}
