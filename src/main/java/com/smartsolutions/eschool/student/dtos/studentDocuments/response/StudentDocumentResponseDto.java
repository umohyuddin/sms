package com.smartsolutions.eschool.student.dtos.studentDocuments.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDocumentResponseDto {

    private Long id;
    private Long studentId;
    private String fileName;
    private String filePath; // path on server or URL
    private String fileType; // PDF, DOCX, IMAGE, etc.
    private String documentType;
}
