package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.chargetype.request.ChargeTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.chargetype.response.ChargeTypeResponseDTO;
import com.smartsolutions.eschool.school.facade.ChargeTypeFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lookups/charge-type")
@Slf4j
public class ChargeTypeController {

    private final ChargeTypeFacade chargeTypeFacade;

    public ChargeTypeController(ChargeTypeFacade chargeTypeFacade) {
        this.chargeTypeFacade = chargeTypeFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChargeTypeResponseDTO> create(@RequestBody @Valid ChargeTypeRequestDTO requestDTO) {
        log.info("[Controller:ChargeTypeController] create() called - Request to create charge type: {}",
                requestDTO.getName());
        ChargeTypeResponseDTO responseDTO = chargeTypeFacade.createChargeType(requestDTO);
        log.info("[Controller:ChargeTypeController] create() succeeded - Created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ChargeTypeResponseDTO>> getAll() {
        log.info("[Controller:ChargeTypeController] getAll() called");
        List<ChargeTypeResponseDTO> resources = chargeTypeFacade.getAll();
        log.info("[Controller:ChargeTypeController] getAll() succeeded - Found {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ChargeTypeResponseDTO>> getAllActive() {
        log.info("[Controller:ChargeTypeController] getAllActive() called");
        List<ChargeTypeResponseDTO> resources = chargeTypeFacade.getAllActive();
        log.info("[Controller:ChargeTypeController] getAllActive() succeeded - Found {} active resources",
                resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChargeTypeResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:ChargeTypeController] getById() called - id: {}", id);
        ChargeTypeResponseDTO resource = chargeTypeFacade.getById(id);
        log.info("[Controller:ChargeTypeController] getById() succeeded");
        return ResponseEntity.ok(resource);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ChargeTypeResponseDTO> update(@PathVariable Long id,
            @RequestBody @Valid ChargeTypeRequestDTO requestDTO) {
        log.info("[Controller:ChargeTypeController] update() called - id: {}", id);
        ChargeTypeResponseDTO responseDTO = chargeTypeFacade.update(id, requestDTO);
        log.info("[Controller:ChargeTypeController] update() succeeded");
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:ChargeTypeController] delete() called - id: {}", id);
        chargeTypeFacade.delete(id);
        log.info("[Controller:ChargeTypeController] delete() succeeded");
        return ResponseEntity.ok(Map.of("message", "Charge Type deleted successfully"));
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ChargeTypeResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:ChargeTypeController] search() called - keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<ChargeTypeResponseDTO> results = chargeTypeFacade.search(keyword.trim());
        log.info("[Controller:ChargeTypeController] search() succeeded - Found {} results", results.size());
        return ResponseEntity.ok(results);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<java.util.Map<String, Long>> getStatistics() {
        log.info("[Controller:ChargeTypeController] getStatistics() called");
        java.util.Map<String, Long> statistics = chargeTypeFacade.getStatistics();
        log.info("[Controller:ChargeTypeController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
