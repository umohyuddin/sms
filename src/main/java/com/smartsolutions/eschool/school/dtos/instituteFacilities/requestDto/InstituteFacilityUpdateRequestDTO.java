package com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteFacilityUpdateRequestDTO {
    private String facilityType;
    private String description;
    private Integer capacity;
}
