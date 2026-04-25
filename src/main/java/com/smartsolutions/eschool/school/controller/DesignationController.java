package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.designations.request.DesignationRequestDTO;
import com.smartsolutions.eschool.school.dtos.designations.response.DesignationCountDTO;
import com.smartsolutions.eschool.school.dtos.designations.response.DesignationResponseDTO;
import com.smartsolutions.eschool.school.facade.DesignationFacade;
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
@RequestMapping("/api/institute/designations")
@Slf4j
@Tag(name = "Designation Management", description = "Endpoints for managing organization-wide designations, including creation, retrieval, and updates.")
public class DesignationController {

    private final DesignationFacade nDesignationFacade;

    public DesignationController(DesignationFacade nDesignationFacade) {
        this.nDesignationFacade = nDesignationFacade;
    }

    @Operation(summary = "Create a new designation", description = "Registers a new organization-scoped designation with the provided details.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Designation created successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = DesignationResponseDTO.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "409", description = "Duplicate designation code", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DesignationResponseDTO> createDesignation(@RequestBody @Valid DesignationRequestDTO requestDTO) {
        log.info("[Controller:DesignationController] createDesignation() called - Request to create designation: {}", requestDTO.getDesignationName());
        DesignationResponseDTO responseDTO = nDesignationFacade.createDesignation(requestDTO);
        log.info("[Controller:DesignationController] createDesignation() succeeded - Designation created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Get all designations", description = "Fetches a list of all designations for the current organization.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = DesignationResponseDTO.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DesignationResponseDTO>> getAll() {
        log.info("[Controller:DesignationController] getAll() called - Request to get all designations");
        List<DesignationResponseDTO> resources = nDesignationFacade.getAll();
        log.info("[Controller:DesignationController] getAll() succeeded - Found {} designations", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @Operation(summary = "Get all active designations", description = "Fetches all active (enabled) designations for the current organization.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully retrieved active designations"),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DesignationResponseDTO>> getAllActive() {
        log.info("[Controller:DesignationController] getAllActive() called - Request to get all active designations");
        List<DesignationResponseDTO> resources = nDesignationFacade.getAllActive();
        log.info("[Controller:DesignationController] getAllActive() succeeded - Found {} active designations", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @Operation(summary = "Get designation by ID", description = "Fetch detailed information about a specific designation by its unique ID.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully retrieved designation",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = DesignationResponseDTO.class))),
        @ApiResponse(responseCode = "404", description = "Designation not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{designationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DesignationResponseDTO> getById(
            @Parameter(description = "Unique ID of the designation to fetch", example = "1") @PathVariable Long designationId) {
        log.info("[Controller:DesignationController] getById() called - Request to fetch designation with id: {}", designationId);
        DesignationResponseDTO resource = nDesignationFacade.getById(designationId);
        log.info("[Controller:DesignationController] getById() succeeded - Found designation: {}", designationId);
        return ResponseEntity.ok().body(resource);
    }

    @Operation(summary = "Search designations", description = "Find designations by keyword matching name or code.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully retrieved matching designations"),
        @ApiResponse(responseCode = "400", description = "Invalid search keyword", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DesignationResponseDTO>> getBySearch(
            @Parameter(description = "Search keyword (name or code)", example = "Manager") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:DesignationController] getBySearch() called - Request to search designations with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<DesignationResponseDTO> resources = nDesignationFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:DesignationController] getBySearch() succeeded - Found {} designations matching keyword: {}", resources.size(), keyword);
        return ResponseEntity.ok().body(resources);
    }

    @Operation(summary = "Update an existing designation", description = "Update details of an existing organization-scoped designation.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Designation updated successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "404", description = "Designation not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{designationId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DesignationResponseDTO> updateDesignation(
            @Parameter(description = "ID of the designation to update", example = "1") @PathVariable Long designationId,
            @RequestBody @Valid DesignationRequestDTO requestDTO) {
        log.info("[Controller:DesignationController] updateDesignation() called - Request to update designation: {}", designationId);
        DesignationResponseDTO updated = nDesignationFacade.updateDesignation(designationId, requestDTO);
        log.info("[Controller:DesignationController] updateDesignation() succeeded - Designation: {} updated successfully", designationId);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Delete (Soft) a designation", description = "Soft delete a designation from the system.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Designation deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Designation not found", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{designationId}")
    public ResponseEntity<Map<String, String>> delete(
            @Parameter(description = "ID of the designation to delete", example = "1") @PathVariable Long designationId) {
        log.info("[Controller:DesignationController] delete() called - Request to delete designation: {}", designationId);
        nDesignationFacade.softDeleteById(designationId);
        log.info("[Controller:DesignationController] delete() succeeded - Designation: {} deleted successfully", designationId);
        return ResponseEntity.ok(Map.of("message", "Designation deleted successfully"));
    }

    @Operation(summary = "Get employee count by designation", description = "Fetches a report of employee distribution across all designations in the organization.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Successfully retrieved report"),
        @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/reports/staff-count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DesignationCountDTO>> getStaffCountReport() {
        log.info("[Controller:DesignationController] getStaffCountReport() called");
        List<DesignationCountDTO> resources = nDesignationFacade.getStaffCountReport();
        log.info("[Controller:DesignationController] getStaffCountReport() succeeded - Found {} entries", resources.size());
        return ResponseEntity.ok().body(resources);
    }
}
