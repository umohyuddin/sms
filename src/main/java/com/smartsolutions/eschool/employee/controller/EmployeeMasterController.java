package com.smartsolutions.eschool.employee.controller;

import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeAddressRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeCreateRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.request.EmployeeMasterRequestDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeAddressResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeDocumentResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeMasterResponseDto;
import com.smartsolutions.eschool.employee.dtos.employeeMaster.response.EmployeeTypeCountDTO;
import com.smartsolutions.eschool.employee.facade.EmployeeAddressFacade;
import com.smartsolutions.eschool.employee.facade.EmployeeMasterFacade;
import com.smartsolutions.eschool.global.error.ErrorResponse;
import com.smartsolutions.eschool.global.utils.UploadUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/institute/employees")
@Slf4j
@Tag(name = "Employee Management", description = "Endpoints for managing institute employees, including creation, retrieval, updates, and documents.")
public class EmployeeMasterController {

    private final EmployeeMasterFacade nEmployeeMasterFacade;
    private final EmployeeAddressFacade nEmployeeAddressFacade;

    public EmployeeMasterController(EmployeeMasterFacade nEmployeeMasterFacade, EmployeeAddressFacade nEmployeeAddressFacade) {
        this.nEmployeeMasterFacade = nEmployeeMasterFacade;
        this.nEmployeeAddressFacade = nEmployeeAddressFacade;
    }

    @Operation(summary = "Get all employees", description = "Retrieve a list of all employees registered in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeMasterResponseDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = {"", "/list"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeMasterResponseDto>> getAllEmployees() {
        log.info("[Controller:EmployeeMasterController] getAllEmployees() called - Request to get all employees");
        List<EmployeeMasterResponseDto> list = nEmployeeMasterFacade.getAllEmployees();
        log.info("[Controller:EmployeeMasterController] getAllEmployees() succeeded - Found {} employees", list.size());
        return ResponseEntity.ok(list);
    }

    @Operation(summary = "Get employee by ID", description = "Fetch detailed information about a specific employee by their unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved employee",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeMasterResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeMasterResponseDto> getEmployeeById(
            @Parameter(description = "Unique ID of the employee", example = "1") @PathVariable Long id) {
        log.info("[Controller:EmployeeMasterController] getEmployeeById() called - Request to fetch employee with id: {}", id);
        EmployeeMasterResponseDto employee = nEmployeeMasterFacade.getEmployeeById(id);
        log.info("[Controller:EmployeeMasterController] getEmployeeById() succeeded - Found employee: {}", id);
        return ResponseEntity.ok(employee);
    }

    @Operation(summary = "Get employee by Code", description = "Fetch detailed information about a specific employee by their code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved employee",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeMasterResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/code/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeMasterResponseDto> getEmployeeByCode(
            @Parameter(description = "Code of the employee", example = "EMP-001") @PathVariable String code) {
        log.info("[Controller:EmployeeMasterController] getEmployeeByCode() called - Request to fetch employee with code: {}", code);
        EmployeeMasterResponseDto employee = nEmployeeMasterFacade.getEmployeeByCode(code);
        log.info("[Controller:EmployeeMasterController] getEmployeeByCode() succeeded - Found employee with code: {}", code);
        return ResponseEntity.ok(employee);
    }

    @Operation(summary = "Get inactive employees count", description = "Retrieve the total count of inactive employees.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved count"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/count/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getTotalInactiveEmployees() {
        log.info("[Controller:EmployeeMasterController] getTotalInactiveEmployees() called");
        Long count = nEmployeeMasterFacade.getTotalInactiveEmployees();
        log.info("[Controller:EmployeeMasterController] getTotalInactiveEmployees() succeeded - Count: {}", count);
        return ResponseEntity.ok(count);
    }

    @Operation(summary = "Upload profile photo", description = "Upload a profile photo for a specific employee.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Photo uploaded successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request or file missing",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(value = "/update-profile-photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadProfilePhoto(
            @Parameter(description = "Employee ID") @RequestParam("employeeId") Long employeeId, 
            @Parameter(description = "Profile photo file") @RequestPart("file") MultipartFile file) {
        log.info("[Controller:EmployeeMasterController] uploadProfilePhoto() called - employeeId: {}", employeeId);
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Profile photo is required");
        }
        String filePath = UploadUtil.saveProfilePhoto(employeeId, file);
        filePath = nEmployeeMasterFacade.updateEmployeeProfile(employeeId, filePath);
        log.info("[Controller:EmployeeMasterController] uploadProfilePhoto() succeeded - employeeId: {}", employeeId);
        return ResponseEntity.ok(Map.of("message", "Profile photo uploaded successfully", "filePath", filePath));
    }

    @Operation(summary = "Get profile photo", description = "Retrieve a profile photo by its filename.")
    @ApiResponse(responseCode = "200", description = "File retrieved successfully")
    @GetMapping("/profile-photos/{fileName:.+}")
    public ResponseEntity<Resource> getProfilePhoto(
            @Parameter(description = "File name") @PathVariable String fileName) throws IOException {
        log.info("[Controller:EmployeeMasterController] getProfilePhoto() called - fileName: {}", fileName);
        Path file = Paths.get(UploadUtil.UPLOAD_DIR, fileName);
        Resource resource = new UrlResource(file.toUri());
        if (!resource.exists()) {
            throw new FileNotFoundException("File not found: " + fileName);
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(resource);
    }

    @Operation(summary = "Upload employee document", description = "Upload a document for a specific employee with a document key.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Document uploaded successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request or file missing",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(value = "/upload-document", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> uploadEmployeeDocument(
            @Parameter(description = "Employee ID") @RequestParam("employeeId") Long employeeId, 
            @Parameter(description = "Document Key (e.g., RESUME, ID_CARD)") @RequestParam("docKey") String docKey, 
            @Parameter(description = "Document file") @RequestPart("file") MultipartFile file) throws IOException {
        log.info("[Controller:EmployeeMasterController] uploadEmployeeDocument() called - employeeId: {}, docKey: {}", employeeId, docKey);
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "File is required"));
        }
        String filePath = UploadUtil.saveEmployeeDocument(employeeId, docKey, file);
        nEmployeeMasterFacade.saveEmployeeDocument(employeeId, docKey, file);
        log.info("[Controller:EmployeeMasterController] uploadEmployeeDocument() succeeded - employeeId: {}, docKey: {}", employeeId, docKey);
        return ResponseEntity.ok(Map.of("message", "Document uploaded successfully", "filePath", filePath, "docKey", docKey));
    }

    @Operation(summary = "Get employee documents", description = "Retrieve a list of all documents associated with an employee.")
    @ApiResponse(responseCode = "200", description = "Documents retrieved successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDocumentResponseDto.class)))
    @GetMapping(value = "/{employeeId}/documents", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeDocumentResponseDto>> getEmployeeDocuments(
            @Parameter(description = "Employee ID") @PathVariable Long employeeId) {
        log.info("[Controller:EmployeeMasterController] getEmployeeDocuments() called - employeeId: {}", employeeId);
        List<EmployeeDocumentResponseDto> documents = nEmployeeMasterFacade.getEmployeeDocuments(employeeId);
        log.info("[Controller:EmployeeMasterController] getEmployeeDocuments() succeeded - Found {} documents", documents.size());
        return ResponseEntity.ok(documents);
    }

    @Operation(summary = "Download employee document", description = "Download a specific employee document by its ID.")
    @ApiResponse(responseCode = "200", description = "Document downloaded successfully")
    @GetMapping("/download-document/{documentId}")
    public ResponseEntity<Resource> downloadEmployeeDocument(
            @Parameter(description = "Document ID") @PathVariable Long documentId, 
            @Parameter(description = "Employee ID") @RequestParam("employeeId") Long employeeId) throws IOException {
        log.info("[Controller:EmployeeMasterController] downloadEmployeeDocument() called - documentId: {}, employeeId: {}", documentId, employeeId);
        Resource document = nEmployeeMasterFacade.getDocumentById(documentId, employeeId);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFilename() + "\"")
                .body(document);
    }

    @Operation(summary = "Create new employee", description = "Register a new employee with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeMasterResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeMasterResponseDto> createEmployee(@Valid @RequestBody EmployeeCreateRequestDto requestDto) {
        log.info("[Controller:EmployeeMasterController] createEmployee() called - firstName: {}", requestDto.getFirstName());
        EmployeeMasterResponseDto createdEmployee = nEmployeeMasterFacade.createEmployee(requestDto);
        log.info("[Controller:EmployeeMasterController] createEmployee() succeeded - id: {}", createdEmployee.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @Operation(summary = "Update employee", description = "Update details of an existing employee.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeMasterResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeMasterResponseDto> updateEmployee(
            @Parameter(description = "Employee ID") @PathVariable Long id, 
            @Valid @RequestBody EmployeeMasterRequestDto requestDto) {
        log.info("[Controller:EmployeeMasterController] updateEmployee() called - id: {}", id);
        EmployeeMasterResponseDto updatedEmployee = nEmployeeMasterFacade.updateEmployee(id, requestDto);
        log.info("[Controller:EmployeeMasterController] updateEmployee() succeeded - id: {}", updatedEmployee.getId());
        return ResponseEntity.ok(updatedEmployee);
    }

    @Operation(summary = "Get employee addresses", description = "Retrieve a list of addresses associated with an employee.")
    @ApiResponse(responseCode = "200", description = "Addresses retrieved successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeAddressResponseDto.class)))
    @GetMapping(value = "/{employeeId}/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeAddressResponseDto>> getEmployeeAddresses(
            @Parameter(description = "Employee ID") @PathVariable Long employeeId) {
        log.info("[Controller:EmployeeMasterController] getEmployeeAddresses() called - employeeId: {}", employeeId);
        List<EmployeeAddressResponseDto> addresses = nEmployeeAddressFacade.getEmployeeAddresses(employeeId);
        log.info("[Controller:EmployeeMasterController] getEmployeeAddresses() succeeded - Found {} addresses for employeeId: {}", addresses.size(), employeeId);
        return ResponseEntity.ok(addresses);
    }

    @Operation(summary = "Get employee address by ID", description = "Retrieve a specific address entry by its ID.")
    @ApiResponse(responseCode = "200", description = "Address retrieved successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeAddressResponseDto.class)))
    @GetMapping(value = "/addresses/{addressId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeAddressResponseDto> getEmployeeAddressById(
            @Parameter(description = "Address ID") @PathVariable Long addressId) {
        log.info("[Controller:EmployeeMasterController] getEmployeeAddressById() called - addressId: {}", addressId);
        EmployeeAddressResponseDto address = nEmployeeAddressFacade.getAddressById(addressId);
        if (address == null) {
            log.warn("[Controller:EmployeeMasterController] getEmployeeAddressById() failed - Address not found: {}", addressId);
            return ResponseEntity.notFound().build();
        }
        log.info("[Controller:EmployeeMasterController] getEmployeeAddressById() succeeded - addressId: {}", addressId);
        return ResponseEntity.ok(address);
    }

    @Operation(summary = "Create employee address", description = "Create a new address entry for an employee.")
    @ApiResponse(responseCode = "201", description = "Address created successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeAddressResponseDto.class)))
    @PostMapping(value = "/{employeeId}/addresses", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeAddressResponseDto> createEmployeeAddress(
            @Parameter(description = "Employee ID") @PathVariable Long employeeId, 
            @Valid @RequestBody EmployeeAddressRequestDto requestDto) {
        log.info("[Controller:EmployeeMasterController] createEmployeeAddress() called - employeeId: {}", employeeId);
        requestDto.setEmployeeId(employeeId);
        EmployeeAddressResponseDto createdAddress = nEmployeeAddressFacade.createAddress(requestDto);
        log.info("[Controller:EmployeeMasterController] createEmployeeAddress() succeeded - id: {}", createdAddress.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }

    @Operation(summary = "Update employee address", description = "Update an existing address entry for an employee.")
    @ApiResponse(responseCode = "200", description = "Address updated successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeAddressResponseDto.class)))
    @PutMapping(value = "/addresses/{addressId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeAddressResponseDto> updateEmployeeAddress(
            @Parameter(description = "Address ID") @PathVariable Long addressId, 
            @Valid @RequestBody EmployeeAddressRequestDto requestDto) {
        log.info("[Controller:EmployeeMasterController] updateEmployeeAddress() called - addressId: {}", addressId);
        EmployeeAddressResponseDto updatedAddress = nEmployeeAddressFacade.updateAddress(addressId, requestDto);
        if (updatedAddress == null) {
            log.warn("[Controller:EmployeeMasterController] updateEmployeeAddress() failed - Address not found: {}", addressId);
            return ResponseEntity.notFound().build();
        }
        log.info("[Controller:EmployeeMasterController] updateEmployeeAddress() succeeded - addressId: {}", addressId);
        return ResponseEntity.ok(updatedAddress);
    }

    @Operation(summary = "Get employee count by type", description = "Retrieve a statistical count of employees grouped by employment type.")
    @ApiResponse(responseCode = "200", description = "Count retrieved successfully",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeTypeCountDTO.class)))
    @GetMapping(value = "/count-by-type", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeTypeCountDTO>> getEmployeeCountByType() {
        log.info("[Controller:EmployeeMasterController] getEmployeeCountByType() called");
        List<EmployeeTypeCountDTO> countList = nEmployeeMasterFacade.getEmployeeCountByType();
        log.info("[Controller:EmployeeMasterController] getEmployeeCountByType() succeeded");
        return ResponseEntity.ok(countList);
    }

    @Operation(summary = "Search employees", description = "Find employees by a generic keyword search.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching employees",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeMasterResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Invalid search keyword",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeMasterResponseDto>> searchByKeyword(
            @Parameter(description = "Search keyword", example = "John") @RequestParam String keyword) {
        log.info("[Controller:EmployeeMasterController] searchByKeyword() called - keyword: '{}'", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<EmployeeMasterResponseDto> result = nEmployeeMasterFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:EmployeeMasterController] searchByKeyword() succeeded - Found {} results", result.size());
        return ResponseEntity.ok(result);
    }
}
