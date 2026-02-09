package com.smartsolutions.sms.academic.dto.response;

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
    private boolean active;
}
