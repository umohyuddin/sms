package com.smartsolutions.eschool.employee.model;

import com.smartsolutions.eschool.global.baseEntity.AuditableEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "employee_document")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDocumentEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_Id", nullable = false)
    private Long employeeId;  // foreign key to Teacher

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "file_path", nullable = false)
    private String filePath; // path on server or URL

    @Column(name = "file_type")
    private String fileType; // PDF, DOCX, IMAGE, etc.
    @Column(name = "document_type", nullable = false)
    private String documentType;
}
