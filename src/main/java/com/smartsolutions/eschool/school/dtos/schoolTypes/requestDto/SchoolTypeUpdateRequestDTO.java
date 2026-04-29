package com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolTypeUpdateRequestDTO {
    private String code;
    private String name;
    private String description;
    private Boolean isActive;
}
