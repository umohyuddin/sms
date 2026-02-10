package com.smartsolutions.eschool.employee.dtos.salaryComponent;

import com.smartsolutions.eschool.global.enums.ComponentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryComponentSearchDto {
    private String name;
    private ComponentType type;
    private Boolean isPercentage;
}
