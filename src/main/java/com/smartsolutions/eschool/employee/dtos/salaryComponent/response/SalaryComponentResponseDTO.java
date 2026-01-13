package com.smartsolutions.eschool.employee.dtos.salaryComponent.response;


import com.smartsolutions.eschool.global.enums.ComponentType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalaryComponentResponseDTO {

    private Long id;
    private String name;
    private ComponentType type;
    private Boolean isPercentage;
    private BigDecimal value;

}
