package com.smartsolutions.eschool.lookups.dtos.currency.responseDto;

import lombok.Data;

@Data
public class CurrencyResponseDTO {
    private Integer id;
    private String isoCode;
    private String name;
    private String symbol;
    private Boolean isActive;
}
