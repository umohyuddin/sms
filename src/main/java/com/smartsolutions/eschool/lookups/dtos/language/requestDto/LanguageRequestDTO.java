package com.smartsolutions.eschool.lookups.dtos.language.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Request payload for creating or updating a language")
public class LanguageRequestDTO {

    @NotBlank(message = "ISO code is required")
    @Size(max = 10, message = "ISO code must be at most 10 characters")
    @Schema(description = "ISO code of the language", example = "EN")
    private String isoCode;

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must be at most 50 characters")
    @Schema(description = "Name of the language", example = "English")
    private String name;

    @Schema(description = "Whether the language is active", example = "true", defaultValue = "true")
    private Boolean isActive = true;
}

