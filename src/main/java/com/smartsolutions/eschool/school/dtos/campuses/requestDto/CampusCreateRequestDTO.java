package com.smartsolutions.eschool.school.dtos.campuses.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request object for creating or updating a campus")
public class CampusCreateRequestDTO {
    @Schema(description = "Unique identifier of the campus", example = "1")
    private Long id;

    @Schema(description = "ID of the associated institute", example = "101")
    private Long instituteId;

    @NotNull
    @Schema(description = "Name of the campus", example = "City Center Campus")
    private String campusName;

    @Schema(description = "Unique code for the campus", example = "CCC-001")
    private String campusCode;

    @Schema(description = "Status indicating if the campus is currently active", example = "true")
    private boolean active;

    @Schema(description = "Primary contact phone number", example = "+923001234567")
    private String contactNumber;

    @Schema(description = "Official email address", example = "contact@citycampus.edu")
    private String email;

    @Schema(description = "Official website URL", example = "https://citycampus.edu")
    private String website;

    @Schema(description = "Physical address of the campus", example = "Plot 45, Sector G-10, Islamabad")
    private String address;

    @Schema(description = "City name", example = "Islamabad")
    private String city;

    @Schema(description = "Binary logo data (optional)")
    private byte[] logo;

    @Schema(description = "ID of the province", example = "1")
    private Long provinceId;

    @Schema(description = "ID of the city lookup", example = "1")
    private Long cityId;
}
