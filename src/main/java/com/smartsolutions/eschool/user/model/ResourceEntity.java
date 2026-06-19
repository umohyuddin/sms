package com.smartsolutions.eschool.user.model;
import org.hibernate.annotations.SQLRestriction;

import org.hibernate.annotations.SQLDelete;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "UPDATE resources SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "resources")
public class ResourceEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resource_name", nullable = false)
    private String resourceName;
    @Column(name = "resource_code", nullable = false)
    private  String resourceCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private ModuleEntity module;

    @Column(name = "version", nullable = false)
    private String version;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @Column(nullable = true)
    private String description;

    @Column(name = "is_auth_required", nullable = false)
    private boolean isAuthRequired = true;

    @Column(nullable = true)
    private Integer rateLimit;

    @Column(name = "is_deprecated", nullable = false)
    private boolean isDeprecated = false;

    @Column(name = "documentation_url", nullable = true)
    private String documentationUrl;

    @Column(nullable = true)
    private String owner;

}

