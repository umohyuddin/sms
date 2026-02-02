package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.responseDto.InstituteAccreditationResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteAccreditationFacade;
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
@RequestMapping("/api/institute/accreditations")
@Slf4j
public class InstituteAccreditationController {

    private final InstituteAccreditationFacade instituteAccreditationFacade;

    public InstituteAccreditationController(InstituteAccreditationFacade instituteAccreditationFacade) {
        this.instituteAccreditationFacade = instituteAccreditationFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteAccreditationResponseDTO> createAccreditation(@Valid @RequestBody InstituteAccreditationCreateRequestDTO requestDTO) {
        InstituteAccreditationResponseDTO responseDTO = instituteAccreditationFacade.createAccreditation(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<InstituteAccreditationResponseDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(instituteAccreditationFacade.getAll(pageable));
    }

    @GetMapping(value = "/institute/{instituteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<InstituteAccreditationResponseDTO>> getByInstituteId(@PathVariable Long instituteId, Pageable pageable) {
        return ResponseEntity.ok(instituteAccreditationFacade.getByInstituteId(instituteId, pageable));
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteAccreditationResponseDTO>> getAllActive() {
        return ResponseEntity.ok(instituteAccreditationFacade.getAllActive());
    }

    @GetMapping(value = "/{accreditationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteAccreditationResponseDTO> getById(@PathVariable Long accreditationId) {
        return ResponseEntity.ok(instituteAccreditationFacade.getById(accreditationId));
    }

    @PutMapping(value = "/{accreditationId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteAccreditationResponseDTO> updateAccreditation(@PathVariable Long accreditationId, @Valid @RequestBody InstituteAccreditationUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(instituteAccreditationFacade.updateAccreditation(accreditationId, requestDTO));
    }

    @DeleteMapping("/{accreditationId}")
    public ResponseEntity<String> deleteAccreditation(@PathVariable Long accreditationId) {
        instituteAccreditationFacade.deleteById(accreditationId);
        return ResponseEntity.ok("Institute accreditation deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteAccreditationResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(instituteAccreditationFacade.searchByKeyword(keyword.trim()));
    }

    @PutMapping(value = "/{accreditationId}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteAccreditationResponseDTO> activate(@PathVariable Long accreditationId) {
        return ResponseEntity.ok(instituteAccreditationFacade.activate(accreditationId));
    }

    @PutMapping(value = "/{accreditationId}/deactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteAccreditationResponseDTO> deactivate(@PathVariable Long accreditationId) {
        return ResponseEntity.ok(instituteAccreditationFacade.deactivate(accreditationId));
    }
}
