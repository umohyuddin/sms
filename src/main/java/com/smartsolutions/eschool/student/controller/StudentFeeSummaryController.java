package com.smartsolutions.eschool.student.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeRateDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.StudentFeeSummaryDTO;
import com.smartsolutions.eschool.student.dtos.studentFeeSummary.responseDto.StudentFeeSummaryResponseDto;
import com.smartsolutions.eschool.student.facade.FeeParticularsFacade;
import com.smartsolutions.eschool.student.facade.StudentFeeSummaryFacade;
import com.smartsolutions.eschool.student.model.FeeParticularsEntity;
import com.smartsolutions.eschool.util.MultiResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.ResourceObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.smartsolutions.eschool.global.error.ErrorResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@RestController
@RequestMapping("/api/students")
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
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentFeeSummaryDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/fee/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/fee/rates called");
        List<StudentFeeSummaryDTO> resources = studentFeeSummaryFacade.getAll();
        log.info("GET /api/fee/rates succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @Operation(summary = "Get fee summary for student", description = "Retrieve the comprehensive fee status and balance for a specific student.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved summary",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentFeeSummaryDTO.class))),
            @ApiResponse(responseCode = "404", description = "Student or summary not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{studentId}/fee/summary", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@Parameter(description = "ID of the student", example = "5001") @PathVariable Long studentId) throws Exception {
        log.info("Received request to fetch Fee rate with id: {}", studentId);
        StudentFeeSummaryDTO studentFeeSummaryDTO = studentFeeSummaryFacade.getByStudentId(studentId);
        log.info("Returning Fee rate: id={}", studentFeeSummaryDTO.getStudentId());
        return ResponseEntity.ok(studentFeeSummaryDTO);
    }

    @Operation(summary = "Filter fee summary", description = "Retrieve a filtered fee summary for a student in a specific academic year.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved filtered summary",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentFeeSummaryResponseDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/fee/summary/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFeeSummary(
            @Parameter(description = "ID of the student", example = "5001") @RequestParam Long studentId,
            @Parameter(description = "ID of the academic year", example = "1") @RequestParam Long academicYearId) throws Exception {
        log.info("Received request to fetch Fee summary for studentId: {} and academicYearId: {}", studentId, academicYearId);
        StudentFeeSummaryResponseDto studentFeeSummaryDTO = studentFeeSummaryFacade.getByStudentFeeSummaryAcademicYear(studentId, academicYearId);
        log.info("Returning Fee summary for studentId={} and academicYearId={}", studentId, academicYearId);
        return ResponseEntity.ok(studentFeeSummaryDTO);
    }

}
