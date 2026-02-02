package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.responseDto.InstituteFacilityResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteFacilityFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/facilities")
@Slf4j
public class InstituteFacilityController {

    private final InstituteFacilityFacade instituteFacilityFacade;

    public InstituteFacilityController(InstituteFacilityFacade instituteFacilityFacade) {
        this.instituteFacilityFacade = instituteFacilityFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteFacilityResponseDTO> createFacility(@Valid @RequestBody InstituteFacilityCreateRequestDTO requestDTO) {
        InstituteFacilityResponseDTO responseDTO = instituteFacilityFacade.createFacility(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<InstituteFacilityResponseDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(instituteFacilityFacade.getAll(pageable));
    }

    @GetMapping(value = "/institute/{instituteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<InstituteFacilityResponseDTO>> getByInstituteId(@PathVariable Long instituteId, Pageable pageable) {
        return ResponseEntity.ok(instituteFacilityFacade.getByInstituteId(instituteId, pageable));
    }

    @GetMapping(value = "/{facilityId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteFacilityResponseDTO> getById(@PathVariable Long facilityId) {
        return ResponseEntity.ok(instituteFacilityFacade.getById(facilityId));
    }

    @PutMapping(value = "/{facilityId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteFacilityResponseDTO> updateFacility(@PathVariable Long facilityId, @Valid @RequestBody InstituteFacilityUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(instituteFacilityFacade.updateFacility(facilityId, requestDTO));
    }

    @DeleteMapping("/{facilityId}")
    public ResponseEntity<String> deleteFacility(@PathVariable Long facilityId) {
        instituteFacilityFacade.deleteById(facilityId);
        return ResponseEntity.ok("Institute facility deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteFacilityResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(instituteFacilityFacade.searchByKeyword(keyword.trim()));
    }
}
