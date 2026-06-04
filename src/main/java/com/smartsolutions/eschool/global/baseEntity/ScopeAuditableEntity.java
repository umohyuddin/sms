package com.smartsolutions.eschool.global.baseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class ScopeAuditableEntity {

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", updatable = false)
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "deleted_by")
    private Long deletedBy;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @PrePersist
    public void prePersist() {
        this.createdBy = getCurrentUser();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedBy = getCurrentUser();
    }


    private Long getCurrentUser() {
        return com.smartsolutions.eschool.util.SecurityUtils.getCurrentUserId();
    }
}
