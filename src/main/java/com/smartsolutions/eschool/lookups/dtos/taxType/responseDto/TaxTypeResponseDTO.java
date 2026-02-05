package com.smartsolutions.eschool.lookups.dtos.taxType.responseDto;

import lombok.Data;

@Data
public class TaxTypeResponseDTO {
    private Long id;
    private String code;
    private String name;
    private java.math.BigDecimal taxPercentage;
    private Long countryId;
    private Boolean isActive;
}
