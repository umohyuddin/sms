package com.smartsolutions.eschool.employee.dtos.EmployeeTypeHistory.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeTypeHistoryRequestDTO {

    private Long employeeId;     // Employee to assign
    private Long employeeTypeId; // Type to assign
    private Long createdBy;      // optional: logged-in user
}
