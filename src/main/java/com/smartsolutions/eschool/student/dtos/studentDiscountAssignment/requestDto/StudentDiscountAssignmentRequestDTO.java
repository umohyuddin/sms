package com.smartsolutions.eschool.student.dtos.studentDiscountAssignment.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
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
@Schema(description = "Request object for assigning a discount rate to a student")
public class StudentDiscountAssignmentRequestDTO {
    @NotNull(message = "Student ID is required")
    @Schema(description = "ID of the student", example = "5001")
    private Long studentId;

    @NotNull(message = "Campus ID is required")
    @Schema(description = "ID of the campus", example = "1")
    private Long campusId;

    @NotNull(message = "Discount Rate ID is required")
    @Schema(description = "ID of the pre-defined discount rate", example = "20")
    private Long discountRateId;

    @NotNull(message = "Academic Year ID is required")
    @Schema(description = "ID of the academic year", example = "1")
    private Long academicYearId;

    @Schema(description = "Calculated amount if fixed discount", example = "500.00")
    private BigDecimal appliedAmount;      // optional

    @Schema(description = "Percentage value if applicable", example = "10.0")
    private BigDecimal appliedPercentage;  // optional

    @Schema(description = "Total assigned fee for calculation context", example = "5000.00")
    private BigDecimal totalAssignedFee;   // added for calculation

    @Schema(description = "Business reason for applying this discount", example = "Sibling discount")
    private String reason;
}
