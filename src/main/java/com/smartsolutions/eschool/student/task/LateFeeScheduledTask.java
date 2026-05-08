package com.smartsolutions.eschool.student.task;

import com.smartsolutions.eschool.school.model.AcademicYearEntity;
import com.smartsolutions.eschool.school.repository.AcademicYearRepository;
import com.smartsolutions.eschool.student.model.StudentFeeAssignmentEntity;
import com.smartsolutions.eschool.student.repository.StudentFeeAssignmentRepository;
import com.smartsolutions.eschool.student.service.StudentFeeSummaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Slf4j
public class LateFeeScheduledTask {

    private final StudentFeeAssignmentRepository assignmentRepository;
    private final StudentFeeSummaryService summaryService;
    private final AcademicYearRepository academicYearRepository;

    public LateFeeScheduledTask(StudentFeeAssignmentRepository assignmentRepository,
                                StudentFeeSummaryService summaryService,
                                AcademicYearRepository academicYearRepository) {
        this.assignmentRepository = assignmentRepository;
        this.summaryService = summaryService;
        this.academicYearRepository = academicYearRepository;
    }

    /**
     * Runs every day at 1:00 AM to update late fees for all overdue assignments.
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void updateOverdueLateFees() {
        log.info("[Task:LateFeeScheduledTask] Starting daily late fee update task");

        AcademicYearEntity currentYear = academicYearRepository.findByIsCurrentTrue().orElse(null);
        if (currentYear == null) {
            log.warn("[Task:LateFeeScheduledTask] No current academic year found, skipping task");
            return;
        }

        // Find all assignments that are past their due date
        List<StudentFeeAssignmentEntity> overdueAssignments = assignmentRepository.findAll().stream()
                .filter(a -> a.getDueDate() != null && a.getDueDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());

        log.info("[Task:LateFeeScheduledTask] Found {} potentially overdue assignments", overdueAssignments.size());

        for (StudentFeeAssignmentEntity assignment : overdueAssignments) {
            try {
                Long studentId = assignment.getStudent().getId();
                Long orgId = assignment.getOrganizationId();
                if (orgId != null) {
                    summaryService.updateSummary(studentId, currentYear.getId(), orgId);
                }
            } catch (Exception e) {
                log.error("[Task:LateFeeScheduledTask] Error updating summary for studentId {}: {}", assignment.getStudent().getId(), e.getMessage());
            }
        }

        log.info("[Task:LateFeeScheduledTask] Completed daily late fee update task for {} students", affectedStudentIds.size());
    }
}
