package com.smartsolutions.eschool.school.dtos.instituteProfiles.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteProfileCreateRequestDTO {

    @NotNull(message = "Institute ID is required")
    private Long instituteId;

    private String description;
    private String mission;
    private String vision;
    private String values;
    private String aboutChairperson;
    private String organizationEmail;
}
