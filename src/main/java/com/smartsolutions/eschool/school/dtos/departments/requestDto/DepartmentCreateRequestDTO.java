package com.smartsolutions.eschool.school.dtos.departments.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request object for creating or updating a department")
public class DepartmentCreateRequestDTO {
    @Schema(description = "Unique identifier of the department", example = "1")
    private Long id;

    @NotNull(message = "Campus ID is required")
    @Schema(description = "ID of the associated campus", example = "1")
    private Long campusId;

    @NotNull(message = "Department type ID is required")
    @Schema(description = "ID of the department type", example = "1")
    private Long departmentTypeId;

    @NotBlank(message = "Department code is required")
    @Schema(description = "Unique code for the department", example = "HR-001")
    private String departmentCode;

    @NotBlank(message = "Department name is required")
    @Schema(description = "Name of the department", example = "Human Resources")
    private String departmentName;

    @Schema(description = "Description of the department", example = "Manages personnel and recruitment")
    private String description;

    @Schema(description = "ID of the parent department", example = "1")
    private Long parentId;

    @Schema(description = "ID of the head employee", example = "101")
    private Long headEmployeeId;

    @Schema(description = "Status indicating if the department is active", example = "true")
    private boolean active = true;
}
