package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.global.utils.UploadUtil;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentBasicInfoUpdateDTO;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentRequestDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentDashboardDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentResponseDTO;
import com.smartsolutions.eschool.student.dtos.studentDocuments.response.StudentDocumentResponseDto;
import com.smartsolutions.eschool.student.facade.StudentFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/institute/students")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    private final StudentFacade studentFacade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getAll() {
        log.info("[Controller:StudentController] GET /api/institute/students - Fetching all students");
        List<StudentDTO> resources = studentFacade.getAll();
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getActive() {
        log.info("[Controller:StudentController] GET /api/institute/students/active - Fetching active students");
        List<StudentDTO> resources = studentFacade.getActive();
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getInactive() {
        log.info("[Controller:StudentController] GET /api/institute/students/inactive - Fetching inactive students");
        List<StudentDTO> resources = studentFacade.getInactive();
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:StudentController] GET /api/institute/students/{} - Fetching by ID", id);
        StudentResponseDTO studentDTO = studentFacade.getById(id);
        return ResponseEntity.ok(studentDTO);
    }

    @GetMapping(value = "/code/{studentCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> getByStudentCode(@PathVariable String studentCode) {
        log.info("[Controller:StudentController] GET /api/institute/students/code/{} - Fetching by Code", studentCode);
        StudentDTO studentDTO = studentFacade.getByStudentCode(studentCode);
        return ResponseEntity.ok(studentDTO);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponseDTO> create(@Valid @RequestBody StudentRequestDTO requestDTO) {
        log.info("[Controller:StudentController] POST /api/institute/students - Creating student");
        StudentResponseDTO createdStudent = studentFacade.createStudent(requestDTO);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponseDTO> update(@PathVariable Long id, @Valid @RequestBody StudentRequestDTO requestDTO) {
        log.info("[Controller:StudentController] PUT /api/institute/students/{} - Updating student", id);
        StudentResponseDTO updatedStudent = studentFacade.updateStudent(id, requestDTO);
        return ResponseEntity.ok(updatedStudent);
    }

    @PatchMapping(value = "/{id}/basic-info", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponseDTO> updateBasicInfo(@PathVariable Long id, @Valid @RequestBody StudentBasicInfoUpdateDTO basicInfoDTO) {
        log.info("[Controller:StudentController] PATCH /api/institute/students/{}/basic-info - Updating basic info", id);
        StudentResponseDTO updatedStudent = studentFacade.updateStudentBasicInfo(id, basicInfoDTO);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> softDelete(@PathVariable Long id) {
        log.info("[Controller:StudentController] DELETE /api/institute/students/{} - Soft deleting student", id);
        studentFacade.softDeleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> searchStudents(
            @RequestParam(required = false) Long campusId,
            @RequestParam(required = false) Long standardId,
            @RequestParam(required = false) Long sectionId,
            @RequestParam(required = false) Long studentId,
            @RequestParam(required = false) Long academicYearId,
            @RequestParam(required = false) String keyword) {
        log.info("[Controller:StudentController] GET /api/institute/students/search - Searching with keyword: {}", keyword);
        String kw = (keyword != null && !keyword.isBlank()) ? keyword.trim() : null;
        List<StudentDTO> students = studentFacade.searchStudents(campusId, standardId, sectionId, studentId, academicYearId, kw);
        return ResponseEntity.ok(students);
    }

    @GetMapping(value = "/campus/{campusId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getStudentsByCampus(@PathVariable Long campusId) {
        log.info("[Controller:StudentController] GET /api/institute/students/campus/{} - Fetching by Campus", campusId);
        List<StudentDTO> resources = studentFacade.getStudentsByCampus(campusId);
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/standard/{standardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getStudentsByStandard(@PathVariable Long standardId) {
        log.info("[Controller:StudentController] GET /api/institute/students/standard/{} - Fetching by Standard", standardId);
        List<StudentDTO> resources = studentFacade.getStudentsByStandard(standardId);
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/section/{sectionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getStudentsBySection(@PathVariable Long sectionId) {
        log.info("[Controller:StudentController] GET /api/institute/students/section/{} - Fetching by Section", sectionId);
        List<StudentDTO> resources = studentFacade.getStudentsBySection(sectionId);
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/dashboard", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDashboardDTO> getStudentDashboard(
            @RequestParam(required = false) Long campusId,
            @RequestParam(required = false) Long standardId,
            @RequestParam(required = false) Long sectionId,
            @RequestParam(required = false) String gender) {
        log.info("[Controller:StudentController] GET /api/institute/students/dashboard - Fetching statistics");
        StudentDashboardDTO dashboard = studentFacade.getStudentDashboardInfo(campusId, standardId, sectionId, gender);
        return ResponseEntity.ok(dashboard);
    }

    @PostMapping(value = "/upload-document", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadStudentDocument(
            @RequestParam("studentId") Long studentId,
            @RequestParam("docKey") String docKey,
            @RequestPart("file") MultipartFile file) {
        log.info("[Controller:StudentController] POST /api/institute/students/upload-document - Uploading for student: {}", studentId);
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "File is required"));
        }
        try {
            studentFacade.saveStudentDocument(studentId, docKey, file);
            return ResponseEntity.ok(Map.of("message", "Document uploaded successfully", "docKey", docKey));
        } catch (Exception e) {
            log.error("[Controller:StudentController] Failed to upload document", e);
            return ResponseEntity.status(500).body(Map.of("message", "Failed to upload document", "error", e.getMessage()));
        }
    }

    @GetMapping(value = "/{studentId}/documents", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDocumentResponseDto>> getStudentDocuments(@PathVariable Long studentId) {
        log.info("[Controller:StudentController] GET /api/institute/students/{}/documents - Fetching documents", studentId);
        List<StudentDocumentResponseDto> documents = studentFacade.getSaveDocuments(studentId);
        return ResponseEntity.ok(documents);
    }

    @GetMapping("/download-document/{documentId}")
    public ResponseEntity<Resource> downloadStudentDocument(
            @PathVariable Long documentId,
            @RequestParam("studentId") Long studentId) throws IOException {
        log.info("[Controller:StudentController] GET /api/institute/students/download-document/{} - Downloading", documentId);
        Resource document = studentFacade.getDocumentById(documentId, studentId);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFilename() + "\"")
                .body(document);
    }
}
