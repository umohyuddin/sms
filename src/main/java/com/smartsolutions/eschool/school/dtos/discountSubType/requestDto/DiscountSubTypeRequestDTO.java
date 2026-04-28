package com.smartsolutions.eschool.school.dtos.discountSubType.requestDto;

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
public class DiscountSubTypeRequestDTO {
    @NotBlank(message = "Code is required")
    private String code;
    @NotBlank(message = "Name is required")
    private String name;
    private String description;
    @NotNull(message = "Discount Type ID is required")
    private Long discountTypeId;
    private Boolean isActive = true;
    private Integer priority = 0;
    private Integer displayOrder = 0;
}
