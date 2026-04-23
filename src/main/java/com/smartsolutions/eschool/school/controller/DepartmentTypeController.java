package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.global.error.ErrorResponse;
import com.smartsolutions.eschool.school.dtos.departmentTypes.requestDto.DepartmentTypeCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.departmentTypes.response.DepartmentTypeResponseDTO;
import com.smartsolutions.eschool.school.facade.DepartmentTypeFacade;
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
@RequestMapping("/api/institute/department-types")
@Slf4j
@Tag(name = "Department Type Management", description = "Endpoints for managing department types.")
public class DepartmentTypeController {

    private final DepartmentTypeFacade departmentTypeFacade;

    public DepartmentTypeController(DepartmentTypeFacade departmentTypeFacade) {
        this.departmentTypeFacade = departmentTypeFacade;
    }

    @Operation(summary = "Get all department types", description = "Retrieve a list of all department types.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentTypeResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentTypeResponseDTO>> getAll() {
        log.info("[Controller:DepartmentTypeController] getAll() called");
        List<DepartmentTypeResponseDTO> resources = departmentTypeFacade.getAll();
        log.info("[Controller:DepartmentTypeController] getAll() succeeded - Found {} department types", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get department type by ID", description = "Fetch detailed information about a specific department type.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved department type",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentTypeResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Department type not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentTypeResponseDTO> getById(
            @Parameter(description = "ID of the department type", example = "1") @PathVariable Long id) {
        log.info("[Controller:DepartmentTypeController] getById() called - id: {}", id);
        DepartmentTypeResponseDTO responseDTO = departmentTypeFacade.getById(id);
        log.info("[Controller:DepartmentTypeController] getById() succeeded - Found department type: {}", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Search department types", description = "Find department types by keyword (name or code).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching department types",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentTypeResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DepartmentTypeResponseDTO>> search(
            @Parameter(description = "Search keyword", example = "HR") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:DepartmentTypeController] search() called - keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<DepartmentTypeResponseDTO> responseDTOs = departmentTypeFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:DepartmentTypeController] search() succeeded - Found {} matching department types", responseDTOs.size());
        return ResponseEntity.ok(responseDTOs);
    }

    @Operation(summary = "Create new department type", description = "Register a new department type.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Department type created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentTypeResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentTypeResponseDTO> create(@Valid @RequestBody DepartmentTypeCreateRequestDTO requestDTO) {
        log.info("[Controller:DepartmentTypeController] create() called - name: {}", requestDTO.getName());
        DepartmentTypeResponseDTO responseDTO = departmentTypeFacade.createDepartmentType(requestDTO);
        log.info("[Controller:DepartmentTypeController] create() succeeded - id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Update department type", description = "Update details of an existing department type.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Department type updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentTypeResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Department type not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DepartmentTypeResponseDTO> update(
            @Parameter(description = "ID of the department type", example = "1") @PathVariable Long id,
            @Valid @RequestBody DepartmentTypeCreateRequestDTO requestDTO) {
        log.info("[Controller:DepartmentTypeController] update() called - id: {}", id);
        DepartmentTypeResponseDTO responseDTO = departmentTypeFacade.updateDepartmentType(id, requestDTO);
        log.info("[Controller:DepartmentTypeController] update() succeeded - id: {}", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Delete department type", description = "Soft delete a department type.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Department type deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Department type not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(
            @Parameter(description = "ID of the department type", example = "1") @PathVariable Long id) {
        log.info("[Controller:DepartmentTypeController] delete() called - id: {}", id);
        departmentTypeFacade.softDeleteById(id);
        log.info("[Controller:DepartmentTypeController] delete() succeeded - id: {}", id);
        return ResponseEntity.ok(Map.of("message", "Department type deleted successfully"));
    }

    @Operation(summary = "Get department type statistics", description = "Retrieve statistics for department types.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:DepartmentTypeController] getStatistics() called");
        Map<String, Long> statistics = departmentTypeFacade.getStatistics();
        log.info("[Controller:DepartmentTypeController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
