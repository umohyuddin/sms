package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.feeRates.requestDto.FeeRateCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeRates.responseDto.FeeRatesResponseDTO;

import com.smartsolutions.eschool.student.facade.FeeRateFacade;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.smartsolutions.eschool.global.error.ErrorResponse;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/fee/rates")
@Slf4j
@Tag(name = "Fee Management - Rates", description = "Endpoints for defining monetary values, percentages, and price points for fee components.")
public class FeeRateController {

    private final FeeRateFacade feeRateFacade;

    public FeeRateController(FeeRateFacade feeRateFacade) {
        this.feeRateFacade = feeRateFacade;
    }

    @Operation(summary = "Get all fee rates", description = "Retrieve a full list of all defined fee rates in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved fee rates",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeRatesResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/fee/rates called");
        List<FeeRatesResponseDTO> resources = feeRateFacade.getAll();
        log.info("GET /api/fee/rates succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @Operation(summary = "Get fee rate by ID", description = "Fetch detailed information of a specific fee rate.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved fee rate",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FeeRatesResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Fee rate not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@Parameter(description = "Unique ID of the fee rate", example = "100") @PathVariable Long id) throws Exception {
        log.info("Received request to fetch Fee rate with id: {}", id);
        FeeRatesResponseDTO feeRateDTO = feeRateFacade.getById(id);
        log.info("Returning Fee rate: id={}", feeRateDTO.getId());
        return ResponseEntity.ok(feeRateDTO);
    }

    @GetMapping(value = "catalog/{catalogId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByFeeCatalogId(@PathVariable Long catalogId) throws Exception {
        log.info("Received request to fetch  Fee rate with id: {}", catalogId);
        FeeRatesResponseDTO feeRateDTO = feeRateFacade.getById(catalogId);
        log.info("Returning Fee rate : id={}", feeRateDTO.getId());
        return ResponseEntity.ok(feeRateDTO);
    }

    @Operation(summary = "Get rates by component", description = "Retrieve all fee rates associated with a specific fee component.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved component rates",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeRatesResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/component/{componentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByFeeComponentId(@Parameter(description = "ID of the fee component", example = "10") @PathVariable Long componentId) {
        log.info("GET /api/fee/rates by componentId called");
        List<FeeRatesResponseDTO> resources = feeRateFacade.getByFeeComponentId(componentId);
        log.info("GET /api/fee/rates by  succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Find active fee rates", description = "Search for currently active fee rates based on campus, standard, and academic year.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved active rates",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeRatesResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findActiveFeeRates(
            @Parameter(description = "ID of the campus", example = "1") @RequestParam Long campusId,
            @Parameter(description = "ID of the academic standard", example = "5") @RequestParam Long standardId,
            @Parameter(description = "ID of the academic year", example = "1") @RequestParam Long academicYearId) {
        log.info("GET /api/fee/rates/active called with campus={}, standard={}, year={}", campusId, standardId,
                academicYearId);
        List<FeeRatesResponseDTO> resources = feeRateFacade.findActiveFeeRates(campusId, standardId, academicYearId);
        log.info("Active Fee Rates returned: {}", resources.size());
        return ResponseEntity.ok(resources);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeRatesResponseDTO> createFeeRate(@Valid @RequestBody FeeRateCreateRequestDTO dto) {
        log.info("POST /api/fee/rates called with payload: {}", dto);
        FeeRatesResponseDTO createdFeeRate = feeRateFacade.create(dto);
        log.info("FeeRate created successfully: id={}", createdFeeRate.getId());
        return ResponseEntity.ok(createdFeeRate);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeRatesResponseDTO> updateFeeRate(@PathVariable Long id,
            @Valid @RequestBody FeeRateCreateRequestDTO dto) {
        log.info("PUT /api/fee/rates/{} called with payload: {}", id, dto);
        FeeRatesResponseDTO updatedFeeRate = feeRateFacade.update(id, dto);
        log.info("FeeRate updated successfully: id={}", updatedFeeRate.getId());
        return ResponseEntity.ok(updatedFeeRate);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> searchFeeRates(@RequestParam(required = false) Long feeCatalogId,
            @RequestParam(required = false) Long feeComponentId, @RequestParam(required = false) String keyword) {
        log.info("GET /api/fee/rates/search called with feeCatalogId={}, feeComponentId={}, keyword={}", feeCatalogId,
                feeComponentId, keyword);
        List<FeeRatesResponseDTO> results = feeRateFacade.searchFeeRates(feeCatalogId, feeComponentId, keyword);
        log.info("Search returned {} FeeRates", results.size());
        // if (results.isEmpty()) {
        // return ResponseEntity.ok().body("No Fee Rates found for the given
        // criteria.");
        // }
        return ResponseEntity.ok(results);
    }

}
