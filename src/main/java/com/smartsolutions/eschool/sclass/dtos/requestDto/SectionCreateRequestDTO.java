package com.smartsolutions.eschool.sclass.dtos.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SectionCreateRequestDTO {

    private Long id;
    @NotBlank(message = "Section name is required")
    private String sectionName;

    private String sectionCode;

    @NotNull(message = "Standard ID must not be null")
    private Long standardId;
    private Long campusId;
}