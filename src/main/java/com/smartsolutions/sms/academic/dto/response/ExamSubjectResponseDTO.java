package com.smartsolutions.sms.academic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamSubjectResponseDTO {
    private Long examId;
    private String examName;
    private Long subjectId;
    private String subjectName;
    private BigDecimal totalMarks;
    private BigDecimal passingMarks;
    private LocalDate examDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long evaluatorId;
    private String evaluatorName;
}
