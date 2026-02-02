package com.smartsolutions.eschool.user.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "permission")
@Getter
@Setter
public class PermissionEntity extends AuditableEntity {
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

    @Column(columnDefinition = "TEXT")
    private String description;
}

