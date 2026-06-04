package com.smartsolutions.eschool.gl.controller;

import com.smartsolutions.eschool.gl.dtos.transactionType.request.TransactionTypeRequestDTO;
import com.smartsolutions.eschool.gl.dtos.transactionType.response.TransactionTypeResponseDTO;
import com.smartsolutions.eschool.gl.facade.TransactionTypeFacade;
import com.smartsolutions.eschool.global.error.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/gl/transaction-types")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "GL Transaction Type Management", description = "Endpoints for managing GL Transaction Types.")
public class TransactionTypeController {

    private final TransactionTypeFacade transactionTypeFacade;

    @Operation(summary = "Get all transaction types")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TransactionTypeResponseDTO>> getAll() {
        log.info("[Controller:TransactionTypeController] getAll() called");
        return ResponseEntity.ok(transactionTypeFacade.getAll());
    }

    @Operation(summary = "Get transaction type by ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionTypeResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:TransactionTypeController] getById() called - ID: {}", id);
        return ResponseEntity.ok(transactionTypeFacade.getById(id));
    }

    @Operation(summary = "Create transaction type")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionTypeResponseDTO> create(@Valid @RequestBody TransactionTypeRequestDTO requestDTO) {
        log.info("[Controller:TransactionTypeController] create() called");
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionTypeFacade.create(requestDTO));
    }

    @Operation(summary = "Update transaction type")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransactionTypeResponseDTO> update(@PathVariable Long id, @Valid @RequestBody TransactionTypeRequestDTO requestDTO) {
        log.info("[Controller:TransactionTypeController] update() called - ID: {}", id);
        return ResponseEntity.ok(transactionTypeFacade.update(id, requestDTO));
    }

    @Operation(summary = "Delete transaction type")
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:TransactionTypeController] delete() called - ID: {}", id);
        transactionTypeFacade.delete(id);
        return ResponseEntity.ok(Map.of("message", "Transaction type deleted successfully"));
    }

    @Operation(summary = "Search transaction types")
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TransactionTypeResponseDTO>> search(@RequestParam String keyword) {
        log.info("[Controller:TransactionTypeController] search() called - Keyword: {}", keyword);
        return ResponseEntity.ok(transactionTypeFacade.search(keyword));
    }
}
