package com.smartsolutions.eschool.employee.dtos.EmployeeDesignationHistory.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDesignationHistoryResponseDTO {

    private Long id;
    private Long employeeId;
    private Long designationId;
    private String designationName;
    private Long departmentId;
    private Boolean isCurrent;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Long createdBy;
    private LocalDateTime createdAt;
}