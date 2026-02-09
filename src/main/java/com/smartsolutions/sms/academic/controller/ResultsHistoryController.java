package com.smartsolutions.sms.academic.controller;

import com.smartsolutions.sms.academic.dto.request.*;
import com.smartsolutions.sms.academic.facade.ResultsHistoryFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/academic/results")
@RequiredArgsConstructor
@Slf4j
public class ResultsHistoryController {

    private final ResultsHistoryFacade resultsHistoryFacade;

    // Student Exam Marks
    @PostMapping("/marks")
    public ResponseEntity<?> recordMarks(@Valid @RequestBody List<StudentExamMarksRequestDTO> dtos) {
        resultsHistoryFacade.recordExamMarks(dtos);
        return ResponseEntity.ok("Marks recorded successfully");
    }

    @GetMapping("/marks/subject/{id}")
    public ResponseEntity<?> getByExamSubject(@PathVariable Long id) {
        return ResponseEntity.ok(resultsHistoryFacade.getMarksByExamSubject(id));
    }

    @GetMapping("/marks/student/{id}")
    public ResponseEntity<?> getStudentMarks(@PathVariable Long id, @RequestParam Long examId) {
        return ResponseEntity.ok(resultsHistoryFacade.getStudentMarks(id, examId));
    }

    // Exam Weightage
    @PostMapping("/weightages")
    public ResponseEntity<?> saveWeightages(@Valid @RequestBody List<ExamWeightageRequestDTO> dtos) {
        resultsHistoryFacade.saveWeightages(dtos);
        return ResponseEntity.ok("Weightages saved successfully");
    }

    @GetMapping("/weightages/standard/{id}")
    public ResponseEntity<?> getWeightagesByStandard(@PathVariable Long id, @RequestParam Long academicYearId) {
        return ResponseEntity.ok(resultsHistoryFacade.getWeightagesByStandard(id, academicYearId));
    }

    // Term Result
    @PostMapping("/process")
    public ResponseEntity<?> processResults(@RequestParam Long standardId, @RequestParam Long sectionId, @RequestParam Long examTermId) {
        resultsHistoryFacade.processTermResults(standardId, sectionId, examTermId);
        return ResponseEntity.ok("Results processing initiated");
    }

    @GetMapping("/section")
    public ResponseEntity<?> getSectionResults(@RequestParam Long standardId, @RequestParam Long sectionId, @RequestParam Long examTermId) {
        return ResponseEntity.ok(resultsHistoryFacade.getSectionTermResults(standardId, sectionId, examTermId));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudentResult(@PathVariable Long id, @RequestParam Long examTermId) {
        return ResponseEntity.ok(resultsHistoryFacade.getStudentTermResult(id, examTermId));
    }

    // Report Card
    @PostMapping("/report-cards")
    public ResponseEntity<?> generateReportCard(@Valid @RequestBody ReportCardRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(resultsHistoryFacade.generateReportCard(dto));
    }

    @GetMapping("/report-cards/student/{id}")
    public ResponseEntity<?> getReportCardsByStudent(@PathVariable Long id) {
        return ResponseEntity.ok(resultsHistoryFacade.getReportCardsByStudent(id));
    }

    @DeleteMapping("/report-cards/{id}")
    public ResponseEntity<?> deleteReportCard(@PathVariable Long id) {
        resultsHistoryFacade.deleteReportCard(id);
        return ResponseEntity.noContent().build();
    }

    // Grade Scale
    @PostMapping("/grade-scales")
    public ResponseEntity<?> createGradeScale(@Valid @RequestBody GradeScaleRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(resultsHistoryFacade.createGradeScale(dto));
    }

    @PutMapping("/grade-scales/{id}")
    public ResponseEntity<?> updateGradeScale(@PathVariable Long id, @Valid @RequestBody GradeScaleRequestDTO dto) {
        return ResponseEntity.ok(resultsHistoryFacade.updateGradeScale(id, dto));
    }

    @GetMapping("/grade-scales")
    public ResponseEntity<?> getAllGradeScales() {
        return ResponseEntity.ok(resultsHistoryFacade.getAllActiveGradeScales());
    }

    @DeleteMapping("/grade-scales/{id}")
    public ResponseEntity<?> deleteGradeScale(@PathVariable Long id) {
        resultsHistoryFacade.deleteGradeScale(id);
        return ResponseEntity.noContent().build();
    }
}
