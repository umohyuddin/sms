package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.requestDto.StudentFeeAssignmentRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.byStudentId.StudentFeeAssignmentsResponseDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentFeeAssignmentFlatDTO;
import com.smartsolutions.eschool.student.facade.StudentFeeAssignmentFacade;
import com.smartsolutions.eschool.util.SecurityUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smartsolutions.eschool.global.error.ErrorResponse;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/students")
@Slf4j
@Tag(name = "Fee Management - Student Assignments", description = "Endpoints for assigning specific fee components and rates to individual students.")
public class StudentFeeAssignmentController {

    private final StudentFeeAssignmentFacade studentFeeAssignmentFacade;

    public StudentFeeAssignmentController(StudentFeeAssignmentFacade studentFeeAssignmentFacade) {
        this.studentFeeAssignmentFacade = studentFeeAssignmentFacade;
    }

    @Operation(summary = "Assign fees to a student", description = "Assign targeted fee components to a student for the current academic session.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully assigned fees",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentFeeSummaryDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid assignment request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(value = "/{studentId}/fees/assign", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentFeeSummaryDTO> createAssignStudentFee(
            @Parameter(description = "ID of the student", example = "5001") @PathVariable Long studentId,
            @RequestBody @Valid StudentFeeAssignmentRequestDTO requestDTO) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Controller:StudentFeeAssignmentController] createAssignStudentFee() called - studentId={}, institute={}", studentId, organizationId);
        StudentFeeSummaryDTO response = studentFeeAssignmentFacade.assignStudentFee(studentId, requestDTO);
        log.info("[Controller:StudentFeeAssignmentController] createAssignStudentFee() succeeded - studentId={}", studentId);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Get fee assignments for student", description = "Retrieve all specific fee components assigned to a student for a given academic year.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved assignments",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentFeeAssignmentsResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Student or assignments not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{studentId}/fees/{academicYearId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentFeeAssignmentsResponseDTO> getById(
            @Parameter(description = "ID of the student", example = "5001") @PathVariable Long studentId,
            @Parameter(description = "ID of the academic year", example = "1") @PathVariable Long academicYearId) {
        Long organizationId = SecurityUtils.getCurrentOrganizationId();
        log.info("[Controller:StudentFeeAssignmentController] getById() called - studentId={}, academicYearId={}, institute={}", studentId, academicYearId, organizationId);
        StudentFeeAssignmentsResponseDTO response = studentFeeAssignmentFacade.getFeeAssignmentByStudentId(studentId, academicYearId);
        log.info("[Controller:StudentFeeAssignmentController] getById() succeeded");
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get flat fee assignments list", description = "Retrieve a flat (denormalized) view of all assigned fees for a student.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved flat assignments",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentFeeAssignmentFlatDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{studentId}/fees/assigned-flat", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentFeeAssignmentFlatDTO>> getAssignedFeesFlat(
            @Parameter(description = "ID of the student", example = "5001") @PathVariable Long studentId,
            @Parameter(description = "ID of the academic year (Optional)", example = "1") @RequestParam(required = false) Long academicYearId) {
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
