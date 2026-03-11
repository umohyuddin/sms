package com.smartsolutions.eschool.lookups.dtos.province.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceResponseDTO {
    private Long id;
    private Long countryId;
    private String countryName;
    private String name;
    private String code;
    private Boolean isActive;
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
