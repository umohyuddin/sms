package com.smartsolutions.eschool.school.dtos.academicYear.responseDto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcademicYearResponseDTO {
    private Long id;

    private String name;          // e.g., "2024-2025"
    private String code;          // e.g., "AY-2024-25"

    private LocalDate startDate;
    private LocalDate endDate;
    private long totalMonths;

    private Boolean isCurrent;
    private String status;        // ACTIVE, UPCOMING, ARCHIVED
    private String remarks;
    private Boolean isLocked;

    // Optional audit info for frontend if needed
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime updatedAt;
    private Long updatedBy;
    private LocalDateTime lockedAt;
    private Long lockedBy;
}
