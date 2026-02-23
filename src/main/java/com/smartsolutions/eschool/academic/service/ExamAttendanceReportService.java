package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceDetailDTO;
import com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceSummaryDTO;
import com.smartsolutions.eschool.academic.entity.mapping.StudentExamAttendanceEntity;

import java.time.LocalDate;
import java.util.List;

public interface ExamAttendanceReportService {

    List<ExamAttendanceSummaryDTO> getCampusAttendanceSummary(Long orgId, Long academicYearId);

    List<ExamAttendanceSummaryDTO> getStandardAttendanceSummary(Long orgId, Long campusId, Long academicYearId);

    List<ExamAttendanceSummaryDTO> getSectionAttendanceSummary(Long orgId, Long standardId, Long academicYearId);

    List<ExamAttendanceSummaryDTO> getSubjectAttendanceSummary(Long orgId, Long sectionId, Long academicYearId);

    List<ExamAttendanceDetailDTO> getDetailedAttendanceReport(Long orgId,
            Long campusId,
            Long standardId,
            Long sectionId,
            Long examSubjectId,
            Long studentId,
            StudentExamAttendanceEntity.AttendanceStatus status,
            LocalDate startDate,
            LocalDate endDate);
}
