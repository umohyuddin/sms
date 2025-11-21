package com.smartsolutions.eschool.school.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstituteDTO {

    private Integer id;
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    private String website;
    private String tagLine;
    private String country;
    private LocalDate establishedDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

//    // Optional: if you want to include campuses in the DTO
//    private List<CampusDTO> campuses;

    // Optional: if you want to include logo as Base64
//    private String logoBase64;
}
