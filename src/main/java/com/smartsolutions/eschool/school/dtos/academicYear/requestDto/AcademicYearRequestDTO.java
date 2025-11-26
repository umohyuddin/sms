package com.smartsolutions.eschool.school.dtos.academicYear.requestDto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AcademicYearRequestDTO {

    private Long id;
    private String name; // e.g., "2024-2025"
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isCurrent;
}
