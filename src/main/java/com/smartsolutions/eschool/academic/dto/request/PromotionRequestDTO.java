package com.smartsolutions.eschool.academic.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionRequestDTO {
    @NotNull(message = "Academic Year ID is required")
    private Long academicYearId;

    @NotNull(message = "Standard ID is required")
    private Long standardId;

    @NotNull(message = "Section ID is required")
    private Long sectionId;

    private Long examTypeId ;

    private Long examId;       // ← ADD THIS


    @NotNull(message = "Organization ID is required")
    private Long organizationId;
    @NotNull(message = "campusId ID is required")
    private Long campusId;

    private java.util.List<StudentPromotionRequest> studentPromotions;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StudentPromotionRequest {
        private Long studentId;
        private String promotionStatus;
        private String remarks;
    }
}
