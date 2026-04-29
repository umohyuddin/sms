package com.smartsolutions.eschool.employee.dtos.salaryComponent.request;

import com.smartsolutions.eschool.global.enums.ComponentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalaryComponentRequestDTO {
    
    @NotBlank(message = "Component name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @NotNull(message = "Component type is required")
    private ComponentType type;

    @NotNull(message = "isPercentage field is required")
    private Boolean isPercentage;
}
