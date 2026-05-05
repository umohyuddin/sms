package com.smartsolutions.eschool.user.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_account_deactivation_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("deleted = false")
@Filter(name = "tenantFilter", condition = "organization_id = :organizationId")
public class UserAccountDeactivationLogEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "organization_id", nullable = false)
    private Long organizationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_user_id", nullable = false)
    private SystemUserEntity systemUser;

    @Column(name = "reason", nullable = false)
    private String reason;

    @Column(name = "deactivated_at", nullable = false)
    private LocalDateTime deactivatedAt;

    @Column(name = "deactivated_by")
    private Long deactivatedBy;
}
