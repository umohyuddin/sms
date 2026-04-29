package com.smartsolutions.eschool.school.dtos.discountType.responseDto;

import com.smartsolutions.eschool.school.dtos.chargetype.response.ChargeTypeResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountTypeResponseDTO {

    private Long id;
    private String code;
    private String name;
    private String description;
    private Boolean active;

    private ChargeTypeResponseDTO chargeType;
    private FeeRecurrenceRuleResponseDTO recurrenceRule;

    private Integer priority;
    private Integer displayOrder;
}
