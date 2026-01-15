package com.smartsolutions.eschool.employee.dtos.EmployeeDepartmentHistory.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDepartmentHistoryRequestDTO {


    private Long employeeId;

    private Long departmentId;

    private Long createdBy; // optional, could be fetched from logged-in user context
}