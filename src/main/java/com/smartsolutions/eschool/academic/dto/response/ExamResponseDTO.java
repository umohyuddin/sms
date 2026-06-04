package com.smartsolutions.eschool.academic.dto.response;

import com.smartsolutions.eschool.academic.entity.master.ExamEntity;
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
    private Long examTypeId;
    private String examTypeName;
    private Long campusId;
    private String campusName;
    private Long standardId;
    private String standardName;
    private Long sectionId;
    private String sectionName;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean resultPublished;
    private ExamEntity.ExamStatus status;
    private boolean active;
}
