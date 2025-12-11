package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentRequestDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentDashboardDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentResponseDTO;
import com.smartsolutions.eschool.student.facade.StudentFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/institute/students")
@Slf4j
public class StudentController {

    @Autowired
    private StudentFacade studentFacade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/students/getall called");
        List<StudentDTO> resources = studentFacade.getAll();
        log.info("GET /api/student/getall succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createStudent(@RequestBody StudentRequestDTO studentDTO) {
        log.info("POST /api/institute/students called to create new student: {}", studentDTO);

        StudentResponseDTO createdStudent = studentFacade.createStudent(studentDTO);

        log.info("Student created successfully with id: {}", createdStudent.getId());
        return ResponseEntity.ok(createdStudent);
    }


    @GetMapping(value = "/campus/{campusId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDTO> getStudentsByCampus(@PathVariable Long campusId) {
        log.info("GET /api/students/by-campus called");
        List<StudentDTO> resources = studentFacade.getStudentsByCampus(campusId);
        log.info("GET /api/student/by-campus succeeded, returned {} resources", resources.size());
        return resources;
    }

    @GetMapping(value = "/search/name/{studentName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDTO> getStudentName(@PathVariable String studentName) {
        log.info("GET /api/students/by-name called");
        List<StudentDTO> resources = studentFacade.getStudentsByName(studentName);
        log.info("GET /api/student/by-name succeeded, returned {} resources", resources.size());
        return resources;
    }

    @GetMapping(value = "/standard/{standardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDTO> getStudentsByStandard(@PathVariable Long standardId) {
        log.info("GET /api/students/by-standard called");
        List<StudentDTO> resources = studentFacade.getStudentsByStandard(standardId);
        log.info("GET /api/student/by-standardId succeeded, returned {} resources", resources.size());
        return resources;
    }

    @GetMapping(value = "/section/{sectionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDTO> getStudentsBySection(@PathVariable Long sectionId) {
        log.info("GET /api/students/by-section called");
        List<StudentDTO> resources = studentFacade.getStudentsBySection(sectionId);
        log.info("GET /api/student/by-section succeeded, returned {} resources", resources.size());
        return resources;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        log.info("Received request to fetch Student with id: {}", id);
        StudentDTO studentDTO = studentFacade.getById(id);
        log.info("Returning Student: id={}", studentDTO.getId());
        return ResponseEntity.ok(studentDTO);
    }

    @GetMapping(value = "/code/{studentCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByStudentCode(@PathVariable String studentCode) throws Exception {
        log.info("Received request to fetch Student with studentCode: {}", studentCode);
        StudentDTO studentDTO = studentFacade.getByStudentCode(studentCode);
        log.info("Returning Student: code={}", studentDTO.getStudentCode());
        return ResponseEntity.ok(studentDTO);
    }

    @GetMapping(value = "/dashboard", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentDashboard(
            @RequestParam(required = false) Long campusId,
            @RequestParam(required = false) Long standardId,
            @RequestParam(required = false) Long sectionId,
            @RequestParam(required = false) String gender) {

        log.info("GET /api/institute/students/dashboard called");

        StudentDashboardDTO dashboard = studentFacade.getStudentDashboardInfo(campusId, standardId, sectionId, gender);

        log.info("Returning dashboard counts: {}", dashboard);
        return ResponseEntity.ok(dashboard);
    }
}
