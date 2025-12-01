package com.smartsolutions.eschool.school.dtos.campuses.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CampusResponseDTO {
    private Long id;
    // Use the ID of the institute for simplicity in API calls
    private Long instituteId;
    private String campusName;
    private String contactNumber;
    private String email;
    private String website;
    private String address;
    // Optional: convert byte[] to Base64 string for API transfer
    private byte[] logo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted = false;
    private Long provinceId;
    private Long cityId;
}
