package com.smartsolutions.eschool.employee.dtos.employeeDeduction.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDeductionRequestDTO {
    @NotNull(message = "Employee ID is required")
    private Long employeeId;

    @NotNull(message = "Deduction type is required")
    @Size(max = 50)
    private String deductionType;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    private BigDecimal amount;

    @NotNull(message = "Month is required")
    private LocalDate month;
}
