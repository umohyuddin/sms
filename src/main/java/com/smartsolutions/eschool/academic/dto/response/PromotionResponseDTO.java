package com.smartsolutions.eschool.academic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromotionResponseDTO {
    private Long studentId;
    private String studentName;
    private String rollNumber;
    private String status;
    private String promotionStatus;
    private String remarks;
    private Boolean isProcessed;
}
