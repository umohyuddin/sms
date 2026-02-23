package com.smartsolutions.eschool.academic.service.impl;

import com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceDetailDTO;
import com.smartsolutions.eschool.academic.dto.response.reports.ExamAttendanceSummaryDTO;
import com.smartsolutions.eschool.academic.entity.mapping.StudentExamAttendanceEntity;
import com.smartsolutions.eschool.academic.repository.StudentExamAttendanceRepository;
import com.smartsolutions.eschool.academic.service.ExamAttendanceReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExamAttendanceReportServiceImpl implements ExamAttendanceReportService {

    private final StudentExamAttendanceRepository attendanceRepository;

    @Override
    public List<ExamAttendanceSummaryDTO> getCampusAttendanceSummary(Long orgId, Long academicYearId) {
        log.info("Generating Campus Attendance Summary for org: {} and year: {}", orgId, academicYearId);
        List<ExamAttendanceSummaryDTO> summaries = attendanceRepository.getCampusSummary(orgId, academicYearId);
        summaries.forEach(this::calculatePercentage);
        return summaries;
    }

    @Override
    public List<ExamAttendanceSummaryDTO> getStandardAttendanceSummary(Long orgId, Long campusId, Long academicYearId) {
        log.info("Generating Standard Attendance Summary for org: {}, campus: {}, year: {}", orgId, campusId,
                academicYearId);
        List<ExamAttendanceSummaryDTO> summaries = attendanceRepository.getStandardSummary(orgId, campusId,
                academicYearId);
        summaries.forEach(this::calculatePercentage);
        return summaries;
    }

    @Override
    public List<ExamAttendanceSummaryDTO> getSectionAttendanceSummary(Long orgId, Long standardId,
            Long academicYearId) {
        log.info("Generating Section Attendance Summary for org: {}, standard: {}, year: {}", orgId, standardId,
                academicYearId);
        List<ExamAttendanceSummaryDTO> summaries = attendanceRepository.getSectionSummary(orgId, standardId,
                academicYearId);
        summaries.forEach(this::calculatePercentage);
        return summaries;
    }

    @Override
    public List<ExamAttendanceSummaryDTO> getSubjectAttendanceSummary(Long orgId, Long sectionId, Long academicYearId) {
        log.info("Generating Subject Attendance Summary for org: {}, section: {}, year: {}", orgId, sectionId,
                academicYearId);
        List<ExamAttendanceSummaryDTO> summaries = attendanceRepository.getSubjectSummary(orgId, sectionId,
                academicYearId);
        summaries.forEach(this::calculatePercentage);
        return summaries;
    }

    @Override
    public List<ExamAttendanceDetailDTO> getDetailedAttendanceReport(Long orgId, Long campusId, Long standardId,
            Long sectionId, Long examSubjectId, Long studentId,
            StudentExamAttendanceEntity.AttendanceStatus status,
            LocalDate startDate, LocalDate endDate) {
        log.info("Generating Detailed Attendance Report for org: {}, status: {}", orgId, status);
        return attendanceRepository.getDetailedReport(orgId, campusId, standardId, sectionId, examSubjectId, studentId,
                status, startDate, endDate);
    }

    private void calculatePercentage(ExamAttendanceSummaryDTO summary) {
        if (summary.getTotalStudents() != null && summary.getTotalStudents() > 0) {
            BigDecimal total = BigDecimal.valueOf(summary.getTotalStudents());
            BigDecimal present = BigDecimal.valueOf(summary.getPresentCount());
            summary.setAttendancePercentage(present.multiply(BigDecimal.valueOf(100))
                    .divide(total, 2, RoundingMode.HALF_UP));
        } else {
            summary.setAttendancePercentage(BigDecimal.ZERO);
        }
    }
}
