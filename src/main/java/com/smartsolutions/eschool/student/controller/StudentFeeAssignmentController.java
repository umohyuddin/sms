package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.StudentFeeAssignmentsResponseDTO;
import com.smartsolutions.eschool.student.facade.StudentFeeAssignmentFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@RequestMapping("/api/students")
@Slf4j
public class StudentFeeAssignmentController {

    private final StudentFeeAssignmentFacade studentFeeAssignmentFacade;

    public StudentFeeAssignmentController(StudentFeeAssignmentFacade studentFeeAssignmentFacade) {
        this.studentFeeAssignmentFacade = studentFeeAssignmentFacade;
    }

    @PostMapping(value = "/{studentId}/fees/assign", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAssignStudentFee(@PathVariable Long studentId, @RequestBody @Valid StudentFeeAssignmentRequestDTO requestDTO) {

        log.info("Received request to Student Fee Assignment for student Id: {}", studentId);
        StudentFeeSummaryDTO studentFeeSummaryDTO = studentFeeAssignmentFacade.assignStudentFee(studentId, requestDTO);
        log.info("Student Fee Assignment created successfully with id: {}", studentFeeSummaryDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(studentFeeSummaryDTO);
    }

    @GetMapping(value = "/{studentId}/fees/{academicYearId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long studentId, @PathVariable Long academicYearId) {
        log.info("GET /api/student/fee/assignment by Student id called");
        StudentFeeAssignmentsResponseDTO feeAssignmentByStudentId = studentFeeAssignmentFacade.getFeeAssignmentByStudentId(studentId, academicYearId);
        log.info("GET /api/student/fee/assignment by Student id succeeded");
        return ResponseEntity.ok().body(feeAssignmentByStudentId);
    }

    @GetMapping(value = "/{studentId}/fees/assigned-flat", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAssignedFeesFlat(@PathVariable Long studentId, @RequestParam(required = false) Long academicYearId) {
        log.info("GET assigned flat fee assignments for studentId={}, academicYearId={}", studentId, academicYearId);
        var response = studentFeeAssignmentFacade.getAssignedFeesFlat(studentId, academicYearId);
        log.info("Successfully fetched {} flat fee assignments for studentId={}", response.size(), studentId);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{studentId}/fees/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateStudentFee(@PathVariable Long studentId, @RequestBody @Valid StudentFeeAssignmentRequestDTO requestDTO) {
        log.info("Received request to update Student Fee for studentId={}", studentId);
        StudentFeeSummaryDTO updatedSummary = studentFeeAssignmentFacade.updateStudentFee(studentId, requestDTO);
        log.info("Student Fee updated successfully for studentId={} with totalAssignedFee={}", studentId, updatedSummary.getTotalAssignedFee());
        return ResponseEntity.ok(updatedSummary);
    }

}
