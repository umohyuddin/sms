package com.smartsolutions.eschool.student.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admission_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionTypeEntity  extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, unique = true, length = 50)
    private String code;  // e.g., NEW_ADMISSION

    @Column(name = "name", nullable = false, length = 150)
    private String name;  // full display name

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;
    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;
}
