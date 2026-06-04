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

    private Long cityId;
    private String cityName;

    private Long provinceId; // optional
    private String provinceName;

    private String postalCode;

    private Long countryId;
    private String countryName;
}
