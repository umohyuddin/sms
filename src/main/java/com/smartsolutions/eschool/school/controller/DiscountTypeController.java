package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.facade.DiscountTypeFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/school/discounts/types")
@Slf4j
public class DiscountTypeController {

    private final DiscountTypeFacade discountTypeFacade;

    public DiscountTypeController(DiscountTypeFacade discountTypeFacade) {
        this.discountTypeFacade = discountTypeFacade;
    }

    // ====================================
    // GET ALL
    // ====================================
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiscountTypeResponseDTO>> getAll() {
        log.info("[Controller:DiscountTypeController] getAll() called - Request to get all discount types");
        List<DiscountTypeResponseDTO> resources = discountTypeFacade.getAll();
        log.info("[Controller:DiscountTypeController] getAll() succeeded - Found {} discount types", resources.size());
        return ResponseEntity.ok(resources);
    }

    // ====================================
    // GET ALL ACTIVE
    // ====================================
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiscountTypeResponseDTO>> getAllActive() {
        log.info("[Controller:DiscountTypeController] getAllActive() called");
        List<DiscountTypeResponseDTO> resources = discountTypeFacade.getAllActive();
        log.info("[Controller:DiscountTypeController] getAllActive() succeeded - Found {} active discount types", resources.size());
        return ResponseEntity.ok(resources);
    }

    // ====================================
    // GET ALL INACTIVE
    // ====================================
    @GetMapping(value = "/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiscountTypeResponseDTO>> getAllInActive() {
        log.info("[Controller:DiscountTypeController] getAllInActive() called");
        List<DiscountTypeResponseDTO> resources = discountTypeFacade.getAllInActive();
        log.info("[Controller:DiscountTypeController] getAllInActive() succeeded - Found {} inactive discount types", resources.size());
        return ResponseEntity.ok(resources);
    }

    // ====================================
    // GET BY ID
    // ====================================
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiscountTypeResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:DiscountTypeController] getById() called - id: {}", id);
        DiscountTypeResponseDTO responseDTO = discountTypeFacade.getById(id);
        log.info("[Controller:DiscountTypeController] getById() succeeded - id: {}", id);
        return ResponseEntity.ok(responseDTO);
    }

    // ====================================
    // CREATE
    // ====================================
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiscountTypeResponseDTO> create(@Valid @RequestBody DiscountTypeRequestDTO requestDTO) {
        log.info("[Controller:DiscountTypeController] create() called - name: {}", requestDTO.getName());
        DiscountTypeResponseDTO response = discountTypeFacade.create(requestDTO);
        log.info("[Controller:DiscountTypeController] create() succeeded - Discount Type created with id: {}", response.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // ====================================
    // UPDATE
    // ====================================
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiscountTypeResponseDTO> update(@PathVariable Long id, @Valid @RequestBody DiscountTypeRequestDTO requestDTO) {
        log.info("[Controller:DiscountTypeController] update() called - id: {}", id);
        DiscountTypeResponseDTO updated = discountTypeFacade.update(id, requestDTO);
        log.info("[Controller:DiscountTypeController] update() succeeded - Discount Type: {} updated successfully", updated.getId());
        return ResponseEntity.ok(updated);
    }

    // ====================================
    // DELETE
    // ====================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> softDeleteById(@PathVariable Long id) {
        log.info("[Controller:DiscountTypeController] softDeleteById() called - id: {}", id);
        discountTypeFacade.softDeleteById(id);
        log.info("[Controller:DiscountTypeController] softDeleteById() succeeded - Discount Type: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Discount Type deleted successfully"));
    }

    // ====================================
    // SEARCH
    // ====================================
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiscountTypeResponseDTO>> search(@RequestParam(required = false) String keyword) {
        log.info("[Controller:DiscountTypeController] search() called - keyword: {}", keyword);
        List<DiscountTypeResponseDTO> results = discountTypeFacade.searchByKeyword(keyword);
        log.info("[Controller:DiscountTypeController] search() succeeded - Found {} discount types", results.size());
        return ResponseEntity.ok(results);
    }
}
