package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeAddressRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeAddressResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeTypeCountDTO;
import com.smartsolutions.eschool.employee.facade.EmployeeAddressFacade;
import com.smartsolutions.eschool.employee.facade.EmployeeMasterFacade;
import com.smartsolutions.eschool.global.utils.UploadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/institute/employees")
@Slf4j
public class EmployeeMasterController {

    private final EmployeeMasterFacade employeeFacade;
    private final EmployeeAddressFacade employeeAddressFacade;

    public EmployeeMasterController(EmployeeMasterFacade employeeFacade, EmployeeAddressFacade employeeAddressFacade) {
        this.employeeFacade = employeeFacade;
        this.employeeAddressFacade = employeeAddressFacade;
    }

    @GetMapping(value = {"", "/list"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeMasterResponseDto>> getAllEmployees() {
        log.info("GET /api/institute/employees/list called");
        List<EmployeeMasterResponseDto> list = employeeFacade.getAllEmployees();
        log.info("GET /api/institute/employees/list succeeded, returned {} resources", list.size());
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeMasterResponseDto> getEmployeeById(@PathVariable Long id) {
        log.info("GET /api/institute/employees/{} called", id);
        EmployeeMasterResponseDto employee = employeeFacade.getEmployeeById(id);
        log.info("GET /api/institute/employees/{} succeeded", id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping(value = "/code/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeMasterResponseDto> getEmployeeByCode(@PathVariable String code) {
        log.info("GET /api/institute/employees/code/{} called", code);
        EmployeeMasterResponseDto employee = employeeFacade.getEmployeeByCode(code);
        log.info("GET /api/institute/employees/code/{} succeeded", code);
        return ResponseEntity.ok(employee);
    }

//    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<EmployeeMasterResponseDto>> searchByKeyword(@RequestParam String keyword_) {
//        log.info("GET /api/institute/employees/search called with keyword: '{}'", keyword_);
//        List<EmployeeMasterResponseDto> result = employeeFacade.searchByKeyword(keyword_);
//        log.info("GET /api/institute/employees/search succeeded, returned {} results", result.size());
//        return ResponseEntity.ok(result);
//    }

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


    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeMasterResponseDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeMasterRequestDto requestDto) {
        log.info("PUT /api/institute/employees/{} called to update employee: {}", id, requestDto);
        try {
            EmployeeMasterResponseDto updatedEmployee = employeeFacade.updateEmployee(id, requestDto);
            log.info("Employee updated successfully with id: {}", updatedEmployee.getId());
            return ResponseEntity.ok(updatedEmployee);
        } catch (Exception e) {
            log.error("Failed to update employee with id: {}", id, e);
            return ResponseEntity.status(500).body(null); // or you can return a custom error DTO
        }
    }


    @GetMapping(value = "/{employeeId}/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeAddressResponseDto>> getEmployeeAddresses(@PathVariable Long employeeId) {
        log.info("GET /api/institute/employees/{}/addresses called", employeeId);
        try {
            List<EmployeeAddressResponseDto> addresses = employeeAddressFacade.getEmployeeAddresses(employeeId);
            log.info("Returned {} addresses for employeeId={}", addresses.size(), employeeId);
            return ResponseEntity.ok(addresses);
        } catch (Exception e) {
            log.error("Failed to fetch addresses for employeeId={}", employeeId, e);
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/addresses/{addressId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeAddressResponseDto> getEmployeeAddressById(@PathVariable Long addressId) {
        log.info("GET /api/institute/employees/addresses/{} called", addressId);
        try {
            EmployeeAddressResponseDto address = employeeAddressFacade.getAddressById(addressId);
            if (address == null) {
                log.warn("Address not found with id={}", addressId);
                return ResponseEntity.notFound().build();
            }
            log.info("Returning address with id={}", addressId);
            return ResponseEntity.ok(address);
        } catch (Exception e) {
            log.error("Failed to fetch address with id={}", addressId, e);
            return ResponseEntity.status(500).build();
        }
    }


    @PostMapping(value = "/{employeeId}/addresses", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeAddressResponseDto> createEmployeeAddress(@PathVariable Long employeeId, @RequestBody EmployeeAddressRequestDto requestDto) {

        log.info("POST /api/institute/employees/{}/addresses called with data: {}", employeeId, requestDto);
        try {
            requestDto.setEmployeeId(employeeId); // ensure the employeeId from path is set
            EmployeeAddressResponseDto createdAddress = employeeAddressFacade.createAddress(requestDto);
            log.info("Employee address created successfully with id={}", createdAddress.getId());
            return ResponseEntity.ok(createdAddress);
        } catch (Exception e) {
            log.error("Failed to create employee address for employeeId={}", employeeId, e);
            return ResponseEntity.status(500).build();
        }
    }

    // -------------------------
// Update an existing employee address
// -------------------------
    @PutMapping(value = "/addresses/{addressId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeAddressResponseDto> updateEmployeeAddress(@PathVariable Long addressId, @RequestBody EmployeeAddressRequestDto requestDto) {

        log.info("PUT /api/institute/employees/addresses/{} called with data: {}", addressId, requestDto);
        try {
            EmployeeAddressResponseDto updatedAddress = employeeAddressFacade.updateAddress(addressId, requestDto);
            if (updatedAddress == null) {
                log.warn("Address not found with id={}", addressId);
                return ResponseEntity.notFound().build();
            }
            log.info("Employee address updated successfully with id={}", addressId);
            return ResponseEntity.ok(updatedAddress);
        } catch (Exception e) {
            log.error("Failed to update employee address with id={}", addressId, e);
            return ResponseEntity.status(500).build();
        }
    }


    @GetMapping("/count-by-type")
    public ResponseEntity<List<EmployeeTypeCountDTO>> getEmployeeCountByType() {
        return ResponseEntity.ok(employeeFacade.getEmployeeCountByType());
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeMasterResponseDto>> searchByKeyword(@RequestParam String keyword) {
        log.info("GET /api/institute/employees/search called with keyword: '{}'", keyword);
        List<EmployeeMasterResponseDto> result = employeeFacade.searchByKeyword(keyword);
        log.info("GET /api/institute/employees/search succeeded, returned {} results", result.size());
        return ResponseEntity.ok(result);
    }
}
