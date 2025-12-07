package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.sclass.dtos.requestDto.StandardCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.requestDto.FeeCatalogComponentRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.responseDto.FeeComponentResponseDTO;
import com.smartsolutions.eschool.student.dtos.feeRates.responseDto.FeeRatesResponseDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeComponentDTO;
import com.smartsolutions.eschool.student.facade.FeeComponentFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/fee/components")
@Slf4j
public class FeeComponentController {

    private final FeeComponentFacade feeComponentFacade;

    public FeeComponentController(FeeComponentFacade feeComponentFacade) {
        this.feeComponentFacade = feeComponentFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/fee/component called");
        List<FeeComponentDTO> resources = feeComponentFacade.getAll();
        log.info("GET /api/fee/component succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeComponentResponseDTO> updateFeeComponent(
            @PathVariable Long id,
            @Valid @RequestBody FeeCatalogComponentRequestDTO dto) {

        log.info("Received request to update Fee Component with id: {}", id);

        // Call the service/facade method to update
        FeeComponentResponseDTO updatedComponent = feeComponentFacade.updateFeeComponent(id, dto);

        log.info("Returning updated Fee Component: id={}", updatedComponent.getId());
        return ResponseEntity.ok(updatedComponent);
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        log.info("Received request to fetch Fee component with id: {}", id);
        FeeComponentDTO feeComponentDTO = feeComponentFacade.getById(id);
        log.info("Returning Fee component: id={}", feeComponentDTO.getId());
        return ResponseEntity.ok(feeComponentDTO);
    }

    @GetMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBySearch(@RequestParam(required = false) Long feeCatalogId, @RequestParam(required = false) String keyword) {
        log.info("GET /api/fee/component/search by keyword called");
        List<FeeComponentResponseDTO> responseDTOS = feeComponentFacade.searchFeeCatalogComponents(feeCatalogId,keyword);
        log.info("GET /api/fee/component/search by keyword succeeded");
        return ResponseEntity.ok().body(responseDTOS);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createFeeCatalogComponent(@Valid @RequestBody FeeCatalogComponentRequestDTO requestDTO) {
        log.info("POST /api/standards - Creating new standard: {}", requestDTO);

        try {
            FeeComponentResponseDTO created = feeComponentFacade.create(requestDTO);
            log.info("Standard created successfully with ID: {}", created.getId());
            return ResponseEntity.ok(created);
        } catch (Exception e) {
            log.error("Failed to create standard", e);
            return ResponseEntity.internalServerError().body("Failed to create standard");
        }
    }

    @GetMapping(value = "catalog/{catalogId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByFeeCatalogId(@PathVariable Long catalogId) throws Exception {
        log.info("Received request to fetch  Fee rate with id: {}", catalogId);
        List<FeeComponentResponseDTO> feeRateDTO = feeComponentFacade.getByFeeCatalogId(catalogId);
        return ResponseEntity.ok(feeRateDTO);
    }
}
