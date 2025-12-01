package com.smartsolutions.eschool.lookups.dtos.city.requestDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityRequestDTO {
    private Long id; // Optional: for updates

    @NotNull(message = "Province ID is required")
    private Long provinceId;

    @NotBlank(message = "City name is required")
    @Size(max = 100, message = "City name cannot exceed 100 characters")
    private String name;

    @Size(max = 10, message = "City code cannot exceed 10 characters")
    private String code;

    private Boolean isActive = true; // default true

}

