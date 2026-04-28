package com.smartsolutions.eschool.school.dtos.chargetype.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChargeTypeRequestDTO {

    @NotBlank(message = "Charge type code is required")
    private String code;

    @NotBlank(message = "Charge type name is required")
    private String name;

    private String description;

    private Boolean active;
}
