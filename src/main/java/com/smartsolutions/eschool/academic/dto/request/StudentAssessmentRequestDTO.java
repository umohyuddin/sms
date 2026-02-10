package com.smartsolutions.eschool.academic.dto.request;

import com.smartsolutions.eschool.academic.entity.mapping.StudentAssessmentEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentAssessmentRequestDTO {
    @NotNull
    private Long assessmentId;
    
    @NotNull
    private Long studentId;
    
    private BigDecimal obtainedMarks;
    private String grade;
    private String remarks;
    private StudentAssessmentEntity.SubmissionStatus submissionStatus = StudentAssessmentEntity.SubmissionStatus.NOT_SUBMITTED;
    private Long evaluatedById;
}
