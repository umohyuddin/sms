package com.smartsolutions.eschool.student.dtos.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Flat response object for fee rate details")
public class FeeRateDTO {

    @Schema(description = "Unique identifier", example = "100")
    private Long id;

    @Schema(description = "Internal code", example = "RATE-TUI-05")
    private String code;

    @Schema(description = "Name", example = "Grade 5 Tuition Fee")
    private String name;

    @Schema(description = "Description", example = "Monthly tuition fee for standard 5")
    private String description;

    @Schema(description = "Status indicating if active", example = "true")
    private boolean active = true;

    @Schema(description = "Display name of academic year", example = "2024-2025")
    private String academicYear; // e.g., "2024-2025"

    @Schema(description = "Fixed amount", example = "5000.00")
    private BigDecimal fixedAmount;

    @Schema(description = "Percentage value", example = "10.0")
    private BigDecimal percentageValue;

    @Schema(description = "Price per unit", example = "0.00")
    private BigDecimal unitPrice;

    @Schema(description = "ID of the base component for percentage calculation", example = "5")
    private Long percentageOfComponentId;

    @Schema(description = "Name of the base component", example = "Tuition Fee")
    private String percentageOfComponentName;

    @Schema(description = "ID of the slab group", example = "1")
    private Long slabGroupId;

    @Schema(description = "Name of the slab group", example = "Monthly Slabs")
    private String slabGroupName;

    @Schema(description = "ID of the charge type", example = "2")
    private Long chargeTypeId;

    @Schema(description = "Code of the charge type", example = "MONTHLY")
    private String chargeTypeCode;

    @Schema(description = "Name of the charge type", example = "Monthly Charge")
    private String chargeTypeName;

    @Schema(description = "Application priority", example = "1")
    private Integer priority;

    @Schema(description = "Effective start date", example = "2024-04-01")
    private LocalDate effectiveFrom;

    @Schema(description = "Effective end date", example = "2025-03-31")
    private LocalDate effectiveTo;

    // Relations (only IDs and optional basic info)
    @Schema(description = "ID of the campus", example = "1")
    private Long campusId;

    @Schema(description = "Name of the campus", example = "Main Campus")
    private String campusName;

    @Schema(description = "ID of the standard", example = "5")
    private Long standardId;

    @Schema(description = "Name of the standard", example = "Standard 5")
    private String standardName;

    @Schema(description = "ID of the fee component", example = "10")
    private Long feeComponentId;

    @Schema(description = "Name of the fee component", example = "Tuition Fee")
    private String feeComponentName;

    @Schema(description = "Creation timestamp", example = "2024-01-01T12:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "Last update timestamp", example = "2024-04-19T10:30:00")
    private LocalDateTime updatedAt;

    @Schema(description = "Soft delete flag", example = "false")
    private boolean deleted = false;

    @Schema(description = "Deletion timestamp", example = "null")
    private LocalDateTime deletedAt;
}
