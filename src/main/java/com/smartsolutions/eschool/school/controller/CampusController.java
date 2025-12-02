package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.campuses.responseDto.CampusResponseDTO;
import com.smartsolutions.eschool.school.dtos.campuses.requestDto.CampusCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.facade.CampusFacade;
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
        List<CampusResponseDTO> resources = nCampusFacade.getAll();
        log.info("GET /api/institute/campus succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        log.info("Received request to fetch campus with id: {}", id);
        CampusResponseDTO campus = nCampusFacade.getById(id);
        log.info("Returning campus: id={}", campus.getId());
        return ResponseEntity.ok(campus);
    }

    @GetMapping(value = "search/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBySearch(@PathVariable String keyword) {
        log.info("GET /api/school/discounts/types/search by keyword called");
        List<CampusResponseDTO> sectionDTO = nCampusFacade.searchByKeyword(keyword);
        log.info("GET /api/school/discounts/types/search by keyword succeeded");
        return ResponseEntity.ok().body(sectionDTO);
    }

    @GetMapping(value = "/by-institute/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByInstituteId(@PathVariable Long id) throws Exception {
        log.info("Received request to fetch campus by Institute Id: {}", id);
        List<CampusResponseDTO> campuses = nCampusFacade.findByInstituteId(id);
        log.info("Returning campuses data");
        return ResponseEntity.ok(campuses);
    }

    @GetMapping(value = "/by-name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByInstituteId(@PathVariable String name) throws Exception {
        log.info("Received request to fetch campus by Institute name: {}", name);
        List<CampusResponseDTO> campuses = nCampusFacade.findByCampusNameContaining(name);
        log.info("Returning campuses  data");
        return ResponseEntity.ok(campuses);
    }

    @DeleteMapping("/{campusId}")
    public ResponseEntity<?> softDeleteById(@PathVariable Long campusId) {
        log.info("API Request: Soft delete Campus ID: {}", campusId);
        try {
            int result = nCampusFacade.softDeleteById(campusId);
            if (result == 0) {
                log.warn("delete failed — Campus not found: {}", campusId);
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
        CampusCreateRequestDTO createdCampus = nCampusFacade.createCampus(dto);
        log.info("Section created successfully with id: {}", createdCampus.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCampus);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampusResponseDTO> updateStandard(@PathVariable Long id, @Valid @RequestBody CampusCreateRequestDTO dto) {
        log.info("Received request to update Campus with id: {}", id);
        CampusResponseDTO updatedCampus = nCampusFacade.updateStandard(id, dto);
        log.info("Returning updated Campus: id={}", updatedCampus.getId());
        return ResponseEntity.ok(updatedCampus);
    }
}

