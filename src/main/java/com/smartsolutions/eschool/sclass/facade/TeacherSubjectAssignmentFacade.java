package com.smartsolutions.eschool.sclass.facade;

import com.smartsolutions.eschool.sclass.dtos.TeacherSubjectAssignment.request.TeacherSubjectAssignmentRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.TeacherSubjectAssignment.response.TeacherSubjectAssignmentResponseDTO;
import com.smartsolutions.eschool.sclass.service.TeacherSubjectAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherSubjectAssignmentFacade {

    private final TeacherSubjectAssignmentService service;

    public TeacherSubjectAssignmentResponseDTO assign(
            TeacherSubjectAssignmentRequestDTO dto) {
        return service.assign(dto);
    }


    public void unassign(Long id) {
        service.unassign(id);
    }

    public TeacherSubjectAssignmentResponseDTO get(Long id) {
        return service.getById(id);
    }

    public List<TeacherSubjectAssignmentResponseDTO> getByTeacher(Long employeeId) {
        return service.getByTeacher(employeeId);
    }


    public List<TeacherSubjectAssignmentResponseDTO> getByClassSection(
            Long standardId,
            Long sectionId,
            Long academicYearId) {
        return service.getByClassSection(standardId, sectionId, academicYearId);
    }
}