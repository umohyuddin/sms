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
@Tag(name = "Designation Management", description = "Endpoints for managing organization-wide designations (tenant-level)")
public class DesignationController {

    private final DesignationFacade designationFacade;

    public DesignationController(DesignationFacade designationFacade) {
        this.designationFacade = designationFacade;
    }

    @Operation(summary = "Create a new designation", description = "Creates a new organization-scoped designation.")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Designation created successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid input", content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "409", description = "Duplicate designation code", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DesignationResponseDTO> createDesignation(@RequestBody @Valid DesignationRequestDTO requestDTO) {
        log.info("[Controller:DesignationController] createDesignation() called - designation: {}", requestDTO.getDesignationName());
        DesignationResponseDTO responseDTO = designationFacade.createDesignation(requestDTO);
        log.info("[Controller:DesignationController] createDesignation() succeeded - created ID: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Get all designations", description = "Fetches all designations for the current organization.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DesignationResponseDTO>> getAll() {
        log.info("[Controller:DesignationController] getAll() called");
        List<DesignationResponseDTO> resources = designationFacade.getAll();
        log.info("[Controller:DesignationController] getAll() succeeded - found {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @Operation(summary = "Get all active designations", description = "Fetches all active (enabled) designations for the current organization.")
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DesignationResponseDTO>> getAllActive() {
        log.info("[Controller:DesignationController] getAllActive() called");
        List<DesignationResponseDTO> resources = designationFacade.getAllActive();
        log.info("[Controller:DesignationController] getAllActive() succeeded - found {} active resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @Operation(summary = "Get designation by ID")
    @GetMapping(value = "/{designationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DesignationResponseDTO> getById(
            @Parameter(description = "ID of the designation to fetch") @PathVariable Long designationId) {
        log.info("[Controller:DesignationController] getById() called - ID: {}", designationId);
        DesignationResponseDTO resource = designationFacade.getById(designationId);
        log.info("[Controller:DesignationController] getById() succeeded - Found designation: {}", designationId);
        return ResponseEntity.ok().body(resource);
    }

    @Operation(summary = "Search designations", description = "Search for designations by name or code using a keyword.")
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DesignationResponseDTO>> getBySearch(
            @Parameter(description = "Search keyword") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:DesignationController] getBySearch() called - keyword: {}", keyword);
        List<DesignationResponseDTO> resources = designationFacade.searchByKeyword(keyword);
        log.info("[Controller:DesignationController] getBySearch() succeeded - found {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @Operation(summary = "Update an existing designation")
    @PutMapping(value = "/{designationId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DesignationResponseDTO> updateDesignation(
            @Parameter(description = "ID of the designation to update") @PathVariable Long designationId,
            @RequestBody @Valid DesignationRequestDTO requestDTO) {
        log.info("[Controller:DesignationController] updateDesignation() called - ID: {}", designationId);
        DesignationResponseDTO updated = designationFacade.updateDesignation(designationId, requestDTO);
        log.info("[Controller:DesignationController] updateDesignation() succeeded - updated ID: {}", designationId);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Delete (Soft) a designation")
    @DeleteMapping("/{designationId}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long designationId) {
        log.info("[Controller:DesignationController] delete() called - ID: {}", designationId);
        designationFacade.softDeleteById(designationId);
        log.info("[Controller:DesignationController] delete() succeeded - marked ID: {} as deleted", designationId);
        return ResponseEntity.ok(Map.of("message", "Designation deleted successfully"));
    }

    @Operation(summary = "Get employee count by designation", description = "Fetches a report of employee distribution across all designations in the organization.")
    @GetMapping(value = "/reports/staff-count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DesignationCountDTO>> getStaffCountReport() {
        log.info("[Controller:DesignationController] getStaffCountReport() called");
        List<DesignationCountDTO> resources = designationFacade.getStaffCountReport();
        log.info("[Controller:DesignationController] getStaffCountReport() succeeded - found {} entries", resources.size());
        return ResponseEntity.ok().body(resources);
    }
}
