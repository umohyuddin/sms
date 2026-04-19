package com.smartsolutions.eschool.lookups.dtos.city.requestDto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request object for creating or updating a city")
public class CityRequestDTO {

    @NotNull(message = "Province ID is required")
    @Schema(description = "ID of the province this city belongs to", example = "1")
    private Long provinceId;

    @NotBlank(message = "City name is required")
    @Size(max = 100, message = "City name cannot exceed 100 characters")
    @Schema(description = "Full name of the city", example = "Lahore")
    private String name;

    @Size(max = 10, message = "City code cannot exceed 10 characters")
    @Schema(description = "Abbreviated code for the city", example = "LHR")
    private String code;

    @Schema(description = "Status indicating if the city is active", example = "true")
    private Boolean isActive = true;
}
