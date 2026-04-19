package com.smartsolutions.eschool.student.dtos.student.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Flat reporting model for student fee assignment details")
public class StudentFeeAssignmentFlatDTO {

    // --- Student Info ---
    @Schema(description = "Unique identifier for the student", example = "5001")
    private Long studentId;

    @Schema(description = "Internal code of the student", example = "ST-2024-001")
    private String studentCode;

    @Schema(description = "Full name of the student", example = "John Doe")
    private String fullName;

    @Schema(description = "First name", example = "John")
    private String firstName;

    @Schema(description = "Last name", example = "Doe")
    private String lastName;

    @Schema(description = "Student email", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Contact number", example = "+923001234567")
    private String phone;

    @Schema(description = "ID of the campus", example = "1")
    private Long campusId;

    @Schema(description = "Name of the campus", example = "Main Campus")
    private String campusName;

    @Schema(description = "ID of the grade standard", example = "5")
    private Long standardId;

    @Schema(description = "Name of the standard", example = "Standard 5")
    private String standardName;

    @Schema(description = "ID of the section", example = "1")
    private Long sectionId;

    @Schema(description = "Name of the section", example = "Section A")
    private String sectionName;

    @Schema(description = "ID of the academic year", example = "1")
    private Long academicYearId;

    @Schema(description = "Name of the academic year", example = "2024-2025")
    private String academicYearName;

    // --- Fee Assignment Info ---
    @Schema(description = "Unique ID of the assignment record", example = "100")
    private Long assignmentId;

    @Schema(description = "Aggregated total amount for this assignment", example = "15000.00")
    private Double totalAmount;

    @Schema(description = "The date the assignment was applied", example = "2024-04-01")
    private LocalDate assignedDate;

    @Schema(description = "Deadline for payment", example = "2024-05-15")
    private LocalDate dueDate;

    // --- Fee Rate Info ---
    @Schema(description = "ID of the applied fee rate", example = "50")
    private Long feeRateId;

    @Schema(description = "Base amount for this specific rate", example = "5000.00")
    private BigDecimal feeAmount;

    @Schema(description = "Currency of the fee", example = "PKR")
    private String currency;

    @Schema(description = "Start of fee validity", example = "2024-04-01")
    private LocalDate feeEffectiveFrom;

    @Schema(description = "End of fee validity", example = "2025-03-31")
    private LocalDate feeEffectiveTo;

    // --- Fee Component Info ---
    @Schema(description = "ID of the fee component", example = "10")
    private Long feeComponentId;

    @Schema(description = "Internal code for the component", example = "COMP-001")
    private String feeComponentCode;

    @Schema(description = "Display name of the component", example = "Tuition Fee")
    private String feeComponentName;

    @Schema(description = "Whether discounts can be applied to this component", example = "true")
    private Boolean discountable;

    @Schema(description = "Whether tax applies to this component", example = "false")
    private Boolean taxable;

    // --- Fee Catalog Info ---
    @Schema(description = "ID of the parent fee catalog", example = "5")
    private Long feeCatalogId;

    @Schema(description = "Catalog code", example = "CAT-TUI")
    private String feeCatalogCode;

    @Schema(description = "Catalog name", example = "Tuition Fees 2024")
    private String feeCatalogName;

    @Schema(description = "Charge type defined in catalog", example = "FIXED")
    private String feeCatalogChargeType;

    @Schema(description = "Recurrence pattern defined in catalog", example = "MONTHLY")
    private String feeCatalogRecurrenceRule;
}
