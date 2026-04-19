package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.campuses.metaData.CampusMetaData;
import com.smartsolutions.eschool.school.dtos.campuses.requestDto.CampusCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.school.facade.CampusFacade;
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
@RequestMapping("/api/institute/campuses")
@Slf4j
@Tag(name = "Campus Management", description = "Endpoints for managing institute campuses, including creation, retrieval, and updates.")
public class CampusController {

    private final CampusFacade nCampusFacade;

    public CampusController(CampusFacade nCampusFacade) {
        this.nCampusFacade = nCampusFacade;
    }

    @Operation(summary = "Get all campuses", description = "Retrieve a list of all campuses registered in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CampusResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampusResponseDTO>> getAll() {
        log.info("[Controller:CampusController] getAll() called - Request to get all campuses");
        List<CampusResponseDTO> resources = nCampusFacade.getAll();
        log.info("[Controller:CampusController] getAll() succeeded - Found {} campuses", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get campus by ID", description = "Fetch detailed information about a specific campus by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved campus",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CampusResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Campus not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampusResponseDTO> getById(
            @Parameter(description = "Unique ID of the campus", example = "1") @PathVariable Long id) {
        log.info("[Controller:CampusController] getById() called - Request to fetch campus with id: {}", id);
        CampusResponseDTO campus = nCampusFacade.getById(id);
        log.info("[Controller:CampusController] getById() succeeded - Found campus: {}", id);
        return ResponseEntity.ok(campus);
    }

    @Operation(summary = "Search campuses", description = "Find campuses by keyword matching name, code, or address.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching campuses",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CampusResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid search keyword",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CampusResponseDTO>> search(
            @Parameter(description = "Search keyword (name, code, etc.)", example = "Main") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:CampusController] search() called - Request to search campuses with keyword: {}",
                keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<CampusResponseDTO> responseDTOs = nCampusFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:CampusController] search() succeeded - Found {} campuses matching keyword: {}",
                responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @Operation(summary = "Delete campus", description = "Soft delete a campus from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Campus deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Campus not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{campusId}")
    public ResponseEntity<Map<String, String>> delete(
            @Parameter(description = "ID of the campus to delete", example = "1") @PathVariable Long campusId) {
        log.info("[Controller:CampusController] delete() called - Request to delete campus: {}", campusId);
        nCampusFacade.softDeleteById(campusId);
        log.info("[Controller:CampusController] delete() succeeded - Campus: {} deleted successfully", campusId);
        return ResponseEntity.ok(Map.of("message", "Campus deleted successfully"));
    }

    @Operation(summary = "Create new campus", description = "Register a new campus with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Campus created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CampusResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampusResponseDTO> create(@Valid @RequestBody CampusCreateRequestDTO requestDTO) {
        log.info("[Controller:CampusController] create() called - Request to create campus: {}",
                requestDTO.getCampusName());
        CampusResponseDTO responseDTO = nCampusFacade.createCampus(requestDTO);
        log.info("[Controller:CampusController] create() succeeded - Campus created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Update campus", description = "Update details of an existing campus.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Campus updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = CampusResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Campus not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampusResponseDTO> update(
            @Parameter(description = "ID of the campus to update", example = "1") @PathVariable Long id,
            @Valid @RequestBody CampusCreateRequestDTO requestDTO) {
        log.info("[Controller:CampusController] update() called - Request to update campus: {}", id);
        CampusResponseDTO responseDTO = nCampusFacade.updateCampus(id, requestDTO);
        log.info("[Controller:CampusController] update() succeeded - Campus: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

//    @GetMapping(value = "/meta", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<CampusMetaData> getMetaData() {
//        log.info("[Controller:CampusController] getMetaData() called");
//        CampusMetaData resources = nCampusFacade.getCampusMetaData();
//        log.info("[Controller:CampusController] getMetaData() succeeded");
//        return ResponseEntity.ok(resources);
//    }

    @Operation(summary = "Get campus statistics", description = "Retrieve statistical data overview for campuses.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<java.util.Map<String, Long>> getStatistics() {
        log.info("[Controller:CampusController] getStatistics() called");
        java.util.Map<String, Long> statistics = nCampusFacade.getStatistics();
        log.info("[Controller:CampusController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
