package com.smartsolutions.eschool.school.dtos.schoolTypes.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "School type details")
public class SchoolTypeResponseDTO {

    @Schema(description = "Unique identifier", example = "1")
    private Long id;

    @Schema(description = "Unique code for the school type", example = "PVT")
    private String code;

    @Schema(description = "Display name of the school type", example = "Private")
    private String name;

    @Schema(description = "Optional description", example = "Privately managed institution")
    private String description;

    @Schema(description = "Whether the school type is active", example = "true")
    private Boolean isActive;

    @Schema(description = "Timestamp when the record was created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the record was last updated")
    private LocalDateTime updatedAt;

    @Schema(description = "Whether the record has been soft-deleted", example = "false")
    private Boolean deleted;
}

