package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.requestDto.InstituteAcademicOfferingCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.requestDto.InstituteAcademicOfferingUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.responseDto.InstituteAcademicOfferingResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteAcademicOfferingFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/academic-offerings")
@Slf4j
public class InstituteAcademicOfferingController {

    private final InstituteAcademicOfferingFacade instituteAcademicOfferingFacade;

    public InstituteAcademicOfferingController(InstituteAcademicOfferingFacade instituteAcademicOfferingFacade) {
        this.instituteAcademicOfferingFacade = instituteAcademicOfferingFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteAcademicOfferingResponseDTO> createOffering(@Valid @RequestBody InstituteAcademicOfferingCreateRequestDTO requestDTO) {
        InstituteAcademicOfferingResponseDTO responseDTO = instituteAcademicOfferingFacade.createOffering(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteAcademicOfferingResponseDTO>> getAll() {
        return ResponseEntity.ok(instituteAcademicOfferingFacade.getAll());
    }

    @GetMapping(value = "/institute/{instituteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteAcademicOfferingResponseDTO>> getByInstituteId(@PathVariable Long instituteId) {
        return ResponseEntity.ok(instituteAcademicOfferingFacade.getByInstituteId(instituteId));
    }

    @GetMapping(value = "/{offeringId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteAcademicOfferingResponseDTO> getById(@PathVariable Long offeringId) {
        return ResponseEntity.ok(instituteAcademicOfferingFacade.getById(offeringId));
    }

    @PutMapping(value = "/{offeringId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteAcademicOfferingResponseDTO> updateOffering(@PathVariable Long offeringId, @Valid @RequestBody InstituteAcademicOfferingUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(instituteAcademicOfferingFacade.updateOffering(offeringId, requestDTO));
    }

    @DeleteMapping("/{offeringId}")
    public ResponseEntity<String> deleteOffering(@PathVariable Long offeringId) {
        instituteAcademicOfferingFacade.deleteById(offeringId);
        return ResponseEntity.ok("Institute academic offering deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteAcademicOfferingResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(instituteAcademicOfferingFacade.searchByKeyword(keyword.trim()));
    }
}
