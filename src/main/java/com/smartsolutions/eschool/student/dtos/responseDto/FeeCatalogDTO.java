package com.smartsolutions.eschool.student.dtos.responseDto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeeCatalogDTO {
    private Long id;

    private String code;
    private String name;
    private String description;
    private String chargeType;
    private String recurrenceRule;
    private boolean active;

    // Relations (exposed as IDs + optional basic info)
    private Long campusId;
    private String campusName;

    private Long academicYearId;
    private String academicYearName;  // "2024-2025"

    private LocalDateTime createdAt;


    private boolean deleted = false;

    private LocalDateTime deletedAt;

//    private List<FeeComponentResponseDTO> components;
}
