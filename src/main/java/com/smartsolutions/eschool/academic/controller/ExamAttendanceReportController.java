package com.smartsolutions.eschool.academic.controller;

import com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceDetailDTO;
import com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceSummaryDTO;
import com.smartsolutions.eschool.academic.entity.mapping.StudentExamAttendanceEntity;
import com.smartsolutions.eschool.academic.facade.ExamAttendanceReportFacade;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/academic/reports/exam-attendance")
@RequiredArgsConstructor
@Slf4j
public class ExamAttendanceReportController {

    private final ExamAttendanceReportFacade reportFacade;

    @GetMapping("/campus-summary")
    public ResponseEntity<List<ExamAttendanceSummaryDTO>> getCampusSummary(
            @RequestParam(required = false) Long academicYearId) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("Report API: Fetching campus summary for org: {}", orgId);
        return ResponseEntity.ok(reportFacade.getCampusSummary(orgId, academicYearId));
    }

    @GetMapping("/standard-summary")
    public ResponseEntity<List<ExamAttendanceSummaryDTO>> getStandardSummary(
            @RequestParam(required = false) Long campusId,
            @RequestParam(required = false) Long academicYearId) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("Report API: Fetching standard summary for org: {}, campus: {}", orgId, campusId);
        return ResponseEntity.ok(reportFacade.getStandardSummary(orgId, campusId, academicYearId));
    }

    @GetMapping("/section-summary")
    public ResponseEntity<List<ExamAttendanceSummaryDTO>> getSectionSummary(
            @RequestParam(required = false) Long standardId,
            @RequestParam(required = false) Long academicYearId) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("Report API: Fetching section summary for org: {}, standard: {}", orgId, standardId);
        return ResponseEntity.ok(reportFacade.getSectionSummary(orgId, standardId, academicYearId));
    }

    @GetMapping("/subject-summary")
    public ResponseEntity<List<ExamAttendanceSummaryDTO>> getSubjectSummary(
            @RequestParam(required = false) Long sectionId,
            @RequestParam(required = false) Long academicYearId) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("Report API: Fetching subject summary for org: {}, section: {}", orgId, sectionId);
        return ResponseEntity.ok(reportFacade.getSubjectSummary(orgId, sectionId, academicYearId));
    }

    @GetMapping("/detail")
    public ResponseEntity<List<ExamAttendanceDetailDTO>> getDetailedReport(
            @RequestParam(required = false) Long campusId,
            @RequestParam(required = false) Long standardId,
            @RequestParam(required = false) Long sectionId,
            @RequestParam(required = false) Long examSubjectId,
            @RequestParam(required = false) Long studentId,
            @RequestParam(required = false) StudentExamAttendanceEntity.AttendanceStatus status,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        log.info("Report API: Fetching detailed report for org: {}", orgId);
        return ResponseEntity.ok(reportFacade.getDetailedReport(orgId, campusId, standardId, sectionId,
                examSubjectId, studentId, status, startDate, endDate));
    }
}
