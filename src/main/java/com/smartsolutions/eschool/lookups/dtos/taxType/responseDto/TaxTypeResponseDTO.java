package com.smartsolutions.eschool.lookups.dtos.taxType.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaxTypeResponseDTO {
    private Long id;
    private String code;
    private String name;
    private BigDecimal taxPercentage;
    private Long countryId;
    private String countryName;
    private Boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
