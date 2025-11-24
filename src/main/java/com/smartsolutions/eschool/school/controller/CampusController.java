package com.smartsolutions.eschool.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartsolutions.eschool.school.dtos.CampusDTO;
import com.smartsolutions.eschool.school.dtos.InstituteDTO;
import com.smartsolutions.eschool.school.dtos.requestDto.CampusCreateRequestDTO;
import com.smartsolutions.eschool.school.facade.CampusFacade;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.sclass.dtos.requestDto.SectionCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.requestDto.StandardCreateRequestDTO;
import com.smartsolutions.eschool.sclass.dtos.responseDto.StandardDTO;
import com.smartsolutions.eschool.util.MultiResourceSuccessResponseObject;
import com.smartsolutions.eschool.util.ResourceObject;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/institute/campus")
@Slf4j
public class CampusController {

    @Autowired
    private CampusFacade nCampusFacade;

    //  get all employee
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/institute/campus called");
        List<CampusDTO> resources = nCampusFacade.getAll();
        log.info("GET /api/institute/campus succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        log.info("Received request to fetch campus with id: {}", id);
        CampusDTO campus = nCampusFacade.getById(id);
        log.info("Returning campus: id={}", campus.getId());
        return ResponseEntity.ok(campus);
    }

    @GetMapping(value = "/by-institute/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByInstituteId(@PathVariable Long id) throws Exception {
        log.info("Received request to fetch campus by Institute Id: {}", id);
        List<CampusDTO> campuses = nCampusFacade.findByInstituteId(id);
        log.info("Returning campuses data");
        return ResponseEntity.ok(campuses);
    }

    @GetMapping(value = "/by-name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByInstituteId(@PathVariable String name) throws Exception {
        log.info("Received request to fetch campus by Institute name: {}", name);
        List<CampusDTO> campuses = nCampusFacade.findByCampusNameContaining(name);
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
    public ResponseEntity<CampusDTO> updateStandard(@PathVariable Long id, @Valid @RequestBody CampusCreateRequestDTO dto) {
        log.info("Received request to update Campus with id: {}", id);
        CampusDTO updatedCampus = nCampusFacade.updateStandard(id, dto);
        log.info("Returning updated Campus: id={}", updatedCampus.getId());
        return ResponseEntity.ok(updatedCampus);
    }
}

