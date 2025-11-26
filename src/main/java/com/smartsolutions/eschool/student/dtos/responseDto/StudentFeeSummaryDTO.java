package com.smartsolutions.eschool.student.dtos.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentFeeSummaryDTO {
    private Long id;

    private BigDecimal totalAssignedFee;

    private BigDecimal totalPaid;

    private BigDecimal balance;

    private Long studentId;
    private String studentFullName;   // optional (recommended)

    private Long academicYearId;
    private String academicYearName;
}
