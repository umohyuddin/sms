package com.smartsolutions.eschool.lookups.dtos.currency.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CurrencyRequestDTO {
    @NotBlank(message = "ISO code is required")
    @Size(max = 10, message = "ISO code must be at most 10 characters")
    private String isoCode;

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @Size(max = 10, message = "Symbol must be at most 10 characters")
    private String symbol;

    private Boolean isActive = true;
}
