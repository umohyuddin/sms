package com.smartsolutions.sms.academic.dto.response;

import com.smartsolutions.sms.academic.entity.master.EmployeeAttendanceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAttendanceResponseDTO {
    private Long id;
    private Long employeeId;
    private String employeeName;
    private LocalDate attendanceDate;
    private EmployeeAttendanceEntity.AttendanceStatus status;
    private String remarks;
}
