package com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request payload to create or update a school type")
public class SchoolTypeCreateRequestDTO {

    @NotBlank(message = "Code is required")
    @Size(max = 30, message = "Code must be at most 30 characters")
    @Schema(description = "Unique code for the school type", example = "PVT")
    private String code;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    @Schema(description = "Display name of the school type", example = "Private")
    private String name;

    @Size(max = 255, message = "Description must be at most 255 characters")
    @Schema(description = "Optional description", example = "Privately managed institution")
    private String description;

    @Schema(description = "Whether the school type is active", example = "true")
    private Boolean isActive = true;
}

