package com.smartsolutions.eschool.gl.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "gl_account_mappings")
@SQLDelete(sql = "UPDATE gl_account_mappings SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GLAccountMappingEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "campus_id")
    private Long campusId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accounting_module_id", nullable = false)
    private AccountingModuleEntity accountingModule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_type_id", nullable = false)
    private TransactionTypeEntity transactionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_key_id", nullable = false)
    private BusinessKeyEntity businessKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posting_key_id", nullable = false)
    private PostingKeyEntity postingKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gl_account_id", nullable = false)
    private GLAccountEntity glAccount;

    @Column(name = "priority_order")
    private int priorityOrder = 1;

    @Column(name = "is_active")
    private boolean isActive = true;
}
