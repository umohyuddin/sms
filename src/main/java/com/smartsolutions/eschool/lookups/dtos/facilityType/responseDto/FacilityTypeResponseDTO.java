package com.smartsolutions.eschool.lookups.dtos.facilityType.responseDto;

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
@Schema(description = "Response payload containing facility type details")
public class FacilityTypeResponseDTO {

    @Schema(description = "Unique ID of the facility type", example = "1")
    private Long id;

    @Schema(description = "Unique code of the facility type", example = "LAB")
    private String code;

    @Schema(description = "Name of the facility type", example = "Science Laboratory")
    private String name;

    @Schema(description = "Detailed description of the facility type", example = "Fully equipped science laboratory")
    private String description;

    @Schema(description = "Whether the facility type is active", example = "true")
    private Boolean isActive;

    @Schema(description = "Indicates if the record is soft-deleted", example = "false")
    private Boolean deleted;

    @Schema(description = "Timestamp when the record was created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the record was last updated")
    private LocalDateTime updatedAt;
}

