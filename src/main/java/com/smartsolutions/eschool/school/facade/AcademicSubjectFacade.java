package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.subjects.request.SubjectRequest;
import com.smartsolutions.eschool.school.dtos.subjects.response.SubjectResponse;
import com.smartsolutions.eschool.school.service.AcademicSubjectService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class AcademicSubjectFacade {

    private final AcademicSubjectService subjectService;

    public AcademicSubjectFacade(AcademicSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    // Get all subjects
    public List<SubjectResponse> getAll() {
        return subjectService.getAll();
    }

    // Get subject by ID
    public SubjectResponse getById(Long id) {
        return subjectService.getById(id);
    }

    // Search subjects by keyword
    public List<SubjectResponse> searchByKeyword(String keyword) {
        return subjectService.searchByKeyword(keyword);
    }

    // Soft delete subject by ID
    public int softDeleteById(Long id) {
        return subjectService.softDeleteById(id);
    }

    // Create new subject
    public SubjectResponse createSubject(SubjectRequest requestDTO) {
        return subjectService.createSubject(requestDTO);
    }

    // Update existing subject
    public SubjectResponse updateSubject(Long id, SubjectRequest requestDTO) {
        return subjectService.updateSubject(id, requestDTO);
    }
}