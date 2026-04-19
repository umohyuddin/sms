package com.smartsolutions.eschool.student.dtos.feeSlab;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response object containing fee slab details")
public class FeeSlabResponseDTO {
    @Schema(description = "Unique identifier of the slab", example = "10")
    private Long id;

    @Schema(description = "ID of the parent slab group", example = "1")
    private Long slabGroupId;

    @Schema(description = "Name of the parent slab group", example = "Monthly Consumption Slabs")
    private String slabGroupName;

    @Schema(description = "Lower boundary of the tier", example = "0.00")
    private BigDecimal minValue;

    @Schema(description = "Upper boundary of the tier", example = "100.00")
    private BigDecimal maxValue;

    @Schema(description = "Applicable charge amount", example = "500.00")
    private BigDecimal amount;

    @Schema(description = "Currency of the amount", example = "PKR")
    private String currency;

    @Schema(description = "Active status", example = "true")
    private boolean active;

    @Schema(description = "Soft-deleted status", example = "false")
    private boolean deleted;

    @Schema(description = "Creation timestamp", example = "2024-01-01T12:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "Last modification timestamp", example = "2024-04-19T10:30:00")
    private LocalDateTime updatedAt;

    @Schema(description = "Deletion timestamp", example = "null")
    private LocalDateTime deletedAt;
}
