package com.smartsolutions.eschool.school.dtos.academicYear.requestDto;


import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 20)
    private String code;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    private Long totalMonths;
    private String remarks;
    private Boolean isCurrent;

    @AssertTrue(message = "Start date must be before end date")
    public boolean isDateRangeValid() {
        return startDate != null && endDate != null && startDate.isBefore(endDate);
    }
}
