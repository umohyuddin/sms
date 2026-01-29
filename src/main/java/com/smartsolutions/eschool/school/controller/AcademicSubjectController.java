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
        log.info("Received request to fetch Subject with id: {}", id);
        SubjectResponse subject = subjectFacade.getById(id);
        log.info("Returning Subject: id={}", subject.getId());
        return ResponseEntity.ok(subject);
    }

    @GetMapping(value = "search/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchByKeyword(@PathVariable String keyword) {
        log.info("GET /api/institute/subjects/search by keyword called: {}", keyword);
        List<SubjectResponse> subjects = subjectFacade.searchByKeyword(keyword);
        log.info("GET /api/institute/subjects/search succeeded, found {} subjects", subjects.size());
        return ResponseEntity.ok(subjects);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> softDeleteById(@PathVariable Long id) {
        log.info("API Request: Soft delete Subject ID: {}", id);
        try {
            int result = subjectFacade.softDeleteById(id);
            if (result == 0) {
                log.warn("Delete failed — Subject not found: {}", id);
                return ResponseEntity.notFound().build();
            }
            log.info("Subject deleted successfully: {}", id);
            return ResponseEntity.ok("Subject deleted successfully");
        } catch (Exception ex) {
            log.error("Error deleting Subject ID: {}", id, ex);
            return ResponseEntity.internalServerError().body("Failed to delete Subject");
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubjectResponse> createSubject(@Valid @RequestBody SubjectRequest dto) {
        log.info("Received request to create new Subject: {}", dto.getName());
        SubjectResponse createdSubject = subjectFacade.createSubject(dto);
        log.info("Subject created successfully with id: {}", createdSubject.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubject);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubjectResponse> updateSubject(@PathVariable Long id, @Valid @RequestBody SubjectRequest dto) {
        log.info("Received request to update Subject with id: {}", id);
        SubjectResponse updatedSubject = subjectFacade.updateSubject(id, dto);
        log.info("Returning updated Subject: id={}", updatedSubject.getId());
        return ResponseEntity.ok(updatedSubject);
    }
}