package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.TeacherSubjectAssignmentRequestDTO;
import com.smartsolutions.sms.academic.dto.response.TeacherSubjectAssignmentResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface TeacherSubjectAssignmentService {
    TeacherSubjectAssignmentResponseDTO assign(TeacherSubjectAssignmentRequestDTO dto);
    List<TeacherSubjectAssignmentResponseDTO> getByTeacher(Long employeeId);
    List<TeacherSubjectAssignmentResponseDTO> getBySection(Long standardId, Long sectionId, Long academicYearId);
    void unassign(Long employeeId, Long standardId, Long sectionId, Long subjectId, Long academicYearId, LocalDate effectiveFrom);
}
