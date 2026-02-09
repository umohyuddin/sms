package com.smartsolutions.sms.academic.dto.response;

import com.smartsolutions.sms.academic.entity.master.ExamEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamResponseDTO {
    private Long id;
    private Long academicYearId;
    private String academicYearName;
    private Long examTermId;
    private String examTermName;
    private Long campusId;
    private String campusName;
    private Long standardId;
    private String standardName;
    private Long sectionId;
    private String sectionName;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private ExamEntity.ExamStatus status;
    private boolean active;
}
