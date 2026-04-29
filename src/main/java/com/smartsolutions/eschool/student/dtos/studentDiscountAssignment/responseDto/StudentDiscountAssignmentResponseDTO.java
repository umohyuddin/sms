package com.smartsolutions.eschool.student.dtos.studentDiscountAssignment.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response object containing detailed student discount assignment info")
public class StudentDiscountAssignmentResponseDTO {
    @Schema(description = "Unique identifier of the assignment", example = "1")
    private Long id;

    @Schema(description = "ID of the student", example = "5001")
    private Long studentId;

    @Schema(description = "Full name of the student", example = "John Doe")
    private String studentName;

    @Schema(description = "ID of the discount rate", example = "20")
    private Long discountRateId;

    @Schema(description = "Name of the discount sub-type", example = "Employee Sibling")
    private String discountSubTypeName;

    @Schema(description = "Whether the discount is percentage-based", example = "true")
    private Boolean isPercentage;

    @Schema(description = "The rate value (percentage or amount)", example = "10.0")
    private BigDecimal value;

    @Schema(description = "ID of the academic year", example = "1")
    private Long academicYearId;

    @Schema(description = "Name of the academic year", example = "2024-2025")
    private String academicYearName;

    @Schema(description = "Actual amount applied", example = "500.00")
    private BigDecimal appliedAmount;

    @Schema(description = "Actual percentage applied", example = "10.0")
    private BigDecimal appliedPercentage;

    @Schema(description = "Status of the discount", example = "true")
    private Boolean isActive;

    @Schema(description = "Reason provided for assignment", example = "Scholarship")
    private String reason;

    @Schema(description = "Timestamp of creation")
    private LocalDateTime createdAt;


    @Schema(description = "ID of the campus", example = "1")
    private Long campusId;


    @Schema(description = "Whether the assignment is currently active (UI toggle state)", example = "true")
    private Boolean assignmentActive;

    // ===== Discount Rate =====
    @Schema(description = "Raw value from the discount rate source", example = "10.0")
    private BigDecimal discountValue;

    @Schema(description = "Start of validity", example = "2024-04-01")
    private LocalDate effectiveFrom;

    @Schema(description = "End of validity", example = "2025-03-31")
    private LocalDate effectiveTo;

    @Schema(description = "System status of the discount rate", example = "true")
    private Boolean discountRateActive;

    // ===== Discount Sub Type =====
    @Schema(description = "ID of sub-type", example = "5")
    private Long discountSubTypeId;

    @Schema(description = "Code of sub-type", example = "SIB-EMP")
    private String discountSubTypeCode;

    @Schema(description = "Display order", example = "1")
    private Integer discountSubTypeDisplayOrder;

    // ===== Discount Type =====
    @Schema(description = "ID of parent type", example = "2")
    private Long discountTypeId;

    @Schema(description = "Code of parent type", example = "SIBLING")
    private String discountTypeCode;

    @Schema(description = "Display name of parent type", example = "Sibling Discount")
    private String discountTypeName;

    @Schema(description = "Charge type affinity", example = "TUITION")
    private String chargeType;

    @Schema(description = "Display order for parent type", example = "1")
    private Integer discountTypeDisplayOrder;
}
