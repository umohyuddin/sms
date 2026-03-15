package com.smartsolutions.eschool.student.dtos.feeSlabGroup;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeeSlabGroupCreateRequestDTO {
    @NotNull(message = "Fee component is required")
    private Long feeComponentId;

    @NotBlank(message = "Code is required")
    private String code;

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    private boolean active = true;
}
