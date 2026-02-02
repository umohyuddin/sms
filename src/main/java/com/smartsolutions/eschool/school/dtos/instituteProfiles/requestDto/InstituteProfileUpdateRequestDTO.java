package com.smartsolutions.eschool.school.dtos.instituteProfiles.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteProfileUpdateRequestDTO {

    private String description;
    private String mission;
    private String vision;
    private String values;
    private String aboutChairperson;
    private String organizationEmail;
}
