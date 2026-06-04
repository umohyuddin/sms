package com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteAccreditationUpdateRequestDTO {
    private String authorityName;
    private String licenseNumber;
    private LocalDate validFrom;
    private LocalDate validTo;
    private Boolean isActive;
}
