package com.smartsolutions.eschool.sclass.controller;

import com.smartsolutions.eschool.sclass.dtos.requestDto.StandardCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.facade.StandardFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/campuses-standards")
@Slf4j
public class StandardController {

    private final StandardFacade standardFacade;

    public StandardController(StandardFacade standardFacade) {
        this.standardFacade = standardFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StandardDTO>> getAll() {
        log.info("[Controller:StandardController] getAll() called - Request to get all standards");
        List<StandardDTO> resources = standardFacade.getAll();
        log.info("[Controller:StandardController] getAll() succeeded - Found {} standards", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardDTO> getById(@PathVariable Long id) {
        log.info("[Controller:StandardController] getById() called - Request to fetch standard with id: {}", id);
        StandardDTO standardDTO = standardFacade.getById(id);
        log.info("[Controller:StandardController] getById() succeeded - Found standard: {}", id);
        return ResponseEntity.ok(standardDTO);
    }

    @GetMapping(value = "/campus/{campusId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StandardDTO>> getByCampusId(@PathVariable Long campusId) {
        log.info("[Controller:StandardController] getByCampusId() called - Request to fetch standards for campus: {}",
                campusId);
        List<StandardDTO> result = standardFacade.getByCampusId(campusId);
        log.info("[Controller:StandardController] getByCampusId() succeeded - Found {} standards", result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StandardDTO>> getStandardsByFilter(@RequestParam(required = false) Long campusId,
            @RequestParam(required = false) String keyword) {
        log.info("[Controller:StandardController] getStandardsByFilter() called - campusId={}, keyword={}", campusId,
                keyword);
        List<StandardDTO> results = standardFacade.getStandardsByFilter(campusId, keyword);
        log.info("[Controller:StandardController] getStandardsByFilter() succeeded - Found {} standards",
                results.size());
        return ResponseEntity.ok(results);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardCreateRequestDTO> createStandard(
            @Valid @RequestBody StandardCreateRequestDTO standardDTO) {
        log.info("[Controller:StandardController] createStandard() called - Request to create standard: {}",
                standardDTO.getStandardName());
        StandardCreateRequestDTO created = standardFacade.create(standardDTO);
        log.info("[Controller:StandardController] createStandard() succeeded - Created standard with id: {}",
                created.getId());
        return ResponseEntity.ok(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardDTO> updateStandard(@PathVariable Long id,
            @Valid @RequestBody StandardCreateRequestDTO dto) {
        log.info("[Controller:StandardController] updateStandard() called - Request to update standard: {}", id);
        StandardDTO updatedStandard = standardFacade.updateStandard(id, dto);
        log.info("[Controller:StandardController] updateStandard() succeeded - Updated standard: {}", id);
        return ResponseEntity.ok(updatedStandard);
    }

    @DeleteMapping("/{standardId}")
    public ResponseEntity<String> softDeleteById(@PathVariable Long standardId) {
        log.info("[Controller:StandardController] softDeleteById() called - Request to delete standard: {}",
                standardId);
        standardFacade.softDeleteById(standardId);
        log.info("[Controller:StandardController] softDeleteById() succeeded - Standard deleted successfully");
        return ResponseEntity.ok("Standard deleted successfully");
    }

    @DeleteMapping("/campus/{campusId}")
    public ResponseEntity<String> softDeleteByCampusId(@PathVariable Long campusId) {
        log.info(
                "[Controller:StandardController] softDeleteByCampusId() called - Request to delete standards for campus: {}",
                campusId);
        int rows = standardFacade.softDeleteByCampusId(campusId);
        log.info("[Controller:StandardController] softDeleteByCampusId() succeeded - {} Standards deleted", rows);
        return ResponseEntity.ok(rows + " Standards deleted");
    }
}
