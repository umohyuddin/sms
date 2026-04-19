package com.smartsolutions.eschool.student.dtos.feeSlabGroup;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response object containing fee slab group metadata")
public class FeeSlabGroupResponseDTO {
    @Schema(description = "Unique identifier of the slab group", example = "1")
    private Long id;

    @Schema(description = "ID of the associated fee component", example = "10")
    private Long feeComponentId;

    @Schema(description = "Name of the associated fee component", example = "Tuition Fee")
    private String feeComponentName;

    @Schema(description = "Identification code", example = "SLB-GRP-01")
    private String code;

    @Schema(description = "Display name", example = "Standard 5 Monthly Tiers")
    private String name;

    @Schema(description = "Brief description", example = "Tiers for monthly tuition fee")
    private String description;

    @Schema(description = "Active status", example = "true")
    private boolean active;

    @Schema(description = "Soft-deleted status", example = "false")
    private boolean deleted;

    @Schema(description = "Creation timestamp", example = "2024-01-01T12:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "Last update timestamp", example = "2024-04-19T10:30:00")
    private LocalDateTime updatedAt;

    @Schema(description = "Deletion timestamp", example = "null")
    private LocalDateTime deletedAt;
}
