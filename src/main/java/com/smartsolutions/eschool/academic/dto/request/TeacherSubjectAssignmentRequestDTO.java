package com.smartsolutions.eschool.academic.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherSubjectAssignmentRequestDTO {
    @NotNull
    private Long employeeId;
    
    @NotNull
    private Long standardId;
    
    @NotNull
    private Long sectionId;
    
    @NotNull
    private Long subjectId;
    
    @NotNull
    private Long academicYearId;
    
    @NotNull
    private LocalDate effectiveFrom;
    
    private String teachingRole = "PRIMARY";
    private LocalDate effectiveTo;
    private boolean active = true;
}
