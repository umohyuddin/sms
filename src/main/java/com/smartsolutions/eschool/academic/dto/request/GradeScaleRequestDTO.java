package com.smartsolutions.eschool.academic.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GradeScaleRequestDTO {
    private Long id;
    
    @NotNull
    private BigDecimal minPercentage;
    
    @NotNull
    private BigDecimal maxPercentage;
    
    @NotBlank(message = "Grade is mandatory")
    private String grade;
    
    private String remarks;
    private java.math.BigDecimal points;
    private Long organizationId;
    private boolean active = true;
}
