package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.sclass.dtos.requestDto.StandardCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.requestDto.FeeCatalogComponentRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.responseDto.FeeComponentResponseDTO;
import com.smartsolutions.eschool.student.dtos.feeRates.responseDto.FeeRatesResponseDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeComponentDTO;
import com.smartsolutions.eschool.student.facade.FeeComponentFacade;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.smartsolutions.eschool.global.error.ErrorResponse;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/fee/components")
@Slf4j
@Tag(name = "Fee Management - Components", description = "Endpoints for managing individual fee components within catalogs.")
public class FeeComponentController {


        private final FeeComponentFacade feeComponentFacade;

        public FeeComponentController(FeeComponentFacade feeComponentFacade) {
            this.feeComponentFacade = feeComponentFacade;
        }

        // ====================================
        // GET ALL COMPONENTS
        // ====================================
        @Operation(summary = "Get all components", description = "Retrieve a list of all fee components across all catalogs.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Successfully retrieved components",
                        content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeComponentResponseDTO.class)))),
                @ApiResponse(responseCode = "500", description = "Internal server error",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
        })
        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<FeeComponentResponseDTO>> getAll() {
            log.info("[Controller:FeeComponentController] getAll() called");
            List<FeeComponentResponseDTO> resources = feeComponentFacade.getAll();
            log.info("[Controller:FeeComponentController] getAll() succeeded - Found {} components", resources.size());
            return ResponseEntity.ok(resources);
        }

        // ====================================
        // GET COMPONENT BY ID
        // ====================================
        @Operation(summary = "Get component by ID", description = "Fetch details of a specific fee component by its unique identifier.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Successfully retrieved component",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = FeeComponentResponseDTO.class))),
                @ApiResponse(responseCode = "404", description = "Component not found",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
                @ApiResponse(responseCode = "500", description = "Internal server error",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
        })
        @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<FeeComponentResponseDTO> getById(@Parameter(description = "Unique ID of the component", example = "10") @PathVariable Long id) {
            log.info("[Controller:FeeComponentController] getById() called - id: {}", id);
            FeeComponentResponseDTO responseDTO = feeComponentFacade.getById(id);
            log.info("[Controller:FeeComponentController] getById() succeeded - id: {}", id);
            return ResponseEntity.ok(responseDTO);
        }

        // ====================================
        // GET COMPONENTS BY FEE CATALOG
        // ====================================
        @Operation(summary = "Get components by catalog", description = "Retrieve all fee components assigned to a specific fee catalog.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Successfully retrieved catalog components",
                        content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeComponentResponseDTO.class)))),
                @ApiResponse(responseCode = "500", description = "Internal server error",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
        })
        @GetMapping(value = "/catalog/{catalogId}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<FeeComponentResponseDTO>> getByFeeCatalogId(@Parameter(description = "ID of the catalog", example = "1") @PathVariable Long catalogId) {
            log.info("[Controller:FeeComponentController] getByFeeCatalogId() called - catalogId: {}", catalogId);
            List<FeeComponentResponseDTO> response = feeComponentFacade.getByFeeCatalogId(catalogId);
            log.info("[Controller:FeeComponentController] getByFeeCatalogId() succeeded - Found {} components", response.size());
            return ResponseEntity.ok(response);
        }

        // ====================================
        // SEARCH COMPONENTS
        // ====================================
        @Operation(summary = "Search components", description = "Search for fee components using catalog ID and/or keyword.")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200", description = "Successfully retrieved search results",
                        content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeComponentResponseDTO.class)))),
                @ApiResponse(responseCode = "500", description = "Internal server error",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
        })
        @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<FeeComponentResponseDTO>> search(
                @Parameter(description = "Optional catalog ID to filter by", example = "1") @RequestParam(required = false) Long feeCatalogId,
                @Parameter(description = "Keyword to search within component name or code", example = "Tuition") @RequestParam(required = false) String keyword
        ) {
            log.info("[Controller:FeeComponentController] search() called - catalogId: {}, keyword: {}", feeCatalogId, keyword);
            List<FeeComponentResponseDTO> response = feeComponentFacade.searchFeeCatalogComponents(feeCatalogId, keyword);
            log.info("[Controller:FeeComponentController] search() succeeded - Found {} components", response.size());
            return ResponseEntity.ok(response);
        }

        // ====================================
        // CREATE COMPONENT
        // ====================================
        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<FeeComponentResponseDTO> create(@Valid @RequestBody FeeCatalogComponentRequestDTO requestDTO) {
            log.info("[Controller:FeeComponentController] create() called - componentCode: {}", requestDTO.getComponentCode());
            FeeComponentResponseDTO created = feeComponentFacade.create(requestDTO);
            log.info("[Controller:FeeComponentController] create() succeeded - id: {}", created.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }

        // ====================================
        // UPDATE COMPONENT
        // ====================================
        @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<FeeComponentResponseDTO> update(@PathVariable Long id, @Valid @RequestBody FeeCatalogComponentRequestDTO requestDTO) {
            log.info("[Controller:FeeComponentController] update() called - id: {}", id);
            FeeComponentResponseDTO updated = feeComponentFacade.updateFeeComponent(id, requestDTO);
            log.info("[Controller:FeeComponentController] update() succeeded - id: {}", updated.getId());
            return ResponseEntity.ok(updated);
        }

    }