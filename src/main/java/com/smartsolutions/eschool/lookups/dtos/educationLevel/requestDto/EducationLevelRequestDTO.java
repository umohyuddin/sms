package com.smartsolutions.eschool.lookups.dtos.educationLevel.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EducationLevelRequestDTO {
    @NotBlank(message = "Code is required")
    @Size(max = 10, message = "Code must be at most 10 characters")
    private String code;

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must be at most 50 characters")
    private String name;

    private Boolean isActive = true;
}
