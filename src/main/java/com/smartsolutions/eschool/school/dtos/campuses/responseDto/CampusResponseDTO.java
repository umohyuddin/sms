package com.smartsolutions.eschool.school.dtos.campuses.responseDto;

import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CampusResponseDTO {
    private Long id;
    // Use the ID of the institute for simplicity in API calls
    private Long instituteId;
    private String instituteName;
    private Long countryId;
    private String countryName;
    private String campusName;
    private String campusCode;
    private String contactNumber;
    private String email;
    private String website;
    private String address;
    // Optional: convert byte[] to Base64 string for API transfer
    private byte[] logo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted = false;
    private boolean isActive;
    private Long provinceId;
    private Long cityId;
    // private InstituteResponseDTO institute;
    private ProvinceResponseDTO province;
    private CityResponseDTO city;
}
