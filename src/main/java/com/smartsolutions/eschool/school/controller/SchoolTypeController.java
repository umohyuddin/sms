package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.global.error.ErrorResponse;
import com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto.SchoolTypeCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.schoolTypes.responseDto.SchoolTypeResponseDTO;
import com.smartsolutions.eschool.school.facade.SchoolTypeFacade;
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
@RequestMapping("/api/institute/school-types")
@Slf4j
@Tag(name = "School Type Management", description = "Endpoints for managing school types, including creation, retrieval, updates, activation, and soft deletion.")
public class SchoolTypeController {

    private final SchoolTypeFacade nSchoolTypeFacade;

    public SchoolTypeController(SchoolTypeFacade nSchoolTypeFacade) {
        this.nSchoolTypeFacade = nSchoolTypeFacade;
    }

    @Operation(summary = "Get all school types", description = "Retrieve a list of all school types for the current organization.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolTypeResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SchoolTypeResponseDTO>> getAll() {
        log.info("[Controller:SchoolTypeController] getAll() called - Request to get all school types");
        List<SchoolTypeResponseDTO> resources = nSchoolTypeFacade.getAll();
        log.info("[Controller:SchoolTypeController] getAll() succeeded - Found {} school types", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get all active school types", description = "Retrieve all school types that are currently active.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved active school types",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolTypeResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SchoolTypeResponseDTO>> getAllActive() {
        log.info("[Controller:SchoolTypeController] getAllActive() called");
        List<SchoolTypeResponseDTO> resources = nSchoolTypeFacade.getAllActive();
        log.info("[Controller:SchoolTypeController] getAllActive() succeeded - Found {} active school types", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get school type by ID", description = "Fetch detailed information about a specific school type by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved school type",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolTypeResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "School type not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTypeResponseDTO> getById(
            @Parameter(description = "Unique ID of the school type", example = "1") @PathVariable Long id) {
        log.info("[Controller:SchoolTypeController] getById() called - id: {}", id);
        SchoolTypeResponseDTO responseDTO = nSchoolTypeFacade.getById(id);
        log.info("[Controller:SchoolTypeController] getById() succeeded - Found school type: {}", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Search school types", description = "Find school types by keyword matching code, name, or description.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching school types",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolTypeResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid search keyword",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SchoolTypeResponseDTO>> search(
            @Parameter(description = "Search keyword (code, name, or description)", example = "Private") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:SchoolTypeController] search() called - keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<SchoolTypeResponseDTO> responseDTOs = nSchoolTypeFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:SchoolTypeController] search() succeeded - Found {} school types matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @Operation(summary = "Create new school type", description = "Register a new school type for the current organization.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "School type created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolTypeResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "School type code already exists",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTypeResponseDTO> create(@Valid @RequestBody SchoolTypeCreateRequestDTO requestDTO) {
        log.info("[Controller:SchoolTypeController] create() called - code: {}", requestDTO.getCode());
        SchoolTypeResponseDTO responseDTO = nSchoolTypeFacade.create(requestDTO);
        log.info("[Controller:SchoolTypeController] create() succeeded - School type created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Update school type", description = "Update details of an existing school type.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "School type updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolTypeResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "School type not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "School type code already exists",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTypeResponseDTO> update(
            @Parameter(description = "ID of the school type to update", example = "1") @PathVariable Long id,
            @Valid @RequestBody SchoolTypeCreateRequestDTO requestDTO) {
        log.info("[Controller:SchoolTypeController] update() called - id: {}", id);
        SchoolTypeResponseDTO responseDTO = nSchoolTypeFacade.update(id, requestDTO);
        log.info("[Controller:SchoolTypeController] update() succeeded - School type: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Delete school type", description = "Soft delete a school type from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "School type deleted successfully"),
            @ApiResponse(responseCode = "404", description = "School type not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(
            @Parameter(description = "ID of the school type to delete", example = "1") @PathVariable Long id) {
        log.info("[Controller:SchoolTypeController] delete() called - id: {}", id);
        nSchoolTypeFacade.softDeleteById(id);
        log.info("[Controller:SchoolTypeController] delete() succeeded - School type: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "School type deleted successfully"));
    }

    @Operation(summary = "Activate school type", description = "Mark a school type as active.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "School type activated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolTypeResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "School type not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTypeResponseDTO> activate(
            @Parameter(description = "ID of the school type to activate", example = "1") @PathVariable Long id) {
        log.info("[Controller:SchoolTypeController] activate() called - id: {}", id);
        SchoolTypeResponseDTO responseDTO = nSchoolTypeFacade.activate(id);
        log.info("[Controller:SchoolTypeController] activate() succeeded - id: {}", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Deactivate school type", description = "Mark a school type as inactive.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "School type deactivated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = SchoolTypeResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "School type not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}/deactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SchoolTypeResponseDTO> deactivate(
            @Parameter(description = "ID of the school type to deactivate", example = "1") @PathVariable Long id) {
        log.info("[Controller:SchoolTypeController] deactivate() called - id: {}", id);
        SchoolTypeResponseDTO responseDTO = nSchoolTypeFacade.deactivate(id);
        log.info("[Controller:SchoolTypeController] deactivate() succeeded - id: {}", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Get school type statistics", description = "Retrieve statistical data overview for school types.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:SchoolTypeController] getStatistics() called");
        Map<String, Long> statistics = nSchoolTypeFacade.getStatistics();
        log.info("[Controller:SchoolTypeController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}

