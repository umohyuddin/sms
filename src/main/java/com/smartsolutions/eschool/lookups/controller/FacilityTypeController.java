package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.facilityType.requestDto.FacilityTypeRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.facilityType.responseDto.FacilityTypeResponseDTO;
import com.smartsolutions.eschool.lookups.facade.FacilityTypeFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lookups/facility-types/v1")
@Slf4j
public class FacilityTypeController {

    private final FacilityTypeFacade facilityTypeFacade;

    public FacilityTypeController(FacilityTypeFacade facilityTypeFacade) {
        this.facilityTypeFacade = facilityTypeFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FacilityTypeResponseDTO>> getAll() {
        log.info("[Controller:FacilityTypeController] getAll() called - Request to get all facility types");
        List<FacilityTypeResponseDTO> resources = facilityTypeFacade.getAll();
        log.info("[Controller:FacilityTypeController] getAll() succeeded - Found {} facility types", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FacilityTypeResponseDTO>> getAllActive() {
        log.info("[Controller:FacilityTypeController] getAllActive() called - Request to get all active facility types");
        List<FacilityTypeResponseDTO> resources = facilityTypeFacade.getAllActive();
        log.info("[Controller:FacilityTypeController] getAllActive() succeeded - Found {} active facility types", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacilityTypeResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:FacilityTypeController] getById() called - Request to fetch facility type with id: {}", id);
        FacilityTypeResponseDTO facilityType = facilityTypeFacade.getById(id);
        log.info("[Controller:FacilityTypeController] getById() succeeded - Found facility type: {}", id);
        return ResponseEntity.ok(facilityType);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FacilityTypeResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:FacilityTypeController] search() called - Request to search facility types with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<FacilityTypeResponseDTO> responseDTOs = facilityTypeFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:FacilityTypeController] search() succeeded - Found {} facility types matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:FacilityTypeController] delete() called - Request to delete facility type: {}", id);
        facilityTypeFacade.softDeleteById(id);
        log.info("[Controller:FacilityTypeController] delete() succeeded - Facility type: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Facility type deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacilityTypeResponseDTO> create(@Valid @RequestBody FacilityTypeRequestDTO requestDTO) {
        log.info("[Controller:FacilityTypeController] create() called - Request to create facility type: {}", requestDTO.getName());
        FacilityTypeResponseDTO responseDTO = facilityTypeFacade.create(requestDTO);
        log.info("[Controller:FacilityTypeController] create() succeeded - Facility type created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacilityTypeResponseDTO> update(@PathVariable Long id, @Valid @RequestBody FacilityTypeRequestDTO requestDTO) {
        log.info("[Controller:FacilityTypeController] update() called - Request to update facility type: {}", id);
        FacilityTypeResponseDTO responseDTO = facilityTypeFacade.update(id, requestDTO);
        log.info("[Controller:FacilityTypeController] update() succeeded - Facility type: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:FacilityTypeController] getStatistics() called");
        Map<String, Long> statistics = facilityTypeFacade.getStatistics();
        log.info("[Controller:FacilityTypeController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
