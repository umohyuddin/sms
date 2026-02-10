package com.smartsolutions.eschool.academic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTermResultResponseDTO {
    private Long studentId;
    private String studentName;
    private Long academicYearId;
    private String academicYearName;
    private Long examTermId;
    private String examTermName;
    private BigDecimal totalMarks;
    private BigDecimal obtainedMarks;
    private BigDecimal percentage;
    private String grade;
    private BigDecimal gpa;
    private LocalDateTime generatedAt;
}
