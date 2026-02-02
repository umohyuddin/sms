package com.smartsolutions.eschool.school.dtos.instituteProfiles.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteProfileResponseDTO {

    private Long id;
    private Long instituteId;
    private String description;
    private String mission;
    private String vision;
    private String values;
    private String aboutChairperson;
    private String organizationEmail;
}
