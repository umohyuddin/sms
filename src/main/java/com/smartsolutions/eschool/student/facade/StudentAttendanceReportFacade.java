package com.smartsolutions.eschool.student.facade;

import com.smartsolutions.eschool.student.dtos.studentAttendance.response.*;
import com.smartsolutions.eschool.student.service.StudentAttendanceReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentAttendanceReportFacade {

    private final StudentAttendanceReportService service;

    public List<DailyAttendanceReportDTO> dailyAttendanceReport(LocalDate date) {
        return service.getDailyAttendance(date);
    }

    public List<ClassAttendanceReportDTO> classAttendanceReport(Long standardId, Long sectionId, LocalDate startDate, LocalDate endDate) {
        return service.getClassAttendance(standardId, sectionId, startDate, endDate);
    }

    public AttendanceSummaryDTO studentAttendanceSummary(Long studentId, LocalDate startDate, LocalDate endDate) {
        return service.getStudentAttendanceSummary(studentId, startDate, endDate);
    }

    public List<AttendanceSummaryDTO> overallAttendanceSummary(LocalDate startDate, LocalDate endDate) {
        return service.getOverallAttendanceSummary(startDate, endDate);
    }


    public StudentAttendanceDTO markAttendance(StudentAttendanceDTO dto) {
        return service.markAttendance(dto);
    }


    public List<StudentAttendanceDTO> markBatchAttendance(List<StudentAttendanceDTO> dtos) {
        return service.markBatchAttendance(dtos);
    }


    public StudentAttendanceDTO updateAttendance(StudentAttendanceDTO dto) {
        return service.updateAttendance(dto);
    }

    public void deleteAttendance(Long id) {
        service.deleteAttendance(id);
    }

    public List<StudentAttendanceDTO> getAttendanceByStudent(Long studentId, LocalDate startDate, LocalDate endDate) {
        return service.getAttendanceByStudent(studentId, startDate, endDate);
    }

    public List<StudentAttendanceDTO> getAttendanceByClass(Long standardId, Long sectionId, LocalDate date) {
        return service.getAttendanceByClass(standardId, sectionId, date);
    }

    public List<StudentAttendanceDTO> getAttendanceByStandard(Long standardId, LocalDate startDate, LocalDate endDate) {
        return service.getAttendanceByStandard(standardId, startDate, endDate);
    }

    public AttendanceCheckDTO checkAttendanceExists(Long studentId, LocalDate attendanceDate) {
        return service.checkAttendanceExists(studentId, attendanceDate);
    }

    public long countPresent(Long studentId, LocalDate startDate, LocalDate endDate) {
        return service.countPresent(studentId, startDate, endDate);
    }

    public long countAbsent(Long studentId, LocalDate startDate, LocalDate endDate) {
        return service.countAbsent(studentId, startDate, endDate);
    }

    public long countLeave(Long studentId, LocalDate startDate, LocalDate endDate) {
        return service.countLeave(studentId, startDate, endDate);
    }
}
