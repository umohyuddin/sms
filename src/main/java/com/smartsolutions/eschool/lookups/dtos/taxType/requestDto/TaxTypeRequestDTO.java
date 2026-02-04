package com.smartsolutions.eschool.lookups.dtos.taxType.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaxTypeRequestDTO {
    @NotBlank(message = "Code is required")
    @Size(max = 20, message = "Code must be at most 20 characters")
    private String code;

    @Size(max = 50, message = "Name must be at most 50 characters")
    private String name;

    private Long countryId;

    private Boolean isActive = true;
}
