package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.attendance.AttendanceReportDTO;
import com.smartsolutions.eschool.student.dtos.attendance.StudentAttendanceRequestDTO;
import com.smartsolutions.eschool.student.dtos.attendance.StudentAttendanceResponseDTO;
import com.smartsolutions.eschool.student.facade.StudentAttendanceFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/api/students/attendance", "/api/students/attendance/"})
@RequiredArgsConstructor
@Slf4j
public class StudentAttendanceController {

    private final StudentAttendanceFacade attendanceFacade;
    private final com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentAttendanceResponseDTO>> search(
            @RequestParam(required = false) Long campusId,
            @RequestParam(required = false) Long standardId,
            @RequestParam(required = false) Long sectionId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(required = false) String keyword) {
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

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("[Controller:StudentAttendanceController] getStatistics() called");
        Map<String, Long> statistics = attendanceFacade.getStatistics(date);
        log.info("[Controller:StudentAttendanceController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }

    @GetMapping(value = "/report", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AttendanceReportDTO> getDetailedReport(
            @RequestParam(required = false) Long campusId,
            @RequestParam(required = false) Long standardId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("[Controller:StudentAttendanceController] getDetailedReport() called - campusId={}, standardId={}, date={}", campusId, standardId, date);
        AttendanceReportDTO report = attendanceFacade.getDetailedReport(campusId, standardId, date);
        log.info("[Controller:StudentAttendanceController] getDetailedReport() succeeded");
        return ResponseEntity.ok(report);
    }
}
