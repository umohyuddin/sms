package com.smartsolutions.eschool.institute.dtos.financialSettings.responseDto;

import com.smartsolutions.eschool.institute.enums.LateFeeType;
import com.smartsolutions.eschool.institute.enums.RefundType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialSettingsResponseDTO {

    private Long id;
    private Long instituteId;
    private Long academicYearId;

    private Long feeRecurrenceRuleId;

    // Currency & Localization
    private Integer currencyId;
    private Long languageId;
    private String locale;

    // Fee Structure Rules
    private Boolean allowPartialPayments;
    private Boolean lateFeeApplicable;
    private LateFeeType lateFeeType;
    private BigDecimal lateFeeValue;

    // Tax Rules
    private Boolean taxApplicable;
    private Long taxTypeId;
    private Boolean taxIncludedInFee;

    // Refund Rules
    private Boolean refundsAllowed;
    private String refundPolicyUrl;
    private Integer refundWindowDays;
    private RefundType refundType;
    private BigDecimal maxRefundPercentage;
    private BigDecimal maxRefundAmount;

    // Compliance Flags
    private Boolean invoiceMandatory;
    private Boolean receiptMandatory;
    private Boolean isActive;
    private Long organizationId;
    private java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime updatedAt;
}
