package com.smartsolutions.eschool.lookups.dtos.province.requestDto;

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
public class ProvinceRequestDTO {
    
    @NotNull(message = "Country ID is required")
    private Long countryId;

    @NotBlank(message = "Province name is required")
    @Size(max = 100, message = "Name must be at most 100 characters")
    private String name;

    @Size(max = 10, message = "Code must be at most 10 characters")
    private String code;

    private Boolean isActive = true;
}
