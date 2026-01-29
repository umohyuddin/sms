package com.smartsolutions.eschool.sclass.dtos.TeacherSubjectAssignment.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherSubjectAssignmentRequestDTO {

    @NotNull
    private Long employeeId;

    @NotNull
    private Long standardId;

    @NotNull
    private Long sectionId;

    @NotNull
    private Long subjectId;

    @NotNull
    private Long academicYearId;
}
