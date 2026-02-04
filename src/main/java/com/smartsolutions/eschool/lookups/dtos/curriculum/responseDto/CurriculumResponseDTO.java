package com.smartsolutions.eschool.lookups.dtos.curriculum.responseDto;

import lombok.Data;

@Data
public class CurriculumResponseDTO {
    private Long id;
    private String code;
    private String name;
    private Boolean isActive;
}
