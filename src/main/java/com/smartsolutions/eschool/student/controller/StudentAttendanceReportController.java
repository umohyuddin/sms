package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.studentAttendance.response.*;
import com.smartsolutions.eschool.student.facade.StudentAttendanceReportFacade;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smartsolutions.eschool.global.error.ErrorResponse;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance/report")
@RequiredArgsConstructor
@Tag(name = "Student Attendance Reporting", description = "Specialized endpoints for generating detailed attendance reports and summaries.")
public class StudentAttendanceReportController {
    private final StudentAttendanceReportFacade facade;

    @Operation(summary = "Get daily report", description = "Retrieve a list of status-wise attendance records for all students on a specific date.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved daily report",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = DailyAttendanceReportDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/daily")
    public ResponseEntity<List<DailyAttendanceReportDTO>> dailyReport(
            @Parameter(description = "Date for the report", example = "2024-04-19")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(facade.dailyAttendanceReport(date));
    }

    @Operation(summary = "Get class-wise report", description = "Retrieve attendance summary for a specific standard and section over a date range.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved class report",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClassAttendanceReportDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/class")
    public ResponseEntity<List<ClassAttendanceReportDTO>> classReport(
            @Parameter(description = "ID of the academic standard", example = "5") @RequestParam Long standardId,
            @Parameter(description = "ID of the section", example = "1") @RequestParam Long sectionId,
            @Parameter(description = "Start date", example = "2024-04-01") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @Parameter(description = "End date", example = "2024-04-30") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(facade.classAttendanceReport(standardId, sectionId, startDate, endDate));
    }

    @Operation(summary = "Get student summary", description = "Retrieve an aggregated attendance summary for a single student over a date range.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved student summary",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AttendanceSummaryDTO.class))),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/student/{studentId}")
    public ResponseEntity<AttendanceSummaryDTO> studentSummary(
            @Parameter(description = "ID of the student", example = "500") @PathVariable Long studentId,
            @Parameter(description = "Start date", example = "2024-04-01") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @Parameter(description = "End date", example = "2024-04-30") @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(facade.studentAttendanceSummary(studentId, startDate, endDate));
    }

    @GetMapping("/overall")
    public ResponseEntity<List<AttendanceSummaryDTO>> overallSummary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(facade.overallAttendanceSummary(startDate, endDate));
    }




    // MARK SINGLE
    @Operation(summary = "Mark attendance (Single)", description = "Record a single attendance entry.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Attendance marked successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentAttendanceDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/mark")
    public ResponseEntity<StudentAttendanceDTO> markAttendance(@RequestBody StudentAttendanceDTO dto) {
        return ResponseEntity.ok(facade.markAttendance(dto));
    }

    @Operation(summary = "Mark attendance (Batch)", description = "Record multiple attendance entries at once.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Batch attendance marked successfully",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentAttendanceDTO.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid input list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/mark/batch")
    public ResponseEntity<List<StudentAttendanceDTO>> markBatchAttendance(@RequestBody List<StudentAttendanceDTO> dtos) {
        return ResponseEntity.ok(facade.markBatchAttendance(dtos));
    }

    // UPDATE
    @PutMapping("/update")
    public ResponseEntity<StudentAttendanceDTO> updateAttendance(@RequestBody StudentAttendanceDTO dto) {
        return ResponseEntity.ok(facade.updateAttendance(dto));
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        facade.deleteAttendance(id);
        return ResponseEntity.noContent().build();
    }

    // GET BY STUDENT
//    @GetMapping("/student/{studentId}")
//    public ResponseEntity<List<StudentAttendanceDTO>> getAttendanceByStudent(
//            @PathVariable Long studentId,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
//        return ResponseEntity.ok(facade.getAttendanceByStudent(studentId, startDate, endDate));
//    }

    // GET BY CLASS
//    @GetMapping("/class")
//    public ResponseEntity<List<StudentAttendanceDTO>> getAttendanceByClass(
//            @RequestParam Long standardId,
//            @RequestParam Long sectionId,
//            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
//        return ResponseEntity.ok(facade.getAttendanceByClass(standardId, sectionId, date));
//    }

    // GET BY STANDARD
    @GetMapping("/standard/{standardId}")
    public ResponseEntity<List<StudentAttendanceDTO>> getAttendanceByStandard(
            @PathVariable Long standardId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(facade.getAttendanceByStandard(standardId, startDate, endDate));
    }

    // CHECK IF EXISTS
    @GetMapping("/check")
    public ResponseEntity<AttendanceCheckDTO> checkAttendanceExists(
            @RequestParam Long studentId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate attendanceDate) {
        return ResponseEntity.ok(facade.checkAttendanceExists(studentId, attendanceDate));
    }

    // COUNT PRESENT / ABSENT / LEAVE
    @GetMapping("/count/present/{studentId}")
    public ResponseEntity<Long> countPresent(
            @PathVariable Long studentId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(facade.countPresent(studentId, startDate, endDate));
    }

    @GetMapping("/count/absent/{studentId}")
    public ResponseEntity<Long> countAbsent(
            @PathVariable Long studentId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(facade.countAbsent(studentId, startDate, endDate));
    }

    @GetMapping("/count/leave/{studentId}")
    public ResponseEntity<Long> countLeave(
            @PathVariable Long studentId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(facade.countLeave(studentId, startDate, endDate));
    }
}
