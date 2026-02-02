package com.smartsolutions.eschool.school.dtos.educationBoards.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationBoardUpdateRequestDTO {
    private String code;
    private String name;
    private String countryCode;
    private String description;
    private Boolean isActive;
}
