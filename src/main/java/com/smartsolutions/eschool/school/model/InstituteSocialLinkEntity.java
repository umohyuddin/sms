package com.smartsolutions.eschool.school.model;
import org.hibernate.annotations.SQLRestriction;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;


@Entity
@SQLDelete(sql = "UPDATE institute_social_links SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "institute_social_links")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteSocialLinkEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id", nullable = false)
    private InstituteEntity institute;

    @Column(name = "platform", length = 50)
    private String platform;

    @Column(name = "url", length = 255)
    private String url;
}
