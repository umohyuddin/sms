package com.smartsolutions.eschool.academic.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamSubjectRequestDTO {
    @NotNull
    private Long examId;
    
    @NotNull
    private Long subjectId;
    
    @NotNull
    private BigDecimal totalMarks;
    
    @NotNull
    private BigDecimal passingMarks;
    
    @NotNull
    private LocalDate examDate;
    
    private LocalTime startTime;
    private LocalTime endTime;
    private Long evaluatorId;
}
