package com.smartsolutions.eschool.employee.dtos.salaryComponent.response;

import com.smartsolutions.eschool.global.enums.ComponentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalaryComponentResponseDTO {

    private Long id;
    private String name;
    private ComponentType type;
    private Boolean isPercentage;
    private BigDecimal value; // kept mapping for consistency
    
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
