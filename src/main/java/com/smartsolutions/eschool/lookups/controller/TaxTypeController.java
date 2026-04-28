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
import java.util.Map;

@RestController
@RequestMapping("/api/lookups/tax-types")
@Slf4j
public class TaxTypeController {

    private final TaxTypeFacade taxTypeFacade;

    public TaxTypeController(TaxTypeFacade taxTypeFacade) {
        this.taxTypeFacade = taxTypeFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaxTypeResponseDTO>> getAll() {
        log.info("[Controller:TaxTypeController] getAll() called - Request to get all tax types");
        List<TaxTypeResponseDTO> resources = taxTypeFacade.getAll();
        log.info("[Controller:TaxTypeController] getAll() succeeded - Found {} tax types", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaxTypeResponseDTO>> getAllActive() {
        log.info("[Controller:TaxTypeController] getAllActive() called - Request to get all active tax types");
        List<TaxTypeResponseDTO> resources = taxTypeFacade.getAllActive();
        log.info("[Controller:TaxTypeController] getAllActive() succeeded - Found {} active tax types",
                resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaxTypeResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:TaxTypeController] getById() called - Request to fetch tax type with id: {}", id);
        TaxTypeResponseDTO taxType = taxTypeFacade.getById(id);
        log.info("[Controller:TaxTypeController] getById() succeeded - Found tax type: {}", id);
        return ResponseEntity.ok(taxType);
    }

    @GetMapping(value = "/country/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaxTypeResponseDTO>> getByCountryId(@PathVariable Long countryId) {
        log.info("[Controller:TaxTypeController] getByCountryId() called - countryId: {}", countryId);
        List<TaxTypeResponseDTO> resources = taxTypeFacade.getByCountryId(countryId);
        log.info("[Controller:TaxTypeController] getByCountryId() succeeded - Found {} tax types for country: {}",
                resources.size(), countryId);
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TaxTypeResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:TaxTypeController] search() called - Request to search tax types with keyword: {}",
                keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<TaxTypeResponseDTO> responseDTOs = taxTypeFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:TaxTypeController] search() succeeded - Found {} tax types matching keyword: {}",
                responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:TaxTypeController] delete() called - Request to delete tax type: {}", id);
        taxTypeFacade.softDeleteById(id);
        log.info("[Controller:TaxTypeController] delete() succeeded - Tax type: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Tax type deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaxTypeResponseDTO> create(@Valid @RequestBody TaxTypeRequestDTO requestDTO) {
        log.info("[Controller:TaxTypeController] create() called - Request to create tax type: {}",
                requestDTO.getCode());
        TaxTypeResponseDTO responseDTO = taxTypeFacade.createTaxType(requestDTO);
        log.info("[Controller:TaxTypeController] create() succeeded - Tax type created with id: {}",
                responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaxTypeResponseDTO> update(@PathVariable Long id,
            @Valid @RequestBody TaxTypeRequestDTO requestDTO) {
        log.info("[Controller:TaxTypeController] update() called - Request to update tax type: {}", id);
        TaxTypeResponseDTO responseDTO = taxTypeFacade.updateTaxType(id, requestDTO);
        log.info("[Controller:TaxTypeController] update() succeeded - Tax type: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:TaxTypeController] getStatistics() called");
        Map<String, Long> statistics = taxTypeFacade.getStatistics();
        log.info("[Controller:TaxTypeController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
