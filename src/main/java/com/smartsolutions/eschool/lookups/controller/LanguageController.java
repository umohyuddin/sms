package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.global.error.ErrorResponse;
import com.smartsolutions.eschool.lookups.dtos.language.requestDto.LanguageRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.language.responseDto.LanguageResponseDTO;
import com.smartsolutions.eschool.lookups.facade.LanguageFacade;
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
@RequestMapping("/api/lookups/languages")
@Slf4j
@Tag(name = "Language Management", description = "Endpoints for managing global system languages, including creation, retrieval, and updates.")
public class LanguageController {

    private final LanguageFacade languageFacade;

    public LanguageController(LanguageFacade languageFacade) {
        this.languageFacade = languageFacade;
    }

    @Operation(summary = "Get all languages", description = "Retrieve a list of all global languages registered in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LanguageResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LanguageResponseDTO>> getAll() {
        log.info("[Controller:LanguageController] getAll() called - Request to get all languages");
        List<LanguageResponseDTO> resources = languageFacade.getAll();
        log.info("[Controller:LanguageController] getAll() succeeded - Found {} languages", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get all active languages", description = "Retrieve a list of all active global languages.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LanguageResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LanguageResponseDTO>> getAllActive() {
        log.info("[Controller:LanguageController] getAllActive() called - Request to get all active languages");
        List<LanguageResponseDTO> resources = languageFacade.getAllActive();
        log.info("[Controller:LanguageController] getAllActive() succeeded - Found {} active languages", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get language by ID", description = "Fetch detailed information about a specific language by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved language",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LanguageResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Language not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageResponseDTO> getById(
            @Parameter(description = "Unique ID of the language", example = "1") @PathVariable Long id) {
        log.info("[Controller:LanguageController] getById() called - Request to fetch language with id: {}", id);
        LanguageResponseDTO language = languageFacade.getById(id);
        log.info("[Controller:LanguageController] getById() succeeded - Found language: {}", id);
        return ResponseEntity.ok(language);
    }

    @Operation(summary = "Search languages", description = "Find languages by keyword matching name or ISO code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching languages",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LanguageResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid search keyword",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LanguageResponseDTO>> search(
            @Parameter(description = "Search keyword (name, isoCode)", example = "English") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:LanguageController] search() called - Request to search languages with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<LanguageResponseDTO> responseDTOs = languageFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:LanguageController] search() succeeded - Found {} languages matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @Operation(summary = "Delete language", description = "Soft delete a language from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Language deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Language not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(
            @Parameter(description = "ID of the language to delete", example = "1") @PathVariable Long id) {
        log.info("[Controller:LanguageController] delete() called - Request to delete language: {}", id);
        languageFacade.softDeleteById(id);
        log.info("[Controller:LanguageController] delete() succeeded - Language: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Language deleted successfully"));
    }

    @Operation(summary = "Create new language", description = "Register a new language with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Language created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LanguageResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "Duplicate language ISO code",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageResponseDTO> create(@Valid @RequestBody LanguageRequestDTO requestDTO) {
        log.info("[Controller:LanguageController] create() called - Request to create language: {}", requestDTO.getName());
        LanguageResponseDTO responseDTO = languageFacade.createLanguage(requestDTO);
        log.info("[Controller:LanguageController] create() succeeded - Language created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Update language", description = "Update details of an existing language.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Language updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LanguageResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Language not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "Duplicate language ISO code",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LanguageResponseDTO> update(
            @Parameter(description = "ID of the language to update", example = "1") @PathVariable Long id,
            @Valid @RequestBody LanguageRequestDTO requestDTO) {
        log.info("[Controller:LanguageController] update() called - Request to update language: {}", id);
        LanguageResponseDTO responseDTO = languageFacade.updateLanguage(id, requestDTO);
        log.info("[Controller:LanguageController] update() succeeded - Language: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Get language statistics", description = "Retrieve statistical data overview for languages.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:LanguageController] getStatistics() called");
        Map<String, Long> statistics = languageFacade.getStatistics();
        log.info("[Controller:LanguageController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}

