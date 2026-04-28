package com.smartsolutions.eschool.student.dtos.feeCatalogComponent.requestDto;

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
@Schema(description = "Request object for linking a component to a fee catalog")
public class FeeCatalogComponentRequestDTO {
    @Schema(description = "Unique identifier of the linking record (Required for updates)", example = "10")
    private Long id;   // Optional (only for Update)

    @Schema(description = "ID of the associated fee catalog", example = "1")
    private Long feeCatalogId;

    @NotBlank(message = "Name is required")
    @Schema(description = "Name of the fee component", example = "Monthly Tuition")
    private String componentName;

    @NotBlank(message = "Code is required")
    @Schema(description = "Logical code for the fee component", example = "TUI-01")
    private String componentCode;

    @Schema(description = "Brief description of the fee component", example = "Regular monthly tuition fee component")
    private String description;

    @NotNull(message = "Active flag is required")
    @Schema(description = "Status indicating if this component is active", example = "true")
    private Boolean active;

    @Schema(description = "Indicates if this component is eligible for discounts", example = "true")
    private Boolean discountable;
}
