package com.smartsolutions.eschool.academic.dto.request;

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
    private Long academicYearId;

    @NotNull
    private Long standardSubjectId;

    @NotNull
    private Long examTermId;

    @NotNull
    private BigDecimal weightPercentage;
    private boolean active = true;
}
