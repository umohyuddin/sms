package com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.response;

import com.smartsolutions.eschool.global.enums.SalaryStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeSalaryFullResponseDTO {
    private Long id;
    private Long salaryId;
    private Long employeeId;
    private String employeeCode;
    private String employeeName;
    private String employeeType;
    private BigDecimal grossSalary;
    private BigDecimal totalDeductions;
    private BigDecimal netSalary;
    private LocalDate effectiveDate;
    private Long salaryStructureId;
    private SalaryStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

