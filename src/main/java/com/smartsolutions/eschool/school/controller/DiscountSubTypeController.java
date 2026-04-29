package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.discountSubType.requestDto.DiscountSubTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountSubType.responseDto.DiscountSubTypeResponseDTO;
import com.smartsolutions.eschool.school.facade.DiscountSubTypeFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/school/discounts/subtypes")
@Slf4j
public class DiscountSubTypeController {

    private final DiscountSubTypeFacade discountSubTypeFacade;

    public DiscountSubTypeController(DiscountSubTypeFacade discountSubTypeFacade) {
        this.discountSubTypeFacade = discountSubTypeFacade;
    }

    // ====================================
    // GET ALL
    // ====================================
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiscountSubTypeResponseDTO>> getAll() {
        log.info("[Controller:DiscountSubTypeController] getAll() called - Request to get all discount sub types");
        List<DiscountSubTypeResponseDTO> resources = discountSubTypeFacade.getAll();
        log.info("[Controller:DiscountSubTypeController] getAll() succeeded - Found {} discount sub types", resources.size());
        return ResponseEntity.ok(resources);
    }

    // ====================================
    // GET ALL ACTIVE
    // ====================================
    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiscountSubTypeResponseDTO>> getAllActive() {
        log.info("[Controller:DiscountSubTypeController] getAllActive() called");
        List<DiscountSubTypeResponseDTO> resources = discountSubTypeFacade.getAllActive();
        log.info("[Controller:DiscountSubTypeController] getAllActive() succeeded - Found {} active discount sub types", resources.size());
        return ResponseEntity.ok(resources);
    }

    // ====================================
    // GET ALL INACTIVE
    // ====================================
    @GetMapping(value = "/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiscountSubTypeResponseDTO>> getAllInActive() {
        log.info("[Controller:DiscountSubTypeController] getAllInActive() called");
        List<DiscountSubTypeResponseDTO> resources = discountSubTypeFacade.getAllInActive();
        log.info("[Controller:DiscountSubTypeController] getAllInActive() succeeded - Found {} inactive discount sub types", resources.size());
        return ResponseEntity.ok(resources);
    }

    // ====================================
    // GET BY ID
    // ====================================
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiscountSubTypeResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:DiscountSubTypeController] getById() called - id: {}", id);
        DiscountSubTypeResponseDTO responseDTO = discountSubTypeFacade.getById(id);
        log.info("[Controller:DiscountSubTypeController] getById() succeeded - id: {}", id);
        return ResponseEntity.ok(responseDTO);
    }

    // ====================================
    // CREATE
    // ====================================
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiscountSubTypeResponseDTO> create(@Valid @RequestBody DiscountSubTypeRequestDTO requestDTO) {
        log.info("[Controller:DiscountSubTypeController] create() called - name: {}", requestDTO.getName());
        DiscountSubTypeResponseDTO response = discountSubTypeFacade.create(requestDTO);
        log.info("[Controller:DiscountSubTypeController] create() succeeded - Discount Sub Type created with id: {}", response.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // ====================================
    // UPDATE
    // ====================================
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiscountSubTypeResponseDTO> update(@PathVariable Long id, @Valid @RequestBody DiscountSubTypeRequestDTO requestDTO) {
        log.info("[Controller:DiscountSubTypeController] update() called - id: {}", id);
        DiscountSubTypeResponseDTO updated = discountSubTypeFacade.update(id, requestDTO);
        log.info("[Controller:DiscountSubTypeController] update() succeeded - Discount Sub Type: {} updated successfully", updated.getId());
        return ResponseEntity.ok(updated);
    }

    // ====================================
    // DELETE BY ID
    // ====================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> softDeleteById(@PathVariable Long id) {
        log.info("[Controller:DiscountSubTypeController] softDeleteById() called - id: {}", id);
        discountSubTypeFacade.softDeleteById(id);
        log.info("[Controller:DiscountSubTypeController] softDeleteById() succeeded - Discount Sub Type: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Discount Sub Type deleted successfully"));
    }

    // ====================================
    // DELETE ALL
    // ====================================
    @DeleteMapping("/all")
    public ResponseEntity<Map<String, String>> softDeleteAll() {
        log.info("[Controller:DiscountSubTypeController] softDeleteAll() called");
        int rows = discountSubTypeFacade.softDeleteAll();
        log.info("[Controller:DiscountSubTypeController] softDeleteAll() succeeded - {} discount sub types deleted", rows);
        return ResponseEntity.ok(Map.of("message", rows + " Discount Sub Types deleted successfully"));
    }

    // ====================================
    // ACTIVATE
    // ====================================
    @PatchMapping(value = "/{id}/activate")
    public ResponseEntity<Map<String, String>> markAsActive(@PathVariable Long id) {
        log.info("[Controller:DiscountSubTypeController] markAsActive() called - id: {}", id);
        discountSubTypeFacade.markAsActive(id);
        log.info("[Controller:DiscountSubTypeController] markAsActive() succeeded - id: {}", id);
        return ResponseEntity.ok(Map.of("message", "Discount Sub Type marked as active successfully"));
    }

    // ====================================
    // DEACTIVATE
    // ====================================
    @PatchMapping(value = "/{id}/deactivate")
    public ResponseEntity<Map<String, String>> markAsInactive(@PathVariable Long id) {
        log.info("[Controller:DiscountSubTypeController] markAsInactive() called - id: {}", id);
        discountSubTypeFacade.markAsInactive(id);
        log.info("[Controller:DiscountSubTypeController] markAsInactive() succeeded - id: {}", id);
        return ResponseEntity.ok(Map.of("message", "Discount Sub Type marked as inactive successfully"));
    }

    // ====================================
    // SEARCH
    // ====================================
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiscountSubTypeResponseDTO>> search(
            @RequestParam(required = false) Long discountTypeId,
            @RequestParam(required = false) String keyword) {
        log.info("[Controller:DiscountSubTypeController] search() called - discountTypeId: {}, keyword: {}", discountTypeId, keyword);
        List<DiscountSubTypeResponseDTO> result = discountSubTypeFacade.searchDiscountComponents(discountTypeId, keyword);
        log.info("[Controller:DiscountSubTypeController] search() succeeded - Found {} discount sub types", result.size());
        return ResponseEntity.ok(result);
    }

    // ====================================
    // GET ACTIVE BY DISCOUNT TYPE
    // ====================================
    @GetMapping(value = "/byDiscountType/{discountTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiscountSubTypeResponseDTO>> getActiveByDiscountTypeId(@PathVariable Long discountTypeId) {
        log.info("[Controller:DiscountSubTypeController] getActiveByDiscountTypeId() called - discountTypeId: {}", discountTypeId);
        List<DiscountSubTypeResponseDTO> result = discountSubTypeFacade.getActiveByDiscountTypeId(discountTypeId);
        log.info("[Controller:DiscountSubTypeController] getActiveByDiscountTypeId() succeeded - Found {} discount sub types", result.size());
        return ResponseEntity.ok(result);
    }
}
