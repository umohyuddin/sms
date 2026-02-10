package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.campuses.metaData.CampusMetaData;
import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.school.dtos.campuses.requestDto.CampusCreateRequestDTO;
import com.smartsolutions.eschool.school.facade.CampusFacade;
import com.smartsolutions.eschool.util.SecurityUtils;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/institute/campuses")
@Slf4j
public class CampusController {

    @Autowired
    private CampusFacade nCampusFacade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/institute/campus called");
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        List<CampusResponseDTO> resources = nCampusFacade.getAll(orgId);
        log.info("GET /api/institute/campus succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        log.info("Received request to fetch campus with id: {}", id);
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        CampusResponseDTO campus = nCampusFacade.getById(id, orgId);
        log.info("Returning campus: id={}", campus.getId());
        return ResponseEntity.ok(campus);
    }

    @GetMapping(value = "search/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBySearch(@PathVariable String keyword) {
        log.info("GET /api/school/discounts/types/search by keyword called");
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        List<CampusResponseDTO> sectionDTO = nCampusFacade.searchByKeyword(keyword, orgId);
        log.info("GET /api/school/discounts/types/search by keyword succeeded");
        return ResponseEntity.ok().body(sectionDTO);
    }

    @GetMapping(value = "/by-institute", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByCurrentInstitute() throws Exception {
        log.info("Received request to fetch campus by Current Institute");
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        List<CampusResponseDTO> campuses = nCampusFacade.findByInstituteId(orgId);
        log.info("Returning campuses data");
        return ResponseEntity.ok(campuses);
    }

    @GetMapping(value = "/by-name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByCampusName(@PathVariable String name) throws Exception {
        log.info("Received request to fetch campus by name: {}", name);
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        List<CampusResponseDTO> campuses = nCampusFacade.findByCampusNameContaining(name, orgId);
        log.info("Returning campuses data");
        return ResponseEntity.ok(campuses);
    }

    @DeleteMapping("/{campusId}")
    public ResponseEntity<?> softDeleteById(@PathVariable Long campusId) {
        log.info("API Request: Soft delete Campus ID: {}", campusId);
        try {
            Long orgId = SecurityUtils.getCurrentOrganizationId();
            int result = nCampusFacade.softDeleteById(campusId, orgId);
            if (result == 0) {
                log.warn("delete failed — Campus not found: {} for organization: {}", campusId, orgId);
                return ResponseEntity.notFound().build();
            }
            log.info("Section deleted successfully: {}", campusId);
            return ResponseEntity.ok("Campus deleted successfully");
        } catch (Exception ex) {
            log.error("Error deleting Campus ID: {}", campusId, ex);
            return ResponseEntity.internalServerError().body("Failed to delete Campus");
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampusCreateRequestDTO> createCampus(@Valid @RequestBody CampusCreateRequestDTO dto) {
        log.info("Received request to create new Section: {}", dto.getCampusName());
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        CampusCreateRequestDTO createdCampus = nCampusFacade.createCampus(dto, orgId);
        log.info("Section created successfully with id: {}", createdCampus.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCampus);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampusResponseDTO> updateCampus(@PathVariable Long id,
            @Valid @RequestBody CampusCreateRequestDTO dto) {
        log.info("Received request to update Campus with id: {}", id);
        Long orgId = SecurityUtils.getCurrentOrganizationId();
        CampusResponseDTO updatedCampus = nCampusFacade.updateCampus(id, dto, orgId);
        log.info("Returning updated Campus: id={}", updatedCampus.getId());
        return ResponseEntity.ok(updatedCampus);
    }

    @GetMapping(value = "meta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCampusMetaData() throws Exception {
        log.info("GET /api/institute/meta called");
        CampusMetaData resources = nCampusFacade.getCampusMetaData();
        log.info("GET /api/institute/meta succeeded");
        return ResponseEntity.ok().body(resources);
    }

}
