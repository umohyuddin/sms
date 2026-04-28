package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.guardianRelation.responseDto.GuardianRelationResponseDTO;
import com.smartsolutions.eschool.student.dtos.guardianRelation.requestDto.GuardianRelationCreateRequestDTO;
import com.smartsolutions.eschool.student.facade.GuardianRelationFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.smartsolutions.eschool.global.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/guardian/relation")
@Slf4j
@Tag(name = "Guardian Relationship Management", description = "Endpoints for managing guardian relationship types, including creation, retrieval, and updates.")
public class GuardianRelationController {

    private final GuardianRelationFacade guardianRelationFacade;

    public GuardianRelationController(GuardianRelationFacade guardianRelationFacade) {
        this.guardianRelationFacade = guardianRelationFacade;
    }

    @Operation(summary = "Get all relations", description = "Retrieve a list of all guardian relationship types registered in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GuardianRelationResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GuardianRelationResponseDTO>> getAll() {
        log.info("[Controller:GuardianRelationController] getAll() called - Request to get all guardian relations");
        List<GuardianRelationResponseDTO> resources = guardianRelationFacade.getAll();
        log.info("[Controller:GuardianRelationController] getAll() succeeded - Found {} guardian relations", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get active relations", description = "Retrieve a list of all active guardian relationship types.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved active list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GuardianRelationResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GuardianRelationResponseDTO>> getActive() {
        log.info("[Controller:GuardianRelationController] getActive() called - Request to get all active guardian relations");
        List<GuardianRelationResponseDTO> resources = guardianRelationFacade.getActive();
        log.info("[Controller:GuardianRelationController] getActive() succeeded - Found {} active guardian relations", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get inactive relations", description = "Retrieve a list of all inactive guardian relationship types.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved inactive list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GuardianRelationResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GuardianRelationResponseDTO>> getInactive() {
        log.info("[Controller:GuardianRelationController] getInactive() called - Request to get all inactive guardian relations");
        List<GuardianRelationResponseDTO> resources = guardianRelationFacade.getInactive();
        log.info("[Controller:GuardianRelationController] getInactive() succeeded - Found {} inactive guardian relations", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get relation by ID", description = "Fetch detailed information about a specific guardian relationship type by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved relation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GuardianRelationResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Relation not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuardianRelationResponseDTO> getById(
            @Parameter(description = "Unique ID of the guardian relation", example = "1") @PathVariable Long id) {
        log.info("[Controller:GuardianRelationController] getById() called - Request to fetch guardian relation with id: {}", id);
        GuardianRelationResponseDTO relation = guardianRelationFacade.getById(id);
        log.info("[Controller:GuardianRelationController] getById() succeeded - Found guardian relation: {}", id);
        return ResponseEntity.ok(relation);
    }

    @Operation(summary = "Search relations", description = "Find guardian relationship types by keyword matching name or code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching relations",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GuardianRelationResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid search keyword",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GuardianRelationResponseDTO>> search(
            @Parameter(description = "Search keyword (name, code, etc.)", example = "Father") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:GuardianRelationController] search() called - Request to search guardian relations with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<GuardianRelationResponseDTO> responseDTOs = guardianRelationFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:GuardianRelationController] search() succeeded - Found {} guardian relations matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @Operation(summary = "Delete relation", description = "Soft delete a guardian relationship type from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relation deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Relation not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(
            @Parameter(description = "ID of the relation to delete", example = "1") @PathVariable Long id) {
        log.info("[Controller:GuardianRelationController] delete() called - Request to delete guardian relation: {}", id);
        guardianRelationFacade.softDeleteById(id);
        log.info("[Controller:GuardianRelationController] delete() succeeded - Guardian relation: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Guardian relation deleted successfully"));
    }

    @Operation(summary = "Create new relation", description = "Register a new guardian relationship type with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Relation created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GuardianRelationResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuardianRelationResponseDTO> create(@Valid @RequestBody GuardianRelationCreateRequestDTO requestDTO) {
        log.info("[Controller:GuardianRelationController] create() called - Request to create guardian relation: {}", requestDTO.getName());
        GuardianRelationResponseDTO responseDTO = guardianRelationFacade.createGuardianRelation(requestDTO);
        log.info("[Controller:GuardianRelationController] create() succeeded - Guardian relation created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Update relation", description = "Update details of an existing guardian relationship type.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Relation updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GuardianRelationResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Relation not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuardianRelationResponseDTO> update(
            @Parameter(description = "ID of the relation to update", example = "1") @PathVariable Long id,
            @Valid @RequestBody GuardianRelationCreateRequestDTO requestDTO) {
        log.info("[Controller:GuardianRelationController] update() called - Request to update guardian relation: {}", id);
        GuardianRelationResponseDTO responseDTO = guardianRelationFacade.updateGuardianRelation(id, requestDTO);
        log.info("[Controller:GuardianRelationController] update() succeeded - Guardian relation: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Get relation statistics", description = "Retrieve statistical data overview for guardian relationship types.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:GuardianRelationController] getStatistics() called");
        Map<String, Long> statistics = guardianRelationFacade.getStatistics();
        log.info("[Controller:GuardianRelationController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
