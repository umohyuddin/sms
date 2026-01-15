package com.smartsolutions.eschool.employee.dtos.EmployeeDepartmentHistory.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmployeeDepartmentHistoryResponseDTO {

    private Long id;

    private Long employeeId;
    private String employeeName; // optional, if you want to show full name

    private Long departmentId;
    private String departmentName;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Boolean isCurrent;
    private Long createdBy;
    private LocalDateTime createdAt;
}