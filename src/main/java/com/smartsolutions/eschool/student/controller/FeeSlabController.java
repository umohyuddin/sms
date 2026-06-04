package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.feeSlab.FeeSlabCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeSlab.FeeSlabResponseDTO;
import com.smartsolutions.eschool.student.facade.FeeSlabFacade;
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
@RequestMapping("/api/student/fee-slabs")
@Slf4j
@Tag(name = "Fee Management - Slabs", description = "Endpoints for managing tiered (slab-based) fee structures within groups.")
public class FeeSlabController {

    private final FeeSlabFacade facade;

    public FeeSlabController(FeeSlabFacade facade) {
        this.facade = facade;
    }

    @Operation(summary = "Get all slabs", description = "Retrieve a full list of all defined fee slabs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved slabs",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeSlabResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeSlabResponseDTO>> getAll() {
        log.info("[Controller:FeeSlabController] getAll() called");
        List<FeeSlabResponseDTO> resources = facade.getAll();
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get slab by ID", description = "Fetch detailed information of a specific fee slab.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved slab",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FeeSlabResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Slab not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeSlabResponseDTO> getById(@Parameter(description = "Unique ID of the slab", example = "10") @PathVariable Long id) {
        log.info("[Controller:FeeSlabController] getById() called with id: {}", id);
        FeeSlabResponseDTO resource = facade.getById(id);
        return ResponseEntity.ok(resource);
    }

    @Operation(summary = "Get slabs by group", description = "Retrieve all slabs belonging to a specific slab group.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved group slabs",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeSlabResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/group/{groupId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeSlabResponseDTO>> getByGroupId(@Parameter(description = "ID of the slab group", example = "1") @PathVariable Long groupId) {
        log.info("[Controller:FeeSlabController] getByGroupId() called with groupId: {}", groupId);
        return ResponseEntity.ok(facade.getByGroupId(groupId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeSlabResponseDTO> create(@Valid @RequestBody FeeSlabCreateRequestDTO dto) {
        log.info("[Controller:FeeSlabController] create() called");
        FeeSlabResponseDTO created = facade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeSlabResponseDTO> update(@PathVariable Long id,
            @Valid @RequestBody FeeSlabCreateRequestDTO dto) {
        log.info("[Controller:FeeSlabController] update() called with id: {}", id);
        FeeSlabResponseDTO updated = facade.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("[Controller:FeeSlabController] delete() called with id: {}", id);
        facade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
