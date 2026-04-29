package com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class SalaryStructureComponentRequestDTO {

    @NotNull(message = "Salary Structure ID is required")
    private Long salaryStructureId;

    @NotEmpty
    private List<SalaryComponentMappingRequestDto> components;

}
