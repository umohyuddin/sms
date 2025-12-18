package com.smartsolutions.eschool.employee.dtos.employeeMaster.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeAddressResponseDto {

    private Long id;

    private Long employeeId;

    private String addressType;

    private String line1;
    private String line2;

    private String city;
    private String state;
    private String postalCode;
    private String country;
}