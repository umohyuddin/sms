package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.studentAttendance.response.*;
import com.smartsolutions.eschool.student.facade.StudentAttendanceReportFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance/report")
@RequiredArgsConstructor
public class StudentAttendanceReportController {
    private final StudentAttendanceReportFacade facade;

    @GetMapping("/daily")
    public ResponseEntity<List<DailyAttendanceReportDTO>> dailyReport(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(facade.dailyAttendanceReport(date));
    }

    @GetMapping("/class")
    public ResponseEntity<List<ClassAttendanceReportDTO>> classReport(@RequestParam Long standardId, @RequestParam Long sectionId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(facade.classAttendanceReport(standardId, sectionId, startDate, endDate));
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<AttendanceSummaryDTO> studentSummary(@PathVariable Long studentId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(facade.studentAttendanceSummary(studentId, startDate, endDate));
    }

    @GetMapping("/overall")
    public ResponseEntity<List<AttendanceSummaryDTO>> overallSummary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return ResponseEntity.ok(facade.overallAttendanceSummary(startDate, endDate));
    }




    // MARK SINGLE
    @PostMapping("/mark")
    public ResponseEntity<StudentAttendanceDTO> markAttendance(@RequestBody StudentAttendanceDTO dto) {
        return ResponseEntity.ok(facade.markAttendance(dto));
    }

    // MARK BATCH
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
