package com.smartsolutions.eschool.employee.dtos.EmployeeDesignationHistory.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDesignationHistoryResponseDTO {

    private Long id;
    private Long employeeId;
    private Long designationId;
    private String designationName;
    private Long departmentId;
    private Boolean isCurrent;
}