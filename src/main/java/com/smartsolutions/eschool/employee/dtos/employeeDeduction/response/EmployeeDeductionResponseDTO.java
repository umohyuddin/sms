package com.smartsolutions.eschool.employee.dtos.employeeDeduction.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDeductionResponseDTO {
    private Long id;
    private Long employeeId;
    private String employeeName;
    private String deductionType;
    private BigDecimal amount;
    private LocalDate month;
}
