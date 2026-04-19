package com.smartsolutions.eschool.lookups.dtos.city.responseDto;

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
@Schema(description = "Response object containing city details")
public class CityResponseDTO {
    @Schema(description = "Unique identifier of the city", example = "1")
    private Long id;

    @Schema(description = "ID of the associated province", example = "1")
    private Long provinceId;

    @Schema(description = "Name of the associated province", example = "Punjab")
    private String provinceName;

    @Schema(description = "Full name of the city", example = "Lahore")
    private String name;

    @Schema(description = "Abbreviated code for the city", example = "LHR")
    private String code;

    @Schema(description = "Status indicating if the city is active", example = "true")
    private Boolean isActive;
    
    @Schema(description = "Timestamp when the record was created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the record was last updated")
    private LocalDateTime updatedAt;
}
