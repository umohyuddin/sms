package com.smartsolutions.sms.academic.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportCardRequestDTO {
    @NotNull
    private Long studentId;
    
    @NotNull
    private Long academicYearId;
    
    private String fileUrl;
}
