package com.smartsolutions.sms.academic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentExamMarksResponseDTO {
    private Long examSubjectId;
    private Long studentId;
    private String studentName;
    private String studentCode;
    private BigDecimal obtainedMarks;
    private BigDecimal graceMarks;
    private boolean locked;
    private String remarks;
}
