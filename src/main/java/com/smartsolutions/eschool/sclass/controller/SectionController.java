package com.smartsolutions.eschool.sclass.controller;

import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
import com.smartsolutions.eschool.sclass.facade.SectionFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/campuses-standards/sections")
@Slf4j
public class SectionController {

    private final SectionFacade sectionFacade;

    public SectionController(SectionFacade sectionFacade) {
        this.sectionFacade = sectionFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SectionDTO>> getAll() {
        log.info("[Controller:SectionController] getAll() called - Request to get all sections");
        List<SectionDTO> resources = sectionFacade.getAll();
        log.info("[Controller:SectionController] getAll() succeeded - Found {} sections", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SectionDTO> getById(@PathVariable Long id) {
        log.info("[Controller:SectionController] getById() called - Request to fetch section with id: {}", id);
        SectionDTO sectionDTO = sectionFacade.getById(id);
        log.info("[Controller:SectionController] getById() succeeded - Found section: {}", id);
        return ResponseEntity.ok(sectionDTO);
    }

    @GetMapping(value = "/standard/{standardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SectionDTO>> getByStandardId(@PathVariable Long standardId) {
        log.info("[Controller:SectionController] getByStandardId() called - Request to fetch sections for standard: {}",
                standardId);
        List<SectionDTO> sectionDTO = sectionFacade.getByStandardId(standardId);
        log.info("[Controller:SectionController] getByStandardId() succeeded - Found {} sections", sectionDTO.size());
        return ResponseEntity.ok(sectionDTO);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SectionDTO>> getBySearch(@RequestParam(required = false) Long campusId,
            @RequestParam(required = false) Long standardId, @RequestParam(required = false) String keyword) {
        log.info("[Controller:SectionController] getBySearch() called - campusId={}, standardId={}, keyword={}",
                campusId, standardId, keyword);
        List<SectionDTO> sectionDTO = sectionFacade.searchSections(campusId, standardId, keyword);
        log.info("[Controller:SectionController] getBySearch() succeeded - Found {} sections", sectionDTO.size());
        return ResponseEntity.ok(sectionDTO);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SectionCreateRequestDTO> createSection(@Valid @RequestBody SectionCreateRequestDTO dto) {
        log.info("[Controller:SectionController] createSection() called - Request to create section: {}",
                dto.getSectionName());
        SectionCreateRequestDTO createdSection = sectionFacade.createSection(dto);
        log.info("[Controller:SectionController] createSection() succeeded - Created with id: {}",
                createdSection.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSection);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SectionDTO> updateSection(@PathVariable Long id,
            @Valid @RequestBody SectionCreateRequestDTO dto) {
        log.info("[Controller:SectionController] updateSection() called - Request to update section: {}", id);
        SectionDTO updatedStandard = sectionFacade.updateSection(id, dto);
        log.info("[Controller:SectionController] updateSection() succeeded - Updated section: {}", id);
        return ResponseEntity.ok(updatedStandard);
    }

    @DeleteMapping("/{sectionId}")
    public ResponseEntity<String> softDeleteById(@PathVariable Long sectionId) {
        log.info("[Controller:SectionController] softDeleteById() called - Request to delete section: {}", sectionId);
        sectionFacade.softDeleteById(sectionId);
        log.info("[Controller:SectionController] softDeleteById() succeeded - Section deleted successfully");
        return ResponseEntity.ok("Section deleted successfully");
    }

    @DeleteMapping("/standard/{standardId}")
    public ResponseEntity<String> softDeleteByStandardId(@PathVariable Long standardId) {
        log.info(
                "[Controller:SectionController] softDeleteByStandardId() called - Request to delete sections for standard: {}",
                standardId);
        int rows = sectionFacade.softDeleteByStandardId(standardId);
        log.info("[Controller:SectionController] softDeleteByStandardId() succeeded - Deleted {} sections", rows);
        return ResponseEntity.ok(rows + " sections soft deleted");
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> softDeleteAll() {
        log.info("[Controller:SectionController] softDeleteAll() called - Request to delete all sections");
        int rows = sectionFacade.softDeleteAll();
        log.info("[Controller:SectionController] softDeleteAll() succeeded - Deleted {} sections", rows);
        return ResponseEntity.ok(rows + " sections soft deleted");
    }
}
