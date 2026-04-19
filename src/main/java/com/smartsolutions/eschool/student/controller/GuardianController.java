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
            @ApiResponse(responseCode = "200", description = "List retrieved successfully",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = GuardianResponseDTO.class))))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GuardianResponseDTO>> getAll() {
        log.info("[Controller:GuardianController] getAll() called - Request to get all guardians");
        List<GuardianResponseDTO> resources = guardianFacade.getAll();
        log.info("[Controller:GuardianController] getAll() succeeded - Found {} guardians", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GuardianResponseDTO>> getActive() {
        log.info("[Controller:GuardianController] getActive() called - Request to get all active guardians");
        List<GuardianResponseDTO> resources = guardianFacade.getActive();
        log.info("[Controller:GuardianController] getActive() succeeded - Found {} active guardians", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GuardianResponseDTO>> getInactive() {
        log.info("[Controller:GuardianController] getInactive() called - Request to get all inactive guardians");
        List<GuardianResponseDTO> resources = guardianFacade.getInactive();
        log.info("[Controller:GuardianController] getInactive() succeeded - Found {} inactive guardians", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get guardian by ID", description = "Fetch detailed information for a specific guardian.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Guardian found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GuardianResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Guardian not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuardianResponseDTO> getById(
            @Parameter(description = "ID of the guardian", example = "1") @PathVariable Long id) {
        log.info("[Controller:GuardianController] getById() called - Request to fetch guardian with id: {}", id);
        GuardianResponseDTO guardian = guardianFacade.getById(id);
        log.info("[Controller:GuardianController] getById() succeeded - Found guardian: {}", id);
        return ResponseEntity.ok(guardian);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GuardianResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:GuardianController] search() called - Request to search guardians with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<GuardianResponseDTO> responseDTOs = guardianFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:GuardianController] search() succeeded - Found {} guardians matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:GuardianController] delete() called - Request to delete guardian: {}", id);
        guardianFacade.softDeleteById(id);
        log.info("[Controller:GuardianController] delete() succeeded - Guardian: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Guardian deleted successfully"));
    }

    @Operation(summary = "Create guardian", description = "Register a new guardian in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Guardian created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GuardianResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid data provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuardianResponseDTO> create(@Valid @RequestBody GuardianCreateRequestDTO requestDTO) {
        log.info("[Controller:GuardianController] create() called - Request to create guardian: {}", requestDTO.getFullName());
        GuardianResponseDTO responseDTO = guardianFacade.createGuardian(requestDTO);
        log.info("[Controller:GuardianController] create() succeeded - Guardian created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GuardianResponseDTO> update(@PathVariable Long id, @Valid @RequestBody GuardianCreateRequestDTO requestDTO) {
        log.info("[Controller:GuardianController] update() called - Request to update guardian: {}", id);
        GuardianResponseDTO responseDTO = guardianFacade.updateGuardian(id, requestDTO);
        log.info("[Controller:GuardianController] update() succeeded - Guardian: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:GuardianController] getStatistics() called");
        Map<String, Long> statistics = guardianFacade.getStatistics();
        log.info("[Controller:GuardianController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }

    @GetMapping(value = "/students/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GuardianResponseDTO>> getGuardiansByStudentId(@PathVariable Long studentId) {
        log.info("[Controller:GuardianController] getGuardiansByStudentId() called - studentId: {}", studentId);
        List<GuardianResponseDTO> guardians = guardianFacade.getGuardiansByStudentId(studentId);
        log.info("[Controller:GuardianController] getGuardiansByStudentId() succeeded - Found {} guardians for student {}", guardians.size(), studentId);
        return ResponseEntity.ok(guardians);
    }
}
