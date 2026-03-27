package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.StudentFeeAssignmentsResponseDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentFeeAssignmentFlatDTO;
import com.smartsolutions.eschool.student.facade.StudentFeeAssignmentFacade;
import com.smartsolutions.eschool.util.SecurityUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
@Slf4j
public class StudentFeeAssignmentController {

    private final StudentFeeAssignmentFacade studentFeeAssignmentFacade;

    public StudentFeeAssignmentController(StudentFeeAssignmentFacade studentFeeAssignmentFacade) {
        this.studentFeeAssignmentFacade = studentFeeAssignmentFacade;
    }

    @PostMapping(value = "/{studentId}/fees/assign", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentFeeSummaryDTO> createAssignStudentFee(@PathVariable Long studentId, @RequestBody @Valid StudentFeeAssignmentRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Controller:StudentFeeAssignmentController] createAssignStudentFee() called - studentId={}, institute={}", studentId, organizationId);
        StudentFeeSummaryDTO response = studentFeeAssignmentFacade.assignStudentFee(studentId, requestDTO);
        log.info("[Controller:StudentFeeAssignmentController] createAssignStudentFee() succeeded - studentId={}", studentId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value = "/{studentId}/fees/{academicYearId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentFeeAssignmentsResponseDTO> getById(@PathVariable Long studentId, @PathVariable Long academicYearId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Controller:StudentFeeAssignmentController] getById() called - studentId={}, academicYearId={}, institute={}", studentId, academicYearId, organizationId);
        StudentFeeAssignmentsResponseDTO response = studentFeeAssignmentFacade.getFeeAssignmentByStudentId(studentId, academicYearId);
        log.info("[Controller:StudentFeeAssignmentController] getById() succeeded");
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{studentId}/fees/assigned-flat", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentFeeAssignmentFlatDTO>> getAssignedFeesFlat(@PathVariable Long studentId, @RequestParam(required = false) Long academicYearId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Controller:StudentFeeAssignmentController] getAssignedFeesFlat() called - studentId={}, academicYearId={}, institute={}", studentId, academicYearId, organizationId);
        List<StudentFeeAssignmentFlatDTO> response = studentFeeAssignmentFacade.getAssignedFeesFlat(studentId, academicYearId);
        log.info("[Controller:StudentFeeAssignmentController] getAssignedFeesFlat() succeeded - Found {} records", response.size());
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{studentId}/fees/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentFeeSummaryDTO> updateStudentFee(@PathVariable Long studentId, @RequestBody @Valid StudentFeeAssignmentRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Controller:StudentFeeAssignmentController] updateStudentFee() called - studentId={}, institute={}", studentId, organizationId);
        StudentFeeSummaryDTO response = studentFeeAssignmentFacade.updateStudentFee(studentId, requestDTO);
        log.info("[Controller:StudentFeeAssignmentController] updateStudentFee() succeeded");
        return ResponseEntity.ok(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentFeeAssignmentFlatDTO>> getAll() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Controller:StudentFeeAssignmentController] getAll() called - institute={}", organizationId);
        List<StudentFeeAssignmentFlatDTO> response = studentFeeAssignmentFacade.getAllAssignments();
        log.info("[Controller:StudentFeeAssignmentController] getAll() succeeded - Found {} records", response.size());
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentFeeAssignmentFlatDTO>> search(@RequestParam(name = "keyword") String keyword) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Controller:StudentFeeAssignmentController] search() called - keyword={}, institute={}", keyword, organizationId);
        List<StudentFeeAssignmentFlatDTO> response = studentFeeAssignmentFacade.searchAssignments(keyword);
        log.info("[Controller:StudentFeeAssignmentController] search() succeeded - Found {} records", response.size());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/assignments/{assignmentId}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long assignmentId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Controller:StudentFeeAssignmentController] delete() called - assignmentId={}, institute={}", assignmentId, organizationId);
        studentFeeAssignmentFacade.deleteAssignment(assignmentId);
        log.info("[Controller:StudentFeeAssignmentController] delete() succeeded");
        return ResponseEntity.ok(Map.of("message", "Fee assignment deleted successfully"));
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getStatistics() {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Controller:StudentFeeAssignmentController] getStatistics() called - institute={}", organizationId);
        Map<String, Object> statistics = studentFeeAssignmentFacade.getStatistics();
        log.info("[Controller:StudentFeeAssignmentController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
