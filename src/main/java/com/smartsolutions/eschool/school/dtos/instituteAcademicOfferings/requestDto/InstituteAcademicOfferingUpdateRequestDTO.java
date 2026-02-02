package com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteAcademicOfferingUpdateRequestDTO {
    private String educationLevel;
    private String curriculum;
    private String board;
}
