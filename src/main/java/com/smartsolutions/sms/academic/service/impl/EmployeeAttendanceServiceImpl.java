package com.smartsolutions.sms.academic.service.impl;

import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.sms.academic.dto.request.EmployeeAttendanceRequestDTO;
import com.smartsolutions.sms.academic.dto.response.EmployeeAttendanceResponseDTO;
import com.smartsolutions.sms.academic.entity.master.EmployeeAttendanceEntity;
import com.smartsolutions.sms.academic.mapper.AttendanceMapper;
import com.smartsolutions.sms.academic.repository.EmployeeAttendanceRepository;
import com.smartsolutions.sms.academic.service.EmployeeAttendanceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeAttendanceServiceImpl implements EmployeeAttendanceService {

    private final EmployeeAttendanceRepository attendanceRepository;
    private final EmployeeMasterRepository employeeRepository;
    private final AttendanceMapper attendanceMapper;

    @Override
    @Transactional
    public void markAttendance(List<EmployeeAttendanceRequestDTO> dtos) {
        for (EmployeeAttendanceRequestDTO dto : dtos) {
            EmployeeMasterEntity employee = employeeRepository.findById(dto.getEmployeeId())
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + dto.getEmployeeId()));
            
            EmployeeAttendanceEntity entity = attendanceMapper.toEntity(dto);
            entity.setEmployee(employee);
            attendanceRepository.save(entity);
        }
    }

    @Override
    public List<EmployeeAttendanceResponseDTO> getEmployeeMonthlyView(Long employeeId, int month, int year) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        return attendanceRepository.findMonthlyView(employeeId, startDate, endDate).stream()
                .map(attendanceMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        log.info("Soft deleting Employee Attendance ID: {}", id);
        if (!attendanceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Attendance record not found");
        }
        attendanceRepository.softDeleteById(id);
    }
}
