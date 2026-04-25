package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.global.error.ErrorResponse;
import com.smartsolutions.eschool.school.dtos.departments.requestDto.DepartmentCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.departments.response.DepartmentResponseDTO;
import com.smartsolutions.eschool.school.facade.DepartmentFacade;
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
@Tag(name = "Department Management", description = "Endpoints for managing departments, including specialized filtering and statistics.")
public class DepartmentController {

    private final DepartmentFacade nDepartmentFacade;

    public DepartmentController(DepartmentFacade nDepartmentFacade) {
        this.nDepartmentFacade = nDepartmentFacade;
    }

    @Operation(summary = "Get all departments", description = "Retrieve a list of all departments registered in the system, with optional campus filtering.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentResponseDTO>> getAll(
            @Parameter(description = "Optional campus ID filter", example = "1") @RequestParam(name = "campusId", required = false) Long campusId) {
        log.info("[Controller:DepartmentController] getAll() called - Request to get all departments, campusId: {}", campusId);
        List<DepartmentResponseDTO> resources;
        if (campusId != null) {
            resources = nDepartmentFacade.getByCampusId(campusId);
        } else {
            resources = nDepartmentFacade.getAll();
        }
        log.info("[Controller:DepartmentController] getAll() succeeded - Found {} departments", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get department by ID", description = "Fetch detailed information about a specific department by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved department",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Department not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDTO> getById(
            @Parameter(description = "Unique ID of the department", example = "1") @PathVariable Long id) {
        log.info("[Controller:DepartmentController] getById() called - Request to fetch department with id: {}", id);
        DepartmentResponseDTO department = nDepartmentFacade.getById(id);
        log.info("[Controller:DepartmentController] getById() succeeded - Found department: {}", id);
        return ResponseEntity.ok(department);
    }

    @Operation(summary = "Search departments", description = "Find departments by keyword matching name or code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching departments",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid search keyword",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentResponseDTO>> search(
            @Parameter(description = "Search keyword (name or code)", example = "Academic") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:DepartmentController] search() called - Request to search departments with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<DepartmentResponseDTO> responseDTOs = nDepartmentFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:DepartmentController] search() succeeded - Found {} matching departments", responseDTOs.size());
        return ResponseEntity.ok(responseDTOs);
    }

    @Operation(summary = "Create new department", description = "Register a new department with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Department created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDTO> create(@Valid @RequestBody DepartmentCreateRequestDTO requestDTO) {
        log.info("[Controller:DepartmentController] create() called - Request to create department: {}", requestDTO.getDepartmentName());
        DepartmentResponseDTO responseDTO = nDepartmentFacade.createDepartment(requestDTO);
        log.info("[Controller:DepartmentController] create() succeeded - Department created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Update department", description = "Update details of an existing department.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Department updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Department not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentResponseDTO> update(
            @Parameter(description = "ID of the department to update", example = "1") @PathVariable Long id,
            @Valid @RequestBody DepartmentCreateRequestDTO requestDTO) {
        log.info("[Controller:DepartmentController] update() called - Request to update department: {}", id);
        DepartmentResponseDTO responseDTO = nDepartmentFacade.updateDepartment(id, requestDTO);
        log.info("[Controller:DepartmentController] update() succeeded - Department: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Delete department", description = "Soft delete a department from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Department deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Department not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(
            @Parameter(description = "ID of the department to delete", example = "1") @PathVariable Long id) {
        log.info("[Controller:DepartmentController] delete() called - Request to delete department: {}", id);
        nDepartmentFacade.softDeleteById(id);
        log.info("[Controller:DepartmentController] delete() succeeded - Department: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Department deleted successfully"));
    }

    @Operation(summary = "Get department statistics", description = "Retrieve statistical data overview for departments.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:DepartmentController] getStatistics() called");
        Map<String, Long> statistics = nDepartmentFacade.getStatistics();
        log.info("[Controller:DepartmentController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
