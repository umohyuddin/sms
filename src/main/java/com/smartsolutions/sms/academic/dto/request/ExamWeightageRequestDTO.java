package com.smartsolutions.sms.academic.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamWeightageRequestDTO {
    @NotNull
    private Long standardId;
    
    @NotNull
    private Long subjectId;
    
    @NotNull
    private Long examTermId;
    
    @NotNull
    private BigDecimal weightPercentage;
}
