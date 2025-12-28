package com.smartsolutions.eschool.school.dtos.institute.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstituteResponseDTO {
    private Long id;
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    private String website;
    private String tagLine;
    private byte[] logo;
    private LocalDate establishedDate;

    private Long countryId;
    private String countryName;

    private Long provinceId;
    private String provinceName;

    private Long cityId;
    private String cityName;
     private Long campusCount;
}
