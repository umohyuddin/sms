package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.departments.request.DepartmentRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.facade.DepartmentFacade;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Departments in the institute.
 * Provides endpoints for operations on Department entities.
 */
@RequestMapping("/api/institute/departments")
@Slf4j
@RestController
public class DepartmentController {

    private final DepartmentFacade departmentFacade;

    public DepartmentController(DepartmentFacade departmentFacade) {
        this.departmentFacade = departmentFacade;
    }

    @Operation(summary = "Create Department", description = "Creates a new department in the institute")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createDepartment(@RequestBody @Valid DepartmentRequestDTO requestDTO) {
        log.info("POST /api/institute/departments called for department: {}", requestDTO.getDepartmentName());
        DepartmentResponseDTO responseDTO = departmentFacade.createDepartment(requestDTO);
        log.info("POST /api/institute/departments succeeded, created department with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Get all Departments", description = "Returns a list of all departments")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllDepartments() {
        log.info("GET /api/institute/departments called");
        List<DepartmentResponseDTO> departments = departmentFacade.getAll();
        log.info("GET /api/institute/departments succeeded, returned {} resources", departments.size());
        return ResponseEntity.ok(departments);
    }

    @Operation(summary = "Get active Departments", description = "Returns a list of all active departments")
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllActiveDepartments() {
        log.info("GET /api/institute/departments/active called");
        List<DepartmentResponseDTO> departments = departmentFacade.getAllActive();
        log.info("GET /api/institute/departments/active succeeded, returned {} resources", departments.size());
        return ResponseEntity.ok(departments);
    }

    @Operation(summary = "Get Department by ID", description = "Fetches department details by its ID")
    @GetMapping(value = "/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getDepartmentById(@PathVariable Long departmentId) {
        log.info("GET /api/institute/departments/{} called", departmentId);
        DepartmentResponseDTO department = departmentFacade.getById(departmentId);
        log.info("GET /api/institute/departments/{} succeeded", departmentId);
        return ResponseEntity.ok(department);
    }

    @Operation(summary = "Update Department", description = "Updates an existing department by ID")
    @PutMapping(value = "/{departmentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateDepartment(@PathVariable Long departmentId, @RequestBody @Valid DepartmentRequestDTO requestDTO) {
        log.info("PUT /api/institute/departments/{} called", departmentId);
        DepartmentResponseDTO updated = departmentFacade.updateDepartment(departmentId, requestDTO);
        log.info("PUT /api/institute/departments/{} succeeded", departmentId);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Delete Department", description = "Soft deletes a department by its ID")
    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long departmentId) {
        log.info("DELETE /api/institute/departments/{} called", departmentId);
        departmentFacade.deleteById(departmentId);
        log.info("DELETE /api/institute/departments/{} succeeded", departmentId);
        return ResponseEntity.ok("Department deleted successfully");
    }

    @Operation(summary = "Search Departments", description = "Search departments by name, code, or head employee")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Departments found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentResponseDTO.class))), @ApiResponse(responseCode = "400", description = "Invalid search keyword")})
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentResponseDTO>> searchDepartments(@RequestParam(name = "keyword") String keyword) {
        log.info("GET /api/institute/departments/search called with keyword: {}", keyword);
        List<DepartmentResponseDTO> results = departmentFacade.searchDepartments(keyword);
        log.info("GET /api/institute/departments/search succeeded, returned {} resources", results.size());
        return ResponseEntity.ok(results);
    }
}
