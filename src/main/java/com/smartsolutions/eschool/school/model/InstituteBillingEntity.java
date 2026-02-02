package com.smartsolutions.eschool.school.model;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Entity
@Table(name = "institute_billing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE institute_billing SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
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

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}
