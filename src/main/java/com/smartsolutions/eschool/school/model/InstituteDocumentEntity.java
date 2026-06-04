package com.smartsolutions.eschool.school.model;
import org.hibernate.annotations.SQLRestriction;

import com.smartsolutions.eschool.global.baseEntity.ScopeAuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;


import java.time.LocalDate;

@Entity
@SQLDelete(sql = "UPDATE institute_documents SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "institute_documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteDocumentEntity extends ScopeAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institute_id", nullable = false)
    private InstituteEntity institute;

    @Column(name = "document_type", length = 50)
    private String documentType;

    @Column(name = "file_name", length = 150)
    private String fileName;

    @Column(name = "file_url", length = 255)
    private String fileUrl;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;
}
