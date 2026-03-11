package com.smartsolutions.eschool.employee.dtos.EmployeeType.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeTypeRequestDTO {

    @NotBlank(message = "Employee type name is required")
    @Size(max = 50, message = "Employee type name must not exceed 50 characters")
    private String name;

    @Size(max = 255, message = "Description must not exceed 255 characters")
    private String description;

    private Boolean active = true;
}
