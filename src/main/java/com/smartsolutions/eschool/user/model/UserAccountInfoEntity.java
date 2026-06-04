package com.smartsolutions.eschool.user.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_account_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLRestriction("deleted = false")
@Filter(name = "tenantFilter", condition = "organization_id = :organizationId")
public class UserAccountInfoEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "organization_id", nullable = false)
    private Long organizationId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_user_id", nullable = false, unique = true)
    private SystemUserEntity systemUser;

    @Column(name = "requires_password_change", nullable = false)
    private Boolean requiresPasswordChange = false;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    @Column(name = "last_login_ip", length = 50)
    private String lastLoginIp;
}
