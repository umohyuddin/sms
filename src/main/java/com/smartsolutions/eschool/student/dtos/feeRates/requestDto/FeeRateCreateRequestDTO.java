package com.smartsolutions.eschool.student.dtos.feeRates.requestDto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
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
public class FeeRateCreateRequestDTO {

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.00", inclusive = false, message = "Amount must be greater than 0")
    private BigDecimal amount;

    private String currency; // optional (USD/PKR etc.)

    @NotNull(message = "Effective From date is required")
    private LocalDate effectiveFrom;

    private LocalDate effectiveTo;

    @NotNull(message = "Campus is required")
    private Long campusId;

    @NotNull(message = "Standard is required")
    private Long standardId;

    @NotNull(message = "Fee Component is Required")
    private Long feeComponentId;

    @NotNull(message = "Academic Year is required")
    private Long academicYearId;

    private boolean active = true;
}
