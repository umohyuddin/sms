package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.requestDto.FeeRecurrenceRuleRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import com.smartsolutions.eschool.lookups.facade.FeeRecurrenceRuleFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lookups/fee-recurrence-rules")
@Slf4j
public class FeeRecurrenceRuleController {

    private final FeeRecurrenceRuleFacade facade;

    public FeeRecurrenceRuleController(FeeRecurrenceRuleFacade facade) {
        this.facade = facade;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeRecurrenceRuleResponseDTO> create(@Valid @RequestBody FeeRecurrenceRuleRequestDTO dto) {
        log.info("POST /api/lookups/fee-recurrence-rules called");
        return ResponseEntity.status(HttpStatus.CREATED).body(facade.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeRecurrenceRuleResponseDTO>> getAllActive() {
        log.info("GET /api/lookups/fee-recurrence-rules called");
        return ResponseEntity.ok(facade.getAllActive());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeRecurrenceRuleResponseDTO> getById(@PathVariable Long id) {
        log.info("GET /api/lookups/fee-recurrence-rules/{} called", id);
        return ResponseEntity.ok(facade.getById(id));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeRecurrenceRuleResponseDTO> update(@PathVariable Long id, @Valid @RequestBody FeeRecurrenceRuleRequestDTO dto) {
        log.info("PUT /api/lookups/fee-recurrence-rules/{} called", id);
        return ResponseEntity.ok(facade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("DELETE /api/lookups/fee-recurrence-rules/{} called", id);
        facade.softDeleteById(id);
        return ResponseEntity.ok("Fee recurrence rule deleted successfully");
    }
}
