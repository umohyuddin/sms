package com.smartsolutions.eschool.user.model;
import org.hibernate.annotations.SQLRestriction;

import org.hibernate.annotations.SQLDelete;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE RoleEntity SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(
        name = "roles",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"code", "organization_id"})
        }
)
public class RoleEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "organization_id", nullable = false)
    private Long organizationId;

    @Column(name = "code", nullable = false, length = 50)
    private String code;   // SUPER_ADMIN, TEACHER, STUDENT

    @Column(name = "name", nullable = false, length = 100)
    private String name;   // Human-readable name

    @Column(length = 255)
    private String description;

    @Column(name = "is_system_role")
    private Boolean systemRole = false;

    @Column(name = "active")
    private Boolean active = true;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Set<PermissionEntity> permissions = new HashSet<>();
}

