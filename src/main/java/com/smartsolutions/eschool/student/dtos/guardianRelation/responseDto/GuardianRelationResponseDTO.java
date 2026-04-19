package com.smartsolutions.eschool.student.dtos.guardianRelation.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Response object for guardian relationship type details")
public class GuardianRelationResponseDTO {
    @Schema(description = "Unique ID", example = "1")
    private Long id;
    @Schema(description = "Relationship code", example = "MOTHER")
    private String code;
    @Schema(description = "Relationship name", example = "Mother")
    private String name;
    @Schema(description = "Description", example = "Biological or legal mother")
    private String description;
    @Builder.Default
    @Schema(description = "Active status", example = "true")
    private Boolean isActive = true;
    @Builder.Default
    @Schema(description = "Default selection", example = "false")
    private Boolean isDefault = false;
    @Schema(description = "Status text", example = "ACTIVE")
    private String status;
    @Builder.Default
    @Schema(description = "Deletion flag", example = "false")
    private boolean deleted = false;
    @Schema(description = "Creation timestamp")
    private LocalDateTime createdAt;
    @Schema(description = "Update timestamp")
    private LocalDateTime updatedAt;
}
