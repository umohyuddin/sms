package com.smartsolutions.eschool.student.dtos.guardianRelation.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Request object for creating or updating a guardian relationship type")
public class GuardianRelationCreateRequestDTO {
    @Schema(description = "Unique ID for update", example = "1")
    private Long id;

    @NotNull
    @Schema(description = "Unique relationship code", example = "FATHER")
    private String code;

    @NotNull
    @Schema(description = "Display name of the relationship", example = "Father")
    private String name;

    @Schema(description = "Detailed description", example = "Biological or legal father")
    private String description;

    @Schema(description = "Whether the relation type is active", example = "true")
    private Boolean isActive = true;

    @Schema(description = "Whether this is the default selection", example = "false")
    private Boolean isDefault = false;

    @Schema(description = "Current status", example = "ACTIVE")
    private String status = "ACTIVE";
}
