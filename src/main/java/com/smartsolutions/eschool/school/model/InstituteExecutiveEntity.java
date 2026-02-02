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
@Table(name = "institute_executives")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE institute_executives SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class InstituteExecutiveEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id", nullable = false)
    private InstituteEntity institute;

    @Column(name = "full_name", length = 100)
    private String fullName;

    @Column(name = "title", length = 50)
    private String title;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}
