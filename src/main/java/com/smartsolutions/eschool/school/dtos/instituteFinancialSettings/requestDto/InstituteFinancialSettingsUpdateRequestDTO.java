package com.smartsolutions.eschool.school.dtos.instituteFinancialSettings.requestDto;

import com.smartsolutions.eschool.institute.enums.RefundType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteFinancialSettingsUpdateRequestDTO {

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
    private RefundType refundType;
    private BigDecimal refundPercentage;
    private BigDecimal refundFixedAmount;

    private Boolean invoiceMandatory;
    private Boolean receiptMandatory;
    private Boolean isActive;
}
