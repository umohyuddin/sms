package com.smartsolutions.eschool.gl.controller;

import com.smartsolutions.eschool.gl.dtos.accounts.requestDto.GLAccountCreateRequestDTO;
import com.smartsolutions.eschool.gl.dtos.accounts.responseDto.GLAccountResponseDTO;
import com.smartsolutions.eschool.gl.facade.GLAccountFacade;
import com.smartsolutions.eschool.global.error.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gl/accounts")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "GL Account Management", description = "Endpoints for managing General Ledger accounts.")
public class GLAccountController {

    private final GLAccountFacade glAccountFacade;

    @Operation(summary = "Get all GL accounts", description = "Retrieve a list of all GL accounts for the current organization.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GLAccountResponseDTO.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GLAccountResponseDTO>> getAll() {
        log.info("[Controller:GLAccountController] getAll() called");
        List<GLAccountResponseDTO> accounts = glAccountFacade.getAll();
        log.info("[Controller:GLAccountController] getAll() succeeded - Found {} accounts", accounts.size());
        return ResponseEntity.ok(accounts);
    }

    @Operation(summary = "Get GL account by ID", description = "Fetch detailed information about a specific GL account by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved account",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GLAccountResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Account not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GLAccountResponseDTO> getById(
            @Parameter(description = "Unique ID of the account", example = "1") @PathVariable Long id) {
        log.info("[Controller:GLAccountController] getById() called - id: {}", id);
        GLAccountResponseDTO account = glAccountFacade.getById(id);
        log.info("[Controller:GLAccountController] getById() succeeded - Found account: {}", id);
        return ResponseEntity.ok(account);
    }

    @Operation(summary = "Search GL accounts", description = "Find accounts by keyword matching name or code.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved matching accounts",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GLAccountResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid search keyword",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GLAccountResponseDTO>> search(
            @Parameter(description = "Search keyword (name, code)", example = "Cash") @RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:GLAccountController] search() called - keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<GLAccountResponseDTO> accounts = glAccountFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:GLAccountController] search() succeeded - Found {} accounts matching keyword: {}", accounts.size(), keyword);
        return ResponseEntity.ok(accounts);
    }

    @Operation(summary = "Create new GL account", description = "Register a new GL account.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Account created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GLAccountResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "409", description = "Duplicate account code",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GLAccountResponseDTO> create(@Valid @RequestBody GLAccountCreateRequestDTO requestDTO) {
        log.info("[Controller:GLAccountController] create() called - code: {}", requestDTO.getAccountCode());
        GLAccountResponseDTO responseDTO = glAccountFacade.createAccount(requestDTO);
        log.info("[Controller:GLAccountController] create() succeeded - Account created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Update GL account", description = "Update details of an existing GL account.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = GLAccountResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Account not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GLAccountResponseDTO> update(
            @Parameter(description = "ID of the account to update", example = "1") @PathVariable Long id,
            @Valid @RequestBody GLAccountCreateRequestDTO requestDTO) {
        log.info("[Controller:GLAccountController] update() called - id: {}", id);
        GLAccountResponseDTO responseDTO = glAccountFacade.updateAccount(id, requestDTO);
        log.info("[Controller:GLAccountController] update() succeeded - Account: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Delete GL account", description = "Soft delete a GL account.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Account deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(
            @Parameter(description = "ID of the account to delete", example = "1") @PathVariable Long id) {
        log.info("[Controller:GLAccountController] delete() called - id: {}", id);
        glAccountFacade.softDeleteById(id);
        log.info("[Controller:GLAccountController] delete() succeeded - Account: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "GL Account deleted successfully"));
    }

    @Operation(summary = "Get GL account statistics", description = "Retrieve statistical data overview for GL accounts.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved statistics"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:GLAccountController] getStatistics() called");
        Map<String, Long> statistics = glAccountFacade.getStatistics();
        log.info("[Controller:GLAccountController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
