package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.city.requestDto.CityRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.facade.CityFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lookups/cities/v1")
@Slf4j
public class CityController {

    private final CityFacade cityFacade;

    public CityController(CityFacade cityFacade) {
        this.cityFacade = cityFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityResponseDTO>> getAll() {
        log.info("[Controller:CityController] getAll() called - Request to get all cities");
        List<CityResponseDTO> resources = cityFacade.getAll();
        log.info("[Controller:CityController] getAll() succeeded - Found {} cities", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityResponseDTO>> getAllActive() {
        log.info("[Controller:CityController] getAllActive() called - Request to get all active cities");
        List<CityResponseDTO> resources = cityFacade.getAllActive();
        log.info("[Controller:CityController] getAllActive() succeeded - Found {} active cities", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/province/{provinceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityResponseDTO>> getByProvinceId(@PathVariable Long provinceId) {
        log.info("[Controller:CityController] getByProvinceId() called - Request to get all cities for province: {}", provinceId);
        List<CityResponseDTO> resources = cityFacade.getByProvinceId(provinceId);
        log.info("[Controller:CityController] getByProvinceId() succeeded - Found {} cities", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:CityController] getById() called - Request to fetch city with id: {}", id);
        CityResponseDTO city = cityFacade.getById(id);
        log.info("[Controller:CityController] getById() succeeded - Found city: {}", id);
        return ResponseEntity.ok(city);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CityResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:CityController] search() called - Request to search cities with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<CityResponseDTO> responseDTOs = cityFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:CityController] search() succeeded - Found {} cities matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:CityController] delete() called - Request to delete city: {}", id);
        cityFacade.softDeleteById(id);
        log.info("[Controller:CityController] delete() succeeded - City: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "City deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityResponseDTO> create(@Valid @RequestBody CityRequestDTO requestDTO) {
        log.info("[Controller:CityController] create() called - Request to create city: {}", requestDTO.getName());
        CityResponseDTO responseDTO = cityFacade.create(requestDTO);
        log.info("[Controller:CityController] create() succeeded - City created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CityResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CityRequestDTO requestDTO) {
        log.info("[Controller:CityController] update() called - Request to update city: {}", id);
        CityResponseDTO responseDTO = cityFacade.update(id, requestDTO);
        log.info("[Controller:CityController] update() succeeded - City: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:CityController] getStatistics() called");
        Map<String, Long> statistics = cityFacade.getStatistics();
        log.info("[Controller:CityController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
