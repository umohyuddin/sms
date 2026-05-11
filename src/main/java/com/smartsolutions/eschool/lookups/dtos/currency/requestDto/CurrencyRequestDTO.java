package com.smartsolutions.eschool.lookups.dtos.currency.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Request payload for creating or updating a currency")
public class CurrencyRequestDTO {

    @NotBlank(message = "ISO code is required")
    @Size(max = 10, message = "ISO code must be at most 10 characters")
    @Schema(description = "ISO code of the currency", example = "USD")
    private String isoCode;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    @Schema(description = "Name of the currency", example = "US Dollar")
    private String name;

    @Size(max = 10, message = "Symbol must be at most 10 characters")
    @Schema(description = "Symbol of the currency", example = "$")
    private String symbol;

    @Schema(description = "Whether the currency is active", example = "true", defaultValue = "true")
    private Boolean isActive = true;
}

