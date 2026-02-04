package com.smartsolutions.eschool.lookups.dtos.facilityType.responseDto;

import lombok.Data;

@Data
public class FacilityTypeResponseDTO {
    private Long id;
    private String code;
    private String name;
    private String description;
    private Boolean isActive;
}
