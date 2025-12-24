package com.smartsolutions.eschool.employee.dtos.employeeMaster.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeAddressRequestDto {
    @NotNull(message = "Employee ID is required")
    private Long employeeId;

    @NotBlank(message = "Address type is required")
    private String addressType;   // PERMANENT, CURRENT, OFFICE

    @NotBlank(message = "Address line 1 is required")
    private String line1;

    private String line2;

    @NotNull(message = "City ID is required")
    private Long cityId;

    private Long provinceId; // Optional, can be null

    @NotNull(message = "Country ID is required")
    private Long countryId;

    private String postalCode;
}
