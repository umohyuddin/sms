package com.smartsolutions.eschool.school.dtos.schoolTypes.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolTypeResponseDTO {
    private Long id;
    private String code;
    private String name;
    private String description;
    private Boolean isActive;
}
