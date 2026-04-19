package com.smartsolutions.eschool.student.dtos.feeCatalog.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request object for creating or updating a fee catalog entry")
public class FeeCatalogRequestDTO {
    @Schema(description = "Unique identifier of the catalog (Required for updates)", example = "1")
    private Long id; // Optional (only for Update)

    @NotBlank(message = "Name is required")
    @Schema(description = "User-friendly name of the fee catalog", example = "Tuition Fee 2024")
    private String name;

    @NotBlank(message = "Code is required")
    @Schema(description = "Internal code for the fee catalog", example = "TUI-2024")
    private String code;

    @Schema(description = "Brief description of what this catalog covers", example = "Monthly tuition fees for the academic year 2024-25")
    private String description;

    @NotNull(message = "Charge type is required")
    @Schema(description = "ID of the charge type (e.g., ADMISSION, MONTHLY, ANNUAL)", example = "2")
    private Long chargeTypeId;

    @Schema(description = "ID of the recurrence rule (e.g., Every Month, One Time)", example = "1")
    private Long recurrenceRuleId;

    @NotNull(message = "Active flag is required")
    @Schema(description = "Status indicating if this catalog is active", example = "true")
    private Boolean active;
}
