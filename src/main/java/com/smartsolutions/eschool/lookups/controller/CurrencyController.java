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
import java.util.Map;

@RestController
@RequestMapping("/api/lookups/currencies/v1")
@Slf4j
public class CurrencyController {

    private final CurrencyFacade currencyFacade;

    public CurrencyController(CurrencyFacade currencyFacade) {
        this.currencyFacade = currencyFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurrencyResponseDTO>> getAll() {
        log.info("[Controller:CurrencyController] getAll() called - Request to get all currencies");
        List<CurrencyResponseDTO> resources = currencyFacade.getAll();
        log.info("[Controller:CurrencyController] getAll() succeeded - Found {} currencies", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurrencyResponseDTO>> getAllActive() {
        log.info("[Controller:CurrencyController] getAllActive() called - Request to get all active currencies");
        List<CurrencyResponseDTO> resources = currencyFacade.getAllActive();
        log.info("[Controller:CurrencyController] getAllActive() succeeded - Found {} active currencies", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> getById(@PathVariable Integer id) {
        log.info("[Controller:CurrencyController] getById() called - Request to fetch currency with id: {}", id);
        CurrencyResponseDTO currency = currencyFacade.getById(id);
        log.info("[Controller:CurrencyController] getById() succeeded - Found currency: {}", id);
        return ResponseEntity.ok(currency);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurrencyResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:CurrencyController] search() called - Request to search currencies with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<CurrencyResponseDTO> responseDTOs = currencyFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:CurrencyController] search() succeeded - Found {} currencies matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Integer id) {
        log.info("[Controller:CurrencyController] delete() called - Request to delete currency: {}", id);
        currencyFacade.softDeleteById(id);
        log.info("[Controller:CurrencyController] delete() succeeded - Currency: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Currency deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> create(@Valid @RequestBody CurrencyRequestDTO requestDTO) {
        log.info("[Controller:CurrencyController] create() called - Request to create currency: {}", requestDTO.getName());
        CurrencyResponseDTO responseDTO = currencyFacade.createCurrency(requestDTO);
        log.info("[Controller:CurrencyController] create() succeeded - Currency created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurrencyResponseDTO> update(@PathVariable Integer id, @Valid @RequestBody CurrencyRequestDTO requestDTO) {
        log.info("[Controller:CurrencyController] update() called - Request to update currency: {}", id);
        CurrencyResponseDTO responseDTO = currencyFacade.updateCurrency(id, requestDTO);
        log.info("[Controller:CurrencyController] update() succeeded - Currency: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:CurrencyController] getStatistics() called");
        Map<String, Long> statistics = currencyFacade.getStatistics();
        log.info("[Controller:CurrencyController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
