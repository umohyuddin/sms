package com.smartsolutions.eschool.student.dtos.feeSlab;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeSlabCreateRequestDTO {
    @NotNull(message = "Slab group is required")
    private Long slabGroupId;

    @NotNull(message = "Minimum value is required")
    @DecimalMin(value = "0.0", message = "Minimum value must be greater than or equal to 0")
    private BigDecimal minValue;

    private BigDecimal maxValue;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private BigDecimal amount;

    private String currency;

    private boolean active = true;
}
