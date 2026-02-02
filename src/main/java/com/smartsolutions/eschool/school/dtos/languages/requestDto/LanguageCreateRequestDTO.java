package com.smartsolutions.eschool.school.dtos.languages.requestDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageCreateRequestDTO {
    private String isoCode;

    @NotBlank
    private String name;
}
