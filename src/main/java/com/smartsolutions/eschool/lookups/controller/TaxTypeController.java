package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.taxType.requestDto.TaxTypeRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.taxType.responseDto.TaxTypeResponseDTO;
import com.smartsolutions.eschool.lookups.facade.TaxTypeFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lookups/tax-types")
@Slf4j
public class TaxTypeController {

    private final TaxTypeFacade taxTypeFacade;

    public TaxTypeController(TaxTypeFacade taxTypeFacade) {
        this.taxTypeFacade = taxTypeFacade;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaxTypeResponseDTO> create(@Valid @RequestBody TaxTypeRequestDTO dto) {
        log.info("POST /api/lookups/tax-types called");
        return ResponseEntity.status(HttpStatus.CREATED).body(taxTypeFacade.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaxTypeResponseDTO>> getAllActive() {
        log.info("GET /api/lookups/tax-types called");
        return ResponseEntity.ok(taxTypeFacade.getAllActive());
    }

    @GetMapping(value = "/country/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaxTypeResponseDTO>> getByCountryId(@PathVariable Long countryId) {
        log.info("GET /api/lookups/tax-types/country/{} called", countryId);
        return ResponseEntity.ok(taxTypeFacade.getByCountryId(countryId));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaxTypeResponseDTO> getById(@PathVariable Long id) {
        log.info("GET /api/lookups/tax-types/{} called", id);
        return ResponseEntity.ok(taxTypeFacade.getById(id));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaxTypeResponseDTO> update(@PathVariable Long id, @Valid @RequestBody TaxTypeRequestDTO dto) {
        log.info("PUT /api/lookups/tax-types/{} called", id);
        return ResponseEntity.ok(taxTypeFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("DELETE /api/lookups/tax-types/{} called", id);
        taxTypeFacade.softDeleteById(id);
        return ResponseEntity.ok("Tax type deleted successfully");
    }
}
