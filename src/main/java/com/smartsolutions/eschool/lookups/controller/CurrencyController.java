package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.currency.requestDto.CurrencyRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.currency.responseDto.CurrencyResponseDTO;
import com.smartsolutions.eschool.lookups.facade.CurrencyFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lookups/currencies")
@Slf4j
public class CurrencyController {

    private final CurrencyFacade currencyFacade;

    public CurrencyController(CurrencyFacade currencyFacade) {
        this.currencyFacade = currencyFacade;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> create(@Valid @RequestBody CurrencyRequestDTO dto) {
        log.info("POST /api/lookups/currencies called");
        return ResponseEntity.status(HttpStatus.CREATED).body(currencyFacade.createCurrency(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurrencyResponseDTO>> getAllActive() {
        log.info("GET /api/lookups/currencies called");
        return ResponseEntity.ok(currencyFacade.getAllActive());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> getById(@PathVariable Integer id) {
        log.info("GET /api/lookups/currencies/{} called", id);
        return ResponseEntity.ok(currencyFacade.getById(id));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> update(@PathVariable Integer id, @Valid @RequestBody CurrencyRequestDTO dto) {
        log.info("PUT /api/lookups/currencies/{} called", id);
        return ResponseEntity.ok(currencyFacade.updateCurrency(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        log.info("DELETE /api/lookups/currencies/{} called", id);
        currencyFacade.softDeleteById(id);
        return ResponseEntity.ok("Currency deleted successfully");
    }
}
