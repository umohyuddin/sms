package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.global.error.ErrorResponse;
import com.smartsolutions.eschool.lookups.dtos.facilityType.requestDto.FacilityTypeRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.facilityType.responseDto.FacilityTypeResponseDTO;
import com.smartsolutions.eschool.lookups.facade.FacilityTypeFacade;
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
@RequestMapping("/api/lookups/facility-types")
@Slf4j
@Tag(name = "Facility Type Management", description = "Endpoints for managing global system facility types, including creation, retrieval, and updates.")
public class FacilityTypeController {

    private final FacilityTypeFacade facilityTypeFacade;

    public FacilityTypeController(FacilityTypeFacade facilityTypeFacade) {
        this.facilityTypeFacade = facilityTypeFacade;
    }

    @Operation(summary = "Get all facility types", description = "Retrieve a list of all global facility types registered in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FacilityTypeResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FacilityTypeResponseDTO>> getAll() {
        log.info("[Controller:FacilityTypeController] getAll() called - Request to get all facility types");
        List<FacilityTypeResponseDTO> resources = facilityTypeFacade.getAll();
        log.info("[Controller:FacilityTypeController] getAll() succeeded - Found {} facility types", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get all active facility types", description = "Retrieve a list of all active global facility types.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FacilityTypeResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FacilityTypeResponseDTO>> getAllActive() {
        log.info("[Controller:FacilityTypeController] getAllActive() called - Request to get all active facility types");
        List<FacilityTypeResponseDTO> resources = facilityTypeFacade.getAllActive();
        log.info("[Controller:FacilityTypeController] getAllActive() succeeded - Found {} active facility types", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get facility type by ID", description = "Fetch detailed information about a specific facility type by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved facility type",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FacilityTypeResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Facility type not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacilityTypeResponseDTO> getById(
            @Parameter(description = "Unique ID of the facility type", example = "1") @PathVariable Long id) {
        log.info("[Controller:FacilityTypeController] getById() called - Request to fetch facility type with id: {}", id);
        FacilityTypeResponseDTO facilityType = facilityTypeFacade.getById(id);
        log.info("[Controller:FacilityTypeController] getById() succeeded - Found facility type: {}", id);
        return ResponseEntity.ok(facilityType);
    }

    @Operation(summary = "Search facility types", description = "Find facility types by keyword matching name or code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching facility types",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FacilityTypeResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid search keyword",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FacilityTypeResponseDTO>> search(
            @Parameter(description = "Search keyword (name, code)", example = "LAB") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:FacilityTypeController] search() called - Request to search facility types with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<FacilityTypeResponseDTO> responseDTOs = facilityTypeFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:FacilityTypeController] search() succeeded - Found {} facility types matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @Operation(summary = "Delete facility type", description = "Soft delete a facility type from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Facility type deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Facility type not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(
            @Parameter(description = "ID of the facility type to delete", example = "1") @PathVariable Long id) {
        log.info("[Controller:FacilityTypeController] delete() called - Request to delete facility type: {}", id);
        facilityTypeFacade.softDeleteById(id);
        log.info("[Controller:FacilityTypeController] delete() succeeded - Facility type: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Facility type deleted successfully"));
    }

    @Operation(summary = "Create new facility type", description = "Register a new facility type with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Facility type created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FacilityTypeResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "Duplicate facility type code",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacilityTypeResponseDTO> create(@Valid @RequestBody FacilityTypeRequestDTO requestDTO) {
        log.info("[Controller:FacilityTypeController] create() called - Request to create facility type: {}", requestDTO.getName());
        FacilityTypeResponseDTO responseDTO = facilityTypeFacade.create(requestDTO);
        log.info("[Controller:FacilityTypeController] create() succeeded - Facility type created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Update facility type", description = "Update details of an existing facility type.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Facility type updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FacilityTypeResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Facility type not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "Duplicate facility type code",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacilityTypeResponseDTO> update(
            @Parameter(description = "ID of the facility type to update", example = "1") @PathVariable Long id,
            @Valid @RequestBody FacilityTypeRequestDTO requestDTO) {
        log.info("[Controller:FacilityTypeController] update() called - Request to update facility type: {}", id);
        FacilityTypeResponseDTO responseDTO = facilityTypeFacade.update(id, requestDTO);
        log.info("[Controller:FacilityTypeController] update() succeeded - Facility type: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Get facility type statistics", description = "Retrieve statistical data overview for facility types.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:FacilityTypeController] getStatistics() called");
        Map<String, Long> statistics = facilityTypeFacade.getStatistics();
        log.info("[Controller:FacilityTypeController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}

