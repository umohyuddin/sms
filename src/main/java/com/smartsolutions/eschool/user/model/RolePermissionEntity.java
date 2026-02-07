package com.smartsolutions.eschool.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "role_permissions",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"role_id", "permission_id"})
        }
)
public class RolePermissionEntity {

    @EmbeddedId
    private RolePermissionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("roleId") // maps roleId attribute of embedded id
    @JoinColumn(name = "role_id")
    private RoleEntity role;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("permissionId") // maps permissionId attribute of embedded id
    @JoinColumn(name = "permission_id")
    private PermissionEntity permission;

    // Optional metadata
//    @Column(name = "assigned_by")
//    private Long assignedBy;
//
//    @Column(name = "assigned_at")
//    private Long assignedAt;
}
