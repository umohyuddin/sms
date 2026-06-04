package com.smartsolutions.eschool.school.dtos.educationBoards.requestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationBoardRequestDTO {
    private String code;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    private String countryCode;
    private String description;
    private Boolean isActive = true;
}
