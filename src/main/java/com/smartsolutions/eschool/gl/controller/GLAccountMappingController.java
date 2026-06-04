package com.smartsolutions.eschool.gl.controller;

import com.smartsolutions.eschool.gl.dtos.glAccountMapping.request.GLAccountMappingRequestDTO;
import com.smartsolutions.eschool.gl.dtos.glAccountMapping.response.GLAccountMappingResponseDTO;
import com.smartsolutions.eschool.gl.facade.GLAccountMappingFacade;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/gl/account-mappings")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "GL Account Mapping Management", description = "Endpoints for managing automated GL Account Mapping rules.")
public class GLAccountMappingController {

    private final GLAccountMappingFacade mappingFacade;

    @Operation(summary = "Get all account mappings")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GLAccountMappingResponseDTO>> getAll() {
        log.info("[Controller:GLAccountMappingController] getAll() called");
        return ResponseEntity.ok(mappingFacade.getAll());
    }

    @Operation(summary = "Get account mapping by ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GLAccountMappingResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:GLAccountMappingController] getById() called - ID: {}", id);
        return ResponseEntity.ok(mappingFacade.getById(id));
    }

    @Operation(summary = "Create account mapping")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GLAccountMappingResponseDTO> create(@Valid @RequestBody GLAccountMappingRequestDTO requestDTO) {
        log.info("[Controller:GLAccountMappingController] create() called");
        return ResponseEntity.status(HttpStatus.CREATED).body(mappingFacade.create(requestDTO));
    }

    @Operation(summary = "Update account mapping")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GLAccountMappingResponseDTO> update(@PathVariable Long id, @Valid @RequestBody GLAccountMappingRequestDTO requestDTO) {
        log.info("[Controller:GLAccountMappingController] update() called - ID: {}", id);
        return ResponseEntity.ok(mappingFacade.update(id, requestDTO));
    }

    @Operation(summary = "Delete account mapping")
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:GLAccountMappingController] delete() called - ID: {}", id);
        mappingFacade.delete(id);
        return ResponseEntity.ok(Map.of("message", "Account mapping rule deleted successfully"));
    }

    @Operation(summary = "Search account mappings")
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GLAccountMappingResponseDTO>> search(@RequestParam String keyword) {
        log.info("[Controller:GLAccountMappingController] search() called - Keyword: {}", keyword);
        return ResponseEntity.ok(mappingFacade.search(keyword));
    }
}
