package com.smartsolutions.eschool.school.dtos.departments.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DepartmentRequestDTO {
    @NotBlank(message = "Department code is required")
    @Size(max = 50, message = "Department code cannot exceed 50 characters")
    private String departmentCode;

    @NotBlank(message = "Department name is required")
    @Size(max = 150, message = "Department name cannot exceed 150 characters")
    private String departmentName;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;

    private Long parentDepartmentId;

    private Long headEmployeeId;

    private Boolean active = true;
}
