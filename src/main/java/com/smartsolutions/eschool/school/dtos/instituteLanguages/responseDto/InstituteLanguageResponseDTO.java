package com.smartsolutions.eschool.school.dtos.instituteLanguages.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteLanguageResponseDTO {
    private Long instituteId;
    private Long languageId;
    private String languageName;
}
