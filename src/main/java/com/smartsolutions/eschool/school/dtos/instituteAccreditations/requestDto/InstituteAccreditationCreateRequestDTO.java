package com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteAccreditationCreateRequestDTO {
    @NotNull
    private Long instituteId;

    private String authorityName;
    private String licenseNumber;
    private LocalDate validFrom;
    private LocalDate validTo;
    private Boolean isActive;
}
