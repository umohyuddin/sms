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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import com.smartsolutions.eschool.global.error.ErrorResponse;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/school/discounts/student")
@Slf4j
@Tag(name = "Student Discount Assignment", description = "Endpoints for assigning and managing student-specific discounts.")
public class StudentDiscountAssignmentController {

    private final StudentDiscountAssignmentFacade studentDiscountFacade;

    public StudentDiscountAssignmentController(StudentDiscountAssignmentFacade studentDiscountFacade) {
        this.studentDiscountFacade = studentDiscountFacade;
    }

    // -------------------------------------------------------------------------
    // CREATE
    // -------------------------------------------------------------------------
    @Operation(summary = "Assign discount to student", description = "Create a new discount assignment for a specific student and academic year.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Discount assigned successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentDiscountAssignmentResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input or business rule violation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
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
    @Operation(summary = "Get all assignments", description = "Retrieve a list of all student discount assignments.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List retrieved successfully",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentDiscountAssignmentResponseDTO.class))))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        log.info("GET /api/school/discounts/student called");
        List<StudentDiscountAssignmentResponseDTO> list = studentDiscountFacade.getAll();
        log.info("Returned {} student discount assignments", list.size());
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Get assigned discounts for student", description = "Fetch all active/assigned discounts for a student in a specific academic year.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved assigned discounts",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentDiscountAssignmentResponseDTO.class)))),
            @ApiResponse(responseCode = "404", description = "Student or Academic Year not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{studentId}/assigned")
    public ResponseEntity<List<StudentDiscountAssignmentResponseDTO>> getAssignedDiscounts(
            @Parameter(description = "ID of the student", example = "5001") @PathVariable Long studentId,
            @Parameter(description = "ID of the academic year", example = "1") @RequestParam Long academicYearId) {
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
    @Operation(summary = "Update assignment", description = "Update details of an existing discount assignment.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Assignment updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentDiscountAssignmentResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Assignment not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{assignmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateStudentDiscount(
            @Parameter(description = "ID of the assignment", example = "1") @PathVariable Long assignmentId,
            @RequestBody @Valid StudentDiscountAssignmentRequestDTO requestDTO) {
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
