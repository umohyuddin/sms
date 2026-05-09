package com.smartsolutions.eschool.gl.controller;

import com.smartsolutions.eschool.gl.dtos.businessKey.request.BusinessKeyRequestDTO;
import com.smartsolutions.eschool.gl.dtos.businessKey.response.BusinessKeyResponseDTO;
import com.smartsolutions.eschool.gl.facade.BusinessKeyFacade;
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
@RequestMapping("/api/gl/business-keys")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "GL Business Key Management", description = "Endpoints for managing GL Business Keys.")
public class BusinessKeyController {

    private final BusinessKeyFacade businessKeyFacade;

    @Operation(summary = "Get all business keys")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BusinessKeyResponseDTO>> getAll() {
        log.info("[Controller:BusinessKeyController] getAll() called");
        return ResponseEntity.ok(businessKeyFacade.getAll());
    }

    @Operation(summary = "Get business key by ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BusinessKeyResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:BusinessKeyController] getById() called - ID: {}", id);
        return ResponseEntity.ok(businessKeyFacade.getById(id));
    }

    @Operation(summary = "Create business key")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BusinessKeyResponseDTO> create(@Valid @RequestBody BusinessKeyRequestDTO requestDTO) {
        log.info("[Controller:BusinessKeyController] create() called");
        return ResponseEntity.status(HttpStatus.CREATED).body(businessKeyFacade.create(requestDTO));
    }

    @Operation(summary = "Update business key")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BusinessKeyResponseDTO> update(@PathVariable Long id, @Valid @RequestBody BusinessKeyRequestDTO requestDTO) {
        log.info("[Controller:BusinessKeyController] update() called - ID: {}", id);
        return ResponseEntity.ok(businessKeyFacade.update(id, requestDTO));
    }

    @Operation(summary = "Delete business key")
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:BusinessKeyController] delete() called - ID: {}", id);
        businessKeyFacade.delete(id);
        return ResponseEntity.ok(Map.of("message", "Business key deleted successfully"));
    }

    @Operation(summary = "Search business keys")
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BusinessKeyResponseDTO>> search(@RequestParam String keyword) {
        log.info("[Controller:BusinessKeyController] search() called - Keyword: {}", keyword);
        return ResponseEntity.ok(businessKeyFacade.search(keyword));
    }
}
