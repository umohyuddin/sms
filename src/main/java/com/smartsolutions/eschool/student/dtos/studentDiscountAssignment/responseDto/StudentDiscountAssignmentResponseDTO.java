package com.smartsolutions.eschool.student.dtos.studentDiscountAssignment.responseDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDiscountAssignmentResponseDTO {
    private Long id;
    private Long studentId;
    private String studentName;

    private Long discountRateId;
    private String discountSubTypeName;
    private Boolean isPercentage;
    private BigDecimal value;

    private Long academicYearId;
    private String academicYearName;

    private BigDecimal appliedAmount;
    private BigDecimal appliedPercentage;

    private Boolean isActive;
    private String reason;

    private LocalDateTime createdAt;
}
