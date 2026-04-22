package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.departments.request.DepartmentRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentCountDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.facade.DepartmentFacade;
import com.smartsolutions.eschool.global.error.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/institute/departments")
@Slf4j
@Tag(name = "Department Management", description = "Endpoints for managing campus-level departments")
public class DepartmentController {

    private final DepartmentFacade departmentFacade;

    public DepartmentController(DepartmentFacade departmentFacade) {
        this.departmentFacade = departmentFacade;
    }

    @Operation(summary = "Create a new department", description = "Creates a new campus-scoped department.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Department created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "409", description = "Duplicate department code", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDTO> createDepartment(@RequestBody @Valid DepartmentRequestDTO requestDTO) {
        log.info("[Controller:DepartmentController] createDepartment() called - name: {}", requestDTO.getDepartmentName());
        DepartmentResponseDTO responseDTO = departmentFacade.createDepartment(requestDTO);
        log.info("[Controller:DepartmentController] createDepartment() succeeded - created ID: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Get all departments", description = "Fetches all departments for the current campus.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentResponseDTO>> getAll() {
        log.info("[Controller:DepartmentController] getAll() called");
        List<DepartmentResponseDTO> resources = departmentFacade.getAll();
        log.info("[Controller:DepartmentController] getAll() succeeded - found {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @Operation(summary = "Get all active departments", description = "Fetches all active (enabled) departments for the current campus.")
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentResponseDTO>> getAllActive() {
        log.info("[Controller:DepartmentController] getAllActive() called");
        List<DepartmentResponseDTO> resources = departmentFacade.getAllActive();
        log.info("[Controller:DepartmentController] getAllActive() succeeded - found {} active resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @Operation(summary = "Get department by ID")
    @GetMapping(value = "/{departmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDTO> getById(
            @Parameter(description = "ID of the department to fetch") @PathVariable Long departmentId) {
        log.info("[Controller:DepartmentController] getById() called - ID: {}", departmentId);
        DepartmentResponseDTO resource = departmentFacade.getById(departmentId);
        log.info("[Controller:DepartmentController] getById() succeeded - Found department: {}", departmentId);
        return ResponseEntity.ok().body(resource);
    }

    @Operation(summary = "Search departments", description = "Search for departments by name or code using a keyword.")
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentResponseDTO>> getBySearch(
            @Parameter(description = "Search keyword") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:DepartmentController] getBySearch() called - keyword: {}", keyword);
        List<DepartmentResponseDTO> resources = departmentFacade.searchByKeyword(keyword);
        log.info("[Controller:DepartmentController] getBySearch() succeeded - found {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @Operation(summary = "Update an existing department")
    @PutMapping(value = "/{departmentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDTO> updateDepartment(
            @Parameter(description = "ID of the department to update") @PathVariable Long departmentId,
            @RequestBody @Valid DepartmentRequestDTO requestDTO) {
        log.info("[Controller:DepartmentController] updateDepartment() called - ID: {}", departmentId);
        DepartmentResponseDTO updated = departmentFacade.updateDepartment(departmentId, requestDTO);
        log.info("[Controller:DepartmentController] updateDepartment() succeeded - updated ID: {}", departmentId);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Delete (Soft) a department")
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:DepartmentController] delete() called - ID: {}", id);
        departmentFacade.softDeleteById(id);
        log.info("[Controller:DepartmentController] delete() succeeded - marked ID: {} as deleted", id);
        return ResponseEntity.ok(Map.of("message", "Department deleted successfully"));
    }

    @Operation(summary = "Get employee count by department", description = "Fetches a report of employee distribution across all departments in the current campus.")
    @GetMapping(value = "/reports/staff-count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentCountDTO>> getStaffCountReport() {
        log.info("[Controller:DepartmentController] getStaffCountReport() called");
        List<DepartmentCountDTO> resources = departmentFacade.getStaffCountReport();
        log.info("[Controller:DepartmentController] getStaffCountReport() succeeded - found {} entries", resources.size());
        return ResponseEntity.ok().body(resources);
    }
}
