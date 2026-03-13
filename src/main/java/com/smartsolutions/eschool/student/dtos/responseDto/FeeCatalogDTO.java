package com.smartsolutions.eschool.student.dtos.responseDto;

import com.smartsolutions.eschool.school.dtos.chargetype.response.ChargeTypeResponseDTO;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeeCatalogDTO {
    private Long id;
    private String code;
    private String name;
    private String description;
    private boolean active;

    private ChargeTypeResponseDTO chargeType;
    private FeeRecurrenceRuleResponseDTO recurrenceRule;
}
