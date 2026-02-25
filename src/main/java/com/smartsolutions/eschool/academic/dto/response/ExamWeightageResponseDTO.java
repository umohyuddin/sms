package com.smartsolutions.eschool.academic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamWeightageResponseDTO {
    private Long id;
    private Long academicYearId;
    private String academicYearName;
    private Long standardSubjectId;
    private String standardName;
    private String subjectName;
    private Long examTermId;
    private String examTermName;
    private BigDecimal weightPercentage;
    private boolean isActive;
}
