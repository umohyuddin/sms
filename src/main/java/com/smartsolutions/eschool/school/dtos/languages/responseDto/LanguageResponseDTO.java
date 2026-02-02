package com.smartsolutions.eschool.school.dtos.languages.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageResponseDTO {
    private Long id;
    private String isoCode;
    private String name;
}
