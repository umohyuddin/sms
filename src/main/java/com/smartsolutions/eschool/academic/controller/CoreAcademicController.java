package com.smartsolutions.eschool.academic.controller;

import com.smartsolutions.eschool.academic.dto.request.StandardSubjectRequestDTO;
import com.smartsolutions.eschool.academic.dto.request.SubjectGroupRequestDTO;
import com.smartsolutions.eschool.academic.dto.request.SubjectRequestDTO;
import com.smartsolutions.eschool.academic.facade.CoreAcademicFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/academic/core")
@RequiredArgsConstructor
@Slf4j
public class CoreAcademicController {

    private final CoreAcademicFacade coreAcademicFacade;

    // Subject Group
    @PostMapping("/groups")
    public ResponseEntity<?> createGroup(@Valid @RequestBody SubjectGroupRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(coreAcademicFacade.createGroup(dto));
    }

    @PutMapping("/groups/{id}")
    public ResponseEntity<?> updateGroup(@PathVariable Long id, @Valid @RequestBody SubjectGroupRequestDTO dto) {
        return ResponseEntity.ok(coreAcademicFacade.updateGroup(id, dto));
    }

    @GetMapping("/groups/{id}")
    public ResponseEntity<?> getGroup(@PathVariable Long id) {
        return ResponseEntity.ok(coreAcademicFacade.getGroupById(id));
    }

    @GetMapping("/groups")
    public ResponseEntity<?> getAllGroups() {
        return ResponseEntity.ok(coreAcademicFacade.getAllActiveGroups());
    }

    @DeleteMapping("/groups/{id}")
    public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
        coreAcademicFacade.deleteGroup(id);
        return ResponseEntity.noContent().build();
    }

    // Subject
    @PostMapping("/subjects")
    public ResponseEntity<?> createSubject(@Valid @RequestBody SubjectRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(coreAcademicFacade.createSubject(dto));
    }

    @PutMapping("/subjects/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable Long id, @Valid @RequestBody SubjectRequestDTO dto) {
        return ResponseEntity.ok(coreAcademicFacade.updateSubject(id, dto));
    }

    @GetMapping("/subjects/{id}")
    public ResponseEntity<?> getSubject(@PathVariable Long id) {
        return ResponseEntity.ok(coreAcademicFacade.getSubjectById(id));
    }

    @GetMapping("/subjects")
    public ResponseEntity<?> getAllSubjects() {
        return ResponseEntity.ok(coreAcademicFacade.getAllActiveSubjects());
    }

    @DeleteMapping("/subjects/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable Long id) {
        coreAcademicFacade.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }

    // Standard Subject
    @PostMapping("/standard-subjects")
    public ResponseEntity<?> assignSubject(@Valid @RequestBody StandardSubjectRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(coreAcademicFacade.assignSubjectToStandard(dto));
    }

    @GetMapping("/standard-subjects")
    public ResponseEntity<?> getStandardSubjects(@RequestParam Long standardId, @RequestParam Long academicYearId) {
        return ResponseEntity.ok(coreAcademicFacade.getSubjectsByStandardAndYear(standardId, academicYearId));
    }

    @DeleteMapping("/standard-subjects")
    public ResponseEntity<?> unassignSubject(@RequestParam Long standardId, @RequestParam Long subjectId, @RequestParam Long academicYearId) {
        coreAcademicFacade.unassignSubjectFromStandard(standardId, subjectId, academicYearId);
        return ResponseEntity.noContent().build();
    }
}
