package com.smartsolutions.sms.academic.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherSubjectAssignmentResponseDTO {
    private Long employeeId;
    private String employeeName;
    private Long standardId;
    private String standardName;
    private Long sectionId;
    private String sectionName;
    private Long subjectId;
    private String subjectName;
    private Long academicYearId;
    private String academicYearName;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
    private String teachingRole;
    private boolean active;
}
