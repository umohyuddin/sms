package com.smartsolutions.eschool.academic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StandardSubjectResponseDTO {
    private Long standardId;
    private String standardName;
    private Long subjectId;
    private String subjectName;
    private Long academicYearId;
    private String academicYearName;
    private boolean optional;
    private Integer weeklyHours;
    private Integer theoryMarks;
    private Integer practicalMarks;
    private boolean active;
}
