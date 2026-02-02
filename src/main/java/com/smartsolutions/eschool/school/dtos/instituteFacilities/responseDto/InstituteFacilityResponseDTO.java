package com.smartsolutions.eschool.school.dtos.instituteFacilities.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteFacilityResponseDTO {
    private Long id;
    private Long instituteId;
    private String facilityType;
    private String description;
    private Integer capacity;
}
