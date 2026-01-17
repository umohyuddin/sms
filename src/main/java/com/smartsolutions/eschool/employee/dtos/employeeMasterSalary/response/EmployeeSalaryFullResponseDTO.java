package com.smartsolutions.eschool.employee.dtos.employeeMasterSalary.response;

import com.smartsolutions.eschool.employee.dtos.SalaryStructureComponent.response.SalaryStructureComponentResponseDTO;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.global.enums.SalaryStatus;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.dtos.designations.response.DesignationResponseDTO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeSalaryFullResponseDTO {
    private Long id;
    private Long salaryId;
    private Long employeeId;
    private String employeeCode;
    private String employeeName;
    private String employeeType;
    private BigDecimal grossSalary;
    private BigDecimal baseSalary;
    private BigDecimal totalDeductions;
    private BigDecimal netSalary;
    private LocalDate effectiveDate;
    private Long salaryStructureId;
    private SalaryStatus status;
    private LocalDateTime createdAt;
    private LocalDate effectiveFrom;
    private LocalDateTime updatedAt;
    private EmployeeMasterResponseDto employee;
    private DesignationResponseDTO designation;
    private DepartmentResponseDTO department;
    private List<SalaryStructureComponentResponseDTO> components;
}

