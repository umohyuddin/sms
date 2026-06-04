package com.smartsolutions.eschool.lookups.dtos.currency.responseDto;

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
@Schema(description = "Response payload containing currency details")
public class CurrencyResponseDTO {

    @Schema(description = "Unique ID of the currency", example = "1")
    private Integer id;

    @Schema(description = "ISO code of the currency", example = "USD")
    private String isoCode;

    @Schema(description = "Name of the currency", example = "US Dollar")
    private String name;

    @Schema(description = "Symbol of the currency", example = "$")
    private String symbol;

    @Schema(description = "Whether the currency is active", example = "true")
    private Boolean isActive;

    @Schema(description = "Indicates if the record is soft-deleted", example = "false")
    private Boolean deleted;

    @Schema(description = "Timestamp when the record was created")
    private LocalDateTime createdAt;

    @Schema(description = "Timestamp when the record was last updated")
    private LocalDateTime updatedAt;
}

