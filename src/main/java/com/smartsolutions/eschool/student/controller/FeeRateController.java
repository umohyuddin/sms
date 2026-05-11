package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.global.error.ErrorResponse;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fee/rates")
@Slf4j
@Tag(name = "Fee Management - Rates", description = "Endpoints for defining monetary values, percentages, and price points for fee components.")
public class FeeRateController {

    private final FeeRateFacade feeRateFacade;

    public FeeRateController(FeeRateFacade feeRateFacade) {
        this.feeRateFacade = feeRateFacade;
    }

    @Operation(summary = "Get all fee rates", description = "Retrieve a full list of all defined fee rates in the system, filtered by organization.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved fee rates",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeRatesResponseDTO.class)))),
            @ApiResponse(responseCode = "403", description = "Access denied",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeRatesResponseDTO>> getAll() {
        log.info("[Controller:FeeRateController] getAll() called");
        List<FeeRatesResponseDTO> response = feeRateFacade.getAll();
        log.info("[Controller:FeeRateController] getAll() succeeded - Found {} resources", response.size());
        return ResponseEntity.ok(response);
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
    public ResponseEntity<FeeRatesResponseDTO> getById(@Parameter(description = "Unique ID of the fee rate", example = "100") @PathVariable Long id) {
        log.info("[Controller:FeeRateController] getById() called - id: {}", id);
        FeeRatesResponseDTO response = feeRateFacade.getById(id);
        log.info("[Controller:FeeRateController] getById() succeeded - id: {}", id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get rates by component", description = "Retrieve all fee rates associated with a specific fee component.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved component rates",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeRatesResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/component/{componentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeRatesResponseDTO>> getByFeeComponentId(@Parameter(description = "ID of the fee component", example = "10") @PathVariable Long componentId) {
        log.info("[Controller:FeeRateController] getByFeeComponentId() called - component: {}", componentId);
        List<FeeRatesResponseDTO> response = feeRateFacade.getByFeeComponentId(componentId);
        log.info("[Controller:FeeRateController] getByFeeComponentId() succeeded - Found {} resources", response.size());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Find active fee rates", description = "Search for currently active fee rates based on campus, standard, and academic year.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved active rates",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeRatesResponseDTO.class)))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeRatesResponseDTO>> findActiveFeeRates(
            @Parameter(description = "ID of the campus", example = "1") @RequestParam Long campusId,
            @Parameter(description = "ID of the academic standard", example = "5") @RequestParam Long standardId,
            @Parameter(description = "ID of the academic year", example = "1") @RequestParam Long academicYearId) {
        log.info("[Controller:FeeRateController] findActiveFeeRates() called - campus: {}, standard: {}, year: {}", campusId, standardId, academicYearId);
        List<FeeRatesResponseDTO> response = feeRateFacade.findActiveFeeRates(campusId, standardId, academicYearId);
        log.info("[Controller:FeeRateController] findActiveFeeRates() succeeded - Found {} resources", response.size());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Create fee rate", description = "Define a new fee rate for a specific component and timeframe.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Fee rate created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FeeRatesResponseDTO.class))),
            @ApiResponse(responseCode = "409", description = "Conflict - Overlapping fee rate exists",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request - Invalid data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeRatesResponseDTO> createFeeRate(@Valid @RequestBody FeeRateCreateRequestDTO dto) {
        log.info("[Controller:FeeRateController] createFeeRate() called");
        FeeRatesResponseDTO response = feeRateFacade.create(dto);
        log.info("[Controller:FeeRateController] createFeeRate() succeeded - id: {}", response.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Update fee rate", description = "Update an existing fee rate definition.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fee rate updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = FeeRatesResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Fee rate not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request - Invalid data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeRatesResponseDTO> updateFeeRate(@Parameter(description = "ID of the fee rate to update", example = "1") @PathVariable Long id,
            @Valid @RequestBody FeeRateCreateRequestDTO dto) {
        log.info("[Controller:FeeRateController] updateFeeRate() called - id: {}", id);
        FeeRatesResponseDTO response = feeRateFacade.update(id, dto);
        log.info("[Controller:FeeRateController] updateFeeRate() succeeded - id: {}", id);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Search fee rates", description = "Search for fee rates using keyword and component filters.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search results",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = FeeRatesResponseDTO.class))))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeRatesResponseDTO>> searchFeeRates(
            @RequestParam(required = false) Long feeCatalogId,
            @RequestParam(required = false) Long feeComponentId,
            @RequestParam(required = false) String keyword) {
        log.info("[Controller:FeeRateController] searchFeeRates() called - keyword: {}", keyword);
        List<FeeRatesResponseDTO> response = feeRateFacade.searchFeeRates(feeCatalogId, feeComponentId, keyword);
        log.info("[Controller:FeeRateController] searchFeeRates() succeeded - Found {} results", response.size());
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete fee rate", description = "Soft delete a fee rate by marking it as deleted.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Fee rate deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Fee rate not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeeRate(@Parameter(description = "ID of the fee rate to delete", example = "1") @PathVariable Long id) {
        log.info("[Controller:FeeRateController] deleteFeeRate() called - id: {}", id);
        feeRateFacade.delete(id);
        log.info("[Controller:FeeRateController] deleteFeeRate() succeeded - id: {}", id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get fee rate statistics", description = "Get summary counts of total, active, and inactive fee rates.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Statistics retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Map.class)))
    })
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:FeeRateController] getStatistics() called");
        Map<String, Long> stats = feeRateFacade.getStatistics();
        log.info("[Controller:FeeRateController] getStatistics() succeeded");
        return ResponseEntity.ok(stats);
    }
}
