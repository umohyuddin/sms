package com.smartsolutions.eschool.school.model;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@SQLDelete(sql = "UPDATE institute_academic_offerings SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "institute_academic_offerings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

}
