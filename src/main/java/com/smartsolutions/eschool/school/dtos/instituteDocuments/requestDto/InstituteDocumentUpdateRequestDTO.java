package com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteDocumentUpdateRequestDTO {
    private String documentType;
    private String fileName;
    private String fileUrl;
    private LocalDate expiryDate;
}
