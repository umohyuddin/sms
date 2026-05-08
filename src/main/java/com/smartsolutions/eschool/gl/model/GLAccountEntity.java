package com.smartsolutions.eschool.gl.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.gl.enums.AccountType;
import com.smartsolutions.eschool.gl.enums.BalanceSide;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "gl_accounts", uniqueConstraints = {
    @UniqueConstraint(name = "uk_account_code", columnNames = {"organization_id", "account_code"})
})
@SQLDelete(sql = "UPDATE gl_accounts SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GLAccountEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "campus_id")
    private Long campusId;

    @Column(name = "account_code", nullable = false, length = 50)
    private String accountCode;

    @Column(name = "account_name", nullable = false, length = 255)
    private String accountName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private GLAccountEntity parent;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @Column(name = "is_group", nullable = false)
    private boolean isGroup = false;

    @Column(name = "level", nullable = false)
    private int level = 1;

    @Column(name = "is_control_account")
    private boolean isControlAccount = false;

    @Column(name = "is_cash_account")
    private boolean isCashAccount = false;

    @Column(name = "is_bank_account")
    private boolean isBankAccount = false;

    @Column(name = "is_reconcilable")
    private boolean isReconcilable = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "normal_balance", nullable = false)
    private BalanceSide normalBalance;

    @Column(name = "currency_code", length = 10)
    private String currencyCode = "PKR";

    @Column(name = "is_active")
    private boolean isActive = true;
}
