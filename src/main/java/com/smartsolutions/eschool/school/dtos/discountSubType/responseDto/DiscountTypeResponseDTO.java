package com.smartsolutions.eschool.school.dtos.discountSubType.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountTypeResponseDTO {
    private Long Id;
    private String Name;
    private String chargeType;          // raw value
    private String chargeTypeLabel;     // human-readable
    private String recurrenceRule;      // raw value
    private String recurrenceRuleLabel;
}
