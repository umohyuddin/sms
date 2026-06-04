package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.subjects.request.SubjectRequest;
import com.smartsolutions.eschool.school.dtos.subjects.response.SubjectResponse;
import com.smartsolutions.eschool.school.facade.AcademicSubjectFacade;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/institute/subjects")
@Slf4j
public class AcademicSubjectController {

    @Autowired
    private AcademicSubjectFacade subjectFacade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        log.info("GET /api/institute/subjects called");
        List<SubjectResponse> subjects = subjectFacade.getAll();
        log.info("GET /api/institute/subjects succeeded, returned {} subjects", subjects.size());
        return ResponseEntity.ok(subjects);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) {
        log.info("GET /api/institute/subjects/{} called", id);
        SubjectResponse subject = subjectFacade.getById(id);
        log.info("GET /api/institute/subjects/{} succeeded", id);
        return ResponseEntity.ok(subject);
    }

    @GetMapping(value = "search/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchByKeyword(@PathVariable String keyword) {
        log.info("GET /api/institute/subjects/search/{} called", keyword);
        List<SubjectResponse> subjects = subjectFacade.searchByKeyword(keyword);
        log.info("GET /api/institute/subjects/search/{} succeeded, returned {} resources", keyword, subjects.size());
        return ResponseEntity.ok(subjects);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> softDeleteById(@PathVariable Long id) {
        log.info("DELETE /api/institute/subjects/{} called", id);
        try {
            int result = subjectFacade.softDeleteById(id);
            if (result == 0) {
                log.warn("DELETE /api/institute/subjects/{} failed - not found", id);
                return ResponseEntity.notFound().build();
            }
            log.info("DELETE /api/institute/subjects/{} succeeded", id);
            return ResponseEntity.ok("Subject deleted successfully");
        } catch (Exception ex) {
            log.error("DELETE /api/institute/subjects/{} failed: {}", id, ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body("Failed to delete Subject");
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubjectResponse> createSubject(@Valid @RequestBody SubjectRequest dto) {
        log.info("POST /api/institute/subjects called for subject: {}", dto.getName());
        SubjectResponse createdSubject = subjectFacade.createSubject(dto);
        log.info("POST /api/institute/subjects succeeded, created with id: {}", createdSubject.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubject);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubjectResponse> updateSubject(@PathVariable Long id, @Valid @RequestBody SubjectRequest dto) {
        log.info("PUT /api/institute/subjects/{} called", id);
        SubjectResponse updatedSubject = subjectFacade.updateSubject(id, dto);
        log.info("PUT /api/institute/subjects/{} succeeded", id);
        return ResponseEntity.ok(updatedSubject);
    }
}
