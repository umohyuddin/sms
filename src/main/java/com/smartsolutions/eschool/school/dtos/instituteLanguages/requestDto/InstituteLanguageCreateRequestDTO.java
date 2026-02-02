package com.smartsolutions.eschool.school.dtos.instituteLanguages.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteLanguageCreateRequestDTO {
    @NotNull
    private Long instituteId;

    @NotNull
    private Long languageId;
}
