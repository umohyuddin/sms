package com.smartsolutions.eschool.school.dtos.instituteExecutives.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteExecutiveCreateRequestDTO {

    @NotNull
    private Long instituteId;

    private String fullName;
    private String title;
    private String email;
}
