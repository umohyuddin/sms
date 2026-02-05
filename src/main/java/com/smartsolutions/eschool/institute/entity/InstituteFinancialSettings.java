package com.smartsolutions.eschool.institute.entity;


import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import com.smartsolutions.eschool.institute.enums.LateFeeType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "institute_financial_settings", uniqueConstraints = {
    @UniqueConstraint(name = "uk_institute_academic_year", columnNames = {"institute_id", "academic_year_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InstituteFinancialSettings extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "institute_id", nullable = false)
    private Long instituteId;

    @Column(name = "academic_year_id", nullable = false)
    private Long academicYearId;

    @Column(name = "fee_recurrence_rule_id")
    private Long feeRecurrenceRuleId;

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

    @Column(name = "late_fee_amount", precision = 10, scale = 2)
    private BigDecimal lateFeeValue;

    // Tax Rules
    @Column(name = "is_tax_applicable")
    private Boolean taxApplicable = false;

    @Column(name = "tax_type_id")
    private Long taxTypeId;

    @Column(name = "is_tax_inclusive")
    private Boolean taxIncludedInFee = false;

    // Refund Rules
    @Column(name = "allow_refunds")
    private Boolean refundsAllowed = false;

    @Column(name = "refund_policy_url", length = 255)
    private String refundPolicyUrl;

    @Column(name = "refund_window_days")
    private Integer refundWindowDays;

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

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}
