package com.smartsolutions.eschool.student.model;
import org.hibernate.annotations.SQLRestriction;

import org.hibernate.annotations.SQLDelete;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@SQLDelete(sql = "UPDATE student_document SET deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@SQLRestriction("deleted = false")
@Table(name = "student_document")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDocumentEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private Long studentId;   // foreign key to Student

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "file_path", nullable = false)
    private String filePath;  // path on server or URL

    @Column(name = "file_type")
    private String fileType;  // PDF, DOCX, IMAGE, etc.

    @Column(name = "document_type", nullable = false)
    private String documentType;
}
