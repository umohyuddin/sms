package com.smartsolutions.eschool.lookups.dtos.language.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LanguageRequestDTO {
    @NotBlank(message = "ISO code is required")
    @Size(max = 10, message = "ISO code must be at most 10 characters")
    private String isoCode;

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must be at most 50 characters")
    private String name;

    private Boolean isActive = true;
}
