package com.smartsolutions.eschool.employee.dtos.salaryComponent.request;

import com.smartsolutions.eschool.global.enums.ComponentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryComponentRequestDTO {
    @NotBlank(message = "Component name is required")
    private String name;

    @NotNull(message = "Component type is required")
    private ComponentType type;

    @NotNull(message = "isPercentage field is required")
    private Boolean isPercentage;
}
