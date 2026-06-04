package com.smartsolutions.eschool.lookups.dtos.language.responseDto;

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
@Schema(description = "Response payload containing language details")
public class LanguageResponseDTO {

    @Schema(description = "Unique ID of the language", example = "1")
    private Long id;

    @Schema(description = "ISO code of the language", example = "EN")
    private String isoCode;

    @Schema(description = "Name of the language", example = "English")
    private String name;

    @Schema(description = "Whether the language is active", example = "true")
    private Boolean isActive;

    @Schema(description = "Indicates if the record is soft-deleted", example = "false")
    private Boolean deleted;

    @Schema(description = "Timestamp when the record was created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the record was last updated")
    private LocalDateTime updatedAt;
}

