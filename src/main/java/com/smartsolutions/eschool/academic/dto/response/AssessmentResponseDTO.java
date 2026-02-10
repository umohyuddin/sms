package com.smartsolutions.eschool.academic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentResponseDTO {
    private Long id;
    private Long teacherSubjectAssignmentId;
    private String subjectName;
    private String teacherName;
    private Long assessmentTypeId;
    private String assessmentTypeName;
    private String title;
    private String description;
    private BigDecimal totalMarks;
    private BigDecimal passingMarks;
    private LocalDate assessmentDate;
    private LocalDate dueDate;
    private boolean published;
    private boolean active;
}
