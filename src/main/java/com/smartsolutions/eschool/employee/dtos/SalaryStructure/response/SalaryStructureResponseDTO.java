package com.smartsolutions.eschool.employee.dtos.SalaryStructure.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalaryStructureResponseDTO {
    private Long id;
    private Long employeeTypeId;
    private String employeeTypeName; // for convenience
    private BigDecimal baseSalary;
    private Boolean isCurrent;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    private Boolean deleted;
}
