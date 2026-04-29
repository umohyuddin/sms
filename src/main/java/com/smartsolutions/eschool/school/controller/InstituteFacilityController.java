package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.responseDto.InstituteFacilityResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteFacilityFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<List<InstituteFacilityResponseDTO>> createFacility(@Valid @RequestBody InstituteFacilityCreateRequestDTO requestDTO) {
        log.info("[Controller:InstituteFacilityController] createFacility() called - Request to create/replace facilities");
        List<InstituteFacilityResponseDTO> responseDTOs = instituteFacilityFacade.createFacility(requestDTO);
        log.info("[Controller:InstituteFacilityController] createFacility() succeeded - {} facilities processed", responseDTOs.size());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTOs);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteFacilityResponseDTO>> getAll() {
        log.info("[Controller:InstituteFacilityController] getAll() called - Request to get all facilities");
        List<InstituteFacilityResponseDTO> responseDTOs = instituteFacilityFacade.getAll();
        log.info("[Controller:InstituteFacilityController] getAll() succeeded - Found {} facilities", responseDTOs.size());
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping(value = "/institute/{instituteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteFacilityResponseDTO>> getByInstituteId(@PathVariable Long instituteId) {
        log.info("[Controller:InstituteFacilityController] getByInstituteId() called - Request to get facilities for institute: {}", instituteId);
        List<InstituteFacilityResponseDTO> responseDTOs = instituteFacilityFacade.getByInstituteId(instituteId);
        log.info("[Controller:InstituteFacilityController] getByInstituteId() succeeded - Found {} facilities for institute: {}", responseDTOs.size(), instituteId);
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping(value = "/{facilityId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteFacilityResponseDTO> getById(@PathVariable Long facilityId) {
        log.info("[Controller:InstituteFacilityController] getById() called - Request to get facility by id: {}", facilityId);
        InstituteFacilityResponseDTO responseDTO = instituteFacilityFacade.getById(facilityId);
        log.info("[Controller:InstituteFacilityController] getById() succeeded - Found facility: {}", facilityId);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping(value = "/{facilityId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteFacilityResponseDTO> updateFacility(@PathVariable Long facilityId, @Valid @RequestBody InstituteFacilityUpdateRequestDTO requestDTO) {
        log.info("[Controller:InstituteFacilityController] updateFacility() called - Request to update facility: {}", facilityId);
        InstituteFacilityResponseDTO responseDTO = instituteFacilityFacade.updateFacility(facilityId, requestDTO);
        log.info("[Controller:InstituteFacilityController] updateFacility() succeeded - Facility: {} updated successfully", facilityId);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{facilityId}")
    public ResponseEntity<String> deleteFacility(@PathVariable Long facilityId) {
        log.info("[Controller:InstituteFacilityController] deleteFacility() called - Request to delete facility: {}", facilityId);
        instituteFacilityFacade.deleteById(facilityId);
        log.info("[Controller:InstituteFacilityController] deleteFacility() succeeded - Facility: {} deleted successfully", facilityId);
        return ResponseEntity.ok("Institute facility deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteFacilityResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:InstituteFacilityController] search() called - Request to search facilities with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<InstituteFacilityResponseDTO> responseDTOs = instituteFacilityFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:InstituteFacilityController] search() succeeded - Found {} facilities matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }
}
