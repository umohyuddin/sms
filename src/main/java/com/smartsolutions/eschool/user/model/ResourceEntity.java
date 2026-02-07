package com.smartsolutions.eschool.user.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
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
@Table(name = "resources")
public class ResourceEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resource_name", nullable = false)
    private String resourceName;

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

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;
}

