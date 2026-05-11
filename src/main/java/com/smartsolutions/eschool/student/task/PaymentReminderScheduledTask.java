package com.smartsolutions.eschool.student.task;

import com.smartsolutions.eschool.global.notification.NotificationService;
import com.smartsolutions.eschool.institute.repository.CampusFinancialSettingsRepository;
import com.smartsolutions.eschool.student.model.StudentFeeInvoiceEntity;
import com.smartsolutions.eschool.student.model.StudentFeeSummaryEntity;
import com.smartsolutions.eschool.student.repository.StudentFeeInvoiceRepository;
import com.smartsolutions.eschool.student.repository.StudentFeeSummaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class PaymentReminderScheduledTask {

    private final StudentFeeInvoiceRepository invoiceRepository;
    private final StudentFeeSummaryRepository summaryRepository;
    private final CampusFinancialSettingsRepository campusSettingsRepository;
    private final NotificationService notificationService;

    // Runs every day at 8:00 AM
    @Scheduled(cron = "0 0 8 * * *")
    public void sendPaymentReminders() {
        log.info("[Task:PaymentReminderScheduledTask] Starting daily payment reminders scan...");

        LocalDate today = LocalDate.now();
        LocalDateTime reminderWindowStart = today.atStartOfDay().minusDays(1); // Don't resend if sent today

        // We check invoices due within the next 7 days
        List<StudentFeeInvoiceEntity> upcomingInvoices = invoiceRepository.findUpcomingInvoicesForReminder(
                today.plusDays(7), reminderWindowStart);

        for (StudentFeeInvoiceEntity invoice : upcomingInvoices) {
            var settings = campusSettingsRepository.findByCampusIdAndAcademicYearId(
                    invoice.getStudent().getCampus().getId(),
                    invoice.getAcademicYear().getId());

            if (settings.isPresent() && Boolean.TRUE.equals(settings.get().getSendPaymentReminder())) {
                int reminderDays = settings.get().getReminderDaysBeforeDue() != null ? settings.get().getReminderDaysBeforeDue() : 3;
                LocalDate reminderDate = invoice.getDueDate().minusDays(reminderDays);

                if (!today.isBefore(reminderDate)) {
                    // Check if there is still a balance
                    summaryRepository.findByStudentIdAndAcademicYearId(
                            invoice.getStudent().getId(), 
                            invoice.getAcademicYear().getId()
                    ).ifPresent(summary -> {
                        if (summary.getBalance().compareTo(BigDecimal.ZERO) > 0) {
                            sendReminder(invoice, summary);
                        }
                    });
                }
            }
        }

        log.info("[Task:PaymentReminderScheduledTask] Finished daily payment reminders scan.");
    }

    private void sendReminder(StudentFeeInvoiceEntity invoice, StudentFeeSummaryEntity summary) {
        String studentName = invoice.getStudent().getFullName();
        String dueDate = invoice.getDueDate().toString();
        BigDecimal balance = summary.getBalance();
        
        String subject = "Payment Reminder: School Fee Voucher Due Soon";
        String message = String.format(
                "Dear Parent, this is a reminder that the school fee voucher for %s (%s) is due on %s. Current outstanding balance: %s. Please ensure timely payment to avoid late fees.",
                studentName, invoice.getMonth(), dueDate, balance.toString()
        );
 
        String recipient = "parent_" + invoice.getStudent().getStudentCode() + "@example.com";
        
        try {
            notificationService.sendNotification(recipient, subject, message);
            
            invoice.setLastReminderSentAt(LocalDateTime.now());
            invoiceRepository.save(invoice);
            
            log.info("[Task:PaymentReminderScheduledTask] Reminder sent for studentId={} | invoiceId={}", 
                    invoice.getStudent().getId(), invoice.getId());
        } catch (Exception e) {
            log.error("[Task:PaymentReminderScheduledTask] Failed to send reminder for studentId={}", 
                    invoice.getStudent().getId(), e);
        }
    }
}
