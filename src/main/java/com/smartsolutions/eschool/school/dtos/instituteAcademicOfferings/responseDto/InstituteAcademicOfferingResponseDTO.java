package com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteAcademicOfferingResponseDTO {
    private Long id;
    private Long instituteId;
    private String educationLevel;
    private String curriculum;
    private String board;
}
