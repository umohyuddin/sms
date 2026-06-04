package com.smartsolutions.eschool.sclass.controller;

import com.smartsolutions.eschool.global.error.ErrorResponse;
import com.smartsolutions.eschool.sclass.dtos.requestDto.StandardCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.facade.StandardFacade;
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
@RequestMapping("/api/institute/campuses-standards")
@Slf4j
@Tag(name = "Standard Management", description = "Endpoints for managing campus standards (grades/classes), including creation, retrieval, and updates.")
public class StandardController {

    private final StandardFacade standardFacade;

    public StandardController(StandardFacade standardFacade) {
        this.standardFacade = standardFacade;
    }

    @Operation(summary = "Get all standards", description = "Retrieve all standards for the current institute.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandardDTO.class))),
            @ApiResponse(responseCode = "403", description = "Organization access denied",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StandardDTO>> getAll() {
        log.info("[Controller:StandardController] getAll() called - Request to get all standards");
        List<StandardDTO> resources = standardFacade.getAll();
        log.info("[Controller:StandardController] getAll() succeeded - Found {} standards", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get standard by ID", description = "Fetch detailed information about a specific standard.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved standard",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandardDTO.class))),
            @ApiResponse(responseCode = "404", description = "Standard not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardDTO> getById(
            @Parameter(description = "Unique ID of the standard", example = "1") @PathVariable Long id) {
        log.info("[Controller:StandardController] getById() called - Request to fetch standard with id: {}", id);
        StandardDTO standardDTO = standardFacade.getById(id);
        log.info("[Controller:StandardController] getById() succeeded - Found standard: {}", id);
        return ResponseEntity.ok(standardDTO);
    }

    @Operation(summary = "Get standards by campus", description = "Retrieve all standards linked to a specific campus.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved standards",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandardDTO.class))),
            @ApiResponse(responseCode = "404", description = "Campus not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/campus/{campusId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StandardDTO>> getByCampusId(
            @Parameter(description = "Campus ID", example = "1") @PathVariable Long campusId) {
        log.info("[Controller:StandardController] getByCampusId() called - Request to fetch standards for campus: {}",
                campusId);
        List<StandardDTO> result = standardFacade.getByCampusId(campusId);
        log.info("[Controller:StandardController] getByCampusId() succeeded - Found {} standards", result.size());
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Search standards", description = "Find standards by optional campus and keyword (name or code).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching standards",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandardDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid search keyword",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StandardDTO>> search(
            @Parameter(description = "Optional campus ID filter") @RequestParam(required = false) Long campusId,
            @Parameter(description = "Search keyword (name, code, etc.)", example = "Grade") @RequestParam(required = false) String keyword) {
        log.info("[Controller:StandardController] search() called - campusId={}, keyword={}", campusId, keyword);
        if (keyword != null && keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        String trimmedKeyword = keyword != null ? keyword.trim() : null;
        List<StandardDTO> results = standardFacade.getStandardsByFilter(campusId, trimmedKeyword);
        log.info("[Controller:StandardController] search() succeeded - Found {} standards", results.size());
        return ResponseEntity.ok(results);
    }

    @Operation(summary = "Create standard", description = "Register a new standard under a campus.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Standard created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandardDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "Duplicate standard code or name",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardDTO> create(@Valid @RequestBody StandardCreateRequestDTO requestDTO) {
        log.info("[Controller:StandardController] create() called - Request to create standard: {}",
                requestDTO.getStandardName());
        StandardDTO created = standardFacade.create(requestDTO);
        log.info("[Controller:StandardController] create() succeeded - Standard created with id: {}", created.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Update standard", description = "Update details of an existing standard.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Standard updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = StandardDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Standard not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardDTO> update(
            @Parameter(description = "ID of the standard to update", example = "1") @PathVariable Long id,
            @Valid @RequestBody StandardCreateRequestDTO requestDTO) {
        log.info("[Controller:StandardController] update() called - Request to update standard: {}", id);
        StandardDTO updatedStandard = standardFacade.updateStandard(id, requestDTO);
        log.info("[Controller:StandardController] update() succeeded - Standard: {} updated successfully", id);
        return ResponseEntity.ok(updatedStandard);
    }

    @Operation(summary = "Delete standard", description = "Soft delete a standard from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Standard deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Standard not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{standardId}")
    public ResponseEntity<Map<String, String>> delete(
            @Parameter(description = "ID of the standard to delete", example = "1") @PathVariable Long standardId) {
        log.info("[Controller:StandardController] delete() called - Request to delete standard: {}", standardId);
        standardFacade.softDeleteById(standardId);
        log.info("[Controller:StandardController] delete() succeeded - Standard: {} deleted successfully", standardId);
        return ResponseEntity.ok(Map.of("message", "Standard deleted successfully"));
    }

    @Operation(summary = "Delete standards by campus", description = "Soft delete all standards linked to a campus.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Standards deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Campus not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/campus/{campusId}")
    public ResponseEntity<Map<String, String>> deleteByCampusId(
            @Parameter(description = "Campus ID whose standards should be deleted", example = "1") @PathVariable Long campusId) {
        log.info("[Controller:StandardController] deleteByCampusId() called - Request to delete standards for campus: {}",
                campusId);
        int rows = standardFacade.softDeleteByCampusId(campusId);
        log.info("[Controller:StandardController] deleteByCampusId() succeeded - {} standards deleted", rows);
        return ResponseEntity.ok(Map.of("message", rows + " Standards deleted"));
    }
}
