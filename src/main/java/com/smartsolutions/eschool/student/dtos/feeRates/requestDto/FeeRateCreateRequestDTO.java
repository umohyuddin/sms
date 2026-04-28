package com.smartsolutions.eschool.student.dtos.feeRates.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Request object for defining a new fee rate (amount or percentage)")
public class FeeRateCreateRequestDTO {

    @Schema(description = "Fixed amount for the fee", example = "5000.00")
    private BigDecimal fixedAmount;

    @Schema(description = "Percentage value for the fee (if applicable)", example = "10.0")
    private BigDecimal percentageValue;

    @Schema(description = "ID of the component on which the percentage is calculated", example = "5")
    private Long percentageOfComponentId;

    @Schema(description = "Unit price if the fee is volume-based", example = "50.00")
    private BigDecimal unitPrice;

    @Schema(description = "ID of the slab group if the fee follows a tiered structure", example = "1")
    private Long slabGroupId;

    @NotNull(message = "Charge Type is required")
    @Schema(description = "ID of the charge type", example = "2")
    private Long chargeTypeId;

    @Schema(description = "Calculation priority relative to other rates", example = "1")
    private Integer priority;

    @Schema(description = "Currency code for the rate", example = "PKR")
    private String currency; // optional (USD/PKR etc.)

    @NotNull(message = "Effective From date is required")
    @Schema(description = "Start date of this rate's validity", example = "2024-04-01")
    private LocalDate effectiveFrom;

    @Schema(description = "End date of this rate's validity (Optional)", example = "2025-03-31")
    private LocalDate effectiveTo;

    @NotNull(message = "Campus is required")
    @Schema(description = "ID of the campus where this rate applies", example = "1")
    private Long campusId;

    @NotNull(message = "Standard is required")
    @Schema(description = "ID of the academic standard (grade level)", example = "5")
    private Long standardId;

    @NotNull(message = "Fee Component is Required")
    @Schema(description = "ID of the fee component (e.g., Tuition Fee)", example = "10")
    private Long feeComponentId;

    @NotNull(message = "Academic Year is required")
    @Schema(description = "ID of the academic year", example = "1")
    private Long academicYearId;

    @Schema(description = "Status indicating if this rate is active", example = "true")
    private boolean active = true;
}
