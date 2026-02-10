package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.subjects.request.SubjectRequest;
import com.smartsolutions.eschool.school.dtos.subjects.response.SubjectResponse;
import com.smartsolutions.eschool.school.service.AcademicSubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class AcademicSubjectFacade {

    private final AcademicSubjectService subjectService;

    public AcademicSubjectFacade(AcademicSubjectService subjectService) {
        this.subjectService = subjectService;
    }

    // Get all subjects
    public List<SubjectResponse> getAll() {
        log.info("Facade: Request to fetch all subjects");
        List<SubjectResponse> result = subjectService.getAll();
        log.info("Facade: Successfully fetched {} subjects", result.size());
        return result;
    }

    // Get subject by ID
    public SubjectResponse getById(Long id) {
        log.info("Facade: Request to fetch subject by id: {}", id);
        SubjectResponse result = subjectService.getById(id);
        log.info("Facade: Successfully fetched subject: id={}", id);
        return result;
    }

    // Search subjects by keyword
    public List<SubjectResponse> searchByKeyword(String keyword) {
        log.info("Facade: Request to search subjects with keyword: {}", keyword);
        List<SubjectResponse> result = subjectService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} subjects", result.size());
        return result;
    }

    // Soft delete subject by ID
    public int softDeleteById(Long id) {
        log.info("Facade: Request to delete subject by id: {}", id);
        int result = subjectService.softDeleteById(id);
        log.info("Facade: Delete result for id {}: {}", id, result);
        return result;
    }

    // Create new subject
    public SubjectResponse createSubject(SubjectRequest requestDTO) {
        log.info("Facade: Request to create subject: {}", requestDTO.getName());
        SubjectResponse result = subjectService.createSubject(requestDTO);
        log.info("Facade: Successfully created subject with id: {}", result.getId());
        return result;
    }

    // Update existing subject
    public SubjectResponse updateSubject(Long id, SubjectRequest requestDTO) {
        log.info("Facade: Request to update subject id: {}", id);
        SubjectResponse result = subjectService.updateSubject(id, requestDTO);
        log.info("Facade: Successfully updated subject: id={}", result.getId());
        return result;
    }
}
