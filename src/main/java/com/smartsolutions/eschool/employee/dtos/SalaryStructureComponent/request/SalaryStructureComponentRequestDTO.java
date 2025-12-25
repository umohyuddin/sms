package com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalaryStructureComponentRequestDTO {

    @NotNull(message = "Salary Structure ID is required")
    private Long salaryStructureId;

    @NotNull(message = "Component ID is required")
    private Long componentId;

    @NotNull(message = "Value is required")
    private BigDecimal value;
}