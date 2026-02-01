package com.smartsolutions.eschool.user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_resource_permissions")
public class UserResourcePermissions {

    @EmbeddedId
    private UserResourcePermissionId userResourcePermissionId;

    // Define other fields and relationships
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private SystemUserEntity user;

    @ManyToOne
    @JoinColumn(name = "resource_id", insertable = false, updatable = false)
    private ResourceEntity resource;

    @ManyToOne
    @JoinColumn(name = "permission_id", insertable = false, updatable = false)
    private PermissionEntity permission;
}