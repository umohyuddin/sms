package com.smartsolutions.sms.academic.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessmentRequestDTO {
    private Long id;
    
    @NotNull
    private Long teacherSubjectAssignmentId;
    
    @NotNull
    private Long academicYearId;
    
    @NotNull
    private Long assessmentTypeId;
    
    @NotBlank(message = "Title is mandatory")
    private String title;
    
    private String description;
    
    @NotNull
    private BigDecimal totalMarks;
    
    private BigDecimal passingMarks;
    private LocalDate assessmentDate;
    private LocalDate dueDate;
    private boolean published = false;
    private boolean active = true;
}
