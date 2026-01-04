package com.smartsolutions.eschool.employee.dtos.employeeDeduction.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class EmployeeDeductionDTO {
    private Long id;
    private String deductionType;
    private BigDecimal amount;
    private LocalDate month;
}
