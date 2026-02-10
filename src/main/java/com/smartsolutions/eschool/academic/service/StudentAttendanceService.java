package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.StudentAttendanceRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.StudentAttendanceResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface StudentAttendanceService {
    void markAttendance(List<StudentAttendanceRequestDTO> dtos);
    List<StudentAttendanceResponseDTO> getSectionAttendance(Long standardId, Long sectionId, LocalDate date);
    List<StudentAttendanceResponseDTO> getStudentMonthlyView(Long studentId, int month, int year);
    void delete(Long id);
}
