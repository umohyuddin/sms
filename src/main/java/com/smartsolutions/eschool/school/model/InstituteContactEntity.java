package com.smartsolutions.eschool.school.model;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "institute_contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "is_deleted = false")
public class InstituteContactEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id", nullable = false)
    private InstituteEntity institute;

    @Column(name = "contact_person_name", length = 100)
    private String contactPersonName;

    @Column(name = "role", length = 50)
    private String role;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "is_primary")
    private Boolean isPrimary = false;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}
