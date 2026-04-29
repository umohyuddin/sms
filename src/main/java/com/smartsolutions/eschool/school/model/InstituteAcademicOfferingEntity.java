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
@Table(name = "institute_academic_offerings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE institute_academic_offerings SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class InstituteAcademicOfferingEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id", nullable = false)
    private InstituteEntity institute;

    @Column(name = "education_level", length = 50)
    private String educationLevel;

    @Column(name = "curriculum", length = 100)
    private String curriculum;

    @Column(name = "board", length = 100)
    private String board;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}
