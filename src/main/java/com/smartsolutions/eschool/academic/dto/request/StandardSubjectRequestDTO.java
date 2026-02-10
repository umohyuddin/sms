package com.smartsolutions.eschool.academic.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardSubjectRequestDTO {
    @NotNull
    private Long standardId;
    
    @NotNull
    private Long subjectId;
    
    @NotNull
    private Long academicYearId;
    
    private boolean optional = false;
    private Integer weeklyHours;
    private Integer theoryMarks;
    private Integer practicalMarks;
    private boolean active = true;
}
