package com.smartsolutions.sms.academic.dto.response;

import com.smartsolutions.sms.academic.entity.mapping.StudentAssessmentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentAssessmentResponseDTO {
    private Long assessmentId;
    private String assessmentTitle;
    private Long studentId;
    private String studentName;
    private String studentCode;
    private BigDecimal obtainedMarks;
    private String grade;
    private String remarks;
    private StudentAssessmentEntity.SubmissionStatus submissionStatus;
    private String evaluatedBy;
    private LocalDateTime evaluatedAt;
}
