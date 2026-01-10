package com.smartsolutions.eschool.employee.dtos.SalaryStructure.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class SalaryStructureRequestDTO {

    @NotNull(message = "Employee type ID is required")
    private Long employeeTypeId;

    @NotNull(message = "Base salary is required")
    @Positive(message = "Base salary must be positive")
    private BigDecimal baseSalary;

    @NotNull(message = "Effective from date is required")
    private LocalDate effectiveFrom;

    private LocalDate effectiveTo; // optional

    private Boolean isCurrent = true;
}