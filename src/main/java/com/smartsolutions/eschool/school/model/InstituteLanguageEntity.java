package com.smartsolutions.eschool.school.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "institute_languages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE institute_languages SET is_deleted = true WHERE institute_id = ? AND language_id = ?")
@Where(clause = "is_deleted = false")
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

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;
}
