package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.sclass.dtos.requestDto.StandardCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.requestDto.FeeCatalogComponentRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.responseDto.FeeComponentResponseDTO;
import com.smartsolutions.eschool.student.dtos.feeRates.responseDto.FeeRatesResponseDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeComponentDTO;
import com.smartsolutions.eschool.student.facade.FeeComponentFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

        // ====================================
        // GET ALL COMPONENTS
        // ====================================
        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<FeeComponentResponseDTO>> getAll() {
            log.info("[Controller:FeeComponentController] getAll() called");
            List<FeeComponentResponseDTO> resources = feeComponentFacade.getAll();
            log.info("[Controller:FeeComponentController] getAll() succeeded - Found {} components", resources.size());
            return ResponseEntity.ok(resources);
        }

        // ====================================
        // GET COMPONENT BY ID
        // ====================================
        @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<FeeComponentResponseDTO> getById(@PathVariable Long id) {
            log.info("[Controller:FeeComponentController] getById() called - id: {}", id);
            FeeComponentResponseDTO responseDTO = feeComponentFacade.getById(id);
            log.info("[Controller:FeeComponentController] getById() succeeded - id: {}", id);
            return ResponseEntity.ok(responseDTO);
        }

        // ====================================
        // GET COMPONENTS BY FEE CATALOG
        // ====================================
        @GetMapping(value = "/catalog/{catalogId}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<FeeComponentResponseDTO>> getByFeeCatalogId(@PathVariable Long catalogId) {
            log.info("[Controller:FeeComponentController] getByFeeCatalogId() called - catalogId: {}", catalogId);
            List<FeeComponentResponseDTO> response = feeComponentFacade.getByFeeCatalogId(catalogId);
            log.info("[Controller:FeeComponentController] getByFeeCatalogId() succeeded - Found {} components", response.size());
            return ResponseEntity.ok(response);
        }

        // ====================================
        // SEARCH COMPONENTS
        // ====================================
        @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<FeeComponentResponseDTO>> search(
                @RequestParam(required = false) Long feeCatalogId,
                @RequestParam(required = false) String keyword
        ) {
            log.info("[Controller:FeeComponentController] search() called - catalogId: {}, keyword: {}", feeCatalogId, keyword);
            List<FeeComponentResponseDTO> response = feeComponentFacade.searchFeeCatalogComponents(feeCatalogId, keyword);
            log.info("[Controller:FeeComponentController] search() succeeded - Found {} components", response.size());
            return ResponseEntity.ok(response);
        }

        // ====================================
        // CREATE COMPONENT
        // ====================================
        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<FeeComponentResponseDTO> create(@Valid @RequestBody FeeCatalogComponentRequestDTO requestDTO) {
            log.info("[Controller:FeeComponentController] create() called - componentCode: {}", requestDTO.getComponentCode());
            FeeComponentResponseDTO created = feeComponentFacade.create(requestDTO);
            log.info("[Controller:FeeComponentController] create() succeeded - id: {}", created.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        }

        // ====================================
        // UPDATE COMPONENT
        // ====================================
        @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<FeeComponentResponseDTO> update(@PathVariable Long id, @Valid @RequestBody FeeCatalogComponentRequestDTO requestDTO) {
            log.info("[Controller:FeeComponentController] update() called - id: {}", id);
            FeeComponentResponseDTO updated = feeComponentFacade.updateFeeComponent(id, requestDTO);
            log.info("[Controller:FeeComponentController] update() succeeded - id: {}", updated.getId());
            return ResponseEntity.ok(updated);
        }

    }