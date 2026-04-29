package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.guardian.responseDto.GuardianResponseDTO;
import com.smartsolutions.eschool.student.dtos.guardian.requestDto.GuardianCreateRequestDTO;
import com.smartsolutions.eschool.student.facade.GuardianFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.smartsolutions.eschool.global.error.ErrorResponse;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/guardians")
@Slf4j
@Tag(name = "Guardian Management", description = "Endpoints for managing student guardians and their personal/contact information.")
public class GuardianController {

    private final GuardianFacade guardianFacade;

    public GuardianController(GuardianFacade guardianFacade) {
        this.guardianFacade = guardianFacade;
    }

    @Operation(summary = "Get all guardians", description = "Retrieve a list of all guardians registered in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = GuardianResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GuardianResponseDTO>> getAll() {
        log.info("[Controller:GuardianController] getAll() called - Request to get all guardians");
        List<GuardianResponseDTO> resources = guardianFacade.getAll();
        log.info("[Controller:GuardianController] getAll() succeeded - Found {} guardians", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get active guardians", description = "Retrieve a list of all active guardians.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved active list",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = GuardianResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GuardianResponseDTO>> getActive() {
        log.info("[Controller:GuardianController] getActive() called - Request to get all active guardians");
        List<GuardianResponseDTO> resources = guardianFacade.getActive();
        log.info("[Controller:GuardianController] getActive() succeeded - Found {} active guardians", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get inactive guardians", description = "Retrieve a list of all inactive guardians.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved inactive list",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = GuardianResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GuardianResponseDTO>> getInactive() {
        log.info("[Controller:GuardianController] getInactive() called - Request to get all inactive guardians");
        List<GuardianResponseDTO> resources = guardianFacade.getInactive();
        log.info("[Controller:GuardianController] getInactive() succeeded - Found {} inactive guardians", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get guardian by ID", description = "Fetch detailed information for a specific guardian by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved guardian",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GuardianResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Guardian not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuardianResponseDTO> getById(
            @Parameter(description = "Unique ID of the guardian", example = "1") @PathVariable Long id) {
        log.info("[Controller:GuardianController] getById() called - Request to fetch guardian with id: {}", id);
        GuardianResponseDTO guardian = guardianFacade.getById(id);
        log.info("[Controller:GuardianController] getById() succeeded - Found guardian: {}", id);
        return ResponseEntity.ok(guardian);
    }

    @Operation(summary = "Search guardians", description = "Find guardians by keyword matching name, CNIC, or phone.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching guardians",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = GuardianResponseDTO.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid search keyword",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GuardianResponseDTO>> search(
            @Parameter(description = "Search keyword (name, CNIC, etc.)", example = "Khan") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:GuardianController] search() called - Request to search guardians with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<GuardianResponseDTO> responseDTOs = guardianFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:GuardianController] search() succeeded - Found {} guardians matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @Operation(summary = "Delete guardian", description = "Soft delete a guardian from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Guardian deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Guardian not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(
            @Parameter(description = "ID of the guardian to delete", example = "1") @PathVariable Long id) {
        log.info("[Controller:GuardianController] delete() called - Request to delete guardian: {}", id);
        guardianFacade.softDeleteById(id);
        log.info("[Controller:GuardianController] delete() succeeded - Guardian: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Guardian deleted successfully"));
    }

    @Operation(summary = "Create guardian", description = "Register a new guardian with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Guardian created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GuardianResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "Duplicate CNIC",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuardianResponseDTO> create(@Valid @RequestBody GuardianCreateRequestDTO requestDTO) {
        log.info("[Controller:GuardianController] create() called - Request to create guardian: {}", requestDTO.getFullName());
        GuardianResponseDTO responseDTO = guardianFacade.createGuardian(requestDTO);
        log.info("[Controller:GuardianController] create() succeeded - Guardian created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Update guardian", description = "Update details of an existing guardian.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Guardian updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GuardianResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Guardian not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "Duplicate CNIC",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuardianResponseDTO> update(
            @Parameter(description = "ID of the guardian to update", example = "1") @PathVariable Long id,
            @Valid @RequestBody GuardianCreateRequestDTO requestDTO) {
        log.info("[Controller:GuardianController] update() called - Request to update guardian: {}", id);
        GuardianResponseDTO responseDTO = guardianFacade.updateGuardian(id, requestDTO);
        log.info("[Controller:GuardianController] update() succeeded - Guardian: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Get guardian statistics", description = "Retrieve statistical data overview for guardians.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:GuardianController] getStatistics() called");
        Map<String, Long> statistics = guardianFacade.getStatistics();
        log.info("[Controller:GuardianController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }

    @Operation(summary = "Get guardians by student ID", description = "Retrieve a list of guardians associated with a specific student.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = GuardianResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/students/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GuardianResponseDTO>> getGuardiansByStudentId(
            @Parameter(description = "ID of the student", example = "1") @PathVariable Long studentId) {
        log.info("[Controller:GuardianController] getGuardiansByStudentId() called - studentId: {}", studentId);
        List<GuardianResponseDTO> guardians = guardianFacade.getGuardiansByStudentId(studentId);
        log.info("[Controller:GuardianController] getGuardiansByStudentId() succeeded - Found {} guardians for student {}", guardians.size(), studentId);
        return ResponseEntity.ok(guardians);
    }
}
