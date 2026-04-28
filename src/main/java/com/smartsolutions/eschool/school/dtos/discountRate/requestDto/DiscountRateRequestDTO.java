package com.smartsolutions.eschool.school.dtos.discountRate.requestDto;

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

    private Long campusId;

    @NotNull(message = "Academic Year ID is required")
    private Long academicYearId;

    @Positive(message = "Discount value must be positive")
    private BigDecimal value;

    private Boolean isPercentage = false;

    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    private Boolean isActive = true;
}
