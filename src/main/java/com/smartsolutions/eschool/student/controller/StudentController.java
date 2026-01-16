package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.global.utils.UploadUtil;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentRequestDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentDashboardDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentResponseDTO;
import com.smartsolutions.eschool.student.dtos.studentDocuments.response.StudentDocumentResponseDto;
import com.smartsolutions.eschool.student.facade.StudentFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<StudentDTO> searchStudents(@RequestParam(required = false) String campusId, @RequestParam(required = false) String standardId, @RequestParam(required = false) String sectionId, @RequestParam(required = false) String studentId, @RequestParam(required = false) String academicYearId, @RequestParam(required = false) String keyword) {
        Long campus = (campusId != null && !campusId.isBlank()) ? Long.valueOf(campusId) : null;
        Long standard = (standardId != null && !standardId.isBlank()) ? Long.valueOf(standardId) : null;
        Long section = (sectionId != null && !sectionId.isBlank()) ? Long.valueOf(sectionId) : null;
        Long student = (studentId != null && !studentId.isBlank()) ? Long.valueOf(studentId) : null;
        Long academicYear = (academicYearId != null && !academicYearId.isBlank()) ? Long.valueOf(academicYearId) : null;
        String kw = (keyword != null && !keyword.isBlank()) ? keyword.trim() : null;
        List<StudentDTO> students = studentFacade.searchStudents(campus, standard, section, student, academicYear, kw);
        log.info("GET /api/students/search returned {} students", students.size());
        return students;
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
        StudentResponseDTO studentDTO = studentFacade.getById(id);
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
    public ResponseEntity<?> getStudentDashboard(@RequestParam(required = false) Long campusId, @RequestParam(required = false) Long standardId, @RequestParam(required = false) Long sectionId, @RequestParam(required = false) String gender) {

        log.info("GET /api/institute/students/dashboard called");

        StudentDashboardDTO dashboard = studentFacade.getStudentDashboardInfo(campusId, standardId, sectionId, gender);

        log.info("Returning dashboard counts: {}", dashboard);
        return ResponseEntity.ok(dashboard);
    }


//    @PostMapping(value = "/update-profile-photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> uploadProfilePhoto(@RequestParam("employeeId") Long employeeId, @RequestPart("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return ResponseEntity.badRequest().body("Profile photo is required");
//        }
//        String filePath = UploadUtil.saveProfilePhoto(employeeId, file);
//        filePath = employeeFacade.updateEmployeeProfile(employeeId, filePath);
//        return ResponseEntity.ok(Map.of("message", "Profile photo uploaded successfully", "filePath", filePath));
//    }
//
//
//    @GetMapping("/profile-photos/{fileName:.+}")
//    public ResponseEntity<Resource> getProfilePhoto(@PathVariable String fileName) throws IOException, MalformedURLException, FileNotFoundException {
//        // Optional: check if user has permission
//        Path file = Paths.get(UploadUtil.UPLOAD_DIR, fileName);
//        Resource resource = new UrlResource(file.toUri());
//        if (!resource.exists()) {
//            throw new FileNotFoundException("File not found");
//        }
//        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(resource);
//    }


    @PostMapping(value = "/upload-document", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadStudentDocument(@RequestParam("studentId") Long studentId, @RequestParam("docKey") String docKey, @RequestPart("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "File is required"));
        }
        try {
            // Save file to disk
            String filePath = UploadUtil.saveStudentDocument(studentId, docKey, file);
            // Save record in database via facade
            studentFacade.saveStudentDocument(studentId, docKey, file);
            return ResponseEntity.ok(Map.of("message", "Document uploaded successfully", "filePath", filePath, "docKey", docKey));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("message", "Failed to upload document", "error", e.getMessage()));
        }
    }

    @GetMapping(value = "/{studentId}/documents", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStudentDocuments(@PathVariable Long studentId) {
        log.info("GET /api/institute /employees/{}/documents called", studentId);
        try {
            List<StudentDocumentResponseDto> documents = studentFacade.getSaveDocuments(studentId);
            if (documents.isEmpty()) {
                log.warn("No documents found for Employee with id: {}", studentId);
            } else {
                log.info("Returned {} documents for Employee with id: {}", documents.size(), studentId);
            }
            return ResponseEntity.ok(documents);
        } catch (Exception e) {
            log.error("Error fetching documents for Employee with id: {}", studentId, e);
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/download-document/{documentId}")
    public ResponseEntity<Resource> downloadStudentDocument(@PathVariable Long documentId, @RequestParam("studentId") Long studentId) throws IOException {
        Resource document = studentFacade.getDocumentById(documentId, studentId);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFilename() + "\"").body(document);
    }


    @PutMapping(value = "/{studentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateStudent(@PathVariable Long studentId, @RequestBody StudentRequestDTO studentRequestDTO) {

        log.info("POST /api/institute/students/{} called to update student", studentId);

        try {
            StudentResponseDTO updatedStudent = studentFacade.updateStudent(studentId, studentRequestDTO);
            log.info("Student updated successfully with id: {}", updatedStudent.getId());
            return ResponseEntity.ok(updatedStudent);
        } catch (Exception e) {
            log.error("Failed to update student with id: {}", studentId, e);
            return ResponseEntity.status(500).body(Map.of("message", "Failed to update student", "error", e.getMessage()));
        }
    }


}
