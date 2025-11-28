package com.smartsolutions.eschool.student.dtos.studentDiscountAssignment.requestDto;

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
public class StudentDiscountAssignmentRequestDTO {
    @NotNull(message = "Student ID is required")
    private Long studentId;

    @NotNull(message = "Discount Rate ID is required")
    private Long discountRateId;

    @NotNull(message = "Academic Year ID is required")
    private Long academicYearId;

    private BigDecimal appliedAmount;      // optional
    private BigDecimal appliedPercentage;  // optional

    private String reason;
}
