package com.smartsolutions.eschool.school.dtos.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampusCreateRequestDTO {
    private Long id;
    @NotNull
    private Long instituteId;

    @NotNull
    private String campusName;

    private String contactNumber;
    private String email;
    private String website;
    private String address;
    private String provinceName;
    private String cityName;
    private String city;
    private byte[] logo;
    private Long provinceId;

    private Long cityId;
}
