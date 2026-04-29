package com.smartsolutions.eschool.academic.dto.response;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeScaleResponseDTO {
    private Long id;
    private BigDecimal minPercentage;
    private BigDecimal maxPercentage;
    private String grade;
    private String remarks;
//    @Transient
//    private java.math.BigDecimal points;
    private boolean active;
    private Long organizationId;
    private java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime updatedAt;
}
