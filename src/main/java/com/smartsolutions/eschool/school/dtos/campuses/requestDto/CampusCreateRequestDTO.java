package com.smartsolutions.eschool.school.dtos.campuses.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
public class CampusCreateRequestDTO {
    private Long id;
    private Long instituteId;

    @NotNull
    private String campusName;
    private String campusCode;
    private boolean active;
    private String contactNumber;
    private String email;
    private String website;
    private String address;
    private String city;
    private byte[] logo;
    private Long provinceId;
    private Long cityId;
}
