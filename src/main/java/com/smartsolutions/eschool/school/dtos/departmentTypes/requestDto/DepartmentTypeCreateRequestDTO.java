package com.smartsolutions.eschool.school.dtos.departmentTypes.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request object for creating or updating a department type")
public class DepartmentTypeCreateRequestDTO {
    @Schema(description = "Unique identifier of the department type", example = "1")
    private Long id;

    @NotBlank(message = "Department type code is required")
    @Schema(description = "Unique code for the department type", example = "HR")
    private String code;

    @NotBlank(message = "Department type name is required")
    @Schema(description = "Name of the department type", example = "Human Resources")
    private String name;

    @Schema(description = "Description of the department type", example = "Manages personnel and payroll")
    private String description;

    @Schema(description = "Status indicating if the department type is active", example = "true")
    private boolean active = true;
}
