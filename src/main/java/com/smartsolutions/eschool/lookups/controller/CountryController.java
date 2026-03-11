package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.country.request.CountryRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.country.response.CountryResponseDTO;
import com.smartsolutions.eschool.lookups.facade.CountryFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lookups/countries/v1")
@Slf4j
public class CountryController {

    private final CountryFacade countryFacade;

    public CountryController(CountryFacade countryFacade) {
        this.countryFacade = countryFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryResponseDTO>> getAll() {
        log.info("[Controller:CountryController] getAll() called - Request to get all countries");
        List<CountryResponseDTO> resources = countryFacade.getAll();
        log.info("[Controller:CountryController] getAll() succeeded - Found {} countries", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryResponseDTO>> getAllActive() {
        log.info("[Controller:CountryController] getAllActive() called - Request to get all active countries");
        List<CountryResponseDTO> resources = countryFacade.getAllActive();
        log.info("[Controller:CountryController] getAllActive() succeeded - Found {} active countries", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:CountryController] getById() called - Request to fetch country with id: {}", id);
        CountryResponseDTO country = countryFacade.getById(id);
        log.info("[Controller:CountryController] getById() succeeded - Found country: {}", id);
        return ResponseEntity.ok(country);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:CountryController] search() called - Request to search countries with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<CountryResponseDTO> responseDTOs = countryFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:CountryController] search() succeeded - Found {} countries matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:CountryController] delete() called - Request to delete country: {}", id);
        countryFacade.softDeleteById(id);
        log.info("[Controller:CountryController] delete() succeeded - Country: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Country deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryResponseDTO> create(@Valid @RequestBody CountryRequestDTO requestDTO) {
        log.info("[Controller:CountryController] create() called - Request to create country: {}", requestDTO.getCountryName());
        CountryResponseDTO responseDTO = countryFacade.create(requestDTO);
        log.info("[Controller:CountryController] create() succeeded - Country created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CountryResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CountryRequestDTO requestDTO) {
        log.info("[Controller:CountryController] update() called - Request to update country: {}", id);
        CountryResponseDTO responseDTO = countryFacade.update(id, requestDTO);
        log.info("[Controller:CountryController] update() succeeded - Country: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:CountryController] getStatistics() called");
        Map<String, Long> statistics = countryFacade.getStatistics();
        log.info("[Controller:CountryController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
