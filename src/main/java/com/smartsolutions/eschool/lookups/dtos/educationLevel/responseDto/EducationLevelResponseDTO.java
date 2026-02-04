package com.smartsolutions.eschool.lookups.dtos.educationLevel.responseDto;

import lombok.Data;

@Data
public class EducationLevelResponseDTO {
    private Long id;
    private String code;
    private String name;
    private Boolean isActive;
}
