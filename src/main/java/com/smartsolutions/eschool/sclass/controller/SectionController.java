package com.smartsolutions.eschool.sclass.controller;

import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
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
@RequestMapping("/api/institute/campuses/standards/sections")
public class SectionController {
    @Autowired
    private SectionFacade sectionFacade;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        log.info("GET /api/sections called");
        List<SectionDTO> resources = sectionFacade.getAll();
        log.info("GET /api/sections succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) {
        log.info("GET /api/sections by id called");
        SectionDTO sectionDTO = sectionFacade.getById(id);
        log.info("GET /api/sections by id succeeded");
        return ResponseEntity.ok().body(sectionDTO);
    }

    @GetMapping(value = "standard/{standardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByStandardId(@PathVariable Long standardId) {
        log.info("GET /api/sections by standard id called");
        List<SectionDTO> sectionDTO = sectionFacade.getByStandardId(standardId);
        log.info("GET /api/sections by standard id succeeded");
        return ResponseEntity.ok().body(sectionDTO);
    }

    @GetMapping(value = "search/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBySearch(@PathVariable String keyword) {
        log.info("GET /api/sections/search by keyword called");
        List<SectionDTO> sectionDTO = sectionFacade.searchByKeyword(keyword);
        log.info("GET /api/sections/search by keyword succeeded");
        return ResponseEntity.ok().body(sectionDTO);
    }


    @DeleteMapping("/{sectionId}")
    public ResponseEntity<?> softDeleteById(@PathVariable Long sectionId) {
        log.info("API Request: Soft delete Section ID: {}", sectionId);
        try {
            int result = sectionFacade.softDeleteById(sectionId);
            if (result == 0) {
                log.warn("delete failed — Section not found: {}", sectionId);
                return ResponseEntity.notFound().build();
            }
            log.info("Section deleted successfully: {}", sectionId);
            return ResponseEntity.ok("Section deleted successfully");
        } catch (Exception ex) {
            log.error("Error deleting Section ID: {}", sectionId, ex);
            return ResponseEntity.internalServerError().body("Failed to delete section");
        }
    }

    @DeleteMapping("/standard/{standardId}")
    public ResponseEntity<?> softDeleteByStandardId(@PathVariable Long standardId) {
        log.info("API Request: delete Sections by Standard ID: {}", standardId);
        try {
            int rows = sectionFacade.softDeleteByStandardId(standardId);
            if (rows == 0) {
                log.warn("No sections found for Standard ID: {}", standardId);
                return ResponseEntity.notFound().build();
            }
            log.info("deleted {} sections for Standard ID: {}", rows, standardId);
            return ResponseEntity.ok(rows + " sections soft deleted");
        } catch (Exception ex) {
            log.error("Error deleting by standardId {} ", standardId, ex);
            return ResponseEntity.internalServerError().body("Failed to delete sections by standard");
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<?> softDeleteAll() {
        log.info("API Request: Soft delete ALL sections");
        try {
            int rows = sectionFacade.softDeleteAll();
            log.info("Soft deleted ALL sections. Count: {}", rows);
            return ResponseEntity.ok(rows + " sections soft deleted");
        } catch (Exception ex) {
            log.error("Error soft deleting ALL sections", ex);
            return ResponseEntity.internalServerError().body("Failed to soft delete all sections");
        }
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SectionCreateRequestDTO> createSection(@Valid @RequestBody SectionCreateRequestDTO dto) {

        log.info("Received request to create new Section: {}", dto.getSectionName());
        SectionCreateRequestDTO createdSection = sectionFacade.createSection(dto);
        log.info("Section created successfully with id: {}", createdSection.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSection);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SectionDTO> updateSection(@PathVariable Long id, @Valid @RequestBody SectionCreateRequestDTO dto) {

        log.info("Received request to update Section with id: {}", id);
        SectionDTO updatedStandard = sectionFacade.updateSection(id, dto);
        log.info("Returning updated Section: id={}", updatedStandard.getId());
        return ResponseEntity.ok(updatedStandard);
    }





}
