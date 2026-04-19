package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.feeCatalog.requestDto.FeeCatalogRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import com.smartsolutions.eschool.student.facade.FeeCatalogFacade;
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
import java.util.Map;

@RestController
@RequestMapping("/api/fee/catalogs")
@Slf4j
@Tag(name = "Fee Management - Catalogs", description = "Endpoints for defining and managing fee structures (catalogs) at the institution.")
public class FeeCatalogController {

    private final FeeCatalogFacade feeCatalogFacade;

    public FeeCatalogController(FeeCatalogFacade feeCatalogFacade) {
        this.feeCatalogFacade = feeCatalogFacade;
    }

    @Operation(summary = "Get all catalogs", description = "Retrieve a full list of all defined fee catalogs.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved catalog list",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeCatalogDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeCatalogDTO>> getAll() {
        log.info("[Controller:FeeCatalogController] getAll() called - Request to get all fee catalogs");
        List<FeeCatalogDTO> resources = feeCatalogFacade.getAll();
        log.info("[Controller:FeeCatalogController] getAll() succeeded - Found {} catalogs", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get catalog by ID", description = "Fetch detailed information of a specific fee catalog by its unique identifier.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved catalog",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FeeCatalogDTO.class))),
            @ApiResponse(responseCode = "404", description = "Catalog not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeCatalogDTO> getById(@Parameter(description = "Unique ID of the catalog", example = "1") @PathVariable Long id) {
        log.info("[Controller:FeeCatalogController] getById() called - Request to fetch catalog with id: {}", id);
        FeeCatalogDTO catalog = feeCatalogFacade.getById(id);
        log.info("[Controller:FeeCatalogController] getById() succeeded - Found catalog: {}", id);
        return ResponseEntity.ok(catalog);
    }

    @Operation(summary = "Search catalogs", description = "Find fee catalogs matching a specific keyword (name or code).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved search results",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeCatalogDTO.class)))),
            @ApiResponse(responseCode = "400", description = "Invalid keyword provided",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeCatalogDTO>> search(@Parameter(description = "Keyword to search catalogs (minimum 1 character)", example = "Tuition") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:FeeCatalogController] search() called - Request to search catalogs with keyword: {}",
                keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<FeeCatalogDTO> responseDTOs = feeCatalogFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:FeeCatalogController] search() succeeded - Found {} catalogs matching keyword: {}",
                responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @Operation(summary = "Create new catalog", description = "Define a new fee catalog with charge types and recurrence rules.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Catalog created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FeeCatalogDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid validation data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeCatalogDTO> create(@Valid @RequestBody FeeCatalogRequestDTO requestDTO) {
        log.info("[Controller:FeeCatalogController] create() called - Request to create catalog: {}",
                requestDTO.getName());
        FeeCatalogDTO responseDTO = feeCatalogFacade.createFeeCatalog(requestDTO);
        log.info("[Controller:FeeCatalogController] create() succeeded - Catalog created with id: {}",
                responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeCatalogDTO> update(@PathVariable Long id,
            @Valid @RequestBody FeeCatalogRequestDTO requestDTO) {
        log.info("[Controller:FeeCatalogController] update() called - Request to update catalog: {}", id);
        FeeCatalogDTO responseDTO = feeCatalogFacade.updateFeeCatalog(id, requestDTO);
        log.info("[Controller:FeeCatalogController] update() succeeded - Catalog: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:FeeCatalogController] delete() called - Request to delete catalog: {}", id);
        feeCatalogFacade.softDeleteById(id);
        log.info("[Controller:FeeCatalogController] delete() succeeded - Catalog: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Fee catalog deleted successfully"));
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:FeeCatalogController] getStatistics() called");
        Map<String, Long> statistics = feeCatalogFacade.getStatistics();
        log.info("[Controller:FeeCatalogController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
