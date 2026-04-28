package com.smartsolutions.eschool.academic.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulkExamWeightageRequestDTO {

    @NotNull(message = "Academic year ID is mandatory")
    private Long academicYearId;

    @NotNull(message = "Exam term ID is mandatory")
    private Long examTermId;

    @NotNull(message = "Standard ID is mandatory")
    private Long standardId;

    @NotEmpty(message = "Weightages cannot be empty")
    @Valid
    private List<SubjectWeightageDTO> weightages;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SubjectWeightageDTO {
        @NotNull(message = "Subject ID is mandatory")
        private Long subjectId;

        @NotNull(message = "Weight percentage is mandatory")
        private BigDecimal weightPercentage;

        private boolean active = true;
    }
}
