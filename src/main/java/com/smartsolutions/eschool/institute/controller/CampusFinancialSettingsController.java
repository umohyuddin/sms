package com.smartsolutions.eschool.institute.controller;

import com.smartsolutions.eschool.institute.dtos.financialSettings.requestDto.CampusFinancialSettingsRequestDTO;
import com.smartsolutions.eschool.institute.dtos.financialSettings.responseDto.CampusFinancialSettingsResponseDTO;
import com.smartsolutions.eschool.institute.facade.CampusFinancialSettingsFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api/campus/financial-settings")
@Slf4j
public class CampusFinancialSettingsController {

    private final CampusFinancialSettingsFacade facade;

    public CampusFinancialSettingsController(CampusFinancialSettingsFacade facade) {
        this.facade = facade;
    }

    @GetMapping(value = "/{campusId}/{academicYearId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampusFinancialSettingsResponseDTO> getByCampusAndAcademicYear(
            @PathVariable Long campusId,
            @PathVariable Long academicYearId) {
        log.info(
                "[Controller:CampusFinancialSettingsController] getByCampusAndAcademicYear() called - campus: {}, year: {}",
                campusId, academicYearId);
        CampusFinancialSettingsResponseDTO responseDTO = facade.getByCampusAndAcademicYear(campusId, academicYearId);
        log.info("[Controller:CampusFinancialSettingsController] getByCampusAndAcademicYear() succeeded");
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampusFinancialSettingsResponseDTO> create(@Valid @RequestBody CampusFinancialSettingsRequestDTO dto) {
        log.info("[Controller:CampusFinancialSettingsController] create() called");
        CampusFinancialSettingsResponseDTO responseDTO = facade.create(dto);
        log.info("[Controller:CampusFinancialSettingsController] create() succeeded - ID: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CampusFinancialSettingsResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody CampusFinancialSettingsRequestDTO dto) {
        log.info("[Controller:CampusFinancialSettingsController] update() called - ID: {}", id);
        CampusFinancialSettingsResponseDTO responseDTO = facade.update(id, dto);
        log.info("[Controller:CampusFinancialSettingsController] update() succeeded - ID: {}", id);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        log.info("[Controller:CampusFinancialSettingsController] delete() called - ID: {}", id);
        facade.softDeleteById(id);
        log.info("[Controller:CampusFinancialSettingsController] delete() succeeded - ID: {}", id);
        return ResponseEntity.ok("Financial settings deleted successfully");
    }

    @GetMapping(value = "/campus/{campusId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<java.util.List<CampusFinancialSettingsResponseDTO>> getAllByCampusId(@PathVariable Long campusId) {
        log.info("[Controller:CampusFinancialSettingsController] getAllByCampusId() called - campus: {}", campusId);
        java.util.List<CampusFinancialSettingsResponseDTO> responseList = facade.getAllByCampusId(campusId);
        log.info("[Controller:CampusFinancialSettingsController] getAllByCampusId() succeeded");
        return ResponseEntity.ok(responseList);
    }
}
