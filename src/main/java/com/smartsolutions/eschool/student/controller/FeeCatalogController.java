package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.feeCatalog.requestDto.FeeCatalogRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import com.smartsolutions.eschool.student.facade.FeeCatalogFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fee/catalogs")
@Slf4j
public class FeeCatalogController {

    private final FeeCatalogFacade feeCatalogFacade;

    public FeeCatalogController(FeeCatalogFacade feeCatalogFacade) {
        this.feeCatalogFacade = feeCatalogFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeCatalogDTO>> getAll() {
        log.info("[Controller:FeeCatalogController] getAll() called - Request to get all fee catalogs");
        List<FeeCatalogDTO> resources = feeCatalogFacade.getAll();
        log.info("[Controller:FeeCatalogController] getAll() succeeded - Found {} catalogs", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeCatalogDTO> getById(@PathVariable Long id) {
        log.info("[Controller:FeeCatalogController] getById() called - Request to fetch catalog with id: {}", id);
        FeeCatalogDTO catalog = feeCatalogFacade.getById(id);
        log.info("[Controller:FeeCatalogController] getById() succeeded - Found catalog: {}", id);
        return ResponseEntity.ok(catalog);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeCatalogDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:FeeCatalogController] search() called - Request to search catalogs with keyword: {}",
                keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<FeeCatalogDTO> responseDTOs = feeCatalogFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:FeeCatalogController] search() succeeded - Found {} catalogs matching keyword: {}",
                responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeCatalogDTO> create(@Valid @RequestBody FeeCatalogRequestDTO requestDTO) {
        log.info("[Controller:FeeCatalogController] create() called - Request to create catalog: {}",
                requestDTO.getName());
        FeeCatalogDTO responseDTO = feeCatalogFacade.createFeeCatalog(requestDTO);
        log.info("[Controller:FeeCatalogController] create() succeeded - Catalog created with id: {}",
                responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeCatalogDTO> update(@PathVariable Long id,
            @Valid @RequestBody FeeCatalogRequestDTO requestDTO) {
        log.info("[Controller:FeeCatalogController] update() called - Request to update catalog: {}", id);
        FeeCatalogDTO responseDTO = feeCatalogFacade.updateFeeCatalog(id, requestDTO);
        log.info("[Controller:FeeCatalogController] update() succeeded - Catalog: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:FeeCatalogController] delete() called - Request to delete catalog: {}", id);
        feeCatalogFacade.softDeleteById(id);
        log.info("[Controller:FeeCatalogController] delete() succeeded - Catalog: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Fee catalog deleted successfully"));
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:FeeCatalogController] getStatistics() called");
        Map<String, Long> statistics = feeCatalogFacade.getStatistics();
        log.info("[Controller:FeeCatalogController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
