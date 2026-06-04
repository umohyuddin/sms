package com.smartsolutions.eschool.school.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@SQLDelete(sql = "UPDATE designations SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "designations")
@Getter
@Setter
public class DesignationEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "designation_code", nullable = false, unique = true, length = 50)
    private String designationCode;

    @Column(name = "designation_name", nullable = false, length = 150)
    private String designationName;

    @Column(length = 255)
    private String description;

    @Column(name = "active", nullable = false)
    private Boolean active = true;
}
