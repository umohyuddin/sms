package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.discountRate.requestDto.DiscountRateRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountRate.responseDto.DiscountRateResponseDTO;
import com.smartsolutions.eschool.school.facade.DiscountRateFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/school/discounts/rates")
@Slf4j
public class DiscountRateController {

    private final DiscountRateFacade discountRateFacade;

    public DiscountRateController(DiscountRateFacade discountRateFacade) {
        this.discountRateFacade = discountRateFacade;
    }

    // ====================================
    // GET ALL
    // ====================================
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiscountRateResponseDTO>> getAll() {
        log.info("[Controller:DiscountRateController] getAll() called - Request to get all discount rates");
        List<DiscountRateResponseDTO> resources = discountRateFacade.getAll();
        log.info("[Controller:DiscountRateController] getAll() succeeded - Found {} discount rates", resources.size());
        return ResponseEntity.ok(resources);
    }

    // ====================================
    // GET BY ID
    // ====================================
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiscountRateResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:DiscountRateController] getById() called - id: {}", id);
        DiscountRateResponseDTO responseDTO = discountRateFacade.getById(id);
        log.info("[Controller:DiscountRateController] getById() succeeded - id: {}", id);
        return ResponseEntity.ok(responseDTO);
    }

    // ====================================
    // GET BY CAMPUS AND ACADEMIC YEAR
    // ====================================
    @GetMapping(value = "/byCampusYear", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiscountRateResponseDTO>> getByCampusAndYear(
            @RequestParam Long campusId,
            @RequestParam Long academicYearId) {
        log.info("[Controller:DiscountRateController] getByCampusAndYear() called - campusId: {}, academicYearId: {}", campusId, academicYearId);
        List<DiscountRateResponseDTO> resources = discountRateFacade.getDiscountRatesByCampusAndAcademicYear(campusId, academicYearId);
        log.info("[Controller:DiscountRateController] getByCampusAndYear() succeeded - Found {} discount rates", resources.size());
        return ResponseEntity.ok(resources);
    }

    // ====================================
    // GET BY CAMPUS
    // ====================================
    @GetMapping(value = "/byCampus", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiscountRateResponseDTO>> getAllByCampus(@RequestParam Long campusId) {
        log.info("[Controller:DiscountRateController] getAllByCampus() called - campusId: {}", campusId);
        List<DiscountRateResponseDTO> resources = discountRateFacade.getAllByCampus(campusId);
        log.info("[Controller:DiscountRateController] getAllByCampus() succeeded - Found {} discount rates", resources.size());
        return ResponseEntity.ok(resources);
    }

    // ====================================
    // GET BY ACADEMIC YEAR
    // ====================================
    @GetMapping(value = "/byAcademicYear", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiscountRateResponseDTO>> getAllByAcademicYear(@RequestParam Long academicYearId) {
        log.info("[Controller:DiscountRateController] getAllByAcademicYear() called - academicYearId: {}", academicYearId);
        List<DiscountRateResponseDTO> resources = discountRateFacade.getAllByAcademicYear(academicYearId);
        log.info("[Controller:DiscountRateController] getAllByAcademicYear() succeeded - Found {} discount rates", resources.size());
        return ResponseEntity.ok(resources);
    }

    // ====================================
    // CREATE
    // ====================================
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiscountRateResponseDTO> create(@Valid @RequestBody DiscountRateRequestDTO requestDTO) {
        log.info("[Controller:DiscountRateController] create() called - discountSubTypeId: {}", requestDTO.getDiscountSubTypeId());
        DiscountRateResponseDTO response = discountRateFacade.create(requestDTO);
        log.info("[Controller:DiscountRateController] create() succeeded - Discount Rate created with id: {}", response.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // ====================================
    // UPDATE
    // ====================================
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiscountRateResponseDTO> update(@PathVariable Long id, @Valid @RequestBody DiscountRateRequestDTO requestDTO) {
        log.info("[Controller:DiscountRateController] update() called - id: {}", id);
        DiscountRateResponseDTO updated = discountRateFacade.update(id, requestDTO);
        log.info("[Controller:DiscountRateController] update() succeeded - Discount Rate: {} updated successfully", updated.getId());
        return ResponseEntity.ok(updated);
    }

    // ====================================
    // DELETE BY ID
    // ====================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> softDeleteById(@PathVariable Long id) {
        log.info("[Controller:DiscountRateController] softDeleteById() called - id: {}", id);
        discountRateFacade.softDeleteById(id);
        log.info("[Controller:DiscountRateController] softDeleteById() succeeded - Discount Rate: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Discount Rate deleted successfully"));
    }

    // ====================================
    // DELETE ALL
    // ====================================
    @DeleteMapping("/all")
    public ResponseEntity<Map<String, String>> softDeleteAll() {
        log.info("[Controller:DiscountRateController] softDeleteAll() called");
        int rows = discountRateFacade.softDeleteAll();
        log.info("[Controller:DiscountRateController] softDeleteAll() succeeded - {} discount rates deleted", rows);
        return ResponseEntity.ok(Map.of("message", rows + " Discount Rates deleted successfully"));
    }

    // ====================================
    // ACTIVATE
    // ====================================
    @PatchMapping(value = "/{id}/activate")
    public ResponseEntity<Map<String, String>> markAsActive(@PathVariable Long id) {
        log.info("[Controller:DiscountRateController] markAsActive() called - id: {}", id);
        discountRateFacade.markAsActive(id);
        log.info("[Controller:DiscountRateController] markAsActive() succeeded - id: {}", id);
        return ResponseEntity.ok(Map.of("message", "Discount Rate marked as active successfully"));
    }

    // ====================================
    // DEACTIVATE
    // ====================================
    @PatchMapping(value = "/{id}/deactivate")
    public ResponseEntity<Map<String, String>> markAsInactive(@PathVariable Long id) {
        log.info("[Controller:DiscountRateController] markAsInactive() called - id: {}", id);
        discountRateFacade.markAsInactive(id);
        log.info("[Controller:DiscountRateController] markAsInactive() succeeded - id: {}", id);
        return ResponseEntity.ok(Map.of("message", "Discount Rate marked as inactive successfully"));
    }

    // ====================================
    // SEARCH
    // ====================================
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DiscountRateResponseDTO>> search(
            @RequestParam(required = false) Long discountTypeId,
            @RequestParam(required = false) Long discountSubTypeId,
            @RequestParam(required = false) Long recurrenceRuleId,
            @RequestParam(required = false) String keyword) {
        log.info("[Controller:DiscountRateController] search() called - discountTypeId: {}, discountSubTypeId: {}, recurrenceRuleId: {}, keyword: {}",
                discountTypeId, discountSubTypeId, recurrenceRuleId, keyword);
        List<DiscountRateResponseDTO> list = discountRateFacade.search(discountTypeId, discountSubTypeId, recurrenceRuleId, keyword);
        log.info("[Controller:DiscountRateController] search() succeeded - Found {} discount rates", list.size());
        return ResponseEntity.ok(list);
    }
}
