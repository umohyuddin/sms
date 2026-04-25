package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.institute.request.InstituteRequestDTO;
import com.smartsolutions.eschool.school.dtos.institute.response.InstituteResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import com.smartsolutions.eschool.global.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/institute")
@Slf4j
@Tag(name = "Institute Management", description = "Endpoints for managing the institute profile, including retrieval, updates, statistics, and metadata.")
public class InstituteController {

    private final InstituteFacade nInstituteFacade;

    public InstituteController(InstituteFacade nInstituteFacade) {
        this.nInstituteFacade = nInstituteFacade;
    }

    @Operation(summary = "Get institute profile", description = "Retrieve the singleton institute profile details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved institute profile",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = InstituteResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Institute not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteResponseDTO> getInstitute() {
        log.info("[Controller:InstituteController] getInstitute() called");
        InstituteResponseDTO responseDTO = nInstituteFacade.getInstitute();
        log.info("[Controller:InstituteController] getInstitute() succeeded");
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Get institute by ID", description = "Retrieve a specific institute profile by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved institute",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = InstituteResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Institute not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteResponseDTO> getById(
            @Parameter(description = "ID of the institute", example = "1") @PathVariable Long id) {
        log.info("[Controller:InstituteController] getById() called - id: {}", id);
        InstituteResponseDTO responseDTO = nInstituteFacade.getById(id);
        log.info("[Controller:InstituteController] getById() succeeded - id: {}", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Update institute profile", description = "Update the details of the institute profile.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Institute updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = InstituteResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteResponseDTO> update(@RequestBody @Valid InstituteRequestDTO requestDTO) {
        log.info("[Controller:InstituteController] update() called");
        InstituteResponseDTO responseDTO = nInstituteFacade.updateInstitute(requestDTO);
        log.info("[Controller:InstituteController] update() succeeded");
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Get institute statistics", description = "Retrieve statistical overview for the institute (e.g., campus counts).")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<java.util.Map<String, Long>> getStatistics() {
        log.info("[Controller:InstituteController] getStatistics() called");
        java.util.Map<String, Long> stats = nInstituteFacade.getStatistics();
        log.info("[Controller:InstituteController] getStatistics() succeeded");
        return ResponseEntity.ok(stats);
    }

    @Operation(summary = "Get institute metadata", description = "Retrieve lookup data for countries, provinces, and cities.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved metadata"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/metadata", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<com.smartsolutions.eschool.school.dtos.institute.metaData.InstituteMetaData> getMetaData() {
        log.info("[Controller:InstituteController] getMetaData() called");
        com.smartsolutions.eschool.school.dtos.institute.metaData.InstituteMetaData metaData = nInstituteFacade.getInstituteMetaData();
        log.info("[Controller:InstituteController] getMetaData() succeeded");
        return ResponseEntity.ok(metaData);
    }
}

