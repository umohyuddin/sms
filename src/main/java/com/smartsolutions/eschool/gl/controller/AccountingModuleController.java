package com.smartsolutions.eschool.gl.controller;

import com.smartsolutions.eschool.gl.dtos.accountingModule.request.AccountingModuleRequestDTO;
import com.smartsolutions.eschool.gl.dtos.accountingModule.response.AccountingModuleResponseDTO;
import com.smartsolutions.eschool.gl.facade.AccountingModuleFacade;
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
@RequestMapping("/api/gl/accounting-modules")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "GL Accounting Module Management", description = "Endpoints for managing GL Accounting Modules.")
public class AccountingModuleController {

    private final AccountingModuleFacade accountingModuleFacade;

    @Operation(summary = "Get all accounting modules")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AccountingModuleResponseDTO>> getAll() {
        log.info("[Controller:AccountingModuleController] getAll() called");
        return ResponseEntity.ok(accountingModuleFacade.getAll());
    }

    @Operation(summary = "Get accounting module by ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountingModuleResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:AccountingModuleController] getById() called - ID: {}", id);
        return ResponseEntity.ok(accountingModuleFacade.getById(id));
    }

    @Operation(summary = "Create accounting module")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountingModuleResponseDTO> create(@Valid @RequestBody AccountingModuleRequestDTO requestDTO) {
        log.info("[Controller:AccountingModuleController] create() called");
        return ResponseEntity.status(HttpStatus.CREATED).body(accountingModuleFacade.create(requestDTO));
    }

    @Operation(summary = "Update accounting module")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountingModuleResponseDTO> update(@PathVariable Long id, @Valid @RequestBody AccountingModuleRequestDTO requestDTO) {
        log.info("[Controller:AccountingModuleController] update() called - ID: {}", id);
        return ResponseEntity.ok(accountingModuleFacade.update(id, requestDTO));
    }

    @Operation(summary = "Delete accounting module")
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:AccountingModuleController] delete() called - ID: {}", id);
        accountingModuleFacade.delete(id);
        return ResponseEntity.ok(Map.of("message", "Accounting module deleted successfully"));
    }

    @Operation(summary = "Search accounting modules")
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AccountingModuleResponseDTO>> search(@RequestParam String keyword) {
        log.info("[Controller:AccountingModuleController] search() called - Keyword: {}", keyword);
        return ResponseEntity.ok(accountingModuleFacade.search(keyword));
    }
}
