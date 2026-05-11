package com.smartsolutions.eschool.school.model;
import org.hibernate.annotations.SQLRestriction;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;


import java.time.LocalDate;

@Entity
@SQLDelete(sql = "UPDATE institute_billing SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "institute_billing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteBillingEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id", nullable = false, unique = true)
    private InstituteEntity institute;

    @Column(name = "billing_email", length = 100)
    private String billingEmail;

    @Column(name = "tax_number", length = 50)
    private String taxNumber;

    @Column(name = "currency", length = 10)
    private String currency;

    @Column(name = "subscription_plan", length = 50)
    private String subscriptionPlan;

    @Column(name = "payment_cycle", length = 20)
    private String paymentCycle;

    @Column(name = "subscription_start")
    private LocalDate subscriptionStart;

    @Column(name = "subscription_end")
    private LocalDate subscriptionEnd;
}
