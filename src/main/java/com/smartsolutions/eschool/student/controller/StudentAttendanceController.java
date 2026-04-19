package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.attendance.AttendanceReportDTO;
import com.smartsolutions.eschool.student.dtos.attendance.StudentAttendanceRequestDTO;
import com.smartsolutions.eschool.student.dtos.attendance.StudentAttendanceResponseDTO;
import com.smartsolutions.eschool.student.facade.StudentAttendanceFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smartsolutions.eschool.global.error.ErrorResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/api/students/attendance", "/api/students/attendance/"})
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Student Attendance", description = "Endpoints for marking, searching, and generating statistics for student attendance.")
public class StudentAttendanceController {

    private final StudentAttendanceFacade attendanceFacade;
    private final com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    /**
     * Search attendance records or Load Roll Call.
     * 
     * | Scenario                       | Repository Result | Service/API Result                           |
     * | :---                           | :---              | :---                                         |
     * | Attendance already marked      | List of Entities  | List of DTOs (with IDs and Status)           |
     * | First time marking (Roll Call) | Empty List []     | **Full list of students** (id: null, status: null) |
     * | Search by keyword (no match)   | Empty List []     | Empty List []                                |
     * | Invalid/Missing Filters        | Empty List []     | Empty List []                                |
     * 
     * Detailed Behavior:
     * - **Scenario A: Attendance already marked**
     *   If there are already records in the database for the given filters and date:
     *   - Result: You will get a list of all attendance records for the provided range (e.g., entire Campus or specific Section).
     *   - Date Factor: This works for both the current date and any past date.
     *   - Use Case: Useful for principals/admins to see overall attendance reports.
     * 
     * - **Scenario B: Attendance NOT marked (No records in DB)**
     *   If the table is empty for the given filters and date:
     *   - Result: You will get an **empty list []** UNLESS you provide all core filters (campusId, standardId, and sectionId).
     *   - Note: The "Roll Call" (auto-populating the student list) is disabled for campus-wide searches for performance reasons.
     *   - Roll Call: Only triggers when you narrow down to a specific **sectionId**.
     */
    @Operation(summary = "Search attendance", description = "Search for attendance records or perform a roll call for a specific section on a date.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved attendance list",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentAttendanceResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentAttendanceResponseDTO>> search(
            @Parameter(description = "ID of the campus", example = "1") @RequestParam(required = false) Long campusId,
            @Parameter(description = "ID of the academic standard", example = "5") @RequestParam(required = false) Long standardId,
            @Parameter(description = "ID of the section (Required for roll call)", example = "1") @RequestParam(required = false) Long sectionId,
            @Parameter(description = "Date for attendance", example = "2024-04-19") @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @Parameter(description = "Keyword for student name search", example = "Arslan") @RequestParam(required = false) String keyword) {
        log.info("[Controller:StudentAttendanceController] search() called - campusId={}, date={}, keyword={}", campusId, date, keyword);
        List<StudentAttendanceResponseDTO> list = attendanceFacade.search(campusId, standardId, sectionId, date, keyword);
        log.info("[Controller:StudentAttendanceController] search() succeeded - Found {} records", list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentAttendanceResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:StudentAttendanceController] getById() called - id: {}", id);
        StudentAttendanceResponseDTO responseDTO = attendanceFacade.getById(id);
        log.info("[Controller:StudentAttendanceController] getById() succeeded");
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Mark attendance (Single or Batch)", description = "Mark attendance for one or more students. Accepts either a single object or a JSON array.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Attendance marked successfully",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentAttendanceResponseDTO.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Object request) {
        if (request instanceof List) {
            log.info("[Controller:StudentAttendanceController] create() - Batch request received");
            List<StudentAttendanceRequestDTO> dtos = objectMapper.convertValue(request, 
                new com.fasterxml.jackson.core.type.TypeReference<List<StudentAttendanceRequestDTO>>() {});
            List<StudentAttendanceResponseDTO> response = attendanceFacade.saveBatch(dtos);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            log.info("[Controller:StudentAttendanceController] create() - Single request received");
            StudentAttendanceRequestDTO dto = objectMapper.convertValue(request, StudentAttendanceRequestDTO.class);
            StudentAttendanceResponseDTO response = attendanceFacade.create(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentAttendanceResponseDTO> update(@PathVariable Long id, @Valid @RequestBody StudentAttendanceRequestDTO requestDTO) {
        log.info("[Controller:StudentAttendanceController] update() called - id: {}", id);
        StudentAttendanceResponseDTO updated = attendanceFacade.update(id, requestDTO);
        log.info("[Controller:StudentAttendanceController] update() succeeded");
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:StudentAttendanceController] delete() called - id: {}", id);
        attendanceFacade.softDelete(id);
        log.info("[Controller:StudentAttendanceController] delete() succeeded");
        return ResponseEntity.ok(Map.of("message", "Attendance record deleted successfully"));
    }

    @Operation(summary = "Get overall statistics", description = "Retrieve summary counts of Present, Absent, and Leave statuses for a specific date.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics",
                    content = @Content(mediaType = "application/json", schema = @Schema(example = "{\"PRESENT\": 150, \"ABSENT\": 10, \"LEAVE\": 5}"))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics(
            @Parameter(description = "Target date for statistics (defaults to today)", example = "2024-04-19") @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("[Controller:StudentAttendanceController] getStatistics() called");
        Map<String, Long> statistics = attendanceFacade.getStatistics(date);
        log.info("[Controller:StudentAttendanceController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }

    /**
     * Get detailed attendance report with hierarchical aggregation and date range support.
     * 
     * | Filter Provided | Aggregation Level          |
     * | :---            | :---                       |
     * | None            | Campus-wide totals         |
     * | campusId        | Standard-wide totals for Campus |
     * | standardId      | Section-wide totals for Standard |
     * | sectionId       | Student-level status for Section |
     * 
     * Full Structure: The report pre-populates all sub-levels even with zero counts.
     */
    @Operation(summary = "Get detailed report", description = "Generate a hierarchical attendance report (Campus -> Standard -> Section -> Student).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved detailed report",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AttendanceReportDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttendanceReportDTO> getDetailedReport(
            @Parameter(description = "ID of the campus", example = "1") @RequestParam(required = false) Long campusId,
            @Parameter(description = "ID of the academic standard", example = "5") @RequestParam(required = false) Long standardId,
            @Parameter(description = "ID of the section", example = "1") @RequestParam(required = false) Long sectionId,
            @Parameter(description = "Report start date", example = "2024-04-01") @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @Parameter(description = "Report end date", example = "2024-04-30") @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        log.info("[Controller:StudentAttendanceController] getDetailedReport() called - campusId={}, standardId={}, sectionId={}, range=[{} to {}]", 
                campusId, standardId, sectionId, startDate, endDate);
        AttendanceReportDTO report = attendanceFacade.getDetailedReport(campusId, standardId, sectionId, startDate, endDate);
        log.info("[Controller:StudentAttendanceController] getDetailedReport() succeeded");
        return ResponseEntity.ok(report);
    }
}
