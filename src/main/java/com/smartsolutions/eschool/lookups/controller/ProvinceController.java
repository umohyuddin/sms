package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.province.requestDto.ProvinceRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.facade.ProvinceFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lookups/provinces/v1")
@Slf4j
public class ProvinceController {

    private final ProvinceFacade provinceFacade;

    public ProvinceController(ProvinceFacade provinceFacade) {
        this.provinceFacade = provinceFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProvinceResponseDTO>> getAll() {
        log.info("[Controller:ProvinceController] getAll() called - Request to get all provinces");
        List<ProvinceResponseDTO> resources = provinceFacade.getAll();
        log.info("[Controller:ProvinceController] getAll() succeeded - Found {} provinces", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProvinceResponseDTO>> getAllActive() {
        log.info("[Controller:ProvinceController] getAllActive() called - Request to get all active provinces");
        List<ProvinceResponseDTO> resources = provinceFacade.getAllActive();
        log.info("[Controller:ProvinceController] getAllActive() succeeded - Found {} active provinces", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/country/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProvinceResponseDTO>> getByCountryId(@PathVariable Long countryId) {
        log.info("[Controller:ProvinceController] getByCountryId() called - Request to get all provinces for country: {}", countryId);
        List<ProvinceResponseDTO> resources = provinceFacade.getByCountryId(countryId);
        log.info("[Controller:ProvinceController] getByCountryId() succeeded - Found {} provinces", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProvinceResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:ProvinceController] getById() called - Request to fetch province with id: {}", id);
        ProvinceResponseDTO province = provinceFacade.getById(id);
        log.info("[Controller:ProvinceController] getById() succeeded - Found province: {}", id);
        return ResponseEntity.ok(province);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProvinceResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:ProvinceController] search() called - Request to search provinces with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<ProvinceResponseDTO> responseDTOs = provinceFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:ProvinceController] search() succeeded - Found {} provinces matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:ProvinceController] delete() called - Request to delete province: {}", id);
        provinceFacade.softDeleteById(id);
        log.info("[Controller:ProvinceController] delete() succeeded - Province: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Province deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProvinceResponseDTO> create(@Valid @RequestBody ProvinceRequestDTO requestDTO) {
        log.info("[Controller:ProvinceController] create() called - Request to create province: {}", requestDTO.getName());
        ProvinceResponseDTO responseDTO = provinceFacade.create(requestDTO);
        log.info("[Controller:ProvinceController] create() succeeded - Province created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProvinceResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ProvinceRequestDTO requestDTO) {
        log.info("[Controller:ProvinceController] update() called - Request to update province: {}", id);
        ProvinceResponseDTO responseDTO = provinceFacade.update(id, requestDTO);
        log.info("[Controller:ProvinceController] update() succeeded - Province: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:ProvinceController] getStatistics() called");
        Map<String, Long> statistics = provinceFacade.getStatistics();
        log.info("[Controller:ProvinceController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
