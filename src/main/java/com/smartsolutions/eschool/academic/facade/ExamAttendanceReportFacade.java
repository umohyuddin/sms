package com.smartsolutions.eschool.academic.facade;

import com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceDetailDTO;
import com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceSummaryDTO;
import com.smartsolutions.eschool.academic.entity.mapping.StudentExamAttendanceEntity;
import com.smartsolutions.eschool.academic.service.ExamAttendanceReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Scope("prototype")
@RequiredArgsConstructor
@Slf4j
public class ExamAttendanceReportFacade {

    private final ExamAttendanceReportService reportService;

    public List<ExamAttendanceSummaryDTO> getCampusSummary(Long orgId, Long academicYearId) {
        return reportService.getCampusAttendanceSummary(orgId, academicYearId);
    }

    public List<ExamAttendanceSummaryDTO> getStandardSummary(Long orgId, Long campusId, Long academicYearId) {
        return reportService.getStandardAttendanceSummary(orgId, campusId, academicYearId);
    }

    public List<ExamAttendanceSummaryDTO> getSectionSummary(Long orgId, Long standardId, Long academicYearId) {
        return reportService.getSectionAttendanceSummary(orgId, standardId, academicYearId);
    }

    public List<ExamAttendanceSummaryDTO> getSubjectSummary(Long orgId, Long sectionId, Long academicYearId) {
        return reportService.getSubjectAttendanceSummary(orgId, sectionId, academicYearId);
    }

    public List<ExamAttendanceDetailDTO> getDetailedReport(Long orgId, Long campusId, Long standardId,
            Long sectionId, Long examSubjectId, Long studentId,
            StudentExamAttendanceEntity.AttendanceStatus status,
            LocalDate startDate, LocalDate endDate) {
        return reportService.getDetailedAttendanceReport(orgId, campusId, standardId, sectionId,
                examSubjectId, studentId, status, startDate, endDate);
    }
}
