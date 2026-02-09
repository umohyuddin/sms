package com.smartsolutions.sms.academic.controller;

import com.smartsolutions.sms.academic.dto.request.TeacherSubjectAssignmentRequestDTO;
import com.smartsolutions.sms.academic.dto.request.TimetableRequestDTO;
import com.smartsolutions.sms.academic.entity.master.TimetableEntity;
import com.smartsolutions.sms.academic.facade.TeacherTimetableFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/academic/scheduling")
@RequiredArgsConstructor
@Slf4j
public class TeacherTimetableController {

    private final TeacherTimetableFacade teacherTimetableFacade;

    // Teacher Assignment
    @PostMapping("/assignments")
    public ResponseEntity<?> assignTeacher(@Valid @RequestBody TeacherSubjectAssignmentRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherTimetableFacade.assignTeacher(dto));
    }

    @GetMapping("/assignments/teacher/{id}")
    public ResponseEntity<?> getTeacherAssignments(@PathVariable Long id) {
        return ResponseEntity.ok(teacherTimetableFacade.getByTeacher(id));
    }

    @GetMapping("/assignments/section")
    public ResponseEntity<?> getSectionAssignments(@RequestParam Long standardId, @RequestParam Long sectionId, @RequestParam Long academicYearId) {
        return ResponseEntity.ok(teacherTimetableFacade.getBySection(standardId, sectionId, academicYearId));
    }

    @DeleteMapping("/assignments")
    public ResponseEntity<?> unassignTeacher(
            @RequestParam Long employeeId, @RequestParam Long standardId, @RequestParam Long sectionId,
            @RequestParam Long subjectId, @RequestParam Long academicYearId, @RequestParam String effectiveFrom) {
        teacherTimetableFacade.unassignTeacher(employeeId, standardId, sectionId, subjectId, academicYearId, LocalDate.parse(effectiveFrom));
        return ResponseEntity.noContent().build();
    }

    // Timetable
    @PostMapping("/timetable")
    public ResponseEntity<?> createTimetable(@Valid @RequestBody TimetableRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherTimetableFacade.createTimetable(dto));
    }

    @PutMapping("/timetable/{id}")
    public ResponseEntity<?> updateTimetable(@PathVariable Long id, @Valid @RequestBody TimetableRequestDTO dto) {
        return ResponseEntity.ok(teacherTimetableFacade.updateTimetable(id, dto));
    }

    @GetMapping("/timetable/section")
    public ResponseEntity<?> getSectionTimetable(@RequestParam Long standardId, @RequestParam Long sectionId) {
        return ResponseEntity.ok(teacherTimetableFacade.getSectionTimetable(standardId, sectionId));
    }

    @GetMapping("/timetable/teacher/{id}")
    public ResponseEntity<?> getTeacherTimetable(@PathVariable Long id, @RequestParam TimetableEntity.DayOfWeek day) {
        return ResponseEntity.ok(teacherTimetableFacade.getTeacherTimetable(id, day));
    }

    @DeleteMapping("/timetable/{id}")
    public ResponseEntity<?> deleteTimetable(@PathVariable Long id) {
        teacherTimetableFacade.deleteTimetable(id);
        return ResponseEntity.noContent().build();
    }
}
