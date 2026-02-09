package com.smartsolutions.sms.academic.controller;

import com.smartsolutions.sms.academic.dto.request.EmployeeAttendanceRequestDTO;
import com.smartsolutions.sms.academic.dto.request.StudentAttendanceRequestDTO;
import com.smartsolutions.sms.academic.facade.AttendanceFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/academic/attendance")
@RequiredArgsConstructor
@Slf4j
public class AttendanceController {

    private final AttendanceFacade attendanceFacade;

    // Student Attendance
    @PostMapping("/students")
    public ResponseEntity<?> markStudentAttendance(@Valid @RequestBody List<StudentAttendanceRequestDTO> dtos) {
        attendanceFacade.markStudentAttendance(dtos);
        return ResponseEntity.ok("Attendance marked successfully");
    }

    @GetMapping("/students/section")
    public ResponseEntity<?> getSectionAttendance(@RequestParam Long standardId, @RequestParam Long sectionId, @RequestParam String date) {
        return ResponseEntity.ok(attendanceFacade.getSectionAttendance(standardId, sectionId, LocalDate.parse(date)));
    }

    @GetMapping("/students/{id}/monthly")
    public ResponseEntity<?> getStudentMonthlyView(@PathVariable Long id, @RequestParam int month, @RequestParam int year) {
        return ResponseEntity.ok(attendanceFacade.getStudentMonthlyView(id, month, year));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudentAttendance(@PathVariable Long id) {
        attendanceFacade.deleteStudentAttendance(id);
        return ResponseEntity.noContent().build();
    }

    // Employee Attendance
    @PostMapping("/employees")
    public ResponseEntity<?> markEmployeeAttendance(@Valid @RequestBody List<EmployeeAttendanceRequestDTO> dtos) {
        attendanceFacade.markEmployeeAttendance(dtos);
        return ResponseEntity.ok("Attendance marked successfully");
    }

    @GetMapping("/employees/{id}/monthly")
    public ResponseEntity<?> getEmployeeMonthlyView(@PathVariable Long id, @RequestParam int month, @RequestParam int year) {
        return ResponseEntity.ok(attendanceFacade.getEmployeeMonthlyView(id, month, year));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> deleteEmployeeAttendance(@PathVariable Long id) {
        attendanceFacade.deleteEmployeeAttendance(id);
        return ResponseEntity.noContent().build();
    }
}
