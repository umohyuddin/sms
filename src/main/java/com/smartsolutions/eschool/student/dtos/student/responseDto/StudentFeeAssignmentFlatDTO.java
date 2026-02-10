package com.smartsolutions.eschool.student.dtos.student.responseDto;

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
public class StudentFeeAssignmentFlatDTO {

    // --- Student Info ---
    private Long studentId;
    private String studentCode;
    private String fullName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Long campusId;
    private String campusName;
    private Long standardId;
    private String standardName;
    private Long sectionId;
    private String sectionName;
    private Long academicYearId;
    private String academicYearName;

    // --- Fee Assignment Info ---
    private Long assignmentId;
    private Double totalAmount;
    private LocalDate assignedDate;
    private LocalDate dueDate;

    // --- Fee Rate Info ---
    private Long feeRateId;
    private BigDecimal feeAmount;
    private String currency;
    private LocalDate feeEffectiveFrom;
    private LocalDate feeEffectiveTo;

    // --- Fee Component Info ---
    private Long feeComponentId;
    private String feeComponentCode;
    private String feeComponentName;
    private Boolean discountable;
    private Boolean taxable;

    // --- Fee Catalog Info ---
    private Long feeCatalogId;
    private String feeCatalogCode;
    private String feeCatalogName;
    private String feeCatalogChargeType;
    private String feeCatalogRecurrenceRule;
}
