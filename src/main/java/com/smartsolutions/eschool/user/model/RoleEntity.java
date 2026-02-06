package com.smartsolutions.eschool.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(
        name = "roles",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"code"})
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

    @Column(name = "deleted")
    private Boolean deleted = false;

    // ============================
    // RELATIONSHIPS
    // ============================
//    @OneToMany(
//            mappedBy = "role",
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    @JsonIgnore
//    private Set<UserRolesEntity> userRoles = new HashSet<>();
}

