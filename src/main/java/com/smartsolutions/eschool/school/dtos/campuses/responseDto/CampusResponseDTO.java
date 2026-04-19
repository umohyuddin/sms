package com.smartsolutions.eschool.school.dtos.campuses.responseDto;

import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Response object containing detailed campus information")
public class CampusResponseDTO {
    @Schema(description = "Unique identifier of the campus", example = "1")
    private Long id;

    @Schema(description = "ID of the associated institute", example = "101")
    private Long instituteId;

    @Schema(description = "Name of the associated institute", example = "Smart Academy")
    private String instituteName;

    @Schema(description = "ID of the country", example = "1")
    private Long countryId;

    @Schema(description = "Name of the country", example = "Pakistan")
    private String countryName;

    @Schema(description = "Name of the campus", example = "City Center Campus")
    private String campusName;

    @Schema(description = "Unique code for the campus", example = "CCC-001")
    private String campusCode;

    @Schema(description = "Primary contact phone number", example = "+923001234567")
    private String contactNumber;

    @Schema(description = "Official email address", example = "contact@citycampus.edu")
    private String email;

    @Schema(description = "Official website URL", example = "https://citycampus.edu")
    private String website;

    @Schema(description = "Physical address of the campus", example = "Plot 45, Sector G-10, Islamabad")
    private String address;

    @Schema(description = "Binary logo data")
    private byte[] logo;

    @Schema(description = "Timestamp when the record was created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the record was last updated")
    private LocalDateTime updatedAt;

    @Schema(description = "Indicates if the record is soft-deleted", example = "false")
    private boolean deleted = false;

    @Schema(description = "Status indicating if the campus is active", example = "true")
    private boolean isActive;

    @Schema(description = "ID of the province", example = "1")
    private Long provinceId;

    @Schema(description = "ID of the city lookup", example = "1")
    private Long cityId;

    @Schema(description = "Province details")
    private ProvinceResponseDTO province;

    @Schema(description = "City details")
    private CityResponseDTO city;
}
