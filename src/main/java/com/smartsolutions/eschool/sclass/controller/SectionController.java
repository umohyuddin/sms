package com.smartsolutions.eschool.sclass.controller;

import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.facade.SectionFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Transactional
@RestController
@RequestMapping("/api/institute/campuses/standards")
public class SectionController {
    @Autowired
    private SectionFacade sectionFacade;

    @GetMapping(value = "/sections", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        log.info("GET /api/institute/campuses/standards/sections called");
        List<SectionDTO> resources = sectionFacade.getAll();
        log.info("GET /api/institute/campuses/standards/sections succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/sections/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) {
        log.info("GET /api/institute/campuses/standards/sections/{} called", id);
        SectionDTO sectionDTO = sectionFacade.getById(id);
        log.info("GET /api/institute/campuses/standards/sections/{} succeeded", id);
        return ResponseEntity.ok().body(sectionDTO);
    }

    @GetMapping(value = "/{standardId}/sections", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByStandardId(@PathVariable Long standardId) {
        log.info("GET /api/institute/campuses/standards/{}/sections called", standardId);
        List<SectionDTO> sectionDTO = sectionFacade.getByStandardId(standardId);
        log.info("GET /api/institute/campuses/standards/{}/sections succeeded, returned {} resources", standardId, sectionDTO.size());
        return ResponseEntity.ok().body(sectionDTO);
    }

    @GetMapping(value = "/sections/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBySearch(@RequestParam(required = false) Long campusId,@RequestParam(required = false) Long standardId,@RequestParam(required = false) String keyword) {
        log.info("GET /api/institute/campuses/standards/sections/search called with keyword: {}", keyword);
        List<SectionDTO> sectionDTO = sectionFacade.searchSections(campusId,standardId,keyword);
        log.info("GET /api/institute/campuses/standards/sections/search succeeded, returned {} resources", sectionDTO.size());
        return ResponseEntity.ok().body(sectionDTO);
    }


    @DeleteMapping("/sections/{sectionId}")
    public ResponseEntity<?> softDeleteById(@PathVariable Long sectionId) {
        log.info("DELETE /api/institute/campuses/standards/sections/{} called", sectionId);
        try {
            int result = sectionFacade.softDeleteById(sectionId);
            if (result == 0) {
                log.warn("DELETE /api/institute/campuses/standards/sections/{} failed - not found", sectionId);
                return ResponseEntity.notFound().build();
            }
            log.info("DELETE /api/institute/campuses/standards/sections/{} succeeded", sectionId);
            return ResponseEntity.ok("Section deleted successfully");
        } catch (Exception ex) {
            log.error("DELETE /api/institute/campuses/standards/sections/{} failed: {}", sectionId, ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body("Failed to delete section");
        }
    }

    @DeleteMapping("/{standardId}/sections")
    public ResponseEntity<?> softDeleteByStandardId(@PathVariable Long standardId) {
        log.info("DELETE /api/institute/campuses/standards/{}/sections called", standardId);
        try {
            int rows = sectionFacade.softDeleteByStandardId(standardId);
            if (rows == 0) {
                log.warn("DELETE /api/institute/campuses/standards/{}/sections failed - not found", standardId);
                return ResponseEntity.notFound().build();
            }
            log.info("DELETE /api/institute/campuses/standards/{}/sections succeeded, deleted {} sections", standardId, rows);
            return ResponseEntity.ok(rows + " sections soft deleted");
        } catch (Exception ex) {
            log.error("DELETE /api/institute/campuses/standards/{}/sections failed: {}", standardId, ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body("Failed to delete sections by standard");
        }
    }

    @DeleteMapping("/sections/all")
    public ResponseEntity<?> softDeleteAll() {
        log.info("DELETE /api/institute/campuses/standards/sections/all called");
        try {
            int rows = sectionFacade.softDeleteAll();
            log.info("DELETE /api/institute/campuses/standards/sections/all succeeded, deleted {} sections", rows);
            return ResponseEntity.ok(rows + " sections soft deleted");
        } catch (Exception ex) {
            log.error("DELETE /api/institute/campuses/standards/sections/all failed: {}", ex.getMessage(), ex);
            return ResponseEntity.internalServerError().body("Failed to soft delete all sections");
        }
    }

    @PostMapping(value = "/sections", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SectionCreateRequestDTO> createSection(@Valid @RequestBody SectionCreateRequestDTO dto) {
        log.info("POST /api/institute/campuses/standards/sections called for section: {}", dto.getSectionName());
        SectionCreateRequestDTO createdSection = sectionFacade.createSection(dto);
        log.info("POST /api/institute/campuses/standards/sections succeeded, created with id: {}", createdSection.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSection);
    }

    @PutMapping(value = "sections/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SectionDTO> updateSection(@PathVariable Long id, @Valid @RequestBody SectionCreateRequestDTO dto) {
        log.info("PUT /api/institute/campuses/standards/sections/{} called", id, dto);
        SectionDTO updatedStandard = sectionFacade.updateSection(id, dto);
        log.info("PUT /api/institute/campuses/standards/sections/{} succeeded", id);
        return ResponseEntity.ok(updatedStandard);
    }
}
