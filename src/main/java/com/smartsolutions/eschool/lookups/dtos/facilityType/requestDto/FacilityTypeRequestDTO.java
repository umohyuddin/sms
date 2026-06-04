package com.smartsolutions.eschool.lookups.dtos.facilityType.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Request payload for creating or updating a facility type")
public class FacilityTypeRequestDTO {

    @NotBlank(message = "Code is required")
    @Size(max = 50, message = "Code must be at most 50 characters")
    @Schema(description = "Unique code of the facility type", example = "LAB")
    private String code;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    @Schema(description = "Name of the facility type", example = "Science Laboratory")
    private String name;

    @Size(max = 255, message = "Description must be at most 255 characters")
    @Schema(description = "Detailed description of the facility type", example = "Fully equipped science laboratory")
    private String description;

    @Schema(description = "Whether the facility type is active", example = "true", defaultValue = "true")
    private Boolean isActive = true;
}

