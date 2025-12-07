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

@Transactional
@RestController
@RequestMapping("/api/institute/campuses/standards")
@Slf4j
public class StandardController {
    @Autowired
    private StandardFacade standardFacade;

    //  get all Enrollments
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {

        log.info("GET /api/standards called");
        List<StandardDTO> resources = standardFacade.getAll();
        log.info("GET /api/standards succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        log.info("Received request to fetch standard with id: {}", id);
        StandardDTO standardDTO = standardFacade.getById(id);
        log.info("Returning standard: id={}", standardDTO.getId());
        return ResponseEntity.ok(standardDTO);
    }

    @GetMapping(value = "/campus/{campusId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByCampusId(@PathVariable Long campusId) throws Exception {
        log.info("Received request to fetch standards with Campus Id: {}", campusId);
        List<StandardDTO> standardDTOList = standardFacade.getByCampusId(campusId);
        log.info("Returning standards by campus by Id successfully");
        return ResponseEntity.ok(standardDTOList);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getStandardsByFilter(@RequestParam(required = false) Long campusId,@RequestParam(required = false) String keyword) {
        log.info("GET /api/institute/campuses/standards/search called with campusId={} and keyword={}", campusId, keyword);

        try {
            List<StandardDTO> results = standardFacade.getStandardsByFilter(campusId, keyword);
            log.info("Search completed. Found {} standards", results.size());
            return ResponseEntity.ok(results);
        } catch (Exception e) {
            log.error("Failed to search standards", e);
            return ResponseEntity.internalServerError().body("Failed to search standards");
        }
    }



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createStandard(@Valid @RequestBody StandardCreateRequestDTO standardDTO) {
        log.info("POST /api/standards - Creating new standard: {}", standardDTO);

        try {
            StandardCreateRequestDTO created = standardFacade.create(standardDTO);
            log.info("Standard created successfully with ID: {}", created.getId());
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            log.error("Failed to create standard", e);
            return ResponseEntity.internalServerError().body("Failed to create standard");
        }
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StandardDTO> updateStandard(@PathVariable Long id, @Valid @RequestBody StandardCreateRequestDTO dto) {

        log.info("Received request to update Standard with id: {}", id);
        StandardDTO updatedStandard = standardFacade.updateStandard(id, dto);
        log.info("Returning updated Standard: id={}", updatedStandard.getId());
        return ResponseEntity.ok(updatedStandard);
    }

    @DeleteMapping("/{standardId}")
    public ResponseEntity<?> softDeleteById(@PathVariable Long standardId) {
        log.info("API Request: Soft delete Standard ID: {}", standardId);
        try {
            int result = standardFacade.softDeleteById(standardId);
            if (result == 0) {
                log.warn("delete failed — Standard not found: {}", standardId);
                return ResponseEntity.notFound().build();
            }
            log.info("Section deleted successfully: {}", standardId);
            return ResponseEntity.ok("Standard deleted successfully");
        } catch (Exception ex) {
            log.error("Error deleting Standard ID: {}", standardId, ex);
            return ResponseEntity.internalServerError().body("Failed to delete Standard");
        }
    }

    @DeleteMapping("/campus/{campusId}")
    public ResponseEntity<?> softDeleteByCampusIdId(@PathVariable Long campusId) {
        log.info("API Request: delete Standard by Campus ID: {}", campusId);
        try {
            int rows = standardFacade.softDeleteByCampusId(campusId);
            if (rows == 0) {
                log.warn("No Standards found for Campus ID: {}", campusId);
                return ResponseEntity.notFound().build();
            }
            log.info("deleted {} Standard for Campus ID: {}", rows, campusId);
            return ResponseEntity.ok(rows + " Standards deleted");
        } catch (Exception ex) {
            log.error("Error deleting by Campus Id {} ", campusId, ex);
            return ResponseEntity.internalServerError().body("Failed to delete Standards by campus by ID");
        }
    }




}
