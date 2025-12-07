package com.smartsolutions.eschool.student.dtos.feeCatalogComponent.requestDto;

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
public class FeeCatalogRequestDTO {
    private Long id;   // Optional (only for Update)

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Code is required")
    private String code;

    private String description;

    @NotBlank(message = "Charge type is required")
    private String chargeType; // FIXED, PERCENTAGE, etc.

    @NotBlank(message = "Rule type is required")
    private String recurrenceRule; // MONTHLY, YEARLY, etc.

    @NotNull(message = "Active flag is required")
    private Boolean active;

}
