package com.smartsolutions.eschool.school.dtos.discountType.requestDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountTypeRequestDTO {
    private String code;
    private String name;
    private String description;
    private Boolean active;
    private String chargeType;          // raw value
    private String recurrenceRule;      // raw value
}
