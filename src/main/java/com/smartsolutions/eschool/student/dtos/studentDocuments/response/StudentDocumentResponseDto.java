package com.smartsolutions.eschool.student.dtos.studentDocuments.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Response object for student document metadata")
public class StudentDocumentResponseDto {

    @Schema(description = "Unique identifier of the document", example = "5001")
    private Long id;

    @Schema(description = "ID of the student associated with this document", example = "1")
    private Long studentId;

    @Schema(description = "Original name of the uploaded file", example = "birth_certificate.pdf")
    private String fileName;

    @Schema(description = "Storage path or URL of the file", example = "/uploads/students/1/birth_certificate.pdf")
    private String filePath; // path on server or URL

    @Schema(description = "MIME type or extension of the file", example = "application/pdf")
    private String fileType; // PDF, DOCX, IMAGE, etc.

    @Schema(description = "Logical type of the document", example = "BIRTH_CERTIFICATE")
    private String documentType;
}
