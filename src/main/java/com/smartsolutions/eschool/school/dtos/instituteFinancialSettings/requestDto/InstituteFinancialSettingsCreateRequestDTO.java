package com.smartsolutions.eschool.school.dtos.instituteFinancialSettings.requestDto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteFinancialSettingsCreateRequestDTO {
    
    @NotNull(message = "Institute ID is required")
    private Long instituteId;
    
    @NotNull(message = "Academic Year ID is required")
    private Long academicYearId;

    private Long feeRecurrenceRuleId;
    
    private Long currencyId;
    private Long languageId;
    private String locale;
    
    private String feeFrequency;
    private Boolean allowPartialPayments;
    private String lateFeeType;
    private BigDecimal lateFeeAmount;
    
    private Boolean isTaxApplicable;
    private Long taxTypeId;
    private Boolean isTaxInclusive;
    
    private Boolean allowRefunds;
    private String refundPolicyUrl;
    private Integer refundWindowDays;
    private BigDecimal refundPercentage;
    private BigDecimal refundFixedAmount;
    
    private Boolean invoiceMandatory;
    private Boolean receiptMandatory;
    private Boolean isActive;
}
