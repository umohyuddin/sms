package com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalaryStructureComponentResponseDTO {
    private Long id;

    private Long salaryStructureId;
    private String salaryStructureName; // optional, if you want to show structure info

    private Long componentId;
    private String componentName;       // optional, to display component name
    private String componentType;       // EARNING / DEDUCTION
    private Boolean isPercentage;       // true if % of base salary

    private BigDecimal value;
}
