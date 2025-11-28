package com.smartsolutions.eschool.school.dtos.discountRate.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountRateRequestDTO {
    @NotNull(message = "Discount Sub Type ID is required")
    private Long discountSubTypeId;

    @NotNull(message = "Campus ID is required")
    private Long campusId; // optional if discount is global

    @NotNull(message = "Academic Year ID is required")
    private Long academicYearId;

    @Positive(message = "Discount value must be positive")
    private BigDecimal value; // fixed amount

    private Boolean isPercentage = false; // true if discount is percentage, false if fixed amount

    private LocalDate effectiveFrom; // optional
    private LocalDate effectiveTo;   // optional

    private Boolean isActive = true;
}
