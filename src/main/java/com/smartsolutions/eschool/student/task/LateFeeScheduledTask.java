package com.smartsolutions.eschool.student.task;

import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.student.model.StudentFeeInvoiceEntity;
import com.smartsolutions.eschool.student.repository.StudentFeeInvoiceRepository;
import com.smartsolutions.eschool.student.service.StudentFeeSummaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
public class LateFeeScheduledTask {

    private final StudentFeeInvoiceRepository invoiceRepository;
    private final StudentFeeSummaryService summaryService;
    private final AcademicYearRepository academicYearRepository;

    public LateFeeScheduledTask(StudentFeeInvoiceRepository invoiceRepository,
                                StudentFeeSummaryService summaryService,
                                AcademicYearRepository academicYearRepository) {
        this.invoiceRepository = invoiceRepository;
        this.summaryService = summaryService;
        this.academicYearRepository = academicYearRepository;
    }

    /**
     * Runs every day at 1:00 AM to update late fees for all overdue invoices.
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void updateOverdueLateFees() {
        log.info("[Task:LateFeeScheduledTask] Starting daily late fee update task");

        AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElse(null);
        if (currentYear == null) {
            log.warn("[Task:LateFeeScheduledTask] No current academic year found, skipping task");
            return;
        }

        // Find all invoices that are past their due date
        List<StudentFeeInvoiceEntity> overdueInvoices = invoiceRepository.findAllOverdueInvoices();

        log.info("[Task:LateFeeScheduledTask] Found {} overdue invoices", overdueInvoices.size());

        java.util.Set<Long> affectedStudentIds = new java.util.HashSet<>();
        for (StudentFeeInvoiceEntity invoice : overdueInvoices) {
            try {
                Long studentId = invoice.getStudent().getId();
                Long orgId = invoice.getOrganizationId();
                if (orgId != null) {
                    // This will trigger LateFeeCalculationService via StudentFeeSummaryService
                    summaryService.updateSummary(studentId, currentYear.getId(), orgId);
                    affectedStudentIds.add(studentId);
                }
            } catch (Exception e) {
                log.error("[Task:LateFeeScheduledTask] Error updating summary for studentId {}: {}", invoice.getStudent().getId(), e.getMessage());
            }
        }

        log.info("[Task:LateFeeScheduledTask] Completed daily late fee update task for {} students", affectedStudentIds.size());
    }
}
