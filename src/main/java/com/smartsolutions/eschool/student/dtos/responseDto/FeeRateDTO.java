package com.smartsolutions.eschool.student.dtos.responseDto;

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
public class FeeRateDTO {

    private Long id;

    private String code;
    private String name;
    private String description;
    // private String chargeType; // e.g., FIXED, PERCENTAGE
    // private String recurrenceRule; // e.g., MONTHLY, YEARLY
    private boolean active = true;

    private String academicYear; // e.g., "2024-2025"

    private BigDecimal fixedAmount;
    private BigDecimal percentageValue;
    private BigDecimal unitPrice;
    private Long percentageOfComponentId;
    private String percentageOfComponentName;

    private Long slabGroupId;
    private String slabGroupName;

    private Long chargeTypeId;
    private String chargeTypeCode;
    private String chargeTypeName;

    private Integer priority;

    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    // Relations (only IDs and optional basic info)
    private Long campusId;
    private String campusName;

    private Long standardId;
    private String standardName;

    private Long feeComponentId;
    private String feeComponentName;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted = false;
    private LocalDateTime deletedAt;
}
