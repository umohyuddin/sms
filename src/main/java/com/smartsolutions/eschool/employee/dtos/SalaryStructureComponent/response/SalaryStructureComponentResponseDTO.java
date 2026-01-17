package com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor   // <--- add this
@AllArgsConstructor
public class SalaryStructureComponentResponseDTO {
    private Long id;

    private Long salaryStructureId;
    private String salaryStructureName; // optional, if you want to show structure info

    private Long componentId;
    private String componentName;       // optional, to display component name
    private String componentType;       // EARNING / DEDUCTION
    private Boolean isPercentage;       // true if % of base salary

    private BigDecimal value;
    private BigDecimal calculatedAmount;
}
