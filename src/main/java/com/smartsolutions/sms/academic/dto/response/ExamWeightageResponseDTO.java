package com.smartsolutions.sms.academic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamWeightageResponseDTO {
    private Long standardId;
    private String standardName;
    private Long subjectId;
    private String subjectName;
    private Long examTermId;
    private String examTermName;
    private BigDecimal weightPercentage;
}
