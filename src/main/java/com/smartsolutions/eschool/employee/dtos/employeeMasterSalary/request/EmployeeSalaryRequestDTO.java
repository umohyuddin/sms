package com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.request;


import com.smartsolutions.eschool.global.enums.SalaryStatus;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EmployeeSalaryRequestDTO {

    @NotNull(message = "Employee ID is required")
    private Long employeeId;

    @NotNull(message = "Salary structure ID is required")
    private Long salaryStructureId;

    @NotNull(message = "Gross salary is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Gross salary must be greater than 0")
    private BigDecimal grossSalary;

    @NotNull(message = "Total deductions are required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Total deductions cannot be negative")
    private BigDecimal totalDeductions;

    @NotNull(message = "Net salary is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Net salary must be greater than 0")
    private BigDecimal netSalary;

    @NotNull(message = "Effective date is required")
    private LocalDate effectiveDate;

    @NotNull(message = "Salary status is required")
    private SalaryStatus status; // Paid, Pending, Forward
}
