package com.smartsolutions.sms.academic.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentExamMarksRequestDTO {
    @NotNull
    private Long examSubjectId;
    
    @NotNull
    private Long studentId;
    
    private BigDecimal obtainedMarks;
    private BigDecimal graceMarks = BigDecimal.ZERO;
    private boolean locked = false;
    private String remarks;
}
