package com.smartsolutions.eschool.auth.dtos.auth.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Employee details for the authenticated user")
public class EmployeeDetailsDTO {

    @Schema(description = "Employee ID", example = "50")
    private Long employeeId;

    @Schema(description = "Employee code", example = "EMP001")
    private String employeeCode;

    @Schema(description = "Employee full name", example = "John Doe")
    private String employeeFullName;

    @Schema(description = "Employee first name", example = "John")
    private String employeeFirstName;

    @Schema(description = "Employee last name", example = "Doe")
    private String employeeLastName;
}
