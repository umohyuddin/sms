package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.feeRates.requestDto.FeeRateCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeRates.responseDto.FeeRatesResponseDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeRateDTO;
import com.smartsolutions.eschool.student.facade.FeeRateFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/fee/rates")
@Slf4j
public class FeeRateController {

    private final FeeRateFacade feeRateFacade;

    public FeeRateController(FeeRateFacade feeRateFacade) {
        this.feeRateFacade = feeRateFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/fee/rates called");
        List<FeeRatesResponseDTO> resources = feeRateFacade.getAll();
        log.info("GET /api/fee/rates succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        log.info("Received request to fetch Fee rate with id: {}", id);
        FeeRatesResponseDTO feeRateDTO = feeRateFacade.getById(id);
        log.info("Returning Fee rate: id={}", feeRateDTO.getId());
        return ResponseEntity.ok(feeRateDTO);
    }

    @GetMapping(value = "catalog/{catalogId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByFeeCatalogId(@PathVariable Long catalogId) throws Exception {
        log.info("Received request to fetch  Fee rate with id: {}", catalogId);
        FeeRatesResponseDTO feeRateDTO = feeRateFacade.getById(catalogId);
        log.info("Returning Fee rate : id={}", feeRateDTO.getId());
        return ResponseEntity.ok(feeRateDTO);
    }


    @GetMapping(value = "/component/{componentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByFeeComponentId(@PathVariable Long componentId) {
        log.info("GET /api/fee/rates by componentId called");
        List<FeeRatesResponseDTO> resources = feeRateFacade.getByFeeComponentId(componentId);
        log.info("GET /api/fee/rates by  succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findActiveFeeRates(@RequestParam Long campusId, @RequestParam Long standardId, @RequestParam Long academicYearId) {
        log.info("GET /api/fee/rates/active called with campus={}, standard={}, year={}", campusId, standardId, academicYearId);
        List<FeeRatesResponseDTO> resources = feeRateFacade.findActiveFeeRates(campusId, standardId, academicYearId);
        log.info("Active Fee Rates returned: {}", resources.size());
        return ResponseEntity.ok(resources);
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeRatesResponseDTO> createFeeRate(@Valid @RequestBody FeeRateCreateRequestDTO dto) {
        log.info("POST /api/fee/rates called with payload: {}", dto);
        FeeRatesResponseDTO createdFeeRate = feeRateFacade.create(dto);
        log.info("FeeRate created successfully: id={}", createdFeeRate.getId());
        return ResponseEntity.ok(createdFeeRate);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeRatesResponseDTO> updateFeeRate(@PathVariable Long id, @Valid @RequestBody FeeRateCreateRequestDTO dto) {
        log.info("PUT /api/fee/rates/{} called with payload: {}", id, dto);
        FeeRatesResponseDTO updatedFeeRate = feeRateFacade.update(id, dto);
        log.info("FeeRate updated successfully: id={}", updatedFeeRate.getId());
        return ResponseEntity.ok(updatedFeeRate);
    }
}
