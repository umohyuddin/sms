package com.smartsolutions.eschool.employee.dtos.EmployeeType.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class EmployeeTypeResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Boolean active;

}
