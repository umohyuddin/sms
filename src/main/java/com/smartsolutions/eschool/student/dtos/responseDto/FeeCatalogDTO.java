package com.smartsolutions.eschool.student.dtos.responseDto;

import io.swagger.v3.oas.annotations.media.Schema;
import com.smartsolutions.eschool.school.dtos.chargetype.response.ChargeTypeResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Response object containing fee catalog details")
public class FeeCatalogDTO {
    @Schema(description = "Unique identifier of the fee catalog", example = "1")
    private Long id;

    @Schema(description = "Internal code of the fee catalog", example = "TUI-2024")
    private String code;

    @Schema(description = "User-friendly name of the fee catalog", example = "Tuition Fee 2024")
    private String name;

    @Schema(description = "Brief description of the fee catalog", example = "Monthly tuition fees for the academic year 2024-25")
    private String description;

    @Schema(description = "Status indicating if this catalog is active", example = "true")
    private boolean active;

    @Schema(description = "Charge type associated with this catalog")
    private ChargeTypeResponseDTO chargeType;

    @Schema(description = "Recurrence rule associated with this catalog")
    private FeeRecurrenceRuleResponseDTO recurrenceRule;
}
