package com.smartsolutions.eschool.sclass.controller;

import com.smartsolutions.eschool.sclass.dtos.requestDto.StandardCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.sclass.facade.StandardFacade;
import com.smartsolutions.eschool.util.SecurityUtils;
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
        log.info("GET /api/institute/campuses-standards called");
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        List<StandardDTO> resources = standardFacade.getAll(orgId);
        log.info("GET /api/institute/campuses-standards succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardDTO> getById(@PathVariable Long id) {
        log.info("GET /api/institute/campuses-standards/{} called", id);
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        StandardDTO standardDTO = standardFacade.getById(id, orgId);
        log.info("GET /api/institute/campuses-standards/{} succeeded", id);
        return ResponseEntity.ok(standardDTO);
    }

    @GetMapping(value = "/campus/{campusId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StandardDTO>> getByCampusId(@PathVariable Long campusId) {
        log.info("GET /api/institute/campuses-standards/campus/{} called", campusId);
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        List<StandardDTO> result = standardFacade.getByCampusId(campusId, orgId);
        log.info("GET /api/institute/campuses-standards/campus/{} succeeded, returned {} resources", campusId,
                result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StandardDTO>> getStandardsByFilter(@RequestParam(required = false) Long campusId,
            @RequestParam(required = false) String keyword) {
        log.info("GET /api/institute/campuses-standards/search called with campusId={} and keyword='{}'", campusId,
                keyword);
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        List<StandardDTO> results = standardFacade.getStandardsByFilter(campusId, keyword, orgId);
        log.info("GET /api/institute/campuses-standards/search succeeded, returned {} resources", results.size());
        return ResponseEntity.ok(results);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardCreateRequestDTO> createStandard(
            @Valid @RequestBody StandardCreateRequestDTO standardDTO) {
        log.info("POST /api/institute/campuses-standards called for standard: {}", standardDTO.getStandardName());
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        StandardCreateRequestDTO created = standardFacade.create(standardDTO, orgId);
        log.info("POST /api/institute/campuses-standards succeeded, created with id: {}", created.getId());
        return ResponseEntity.ok(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardDTO> updateStandard(@PathVariable Long id,
            @Valid @RequestBody StandardCreateRequestDTO dto) {
        log.info("PUT /api/institute/campuses-standards/{} called", id);
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        StandardDTO updatedStandard = standardFacade.updateStandard(id, dto, orgId);
        log.info("PUT /api/institute/campuses-standards/{} succeeded", id);
        return ResponseEntity.ok(updatedStandard);
    }

    @DeleteMapping("/{standardId}")
    public ResponseEntity<String> softDeleteById(@PathVariable Long standardId) {
        log.info("DELETE /api/institute/campuses-standards/{} called", standardId);
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        standardFacade.softDeleteById(standardId, orgId);
        log.info("DELETE /api/institute/campuses-standards/{} succeeded", standardId);
        return ResponseEntity.ok("Standard deleted successfully");
    }

    @DeleteMapping("/campus/{campusId}")
    public ResponseEntity<String> softDeleteByCampusId(@PathVariable Long campusId) {
        log.info("DELETE /api/institute/campuses-standards/campus/{} called", campusId);
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        int rows = standardFacade.softDeleteByCampusId(campusId, orgId);
        log.info("DELETE /api/institute/campuses-standards/campus/{} succeeded, deleted {} resources", campusId, rows);
        return ResponseEntity.ok(rows + " Standards deleted");
    }
}
