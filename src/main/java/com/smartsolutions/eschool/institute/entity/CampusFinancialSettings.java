package com.smartsolutions.eschool.institute.entity;
import org.hibernate.annotations.SQLRestriction;

import org.hibernate.annotations.SQLDelete;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import com.smartsolutions.eschool.institute.enums.LateFeeApplyOn;
import com.smartsolutions.eschool.institute.enums.LateFeeFrequency;
import com.smartsolutions.eschool.institute.enums.LateFeeType;
import com.smartsolutions.eschool.institute.enums.RefundType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@SQLDelete(sql = "UPDATE campus_financial_settings SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "campus_financial_settings", uniqueConstraints = {
        @UniqueConstraint(name = "uk_campus_academic_year", columnNames = { "campus_id", "academic_year_id" })
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CampusFinancialSettings extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "institute_id", nullable = false)
    private Long instituteId;

    @Column(name = "campus_id", nullable = false)
    private Long campusId;

    @Column(name = "academic_year_id", nullable = false)
    private Long academicYearId;

    // Currency & Localization
    @Column(name = "currency_id", nullable = false)
    private Integer currencyId;

    @Column(name = "language_id")
    private Long languageId;

    @Column(name = "locale", length = 10)
    private String locale;

    @Column(name = "allow_partial_payments")
    private Boolean allowPartialPayments = false;

    @Column(name = "late_fee_applicable")
    private Boolean lateFeeApplicable = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "late_fee_type", length = 20)
    private LateFeeType lateFeeType;

    @Column(name = "late_fee_fixed_amount", precision = 10, scale = 2)
    private BigDecimal lateFeeFixedAmount;

    @Column(name = "late_fee_percentage", precision = 5, scale = 2)
    private BigDecimal lateFeePercentage;

    @Column(name = "grace_days")
    private Integer graceDays = 0;

    @Enumerated(EnumType.STRING)
    @Column(name = "late_fee_frequency", length = 20)
    private LateFeeFrequency lateFeeFrequency;

    @Column(name = "late_fee_max_amount", precision = 10, scale = 2)
    private BigDecimal lateFeeMaxAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "late_fee_apply_on", length = 20)
    private LateFeeApplyOn lateFeeApplyOn;

    @Column(name = "send_payment_reminder")
    private Boolean sendPaymentReminder = false;

    @Column(name = "reminder_days_before_due")
    private Integer reminderDaysBeforeDue = 0;

    // Tax Rules
    @Column(name = "tax_type_id")
    private Long taxTypeId;

    // Refund Rules
    @Column(name = "allow_refunds")
    private Boolean refundsAllowed = false;

    @Column(name = "refund_policy_url", length = 255)
    private String refundPolicyUrl;

    @Column(name = "refund_window_days")
    private Integer refundWindowDays;

    @Enumerated(EnumType.STRING)
    @Column(name = "refund_type", length = 20)
    private RefundType refundType;

    @Column(name = "refund_percentage", precision = 5, scale = 2)
    private BigDecimal maxRefundPercentage;

    @Column(name = "refund_fixed_amount", precision = 10, scale = 2)
    private BigDecimal maxRefundAmount;

    // Compliance Flags
    @Column(name = "invoice_mandatory")
    private Boolean invoiceMandatory = false;

    @Column(name = "receipt_mandatory")
    private Boolean receiptMandatory = true;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "fee_recurrence_rule_id")
    private Long feeRecurrenceRuleId;
}
