package com.smartsolutions.eschool.school.model;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import com.smartsolutions.eschool.lookups.model.CurrencyEntity;
import com.smartsolutions.eschool.lookups.model.FeeRecurrenceRuleEntity;
import com.smartsolutions.eschool.lookups.model.LanguageEntity;
import com.smartsolutions.eschool.lookups.model.TaxTypeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;

@Entity
@Table(name = "institute_financial_settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE institute_financial_settings SET is_deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "is_deleted = false")
public class InstituteFinancialSettingsEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id", nullable = false)
    private InstituteEntity institute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_year_id", nullable = false)
    private AcademicYearEntity academicYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fee_recurrence_rule_id")
    private FeeRecurrenceRuleEntity feeRecurrenceRule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id")
    private CurrencyEntity currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    private LanguageEntity language;

    @Column(name = "locale", length = 10)
    private String locale;

    @Column(name = "fee_frequency", length = 20)
    private String feeFrequency;

    @Column(name = "allow_partial_payments")
    private Boolean allowPartialPayments = false;

    @Column(name = "late_fee_type", length = 20)
    private String lateFeeType;

    @Column(name = "late_fee_amount", precision = 10, scale = 2)
    private BigDecimal lateFeeAmount;

    @Column(name = "is_tax_applicable")
    private Boolean isTaxApplicable = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tax_type_id")
    private TaxTypeEntity taxType;

    @Column(name = "is_tax_inclusive")
    private Boolean isTaxInclusive = false;

    @Column(name = "allow_refunds")
    private Boolean allowRefunds = false;

    @Column(name = "refund_policy_url", length = 255)
    private String refundPolicyUrl;

    @Column(name = "refund_window_days")
    private Integer refundWindowDays;

    @Column(name = "refund_percentage", precision = 5, scale = 2)
    private BigDecimal refundPercentage;

    @Column(name = "refund_fixed_amount", precision = 10, scale = 2)
    private BigDecimal refundFixedAmount;

    @Column(name = "invoice_mandatory")
    private Boolean invoiceMandatory = true;

    @Column(name = "receipt_mandatory")
    private Boolean receiptMandatory = true;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}
