package com.smartsolutions.eschool.student.dtos.admissionType.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionTypeCreateRequestDTO {
    private Long id;

    @NotNull
    private String code;

    @NotNull
    private String name;

    private String description;

    private Boolean isActive = true;
}
