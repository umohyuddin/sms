package com.smartsolutions.eschool.school.dtos.schoolTypes.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SchoolTypeRequestDTO {
    @NotBlank
    private String code;

    @NotBlank
    private String name;

    private String description;

    private Boolean isActive;
}
