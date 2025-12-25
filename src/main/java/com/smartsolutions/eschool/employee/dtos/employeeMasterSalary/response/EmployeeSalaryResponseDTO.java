package com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.response;

import com.smartsolutions.eschool.global.enums.SalaryStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class EmployeeSalaryResponseDTO {
    private Long id;

    private Long employeeId;

    private Long salaryStructureId;

    private BigDecimal grossSalary;

    private BigDecimal totalDeductions;

    private BigDecimal netSalary;

    private LocalDate effectiveDate;

    private SalaryStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
