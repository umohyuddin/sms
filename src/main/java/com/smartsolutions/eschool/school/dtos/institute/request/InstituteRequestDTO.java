package com.smartsolutions.eschool.school.dtos.institute.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstituteRequestDTO {

    private String name;
    private String address;
    private String contactNumber;
    private String email;
    private String website;
    private String tagLine;
    private byte[] logo;
    private LocalDate establishedDate;

    private Long countryId;
    private Long provinceId;
    private Long cityId;
}