package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.EmployeeAttendanceRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.EmployeeAttendanceResponseDTO;

import java.util.List;

public interface EmployeeAttendanceService {
    void markAttendance(List<EmployeeAttendanceRequestDTO> dtos);
    List<EmployeeAttendanceResponseDTO> getEmployeeMonthlyView(Long employeeId, int month, int year);
    void delete(Long id);
}
