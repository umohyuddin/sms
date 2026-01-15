package com.smartsolutions.eschool.employee.dtos.EmployeeTypeHistory.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeTypeHistoryDTO {

    private Long id;
    private Long employeeId;
    private Long employeeTypeId;
    private String employeeTypeName;
    private Boolean isCurrent;
}
