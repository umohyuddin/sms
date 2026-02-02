package com.smartsolutions.eschool.school.dtos.educationBoards.requestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EducationBoardCreateRequestDTO {
    private String code;

    @NotBlank
    private String name;

    private String countryCode;
    private String description;
    private Boolean isActive;
}
