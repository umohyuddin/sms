package com.smartsolutions.eschool.school.dtos.instituteExecutives.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteExecutiveUpdateRequestDTO {

    private String fullName;
    private String title;
    private String email;
}
