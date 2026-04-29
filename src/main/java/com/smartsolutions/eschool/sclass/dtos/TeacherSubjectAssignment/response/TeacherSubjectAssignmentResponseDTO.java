package com.smartsolutions.eschool.sclass.dtos.TeacherSubjectAssignment.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherSubjectAssignmentResponseDTO {

    private Long id;

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
}
