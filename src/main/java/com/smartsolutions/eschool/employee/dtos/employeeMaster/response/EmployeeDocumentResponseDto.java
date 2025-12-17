package com.smartsolutions.eschool.employee.dtos.employeeMaster.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDocumentResponseDto {
    private Long id;
    private Long employeeId;
    private String fileName;
    private String filePath; // path on server or URL
    private String fileType; // PDF, DOCX, IMAGE, etc.
    private String documentType;
}
