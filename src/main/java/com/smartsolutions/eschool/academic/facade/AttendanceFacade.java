package com.smartsolutions.eschool.academic.facade;

import com.smartsolutions.eschool.academic.dto.request.EmployeeAttendanceRequestDTO;
import com.smartsolutions.eschool.academic.dto.request.StudentAttendanceRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.EmployeeAttendanceResponseDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentAttendanceResponseDTO;
import com.smartsolutions.eschool.academic.service.EmployeeAttendanceService;
import com.smartsolutions.eschool.academic.service.StudentAttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class AttendanceFacade {

    private final StudentAttendanceService studentAttendanceService;
    private final EmployeeAttendanceService employeeAttendanceService;

    // Student Attendance
    public void markStudentAttendance(List<StudentAttendanceRequestDTO> dtos) { studentAttendanceService.markAttendance(dtos); }
    public List<StudentAttendanceResponseDTO> getSectionAttendance(Long standardId, Long sectionId, LocalDate date) { return studentAttendanceService.getSectionAttendance(standardId, sectionId, date); }
    public List<StudentAttendanceResponseDTO> getStudentMonthlyView(Long studentId, int month, int year) { return studentAttendanceService.getStudentMonthlyView(studentId, month, year); }
    public void deleteStudentAttendance(Long id) { studentAttendanceService.delete(id); }

    // Employee Attendance
    public void markEmployeeAttendance(List<EmployeeAttendanceRequestDTO> dtos) { employeeAttendanceService.markAttendance(dtos); }
    public List<EmployeeAttendanceResponseDTO> getEmployeeMonthlyView(Long employeeId, int month, int year) { return employeeAttendanceService.getEmployeeMonthlyView(employeeId, month, year); }
    public void deleteEmployeeAttendance(Long id) { employeeAttendanceService.delete(id); }
}
