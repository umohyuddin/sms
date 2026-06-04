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

@Entity
@SQLDelete(sql = "UPDATE ActionEntity SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(
        name = "actions",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"code"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActionEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, length = 50)
    private String code; // VIEW, CREATE, UPDATE, DELETE, APPROVE, EXPORT

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "is_active", nullable = false)
    private Boolean active = true;
}
