package com.smartsolutions.eschool.lookups.dtos.language.responseDto;

import lombok.Data;

@Data
public class LanguageResponseDTO {
    private Long id;
    private String isoCode;
    private String name;
    private Boolean isActive;
}
