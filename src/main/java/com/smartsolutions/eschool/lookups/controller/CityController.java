package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.city.requestDto.CityRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.facade.CityFacade;
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

import com.smartsolutions.eschool.global.error.ErrorResponse;

@RestController
@RequestMapping("/api/lookups/cities/v1")
@Slf4j
@Tag(name = "City Lookups", description = "Endpoints for managing cities in the lookup system.")
public class CityController {

    private final CityFacade cityFacade;

    public CityController(CityFacade cityFacade) {
        this.cityFacade = cityFacade;
    }

    @Operation(summary = "Get all cities", description = "Retrieve a list of all cities in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved cities",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CityResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityResponseDTO>> getAll() {
        log.info("[Controller:CityController] getAll() called - Request to get all cities");
        List<CityResponseDTO> resources = cityFacade.getAll();
        log.info("[Controller:CityController] getAll() succeeded - Found {} cities", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get active cities", description = "Retrieve a list of all active cities.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved active cities",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CityResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityResponseDTO>> getAllActive() {
        log.info("[Controller:CityController] getAllActive() called - Request to get all active cities");
        List<CityResponseDTO> resources = cityFacade.getAllActive();
        log.info("[Controller:CityController] getAllActive() succeeded - Found {} active cities", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get cities by province", description = "Retrieve all cities belonging to a specific province.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved cities for province",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CityResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Province not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/province/{provinceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityResponseDTO>> getByProvinceId(
            @Parameter(description = "ID of the province", example = "1") @PathVariable Long provinceId) {
        log.info("[Controller:CityController] getByProvinceId() called - Request to get all cities for province: {}", provinceId);
        List<CityResponseDTO> resources = cityFacade.getByProvinceId(provinceId);
        log.info("[Controller:CityController] getByProvinceId() succeeded - Found {} cities", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get city by ID", description = "Fetch detailed information about a specific city.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved city",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CityResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "City not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityResponseDTO> getById(
            @Parameter(description = "ID of the city", example = "1") @PathVariable Long id) {
        log.info("[Controller:CityController] getById() called - Request to fetch city with id: {}", id);
        CityResponseDTO city = cityFacade.getById(id);
        log.info("[Controller:CityController] getById() succeeded - Found city: {}", id);
        return ResponseEntity.ok(city);
    }

    @Operation(summary = "Search cities", description = "Search for cities by keyword.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching cities",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CityResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid search keyword",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityResponseDTO>> search(
            @Parameter(description = "Search keyword", example = "Lahore") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:CityController] search() called - Request to search cities with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<CityResponseDTO> responseDTOs = cityFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:CityController] search() succeeded - Found {} cities matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @Operation(summary = "Delete city", description = "Soft delete a city from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City deleted successfully"),
            @ApiResponse(responseCode = "404", description = "City not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(
            @Parameter(description = "ID of the city to delete", example = "1") @PathVariable Long id) {
        log.info("[Controller:CityController] delete() called - Request to delete city: {}", id);
        cityFacade.softDeleteById(id);
        log.info("[Controller:CityController] delete() succeeded - City: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "City deleted successfully"));
    }

    @Operation(summary = "Create new city", description = "Register a new city in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "City created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CityResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityResponseDTO> create(@Valid @RequestBody CityRequestDTO requestDTO) {
        log.info("[Controller:CityController] create() called - Request to create city: {}", requestDTO.getName());
        CityResponseDTO responseDTO = cityFacade.create(requestDTO);
        log.info("[Controller:CityController] create() succeeded - City created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Update city", description = "Update details of an existing city.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "City updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CityResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "City not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityResponseDTO> update(
            @Parameter(description = "ID of the city to update", example = "1") @PathVariable Long id,
            @Valid @RequestBody CityRequestDTO requestDTO) {
        log.info("[Controller:CityController] update() called - Request to update city: {}", id);
        CityResponseDTO responseDTO = cityFacade.update(id, requestDTO);
        log.info("[Controller:CityController] update() succeeded - City: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Get city statistics", description = "Retrieve statistical data overview for cities.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:CityController] getStatistics() called");
        Map<String, Long> statistics = cityFacade.getStatistics();
        log.info("[Controller:CityController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
