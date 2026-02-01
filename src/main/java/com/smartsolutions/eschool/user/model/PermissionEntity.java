package com.smartsolutions.eschool.user.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "permission")
@Getter
@Setter
public class PermissionEntity {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private Long id;

@Column(length = 255, nullable = false)
private String permissionName;
@Column(length = 100, unique = true)
private String code;

@Column(length = 255)
private String module;

@Column(name = "created_at")
private Long createdAt;

@Column(name = "updated_at")
private Long updatedAt;

@Column(name = "is_deleted")
private boolean isDeleted;

@Column(columnDefinition = "TEXT")
private String description;
//    @ManyToMany(mappedBy = "permissions")
//    private List<Resource> resources;


public PermissionEntity(String permissionName, String description) {
    this.permissionName = permissionName;
    this.description = description;
}

// Default constructor (required by JPA)
public PermissionEntity() {
}
}

