package com.smartsolutions.eschool.lookups.model;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "languages")
@SQLDelete(sql = "UPDATE languages SET is_deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("is_deleted = false")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LanguageEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iso_code", unique = true, length = 10)
    private String isoCode;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;
}

