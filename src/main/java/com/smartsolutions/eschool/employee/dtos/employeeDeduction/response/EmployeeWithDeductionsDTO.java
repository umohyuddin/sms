package com.smartsolutions.eschool.employee.dtos.employeeDeduction.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmployeeWithDeductionsDTO {
    private Long employeeId;
    private String employeeCode;
    private String fullName;
    private String employeeType;
    private List<EmployeeDeductionDTO> deductions;
}
