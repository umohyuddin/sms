package com.smartsolutions.sms.academic.controller;

import com.smartsolutions.sms.academic.dto.request.*;
import com.smartsolutions.sms.academic.facade.ExamAssessmentFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/academic/evaluation")
@RequiredArgsConstructor
@Slf4j
public class ExamAssessmentController {

    private final ExamAssessmentFacade examAssessmentFacade;

    // Exam Type
    @PostMapping("/exam-types")
    public ResponseEntity<?> createExamType(@Valid @RequestBody ExamTypeRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(examAssessmentFacade.createExamType(dto));
    }

    @PutMapping("/exam-types/{id}")
    public ResponseEntity<?> updateExamType(@PathVariable Long id, @Valid @RequestBody ExamTypeRequestDTO dto) {
        return ResponseEntity.ok(examAssessmentFacade.updateExamType(id, dto));
    }

    @GetMapping("/exam-types")
    public ResponseEntity<?> getAllExamTypes() {
        return ResponseEntity.ok(examAssessmentFacade.getAllActiveExamTypes());
    }

    @DeleteMapping("/exam-types/{id}")
    public ResponseEntity<?> deleteExamType(@PathVariable Long id) {
        examAssessmentFacade.deleteExamType(id);
        return ResponseEntity.noContent().build();
    }

    // Exam Term
    @PostMapping("/exam-terms")
    public ResponseEntity<?> createExamTerm(@Valid @RequestBody ExamTermRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(examAssessmentFacade.createExamTerm(dto));
    }

    @PutMapping("/exam-terms/{id}")
    public ResponseEntity<?> updateExamTerm(@PathVariable Long id, @Valid @RequestBody ExamTermRequestDTO dto) {
        return ResponseEntity.ok(examAssessmentFacade.updateExamTerm(id, dto));
    }

    @GetMapping("/exam-terms")
    public ResponseEntity<?> getTermsByYear(@RequestParam Long academicYearId) {
        return ResponseEntity.ok(examAssessmentFacade.getActiveTermsByYear(academicYearId));
    }

    @DeleteMapping("/exam-terms/{id}")
    public ResponseEntity<?> deleteExamTerm(@PathVariable Long id) {
        examAssessmentFacade.deleteExamTerm(id);
        return ResponseEntity.noContent().build();
    }

    // Assessment Type
    @PostMapping("/assessment-types")
    public ResponseEntity<?> createAssessmentType(@Valid @RequestBody AssessmentTypeRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(examAssessmentFacade.createAssessmentType(dto));
    }

    @PutMapping("/assessment-types/{id}")
    public ResponseEntity<?> updateAssessmentType(@PathVariable Long id, @Valid @RequestBody AssessmentTypeRequestDTO dto) {
        return ResponseEntity.ok(examAssessmentFacade.updateAssessmentType(id, dto));
    }

    @GetMapping("/assessment-types")
    public ResponseEntity<?> getAllAssessmentTypes() {
        return ResponseEntity.ok(examAssessmentFacade.getAllActiveAssessmentTypes());
    }

    @DeleteMapping("/assessment-types/{id}")
    public ResponseEntity<?> deleteAssessmentType(@PathVariable Long id) {
        examAssessmentFacade.deleteAssessmentType(id);
        return ResponseEntity.noContent().build();
    }

    // Exam
    @PostMapping("/exams")
    public ResponseEntity<?> createExam(@Valid @RequestBody ExamRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(examAssessmentFacade.createExam(dto));
    }

    @PutMapping("/exams/{id}")
    public ResponseEntity<?> updateExam(@PathVariable Long id, @Valid @RequestBody ExamRequestDTO dto) {
        return ResponseEntity.ok(examAssessmentFacade.updateExam(id, dto));
    }

    @GetMapping("/exams/{id}")
    public ResponseEntity<?> getExam(@PathVariable Long id) {
        return ResponseEntity.ok(examAssessmentFacade.getExamById(id));
    }

    @GetMapping("/exams/section")
    public ResponseEntity<?> getSectionExams(@RequestParam Long standardId, @RequestParam Long sectionId, @RequestParam Long academicYearId) {
        return ResponseEntity.ok(examAssessmentFacade.getExamsBySection(standardId, sectionId, academicYearId));
    }

    @DeleteMapping("/exams/{id}")
    public ResponseEntity<?> deleteExam(@PathVariable Long id) {
        examAssessmentFacade.deleteExam(id);
        return ResponseEntity.noContent().build();
    }

    // Exam Subject
    @PostMapping("/exam-subjects")
    public ResponseEntity<?> scheduleSubject(@Valid @RequestBody ExamSubjectRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(examAssessmentFacade.scheduleSubject(dto));
    }

    @GetMapping("/exam-subjects")
    public ResponseEntity<?> getExamSubjects(@RequestParam Long examId) {
        return ResponseEntity.ok(examAssessmentFacade.getSubjectsByExam(examId));
    }

    @DeleteMapping("/exam-subjects")
    public ResponseEntity<?> unscheduleSubject(@RequestParam Long examId, @RequestParam Long subjectId) {
        examAssessmentFacade.unscheduleSubject(examId, subjectId);
        return ResponseEntity.noContent().build();
    }

    // Assessment
    @PostMapping("/assessments")
    public ResponseEntity<?> createAssessment(@Valid @RequestBody AssessmentRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(examAssessmentFacade.createAssessment(dto));
    }

    @PutMapping("/assessments/{id}")
    public ResponseEntity<?> updateAssessment(@PathVariable Long id, @Valid @RequestBody AssessmentRequestDTO dto) {
        return ResponseEntity.ok(examAssessmentFacade.updateAssessment(id, dto));
    }

    @GetMapping("/assessments/{id}")
    public ResponseEntity<?> getAssessment(@PathVariable Long id) {
        return ResponseEntity.ok(examAssessmentFacade.getAssessmentById(id));
    }

    @GetMapping("/assessments/assignment/{id}")
    public ResponseEntity<?> getAssessmentsByAssignment(@PathVariable Long id) {
        return ResponseEntity.ok(examAssessmentFacade.getAssessmentsByAssignment(id));
    }

    @DeleteMapping("/assessments/{id}")
    public ResponseEntity<?> deleteAssessment(@PathVariable Long id) {
        examAssessmentFacade.deleteAssessment(id);
        return ResponseEntity.noContent().build();
    }

    // Student Assessment
    @PostMapping("/student-assessments/submit")
    public ResponseEntity<?> submitAssessment(@Valid @RequestBody StudentAssessmentRequestDTO dto) {
        examAssessmentFacade.submitAssessment(dto);
        return ResponseEntity.ok("Assessment submitted successfully");
    }

    @PostMapping("/student-assessments/evaluate")
    public ResponseEntity<?> evaluateAssessment(@Valid @RequestBody StudentAssessmentRequestDTO dto) {
        examAssessmentFacade.evaluateAssessment(dto);
        return ResponseEntity.ok("Assessment evaluated successfully");
    }

    @GetMapping("/student-assessments/assessment/{id}")
    public ResponseEntity<?> getSubmissionsByAssessment(@PathVariable Long id) {
        return ResponseEntity.ok(examAssessmentFacade.getByAssessment(id));
    }

    @GetMapping("/student-assessments/student/{id}")
    public ResponseEntity<?> getSubmissionsByStudent(@PathVariable Long id) {
        return ResponseEntity.ok(examAssessmentFacade.getByStudent(id));
    }
}
