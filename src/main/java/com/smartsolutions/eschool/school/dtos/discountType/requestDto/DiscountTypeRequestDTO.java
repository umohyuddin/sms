package com.smartsolutions.eschool.school.dtos.discountType.requestDto;

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
public class DiscountTypeRequestDTO {
    @NotBlank(message = "Code is required")
    private String code;

    @NotBlank(message = "Name is required")
    private String name;

    private String description;
    private Boolean active;

    @NotNull(message = "Charge Type ID is required")
    private Long chargeTypeId;

    private Long recurrenceRuleId;

    private Integer priority;
    private Integer displayOrder;
}
