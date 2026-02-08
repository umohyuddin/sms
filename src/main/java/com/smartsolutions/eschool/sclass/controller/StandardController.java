package com.smartsolutions.eschool.sclass.controller;

import com.smartsolutions.eschool.sclass.dtos.requestDto.StandardCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.facade.StandardFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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
        log.info("GET /api/institute/campuses-standards called");
        List<StandardDTO> resources = standardFacade.getAll();
        log.info("GET /api/institute/campuses-standards succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardDTO> getById(@PathVariable Long id) {
        log.info("GET /api/institute/campuses-standards/{} called", id);
        StandardDTO standardDTO = standardFacade.getById(id);
        log.info("GET /api/institute/campuses-standards/{} succeeded", id);
        return ResponseEntity.ok(standardDTO);
    }

    @GetMapping(value = "/campus/{campusId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StandardDTO>> getByCampusId(@PathVariable Long campusId) {
        log.info("GET /api/institute/campuses-standards/campus/{} called", campusId);
        List<StandardDTO> result = standardFacade.getByCampusId(campusId);
        log.info("GET /api/institute/campuses-standards/campus/{} succeeded, returned {} resources", campusId, result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StandardDTO>> getStandardsByFilter(@RequestParam(required = false) Long campusId, @RequestParam(required = false) String keyword) {
        log.info("GET /api/institute/campuses-standards/search called with campusId={} and keyword='{}'", campusId, keyword);
        List<StandardDTO> results = standardFacade.getStandardsByFilter(campusId, keyword);
        log.info("GET /api/institute/campuses-standards/search succeeded, returned {} resources", results.size());
        return ResponseEntity.ok(results);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardCreateRequestDTO> createStandard(@Valid @RequestBody StandardCreateRequestDTO standardDTO) {
        log.info("POST /api/institute/campuses-standards called for standard: {}", standardDTO.getStandardName());
        StandardCreateRequestDTO created = standardFacade.create(standardDTO);
        log.info("POST /api/institute/campuses-standards succeeded, created with id: {}", created.getId());
        return ResponseEntity.ok(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardDTO> updateStandard(@PathVariable Long id, @Valid @RequestBody StandardCreateRequestDTO dto) {
        log.info("PUT /api/institute/campuses-standards/{} called", id);
        StandardDTO updatedStandard = standardFacade.updateStandard(id, dto);
        log.info("PUT /api/institute/campuses-standards/{} succeeded", id);
        return ResponseEntity.ok(updatedStandard);
    }

    @DeleteMapping("/{standardId}")
    public ResponseEntity<String> softDeleteById(@PathVariable Long standardId) {
        log.info("DELETE /api/institute/campuses-standards/{} called", standardId);
        int result = standardFacade.softDeleteById(standardId);
        log.info("DELETE /api/institute/campuses-standards/{} succeeded", standardId);
        return ResponseEntity.ok("Standard deleted successfully");
    }

    @DeleteMapping("/campus/{campusId}")
    public ResponseEntity<String> softDeleteByCampusId(@PathVariable Long campusId) {
        log.info("DELETE /api/institute/campuses-standards/campus/{} called", campusId);
        int rows = standardFacade.softDeleteByCampusId(campusId);
        log.info("DELETE /api/institute/campuses-standards/campus/{} succeeded, deleted {} resources", campusId, rows);
        return ResponseEntity.ok(rows + " Standards deleted");
    }
}
