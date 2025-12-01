package com.smartsolutions.eschool.sclass.dtos.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StandardCreateRequestDTO {
    private Long id;
    @NotBlank(message = "Standard name is required")
    private String standardName;
    private String standardCode;
    private String description;
    @NotNull(message = "Campus ID must not be null")
    private Long campusId;
}
