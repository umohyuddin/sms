package com.smartsolutions.eschool.student.controller;


import com.smartsolutions.eschool.student.dtos.studentDiscountAssignment.requestDto.StudentDiscountAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.studentDiscountAssignment.responseDto.StudentDiscountAssignmentResponseDTO;
import com.smartsolutions.eschool.student.facade.StudentDiscountAssignmentFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/school/discounts/student")
@Slf4j
public class StudentDiscountAssignmentController {

    private final StudentDiscountAssignmentFacade studentDiscountFacade;

    public StudentDiscountAssignmentController(StudentDiscountAssignmentFacade studentDiscountFacade) {
        this.studentDiscountFacade = studentDiscountFacade;
    }

    // -------------------------------------------------------------------------
    // CREATE
    // -------------------------------------------------------------------------
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createStudentDiscount(@RequestBody @Valid StudentDiscountAssignmentRequestDTO requestDTO) {
        log.info("Received request to assign discount to student");
        StudentDiscountAssignmentResponseDTO responseDTO = studentDiscountFacade.assignDiscount(requestDTO);
        log.info("Discount assigned successfully with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    // -------------------------------------------------------------------------
    // GET ALL
    // -------------------------------------------------------------------------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        log.info("GET /api/school/discounts/student called");
        List<StudentDiscountAssignmentResponseDTO> list = studentDiscountFacade.getAll();
        log.info("Returned {} student discount assignments", list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{studentId}/assigned")
    public ResponseEntity<List<StudentDiscountAssignmentResponseDTO>> getAssignedDiscounts(@PathVariable Long studentId, @RequestParam Long academicYearId) {
        log.info("GET /api/school/discounts/student/{}/assigned?academicYearId={} called", studentId, academicYearId);

        List<StudentDiscountAssignmentResponseDTO> assignedDiscounts = studentDiscountFacade.getAssignedDiscountsForStudent(studentId, academicYearId);

        log.info("Returned {} assigned discounts for student {}", assignedDiscounts.size(), studentId);
        return ResponseEntity.ok(assignedDiscounts);
    }

    // -------------------------------------------------------------------------
    // GET BY ID
    // -------------------------------------------------------------------------
    @GetMapping(value = "/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long assignmentId) {
        log.info("GET /api/school/discounts/student/{} called", assignmentId);
        StudentDiscountAssignmentResponseDTO dto = studentDiscountFacade.getById(assignmentId);
        log.info("Returned student discount assignment with id {}", dto.getId());
        return ResponseEntity.ok(dto);
    }

    // -------------------------------------------------------------------------
    // GET ALL BY STUDENT
    // -------------------------------------------------------------------------
    @GetMapping(value = "/by-student/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByStudent(@PathVariable Long studentId) {
        log.info("GET /api/school/discounts/student/by-student/{} called", studentId);
        List<StudentDiscountAssignmentResponseDTO> list = studentDiscountFacade.getByStudent(studentId);
        log.info("Returned {} discounts for student {}", list.size(), studentId);
        return ResponseEntity.ok(list);
    }

    // -------------------------------------------------------------------------
    // UPDATE ASSIGNMENT
    // -------------------------------------------------------------------------
    @PutMapping(value = "/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateStudentDiscount(@PathVariable Long assignmentId, @RequestBody @Valid StudentDiscountAssignmentRequestDTO requestDTO) {
        log.info("PUT /api/school/discounts/student/{} called", assignmentId);
        StudentDiscountAssignmentResponseDTO dto = studentDiscountFacade.updateAssignment(assignmentId, requestDTO);
        log.info("Updated student discount assignment {}", assignmentId);
        return ResponseEntity.ok(dto);
    }

    // -------------------------------------------------------------------------
    // SOFT DELETE BY ID
    // -------------------------------------------------------------------------
    @DeleteMapping("/{assignmentId}")
    public ResponseEntity<?> softDeleteById(@PathVariable Long assignmentId) {
        log.info("DELETE /api/school/discounts/student/{} called", assignmentId);
        int result = studentDiscountFacade.softDelete(assignmentId);
        if (result == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student discount assignment not found with id: " + assignmentId);
        }
        log.info("Student discount assignment deleted successfully: {}", assignmentId);
        return ResponseEntity.ok("Student discount assignment deleted successfully");
    }

    // -------------------------------------------------------------------------
    // DELETE ALL
    // -------------------------------------------------------------------------
    @DeleteMapping("/all")
    public ResponseEntity<?> softDeleteAll() {
        log.info("DELETE /api/school/discounts/student/all called");
        int count = studentDiscountFacade.softDeleteAll();
        log.info("Deleted {} student discount assignments", count);
        return ResponseEntity.ok(count + " student discount assignments deleted");
    }

    // -------------------------------------------------------------------------
    // ACTIVATE
    // -------------------------------------------------------------------------
    @PatchMapping(value = "/{assignmentId}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> activate(@PathVariable Long assignmentId) {
        log.info("PATCH /api/school/discounts/student/{}/activate called", assignmentId);
        studentDiscountFacade.markAsActive(assignmentId);
        return ResponseEntity.ok("Student discount assignment marked as active");
    }

    // -------------------------------------------------------------------------
    // DEACTIVATE
    // -------------------------------------------------------------------------
    @PatchMapping(value = "/{assignmentId}/deactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deactivate(@PathVariable Long assignmentId) {
        log.info("PATCH /api/school/discounts/student/{}/deactivate called", assignmentId);
        studentDiscountFacade.markAsInactive(assignmentId);
        return ResponseEntity.ok("Student discount assignment marked as inactive");
    }

//    // -------------------------------------------------------------------------
//    // SEARCH BY KEYWORD (Optional)
//    // -------------------------------------------------------------------------
//    @GetMapping(value = "/search/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> search(@PathVariable String keyword) {
//        log.info("GET /api/school/discounts/student/search/{} called", keyword);
//        List<StudentDiscountResponseDTO> list = studentDiscountFacade.search(keyword);
//        log.info("Returned {} results for search '{}'", list.size(), keyword);
//        return ResponseEntity.ok(list);
//    }
}
