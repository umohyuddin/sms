package com.smartsolutions.eschool.student.task;

import com.smartsolutions.eschool.global.notification.NotificationService;
import com.smartsolutions.eschool.institute.repository.CampusFinancialSettingsRepository;
import com.smartsolutions.eschool.student.model.StudentFeeAssignmentEntity;
import com.smartsolutions.eschool.student.model.StudentFeeSummaryEntity;
import com.smartsolutions.eschool.student.repository.StudentFeeAssignmentRepository;
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

    private final StudentFeeAssignmentRepository assignmentRepository;
    private final StudentFeeSummaryRepository summaryRepository;
    private final CampusFinancialSettingsRepository campusSettingsRepository;
    private final NotificationService notificationService;

    // Runs every day at 8:00 AM
    @Scheduled(cron = "0 0 8 * * *")
    public void sendPaymentReminders() {
        log.info("[Task:PaymentReminderScheduledTask] Starting daily payment reminders scan...");

        LocalDate today = LocalDate.now();
        LocalDateTime reminderWindowStart = today.atStartOfDay().minusDays(1); // Don't resend if sent today

        // We check assignments due within the next 7 days (broad window, specific checks inside)
        List<StudentFeeAssignmentEntity> upcomingAssignments = assignmentRepository.findUpcomingAssignmentsForReminder(
                today.plusDays(7), reminderWindowStart);

        for (StudentFeeAssignmentEntity assignment : upcomingAssignments) {
            var settings = campusSettingsRepository.findByCampusIdAndAcademicYearIdAndDeletedFalse(
                    assignment.getStudent().getCampus().getId(),
                    assignment.getAcademicYear().getId());

            if (settings.isPresent() && Boolean.TRUE.equals(settings.get().getSendPaymentReminder())) {
                int reminderDays = settings.get().getReminderDaysBeforeDue() != null ? settings.get().getReminderDaysBeforeDue() : 3;
                LocalDate reminderDate = assignment.getDueDate().minusDays(reminderDays);

                if (!today.isBefore(reminderDate)) {
                    // Check if there is still a balance
                    summaryRepository.findByStudentIdAndAcademicYearId(
                            assignment.getStudent().getId(), 
                            assignment.getAcademicYear().getId()
                    ).ifPresent(summary -> {
                        if (summary.getBalance().compareTo(BigDecimal.ZERO) > 0) {
                            sendReminder(assignment, summary);
                        }
                    });
                }
            }
        }

        log.info("[Task:PaymentReminderScheduledTask] Finished daily payment reminders scan.");
    }

    private void sendReminder(StudentFeeAssignmentEntity assignment, StudentFeeSummaryEntity summary) {
        String studentName = assignment.getStudent().getFullName();
        String dueDate = assignment.getDueDate().toString();
        BigDecimal balance = summary.getBalance();
        
        String subject = "Payment Reminder: School Fees Due Soon";
        String message = String.format(
                "Dear Parent, this is a reminder that the school fee for %s is due on %s. Current outstanding balance: %s. Please ensure timely payment to avoid late fees.",
                studentName, dueDate, balance.toString()
        );

        // Mock recipient (in a real system, we'd get parent's email/phone from StudentEntity)
        String recipient = "parent_" + assignment.getStudent().getStudentCode() + "@example.com";
        
        try {
            notificationService.sendNotification(recipient, subject, message);
            
            assignment.setLastReminderSentAt(LocalDateTime.now());
            assignmentRepository.save(assignment);
            
            log.info("[Task:PaymentReminderScheduledTask] Reminder sent for studentId={} | assignmentId={}", 
                    assignment.getStudent().getId(), assignment.getId());
        } catch (Exception e) {
            log.error("[Task:PaymentReminderScheduledTask] Failed to send reminder for studentId={}", 
                    assignment.getStudent().getId(), e);
        }
    }
}
