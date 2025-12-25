package com.smartsolutions.eschool.employee.dtos.salaryComponent.response;


import com.smartsolutions.eschool.global.enums.ComponentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaryComponentResponseDTO {

    private Long id;
    private String name;
    private ComponentType type;
    private Boolean isPercentage;
}
