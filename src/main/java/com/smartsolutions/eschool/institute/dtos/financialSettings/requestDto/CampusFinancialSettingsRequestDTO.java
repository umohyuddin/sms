package com.smartsolutions.eschool.institute.dtos.financialSettings.requestDto;

import com.smartsolutions.eschool.institute.enums.LateFeeApplyOn;
import com.smartsolutions.eschool.institute.enums.LateFeeFrequency;
import com.smartsolutions.eschool.institute.enums.LateFeeType;
import com.smartsolutions.eschool.institute.enums.RefundType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CampusFinancialSettingsRequestDTO {

    @NotNull(message = "Institute ID is required")
    private Long instituteId;

    @NotNull(message = "Campus ID is required")
    private Long campusId;

    @NotNull(message = "Academic Year ID is required")
    private Long academicYearId;

    // Currency & Localization
    @NotNull(message = "Currency ID is required")
    private Integer currencyId;

    private Long languageId;

    @Size(max = 10, message = "Locale cannot exceed 10 characters")
    private String locale;

    // Fee Structure Rules
    private Boolean allowPartialPayments;
    private Boolean lateFeeApplicable;
    private LateFeeType lateFeeType;

    @DecimalMin(value = "0.0", inclusive = true, message = "Late fee amount must be non-negative")
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

    // Refund Rules
    private Boolean refundsAllowed;

    @Size(max = 255, message = "Refund policy URL cannot exceed 255 characters")
    private String refundPolicyUrl;

    @Min(value = 0, message = "Refund window days must be non-negative")
    private Integer refundWindowDays;
    private RefundType refundType;

    @DecimalMin(value = "0.0", inclusive = true, message = "Max refund percentage must be non-negative")
    @DecimalMax(value = "100.0", inclusive = true, message = "Max refund percentage cannot exceed 100")
    private BigDecimal maxRefundPercentage;

    @DecimalMin(value = "0.0", inclusive = true, message = "Max refund amount must be non-negative")
    private BigDecimal maxRefundAmount;

    // Compliance Flags
    private Boolean invoiceMandatory;
    private Boolean receiptMandatory;
    private Boolean isActive;

    private Long feeRecurrenceRuleId;
    private Integer invoiceGenerationDay;
    private Integer invoiceDueDay;
}
