package com.smartsolutions.sms.academic.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTermResultRequestDTO {
    @NotNull
    private Long studentId;
    
    @NotNull
    private Long academicYearId;
    
    @NotNull
    private Long examTermId;
    
    private BigDecimal totalMarks;
    private BigDecimal obtainedMarks;
    private BigDecimal percentage;
    private String grade;
    private BigDecimal gpa;
}
