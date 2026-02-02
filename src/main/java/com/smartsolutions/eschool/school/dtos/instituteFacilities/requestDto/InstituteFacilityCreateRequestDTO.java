package com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteFacilityCreateRequestDTO {
    @NotNull
    private Long instituteId;

    private String facilityType;
    private String description;
    private Integer capacity;
}
