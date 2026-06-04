package com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteAcademicOfferingCreateRequestDTO {
    @NotNull
    private Long instituteId;

    private String educationLevel;
    private String curriculum;
    private String board;
}
