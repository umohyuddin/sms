package com.smartsolutions.eschool.school.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class InstituteLanguageId implements Serializable {
    @Column(name = "institute_id")
    private Long instituteId;

    @Column(name = "language_id")
    private Long languageId;
}
