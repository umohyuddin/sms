package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.feeSlabGroup.FeeSlabGroupCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeSlabGroup.FeeSlabGroupResponseDTO;
import com.smartsolutions.eschool.student.facade.FeeSlabGroupFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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

import com.smartsolutions.eschool.global.error.ErrorResponse;

import java.util.List;

@RestController
@RequestMapping("/api/student/fee-slab-groups")
@Slf4j
@Tag(name = "Fee Management - Slab Groups", description = "Endpoints for managing groups of tiered fee slabs.")
public class FeeSlabGroupController {

    private final FeeSlabGroupFacade facade;

    public FeeSlabGroupController(FeeSlabGroupFacade facade) {
        this.facade = facade;
    }

    @Operation(summary = "Get all slab groups", description = "Retrieve a list of all defined fee slab groups.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved slab groups",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeSlabGroupResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeSlabGroupResponseDTO>> getAll() {
        log.info("[Controller:FeeSlabGroupController] getAll() called");
        List<FeeSlabGroupResponseDTO> resources = facade.getAll();
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get slab group by ID", description = "Fetch detailed information of a specific fee slab group.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved slab group",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FeeSlabGroupResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Slab group not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeSlabGroupResponseDTO> getById(@Parameter(description = "Unique ID of the slab group", example = "1") @PathVariable Long id) {
        log.info("[Controller:FeeSlabGroupController] getById() called with id: {}", id);
        FeeSlabGroupResponseDTO resource = facade.getById(id);
        return ResponseEntity.ok(resource);
    }

    @Operation(summary = "Search slab groups", description = "Find slab groups matching a keyword (name or code).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved search results",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeSlabGroupResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeSlabGroupResponseDTO>> search(
            @Parameter(description = "Keyword to search within group name or code", example = "Tuition") @RequestParam(name = "keyword", required = false) String keyword) {
        log.info("[Controller:FeeSlabGroupController] search() called with keyword: {}", keyword);
        return ResponseEntity.ok(facade.search(keyword));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeSlabGroupResponseDTO> create(@Valid @RequestBody FeeSlabGroupCreateRequestDTO dto) {
        log.info("[Controller:FeeSlabGroupController] create() called");
        FeeSlabGroupResponseDTO created = facade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeSlabGroupResponseDTO> update(@PathVariable Long id,
            @Valid @RequestBody FeeSlabGroupCreateRequestDTO dto) {
        log.info("[Controller:FeeSlabGroupController] update() called with id: {}", id);
        FeeSlabGroupResponseDTO updated = facade.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("[Controller:FeeSlabGroupController] delete() called with id: {}", id);
        facade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
