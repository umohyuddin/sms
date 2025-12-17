package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.facade.EmployeeMasterFacade;
import com.smartsolutions.eschool.global.utils.UploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/institute/employees")
@Slf4j
public class EmployeeMasterController {
    @Autowired
    private EmployeeMasterFacade employeeFacade;

    // -------------------------
    // Get all employees
    // -------------------------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeMasterResponseDto>> getAllEmployees() {
        log.info("GET /api/institute/employees called");
        List<EmployeeMasterResponseDto> employees = employeeFacade.getAllEmployees();
        log.info("GET /api/institute/employees returned {} employees", employees.size());
        return ResponseEntity.ok(employees);
    }

    // -------------------------
    // Get employee by ID
    // -------------------------
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeMasterResponseDto> getEmployeeById(@PathVariable Long id) {
        log.info("GET /api/institute/employees/{} called", id);
        EmployeeMasterResponseDto employee = employeeFacade.getEmployeeById(id);
        log.info("Returning Employee: id={}", employee.getId());
        return ResponseEntity.ok(employee);
    }

    // -------------------------
    // Get employee by code
    // -------------------------
    @GetMapping(value = "/code/{employeeCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeMasterResponseDto> getEmployeeByCode(@PathVariable String employeeCode) {
        log.info("GET /api/institute/employees/code/{} called", employeeCode);
        EmployeeMasterResponseDto employee = employeeFacade.getEmployeeByCode(employeeCode);
        log.info("Returning Employee: code={}", employee.getEmployeeCode());
        return ResponseEntity.ok(employee);
    }

    // -------------------------
    // Search employees by name
    // -------------------------
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeMasterResponseDto>> searchEmployees(@RequestParam String name) {
        log.info("GET /api/institute/employees/search called with name={}", name);
        List<EmployeeMasterResponseDto> employees = employeeFacade.searchEmployeesByName(name);
        log.info("Returned {} employees matching name={}", employees.size(), name);
        return ResponseEntity.ok(employees);
    }

    // -------------------------
    // Filter employees by gender
    // -------------------------
    @GetMapping(value = "/gender/{gender}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeMasterResponseDto>> getEmployeesByGender(@PathVariable String gender) {
        log.info("GET /api/institute/employees/gender/{} called", gender);
        List<EmployeeMasterResponseDto> employees = employeeFacade.getEmployeesByGender(gender);
        log.info("Returned {} employees for gender={}", employees.size(), gender);
        return ResponseEntity.ok(employees);
    }

    // -------------------------
    // Filter employees by active status
    // -------------------------
    @GetMapping(value = "/active/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeMasterResponseDto>> getEmployeesByActiveStatus(@PathVariable Boolean status) {
        log.info("GET /api/institute/employees/active/{} called", status);
        List<EmployeeMasterResponseDto> employees = employeeFacade.getEmployeesByActiveStatus(status);
        log.info("Returned {} employees for active status={}", employees.size(), status);
        return ResponseEntity.ok(employees);
    }

    // -------------------------
    // Filter employees by probation end date
    // -------------------------
    @GetMapping(value = "/probation-before", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeMasterResponseDto>> getEmployeesWithProbationEndedBefore(@RequestParam Date date) {
        log.info("GET /api/institute/employees/probation-before called with date={}", date);
        List<EmployeeMasterResponseDto> employees = employeeFacade.getEmployeesWithProbationEndedBefore(date);
        log.info("Returned {} employees with probation ended before {}", employees.size(), date);
        return ResponseEntity.ok(employees);
    }

    // -------------------------
    // Create a new employee
    // -------------------------
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeMasterResponseDto> createEmployee(@RequestBody EmployeeMasterRequestDto requestDto) {
        log.info("POST /api/institute/employees called to create new employee: {}", requestDto);
        EmployeeMasterResponseDto createdEmployee = employeeFacade.createEmployee(requestDto);
        log.info("Employee created successfully with id: {}", createdEmployee.getId());
        return ResponseEntity.ok(createdEmployee);
    }

    // -------------------------
    // Metrics
    // -------------------------
    @GetMapping(value = "/count/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getTotalEmployees() {
        log.info("GET /api/institute/employees/count/all called");
        return ResponseEntity.ok(employeeFacade.getTotalEmployees());
    }

    @GetMapping(value = "/count/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getTotalActiveEmployees() {
        log.info("GET /api/institute/employees/count/active called");
        return ResponseEntity.ok(employeeFacade.getTotalActiveEmployees());
    }

    @GetMapping(value = "/count/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getTotalInactiveEmployees() {
        log.info("GET /api/institute/employees/count/inactive called");
        return ResponseEntity.ok(employeeFacade.getTotalInactiveEmployees());
    }


    @PostMapping(value = "/update-profile-photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadProfilePhoto(@RequestParam("employeeId") Long employeeId, @RequestPart("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Profile photo is required");
        }
        String filePath = UploadUtil.saveProfilePhoto(employeeId, file);
        filePath = employeeFacade.updateEmployeeProfile(employeeId, filePath);
        return ResponseEntity.ok(Map.of("message", "Profile photo uploaded successfully", "filePath", filePath));
    }


    @GetMapping("/profile-photos/{fileName:.+}")
    public ResponseEntity<Resource> getProfilePhoto(@PathVariable String fileName) throws IOException, MalformedURLException, FileNotFoundException {
        // Optional: check if user has permission
        Path file = Paths.get(UploadUtil.UPLOAD_DIR, fileName);
        Resource resource = new UrlResource(file.toUri());
        if (!resource.exists()) {
            throw new FileNotFoundException("File not found");
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(resource);
    }


    @PostMapping(value = "/upload-document", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadEmployeeDocument(@RequestParam("employeeId") Long employeeId, @RequestParam("docKey") String docKey, @RequestPart("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "File is required"));
        }
        try {
            // Save file to disk
            String filePath = UploadUtil.saveEmployeeDocument(employeeId, docKey, file);
            // Save record in database via facade
            employeeFacade.saveEmployeeDocument(employeeId, docKey, file);
            return ResponseEntity.ok(Map.of("message", "Document uploaded successfully", "filePath", filePath, "docKey", docKey));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("message", "Failed to upload document", "error", e.getMessage()));
        }
    }

    @GetMapping(value = "/{employeeId}/documents", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEmployeeDocuments(@PathVariable Long employeeId) {
        log.info("GET /api/institute /employees/{}/documents called", employeeId);
        try {
            List<EmployeeDocumentResponseDto> documents = employeeFacade.getEmployeeDocuments(employeeId);
            if (documents.isEmpty()) {
                log.warn("No documents found for Employee with id: {}", employeeId);
            } else {
                log.info("Returned {} documents for Employee with id: {}", documents.size(), employeeId);
            }
            return ResponseEntity.ok(documents);
        } catch (Exception e) {
            log.error("Error fetching documents for Employee with id: {}", employeeId, e);
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/download-document/{documentId}")
    public ResponseEntity<Resource> downloadEmployeeDocument(@PathVariable Long documentId, @RequestParam("employeeId") Long employeeId) throws IOException {
        Resource document = employeeFacade.getDocumentById(documentId, employeeId);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFilename() + "\"").body(document);
    }


}