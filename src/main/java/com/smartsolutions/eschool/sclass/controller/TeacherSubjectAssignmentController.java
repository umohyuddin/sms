package com.smartsolutions.eschool.sclass.controller;

import com.smartsolutions.eschool.sclass.dtos.TeacherSubjectAssignment.request.TeacherSubjectAssignmentRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.TeacherSubjectAssignment.response.TeacherSubjectAssignmentResponseDTO;
import com.smartsolutions.eschool.sclass.facade.TeacherSubjectAssignmentFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher-subject-assignments")
@RequiredArgsConstructor
public class TeacherSubjectAssignmentController {

    private final TeacherSubjectAssignmentFacade facade;

    @PostMapping
    public TeacherSubjectAssignmentResponseDTO assign(
            @RequestBody @Valid TeacherSubjectAssignmentRequestDTO dto) {
        return facade.assign(dto);
    }

    @DeleteMapping("/{id}")
    public void unassign(@PathVariable Long id) {
        facade.unassign(id);
    }

    @GetMapping("/{id}")
    public TeacherSubjectAssignmentResponseDTO get(@PathVariable Long id) {
        return facade.get(id);
    }

    @GetMapping("/by-teacher/{employeeId}")
    public List<TeacherSubjectAssignmentResponseDTO> getByTeacher(
            @PathVariable Long employeeId) {
        return facade.getByTeacher(employeeId);
    }

    @GetMapping("/by-class-section")
    public List<TeacherSubjectAssignmentResponseDTO> getByClassSection(
            @RequestParam Long standardId,
            @RequestParam Long sectionId,
            @RequestParam Long academicYearId) {

        return facade.getByClassSection(standardId, sectionId, academicYearId);
    }
}
