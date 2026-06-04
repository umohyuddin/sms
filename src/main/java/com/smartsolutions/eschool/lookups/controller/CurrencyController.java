package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.global.error.ErrorResponse;
import com.smartsolutions.eschool.lookups.dtos.currency.requestDto.CurrencyRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.currency.responseDto.CurrencyResponseDTO;
import com.smartsolutions.eschool.lookups.facade.CurrencyFacade;
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
@RequestMapping("/api/lookups/currencies")
@Slf4j
@Tag(name = "Currency Management", description = "Endpoints for managing global system currencies, including creation, retrieval, and updates.")
public class CurrencyController {

    private final CurrencyFacade currencyFacade;

    public CurrencyController(CurrencyFacade currencyFacade) {
        this.currencyFacade = currencyFacade;
    }

    @Operation(summary = "Get all currencies", description = "Retrieve a list of all global currencies registered in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CurrencyResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurrencyResponseDTO>> getAll() {
        log.info("[Controller:CurrencyController] getAll() called - Request to get all currencies");
        List<CurrencyResponseDTO> resources = currencyFacade.getAll();
        log.info("[Controller:CurrencyController] getAll() succeeded - Found {} currencies", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get all active currencies", description = "Retrieve a list of all active global currencies.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CurrencyResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurrencyResponseDTO>> getAllActive() {
        log.info("[Controller:CurrencyController] getAllActive() called - Request to get all active currencies");
        List<CurrencyResponseDTO> resources = currencyFacade.getAllActive();
        log.info("[Controller:CurrencyController] getAllActive() succeeded - Found {} active currencies", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get currency by ID", description = "Fetch detailed information about a specific currency by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved currency",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CurrencyResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Currency not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> getById(
            @Parameter(description = "Unique ID of the currency", example = "1") @PathVariable Integer id) {
        log.info("[Controller:CurrencyController] getById() called - Request to fetch currency with id: {}", id);
        CurrencyResponseDTO currency = currencyFacade.getById(id);
        log.info("[Controller:CurrencyController] getById() succeeded - Found currency: {}", id);
        return ResponseEntity.ok(currency);
    }

    @Operation(summary = "Search currencies", description = "Find currencies by keyword matching name or ISO code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching currencies",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CurrencyResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid search keyword",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurrencyResponseDTO>> search(
            @Parameter(description = "Search keyword (name, isoCode)", example = "USD") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:CurrencyController] search() called - Request to search currencies with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<CurrencyResponseDTO> responseDTOs = currencyFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:CurrencyController] search() succeeded - Found {} currencies matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @Operation(summary = "Delete currency", description = "Soft delete a currency from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Currency deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Currency not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(
            @Parameter(description = "ID of the currency to delete", example = "1") @PathVariable Integer id) {
        log.info("[Controller:CurrencyController] delete() called - Request to delete currency: {}", id);
        currencyFacade.softDeleteById(id);
        log.info("[Controller:CurrencyController] delete() succeeded - Currency: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Currency deleted successfully"));
    }

    @Operation(summary = "Create new currency", description = "Register a new currency with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Currency created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CurrencyResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "Duplicate currency ISO code",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> create(@Valid @RequestBody CurrencyRequestDTO requestDTO) {
        log.info("[Controller:CurrencyController] create() called - Request to create currency: {}", requestDTO.getName());
        CurrencyResponseDTO responseDTO = currencyFacade.createCurrency(requestDTO);
        log.info("[Controller:CurrencyController] create() succeeded - Currency created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Update currency", description = "Update details of an existing currency.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Currency updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CurrencyResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Currency not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "Duplicate currency ISO code",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> update(
            @Parameter(description = "ID of the currency to update", example = "1") @PathVariable Integer id,
            @Valid @RequestBody CurrencyRequestDTO requestDTO) {
        log.info("[Controller:CurrencyController] update() called - Request to update currency: {}", id);
        CurrencyResponseDTO responseDTO = currencyFacade.updateCurrency(id, requestDTO);
        log.info("[Controller:CurrencyController] update() succeeded - Currency: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Get currency statistics", description = "Retrieve statistical data overview for currencies.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:CurrencyController] getStatistics() called");
        Map<String, Long> statistics = currencyFacade.getStatistics();
        log.info("[Controller:CurrencyController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}

