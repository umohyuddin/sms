package com.smartsolutions.eschool.lookups.dtos.city.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityResponseDTO {
    private Long id;
    private Long provinceId;
    private String name;
    private String code;
    private Boolean isActive;
    private Boolean deleted;
}

