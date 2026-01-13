package com.smartsolutions.eschool.employee.dtos.SalaryStructure.response;

import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.response.SalaryStructureComponentResponseDTO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SalaryStructureDetailDTO {
    private Long id;
    private String employeeTypeName;
    private BigDecimal baseSalary;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    private List<SalaryStructureComponentResponseDTO> components;

}
