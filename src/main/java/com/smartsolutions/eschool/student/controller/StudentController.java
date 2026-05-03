package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.global.utils.UploadUtil;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentBasicInfoUpdateDTO;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentRequestDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentDashboardDTO;
import com.smartsolutions.eschool.student.dtos.student.responseDto.StudentResponseDTO;
import com.smartsolutions.eschool.student.dtos.studentDocuments.response.StudentDocumentResponseDto;
import com.smartsolutions.eschool.student.dtos.student.requestDto.StudentSearchRequestDTO;
import com.smartsolutions.eschool.student.facade.StudentFacade;
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
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.smartsolutions.eschool.global.error.ErrorResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/institute/students")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Student Management", description = "Comprehensive endpoints for managing student profiles, document uploads, and academic lookups.")
public class StudentController {

    private final StudentFacade studentFacade;

    @Operation(summary = "Get all students", description = "Retrieve a full list of all students in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getAll() {
        log.info("[Controller:StudentController] GET /api/institute/students - Fetching all students");
        List<StudentDTO> resources = studentFacade.getAll();
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get active students", description = "Retrieve a list of all currently active students.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved active students",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getActive() {
        log.info("[Controller:StudentController] GET /api/institute/students/active - Fetching active students");
        List<StudentDTO> resources = studentFacade.getActive();
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get inactive students", description = "Retrieve a list of all currently inactive (withdrawn/deleted) students.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved inactive students",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> getInactive() {
        log.info("[Controller:StudentController] GET /api/institute/students/inactive - Fetching inactive students");
        List<StudentDTO> resources = studentFacade.getInactive();
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get student by ID", description = "Fetch detailed profile of a specific student by their unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved student profile",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponseDTO> getById(
            @Parameter(description = "ID of the student", example = "1") @PathVariable Long id) {
        log.info("[Controller:StudentController] GET /api/institute/students/{} - Fetching by ID", id);
        StudentResponseDTO studentDTO = studentFacade.getById(id);
        return ResponseEntity.ok(studentDTO);
    }

    @Operation(summary = "Get student by code", description = "Fetch student profile using their unique student code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved student",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentDTO.class))),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/code/{studentCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDTO> getByStudentCode(
            @Parameter(description = "Unique admission code of the student", example = "STU-2024-001") @PathVariable String studentCode) {
        log.info("[Controller:StudentController] GET /api/institute/students/code/{} - Fetching by Code", studentCode);
        StudentDTO studentDTO = studentFacade.getByStudentCode(studentCode);
        return ResponseEntity.ok(studentDTO);
    }

    @Operation(summary = "Create new student", description = "Register a new student in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponseDTO> create(@Valid @RequestBody StudentRequestDTO requestDTO) {
        log.info("[Controller:StudentController] POST /api/institute/students - Creating student");
        StudentResponseDTO createdStudent = studentFacade.createStudent(requestDTO);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @Operation(summary = "Update student", description = "Update full profile details of an existing student.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponseDTO> update(
            @Parameter(description = "ID of the student to update", example = "1") @PathVariable Long id,
            @Valid @RequestBody StudentRequestDTO requestDTO) {
        log.info("[Controller:StudentController] PUT /api/institute/students/{} - Updating student", id);
        StudentResponseDTO updatedStudent = studentFacade.updateStudent(id, requestDTO);
        return ResponseEntity.ok(updatedStudent);
    }

    @Operation(summary = "Update student basic info", description = "Update only the basic personal info of a student (Patch update).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Basic info updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PatchMapping(value = "/{id}/basic-info", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentResponseDTO> updateBasicInfo(
            @Parameter(description = "ID of the student", example = "5001") @PathVariable Long id,
            @Valid @RequestBody StudentBasicInfoUpdateDTO basicInfoDTO) {
        log.info("[Controller:StudentController] PATCH /api/institute/students/{}/basic-info - Updating basic info", id);
        StudentResponseDTO updatedStudent = studentFacade.updateStudentBasicInfo(id, basicInfoDTO);
        return ResponseEntity.ok(updatedStudent);
    }

    @Operation(summary = "Delete student", description = "Soft delete a student record from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> softDelete(
            @Parameter(description = "ID of the student to delete", example = "5001") @PathVariable Long id) {
        log.info("[Controller:StudentController] DELETE /api/institute/students/{} - Soft deleting student", id);
        studentFacade.softDeleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Search students (Generic)", description = "Filter students by campus, standard, section, academic year, status (active/inactive), or keyword.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved search results",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDTO>> searchStudents(
            @org.springdoc.core.annotations.ParameterObject StudentSearchRequestDTO searchRequest) {
        log.info("[Controller:StudentController] GET /api/institute/students/search - Params: {}", searchRequest);
        List<StudentDTO> students = studentFacade.searchStudents(searchRequest);
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



    //no need of this
    @Operation(summary = "Get dashboard statistics", description = "Retrieve high-level statistics for students based on filters.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved dashboard data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StudentDashboardDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/dashboard", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDashboardDTO> getStudentDashboard(
            @Parameter(description = "ID of the campus", example = "1") @RequestParam(required = false) Long campusId,
            @Parameter(description = "ID of the academic standard", example = "5") @RequestParam(required = false) Long standardId,
            @Parameter(description = "ID of the section", example = "1") @RequestParam(required = false) Long sectionId,
            @Parameter(description = "Filter by gender", example = "Male") @RequestParam(required = false) String gender) {
        log.info("[Controller:StudentController] GET /api/institute/students/dashboard - Fetching statistics");
        StudentDashboardDTO dashboard = studentFacade.getStudentDashboardInfo(campusId, standardId, sectionId, gender);
        return ResponseEntity.ok(dashboard);
    }

    @Operation(summary = "Upload student document", description = "Upload a document (PDF/Image) for a specific student.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Document uploaded successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid file or parameters",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(value = "/upload-document", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadStudentDocument(
            @Parameter(description = "ID of the student", example = "1") @RequestParam("studentId") Long studentId,
            @Parameter(description = "Document type key", example = "ADMISSION_FORM") @RequestParam("docKey") String docKey,
            @Parameter(description = "File to upload") @RequestPart("file") MultipartFile file) {
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

    @Operation(summary = "Get student documents", description = "List all uploaded documents for a specific student.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List retrieved successfully",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StudentDocumentResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{studentId}/documents", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StudentDocumentResponseDto>> getStudentDocuments(
            @Parameter(description = "ID of the student", example = "5001") @PathVariable Long studentId) {
        log.info("[Controller:StudentController] GET /api/institute/students/{}/documents - Fetching documents", studentId);
        List<StudentDocumentResponseDto> documents = studentFacade.getSaveDocuments(studentId);
        return ResponseEntity.ok(documents);
    }

    @Operation(summary = "Download document", description = "Download a specific student document by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Download started"),
            @ApiResponse(responseCode = "404", description = "Document or Student not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/download-document/{documentId}")
    public ResponseEntity<Resource> downloadStudentDocument(
            @Parameter(description = "ID of the document record", example = "100") @PathVariable Long documentId,
            @Parameter(description = "ID of the student owner", example = "5001") @RequestParam("studentId") Long studentId) throws IOException {
        log.info("[Controller:StudentController] GET /api/institute/students/download-document/{} - Downloading", documentId);
        Resource document = studentFacade.getDocumentById(documentId, studentId);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFilename() + "\"")
                .body(document);
    }
}
