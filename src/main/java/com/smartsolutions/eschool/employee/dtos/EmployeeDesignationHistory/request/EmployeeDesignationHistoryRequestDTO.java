package com.smartsolutions.eschool.employee.dtos.EmployeeDesignationHistory.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDesignationHistoryRequestDTO {

    private Long employeeId;
    private Long designationId;
    private Long departmentId; // optional
    private Long createdBy;    // optional, can get from logged-in user
}
