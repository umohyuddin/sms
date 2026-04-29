package com.smartsolutions.eschool.lookups.dtos.country.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CountryRequestDTO {
    @NotBlank(message = "Country code is required")
    @Size(max = 5, message = "Country code must be at most 5 characters")
    private String countryCode;

    @NotBlank(message = "Country name is required")
    @Size(max = 100, message = "Country name must be at most 100 characters")
    private String countryName;

    @Size(max = 3, message = "ISO code must be at most 3 characters")
    private String isoCode;

    @Size(max = 10, message = "Phone code must be at most 10 characters")
    private String phoneCode;

    private Boolean isActive = true;
}
