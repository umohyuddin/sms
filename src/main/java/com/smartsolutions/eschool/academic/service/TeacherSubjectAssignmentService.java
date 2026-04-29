package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.TeacherSubjectAssignmentRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.TeacherSubjectAssignmentResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface TeacherSubjectAssignmentService {
    TeacherSubjectAssignmentResponseDTO assign(TeacherSubjectAssignmentRequestDTO dto);

    List<TeacherSubjectAssignmentResponseDTO> getByTeacher(Long employeeId);

    List<TeacherSubjectAssignmentResponseDTO> getBySection(Long standardId, Long sectionId, Long academicYearId);

    List<TeacherSubjectAssignmentResponseDTO> getByStandard(Long standardId, Long academicYearId);

    void unassign(Long employeeId, Long standardId, Long sectionId, Long subjectId, Long academicYearId,
            LocalDate effectiveFrom);
}
