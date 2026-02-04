package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.facilityType.requestDto.FacilityTypeRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.facilityType.responseDto.FacilityTypeResponseDTO;
import com.smartsolutions.eschool.lookups.facade.FacilityTypeFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lookups/facility-types")
@Slf4j
public class FacilityTypeController {

    private final FacilityTypeFacade facilityTypeFacade;

    public FacilityTypeController(FacilityTypeFacade facilityTypeFacade) {
        this.facilityTypeFacade = facilityTypeFacade;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacilityTypeResponseDTO> create(@Valid @RequestBody FacilityTypeRequestDTO dto) {
        log.info("POST /api/lookups/facility-types called");
        return ResponseEntity.status(HttpStatus.CREATED).body(facilityTypeFacade.create(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FacilityTypeResponseDTO>> getAllActive() {
        log.info("GET /api/lookups/facility-types called");
        return ResponseEntity.ok(facilityTypeFacade.getAllActive());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacilityTypeResponseDTO> getById(@PathVariable Long id) {
        log.info("GET /api/lookups/facility-types/{} called", id);
        return ResponseEntity.ok(facilityTypeFacade.getById(id));
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FacilityTypeResponseDTO> update(@PathVariable Long id, @Valid @RequestBody FacilityTypeRequestDTO dto) {
        log.info("PUT /api/lookups/facility-types/{} called", id);
        return ResponseEntity.ok(facilityTypeFacade.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("DELETE /api/lookups/facility-types/{} called", id);
        facilityTypeFacade.softDeleteById(id);
        return ResponseEntity.ok("Facility type deleted successfully");
    }
}
