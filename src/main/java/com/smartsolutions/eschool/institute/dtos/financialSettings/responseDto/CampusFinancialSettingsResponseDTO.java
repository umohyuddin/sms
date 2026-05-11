package com.smartsolutions.eschool.institute.dtos.financialSettings.responseDto;

import com.smartsolutions.eschool.institute.enums.LateFeeApplyOn;
import com.smartsolutions.eschool.institute.enums.LateFeeFrequency;
import com.smartsolutions.eschool.institute.enums.LateFeeType;
import com.smartsolutions.eschool.institute.enums.RefundType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampusFinancialSettingsResponseDTO {

    private Long id;
    private Long instituteId;
    private String instituteName;
    private Long campusId;
    private String campusName;
    private Long academicYearId;
    private String academicYearName;

    // Currency & Localization
    private Integer currencyId;
    private String currencyName;
    private Long languageId;
    private String languageName;
    private String locale;

    // Fee Structure Rules
    private Boolean allowPartialPayments;
    private Boolean lateFeeApplicable;
    private LateFeeType lateFeeType;
    private BigDecimal lateFeeFixedAmount;
    private BigDecimal lateFeePercentage;
    private Integer graceDays;
    private LateFeeFrequency lateFeeFrequency;
    private BigDecimal lateFeeMaxAmount;
    private LateFeeApplyOn lateFeeApplyOn;
    private Boolean sendPaymentReminder;
    private Integer reminderDaysBeforeDue;

    // Tax Rules
    private Long taxTypeId;
    private String taxTypeName;

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
    private Long feeRecurrenceRuleId;
    private String feeRecurrenceRuleName;
    private Integer invoiceGenerationDay;
    private Integer invoiceDueDay;
    private java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime updatedAt;
}
