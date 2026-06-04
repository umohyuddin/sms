package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.global.error.ErrorResponse;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.studentFeeSummary.responseDto.StudentFeeSummaryResponseDto;
import com.smartsolutions.eschool.student.facade.StudentFeeSummaryFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students/fee/summary")
@Slf4j
@Tag(name = "Fee Management - Summaries", description = "Endpoints for viewing aggregated fee statuses, balances, and payment histories.")
public class StudentFeeSummaryController {

    private final StudentFeeSummaryFacade studentFeeSummaryFacade;

    public StudentFeeSummaryController(StudentFeeSummaryFacade studentFeeSummaryFacade) {
        this.studentFeeSummaryFacade = studentFeeSummaryFacade;
    }

    @Operation(summary = "Get all fee summaries", description = "Retrieve a list of fee summaries for all students in the current active session.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved summaries",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StudentFeeSummaryDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentFeeSummaryDTO>> getAll() {
        log.info("[Controller:StudentFeeSummaryController] getAll() called - Request to get all fee summaries");
        List<StudentFeeSummaryDTO> resources = studentFeeSummaryFacade.getAll();
        log.info("[Controller:StudentFeeSummaryController] getAll() succeeded - Found {} summaries", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get fee summary by student ID", description = "Retrieve the comprehensive fee status and balance for a specific student.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved summary",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = StudentFeeSummaryDTO.class))),
            @ApiResponse(responseCode = "404", description = "Student or summary not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentFeeSummaryDTO> getByStudentId(
            @Parameter(description = "ID of the student", example = "5001") @PathVariable Long studentId) {
        log.info("[Controller:StudentFeeSummaryController] getByStudentId() called - Request to fetch summary for student: {}", studentId);
        StudentFeeSummaryDTO dto = studentFeeSummaryFacade.getByStudentId(studentId);
        log.info("[Controller:StudentFeeSummaryController] getByStudentId() succeeded");
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Filter detailed fee summary", description = "Retrieve a detailed fee summary with monthly breakdown for a student in a specific academic year.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved detailed summary",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = StudentFeeSummaryResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Summary not found",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentFeeSummaryResponseDto> getDetailedSummary(
            @Parameter(description = "ID of the student", example = "5001") @RequestParam Long studentId,
            @Parameter(description = "ID of the academic year", example = "1") @RequestParam Long academicYearId) {
        log.info("[Controller:StudentFeeSummaryController] getDetailedSummary() called - studentId: {}, academicYearId: {}", 
                studentId, academicYearId);
        StudentFeeSummaryResponseDto dto = studentFeeSummaryFacade.getByStudentFeeSummaryAcademicYear(studentId, academicYearId);
        log.info("[Controller:StudentFeeSummaryController] getDetailedSummary() succeeded");
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Search fee summaries", description = "Find fee summaries by student name or code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching summaries",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = StudentFeeSummaryDTO.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid search keyword",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentFeeSummaryDTO>> search(
            @Parameter(description = "Search keyword (name or code)", example = "John") @RequestParam String keyword) {
        log.info("[Controller:StudentFeeSummaryController] search() called - keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<StudentFeeSummaryDTO> dtos = studentFeeSummaryFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:StudentFeeSummaryController] search() succeeded - Found {} matching summaries", dtos.size());
        return ResponseEntity.ok(dtos);
    }
}

