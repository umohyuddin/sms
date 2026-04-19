package com.smartsolutions.eschool.student.dtos.feeSlabGroup;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request object for creating or updating a group of fee slabs")
public class FeeSlabGroupCreateRequestDTO {
    @NotNull(message = "Fee component is required")
    @Schema(description = "ID of the associated fee component", example = "10")
    private Long feeComponentId;

    @NotBlank(message = "Code is required")
    @Schema(description = "Identification code for the slab group", example = "SLB-GRP-01")
    private String code;

    @NotBlank(message = "Name is required")
    @Schema(description = "Display name of the slab group", example = "Standard 5 Monthly Tiers")
    private String name;

    @Schema(description = "Detailed description", example = "Tiers for monthly tuition fee based on enrolment date")
    private String description;

    @Schema(description = "Active status flag", example = "true")
    private boolean active = true;
}
