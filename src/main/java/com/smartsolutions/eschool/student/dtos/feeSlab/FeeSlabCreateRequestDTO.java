package com.smartsolutions.eschool.student.dtos.feeSlab;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request object for creating or updating a fee slab (tier)")
public class FeeSlabCreateRequestDTO {
    @NotNull(message = "Slab group is required")
    @Schema(description = "ID of the parent slab group", example = "1")
    private Long slabGroupId;

    @NotNull(message = "Minimum value is required")
    @DecimalMin(value = "0.0", message = "Minimum value must be greater than or equal to 0")
    @Schema(description = "Lower boundary of the tier (e.g., units, income, etc.)", example = "0.00")
    private BigDecimal minValue;

    @Schema(description = "Upper boundary of the tier (e.g., units, income, etc.)", example = "100.00")
    private BigDecimal maxValue;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    @Schema(description = "Monetary amount to charge if the value falls in this slab", example = "500.00")
    private BigDecimal amount;

    @Schema(description = "Currency for the slab amount", example = "PKR")
    private String currency;

    @Schema(description = "Status indicating if this slab is active", example = "true")
    private boolean active = true;
}
