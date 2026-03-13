package com.smartsolutions.eschool.student.dtos.feeCatalog.requestDto;

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
    private Long id; // Optional (only for Update)

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Code is required")
    private String code;

    private String description;

    @NotNull(message = "Charge type is required")
    private Long chargeTypeId;

    private Long recurrenceRuleId;

    @NotNull(message = "Active flag is required")
    private Boolean active;

}
