package com.smartsolutions.eschool.school.model;
import org.hibernate.annotations.SQLRestriction;

import com.smartsolutions.eschool.lookups.model.LanguageEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;


@Entity
@SQLDelete(sql = "UPDATE institute_languages SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "institute_languages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteLanguageEntity {

    @EmbeddedId
    private InstituteLanguageId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("instituteId")
    @JoinColumn(name = "institute_id", nullable = false)
    private InstituteEntity institute;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("languageId")
    @JoinColumn(name = "language_id", nullable = false)
    private LanguageEntity language;
}
