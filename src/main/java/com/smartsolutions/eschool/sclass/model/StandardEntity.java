package com.smartsolutions.eschool.sclass.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.student.model.FeeRateEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.List;

@Entity
@Table(name = "standards")
@SQLDelete(sql = "UPDATE standards SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "standard_name", nullable = false)
    private String standardName;

    @Column(name = "standard_code")
    private String standardCode;

    @Column(name = "description")
    private String description;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

    @OneToMany(mappedBy = "standard", cascade = CascadeType.ALL)
    private List<SectionEntity> sections;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id", nullable = false)
    private CampusEntity campus;

    @OneToMany(mappedBy = "standard", fetch = FetchType.LAZY)
    private List<StudentEntity> students;

    @OneToMany(mappedBy = "standard", fetch = FetchType.LAZY)
    private List<FeeRateEntity> feeRates;

}
