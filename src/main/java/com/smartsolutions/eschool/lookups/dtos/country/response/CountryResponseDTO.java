package com.smartsolutions.eschool.lookups.dtos.country.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryResponseDTO {
    private Long id;
    private String countryCode;
    private String countryName;
    private String isoCode;
    private String phoneCode;
    private Boolean isActive;
}
