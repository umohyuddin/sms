package com.smartsolutions.eschool.student.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.student.dtos.StudentDTO;
import com.smartsolutions.eschool.student.dtos.feeCatalog.requestDto.FeeCatalogRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import com.smartsolutions.eschool.student.facade.FeeCatelogFacade;
import com.smartsolutions.eschool.student.facade.FeeFacade;
import com.smartsolutions.eschool.student.model.FeeEntity;
import com.smartsolutions.eschool.util.MultiResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.ResourceObject;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Transactional
@RestController
@RequestMapping("/api/fee/catalogs")
@Slf4j
public class FeeCatalogController {
    private final FeeCatelogFacade feeCatalogFacade;

    public FeeCatalogController(FeeCatelogFacade feeCatelogFacade) {
        this.feeCatalogFacade = feeCatelogFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/fee/catalog called");
        List<FeeCatalogDTO> resources = feeCatalogFacade.getAll();
        log.info("GET /api/fee/catalog succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        log.info("Received request to fetch Fee catalog with id: {}", id);
        FeeCatalogDTO feeCatalogDTO = feeCatalogFacade.getById(id);
        log.info("Returning Fee catalog: id={}", feeCatalogDTO.getId());
        return ResponseEntity.ok(feeCatalogDTO);
    }

    @GetMapping(value = "/search/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FeeCatalogDTO> getStudentName(@PathVariable String keyword) {
        log.info("GET /api/fee/catalog by keyword called");
        List<FeeCatalogDTO> resources = feeCatalogFacade.searchFeeCatalog(keyword);
        log.info("GET /api/fee/catalog by keyword succeeded, returned {} resources", resources.size());
        return resources;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createFeeCatalog(@RequestBody FeeCatalogRequestDTO feeCatalogDTO) {
        log.info("POST /api/fee/catalogs called with payload: {}", feeCatalogDTO);
        FeeCatalogDTO savedCatalog = feeCatalogFacade.save(feeCatalogDTO);
        log.info("Fee Catalog created successfully with id={}", savedCatalog.getId());
        return ResponseEntity.ok(savedCatalog);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeCatalogDTO> updateFeeCatalog(@PathVariable Long id, @RequestBody FeeCatalogRequestDTO feeCatalogDTO) {
        log.info("PUT /api/fee/catalogs/{} called with {}", id, feeCatalogDTO);
        try {
            FeeCatalogDTO updatedCatalog = feeCatalogFacade.update(id, feeCatalogDTO);
            log.info("Fee Catalog updated successfully with id={}", id);
            return ResponseEntity.ok(updatedCatalog);
        } catch (Exception e) {
            log.error("Failed to update Fee Catalog with id={}", id, e);
            return ResponseEntity.status(500).build();
        }
    }

}
