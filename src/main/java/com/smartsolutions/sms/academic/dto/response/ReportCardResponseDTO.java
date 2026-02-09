package com.smartsolutions.sms.academic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportCardResponseDTO {
    private Long id;
    private Long studentId;
    private String studentName;
    private Long academicYearId;
    private String academicYearName;
    private LocalDateTime generatedAt;
    private String fileUrl;
}
