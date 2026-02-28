package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.responseDto.InstituteAccreditationResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteAccreditationFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<InstituteAccreditationResponseDTO> createAccreditation(
            @Valid @RequestBody InstituteAccreditationCreateRequestDTO requestDTO) {
        log.info(
                "[Controller:InstituteAccreditationController] createAccreditation() called - Request to create accreditation");
        InstituteAccreditationResponseDTO responseDTO = instituteAccreditationFacade.createAccreditation(requestDTO);
        log.info(
                "[Controller:InstituteAccreditationController] createAccreditation() succeeded - Accreditation created successfully: {}",
                responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteAccreditationResponseDTO>> getAll() {
        log.info("[Controller:InstituteAccreditationController] getAll() called - Request to get all accreditations");
        List<InstituteAccreditationResponseDTO> responseDTOs = instituteAccreditationFacade.getAll();
        log.info("[Controller:InstituteAccreditationController] getAll() succeeded - Found {} accreditations",
                responseDTOs.size());
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping(value = "/institute/{instituteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteAccreditationResponseDTO>> getByInstituteId(@PathVariable Long instituteId) {
        log.info(
                "[Controller:InstituteAccreditationController] getByInstituteId() called - Request to get accreditations for institute: {}",
                instituteId);
        List<InstituteAccreditationResponseDTO> responseDTOs = instituteAccreditationFacade
                .getByInstituteId(instituteId);
        log.info(
                "[Controller:InstituteAccreditationController] getByInstituteId() succeeded - Found {} accreditations for institute: {}",
                responseDTOs.size(), instituteId);
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteAccreditationResponseDTO>> getAllActive() {
        log.info(
                "[Controller:InstituteAccreditationController] getAllActive() called - Request to get all active accreditations");
        List<InstituteAccreditationResponseDTO> responseDTOs = instituteAccreditationFacade.getAllActive();
        log.info(
                "[Controller:InstituteAccreditationController] getAllActive() succeeded - Found {} active accreditations",
                responseDTOs.size());
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping(value = "/{accreditationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteAccreditationResponseDTO> getById(@PathVariable Long accreditationId) {
        log.info(
                "[Controller:InstituteAccreditationController] getById() called - Request to get accreditation by id: {}",
                accreditationId);
        InstituteAccreditationResponseDTO responseDTO = instituteAccreditationFacade.getById(accreditationId);
        log.info("[Controller:InstituteAccreditationController] getById() succeeded - Found accreditation: {}",
                accreditationId);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping(value = "/{accreditationId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteAccreditationResponseDTO> updateAccreditation(@PathVariable Long accreditationId,
            @Valid @RequestBody InstituteAccreditationUpdateRequestDTO requestDTO) {
        log.info(
                "[Controller:InstituteAccreditationController] updateAccreditation() called - Request to update accreditation: {}",
                accreditationId);
        InstituteAccreditationResponseDTO responseDTO = instituteAccreditationFacade
                .updateAccreditation(accreditationId, requestDTO);
        log.info(
                "[Controller:InstituteAccreditationController] updateAccreditation() succeeded - Accreditation: {} updated successfully",
                accreditationId);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{accreditationId}")
    public ResponseEntity<String> deleteAccreditation(@PathVariable Long accreditationId) {
        log.info(
                "[Controller:InstituteAccreditationController] deleteAccreditation() called - Request to delete accreditation: {}",
                accreditationId);
        instituteAccreditationFacade.deleteById(accreditationId);
        log.info(
                "[Controller:InstituteAccreditationController] deleteAccreditation() succeeded - Accreditation: {} deleted successfully",
                accreditationId);
        return ResponseEntity.ok("Institute accreditation deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteAccreditationResponseDTO>> search(
            @RequestParam(name = "keyword") String keyword) {
        log.info(
                "[Controller:InstituteAccreditationController] search() called - Request to search accreditations with keyword: {}",
                keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<InstituteAccreditationResponseDTO> responseDTOs = instituteAccreditationFacade
                .searchByKeyword(keyword.trim());
        log.info(
                "[Controller:InstituteAccreditationController] search() succeeded - Found {} accreditations matching keyword: {}",
                responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @PutMapping(value = "/{accreditationId}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteAccreditationResponseDTO> activate(@PathVariable Long accreditationId) {
        log.info(
                "[Controller:InstituteAccreditationController] activate() called - Request to activate accreditation: {}",
                accreditationId);
        InstituteAccreditationResponseDTO responseDTO = instituteAccreditationFacade.activate(accreditationId);
        log.info(
                "[Controller:InstituteAccreditationController] activate() succeeded - Accreditation: {} activated successfully",
                accreditationId);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping(value = "/{accreditationId}/deactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteAccreditationResponseDTO> deactivate(@PathVariable Long accreditationId) {
        log.info(
                "[Controller:InstituteAccreditationController] deactivate() called - Request to deactivate accreditation: {}",
                accreditationId);
        InstituteAccreditationResponseDTO responseDTO = instituteAccreditationFacade.deactivate(accreditationId);
        log.info(
                "[Controller:InstituteAccreditationController] deactivate() succeeded - Accreditation: {} deactivated successfully",
                accreditationId);
        return ResponseEntity.ok(responseDTO);
    }
}
