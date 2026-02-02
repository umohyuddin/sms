package com.smartsolutions.eschool.school.dtos.instituteDocuments.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstituteDocumentResponseDTO {
    private Long id;
    private Long instituteId;
    private String documentType;
    private String fileName;
    private String fileUrl;
    private LocalDate expiryDate;
}
