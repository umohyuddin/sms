package com.smartsolutions.eschool.academic.dto.request;

import com.smartsolutions.eschool.academic.entity.master.EmployeeAttendanceEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAttendanceRequestDTO {
    private Long id;
    
    @NotNull
    private Long employeeId;
    
    @NotNull
    private LocalDate attendanceDate;
    
    @NotNull
    private EmployeeAttendanceEntity.AttendanceStatus status;
    
    private String remarks;
}
