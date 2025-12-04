package com.smartsolutions.eschool.student.dtos.responseDto;

import jakarta.persistence.Column;
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
    private String chargeType;          // raw value
    private String chargeTypeLabel;     // human-readable
    private String recurrenceRule;      // raw value
    private String recurrenceRuleLabel; // human-readable
}
