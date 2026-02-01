package com.smartsolutions.eschool.user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "resource_permissions")
public class ResourcePermission {

    @EmbeddedId
    private ResourcePermissionId resourcePermissionId;

    @Column(name = "allowed_methods")
    private String allowedMethods;

    // Define other fields and relationships

    @ManyToOne
    @JoinColumn(name = "resource_id", insertable = false, updatable = false)
    private ResourceEntity resource;

    @ManyToOne
    @JoinColumn(name = "permission_id", insertable = false, updatable = false)
    private PermissionEntity permission;
    // Define getters and setters
}