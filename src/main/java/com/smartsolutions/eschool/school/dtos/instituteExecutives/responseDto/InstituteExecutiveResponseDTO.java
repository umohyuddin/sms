package com.smartsolutions.eschool.school.dtos.instituteExecutives.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteExecutiveResponseDTO {

    private Long id;
    private Long instituteId;
    private String fullName;
    private String title;
    private String email;
}
