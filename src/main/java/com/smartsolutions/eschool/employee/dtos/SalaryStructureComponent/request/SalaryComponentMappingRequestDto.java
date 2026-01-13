package com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SalaryComponentMappingRequestDto {

    @NotNull
    private Long componentId;

    @NotBlank
    private String componentName;

    @NotNull
    private Boolean isPercentage;

    @NotBlank
    private BigDecimal value;
}
