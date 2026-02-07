package com.smartsolutions.eschool.user.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
        name = "permission",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"code"}),
                @UniqueConstraint(name = "uq_mod_res_act", columnNames = {"module_id", "resource_id", "action_id", "organization_id"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissionEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "organization_id", nullable = true)
    private Long organizationId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "code", nullable = false, length = 150)
    private String code; // e.g., FINANCE_FEE_VIEW

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", nullable = false)
    private ModuleEntity module;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resource_id", nullable = false)
    private ResourceEntity resource;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_id", nullable = false)
    private ActionEntity action;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "active")
    private Boolean active = true;

    @Column(name = "deleted")
    private Boolean deleted = false;

    @PrePersist
    @PreUpdate
    public void generateCode() {
        if (this.module != null && this.resource != null && this.action != null) {
            this.code = (module.getCode() + "_" + resource.getResourceName().replace(" ", "_") + "_" + action.getCode()).toUpperCase();
        }
    }
}

