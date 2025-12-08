package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.facade.DiscountTypeFacade;
import com.smartsolutions.eschool.sclass.dtos.responseDto.SectionDTO;
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
@RequestMapping("/api/school/discounts/types")
@Slf4j
public class DiscountTypeController {
    private final DiscountTypeFacade discountTypeFacade;

    public DiscountTypeController(DiscountTypeFacade discountTypeFacade) {
        this.discountTypeFacade = discountTypeFacade;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createDiscountType(@RequestBody @Valid DiscountTypeRequestDTO requestDTO) {
        log.info("Received request to create Discount Type");
        DiscountTypeResponseDTO discountTypeResponseDTO = discountTypeFacade.createDiscountType(requestDTO);
        log.info("Discount Type created successfully with id: {}", discountTypeResponseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(discountTypeResponseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/school/discounts/types called");
        List<DiscountTypeResponseDTO> resources = discountTypeFacade.getAll();
        log.info("GET /api/school/discounts/types succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllActive() throws Exception {
        log.info("GET /api/school/discounts/types/active called");
        List<DiscountTypeResponseDTO> resources = discountTypeFacade.getAllActive();
        log.info("GET /api/school/discounts/types/active succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllInActive() throws Exception {
        log.info("GET /api/school/discounts/types/inactive called");
        List<DiscountTypeResponseDTO> resources = discountTypeFacade.getAllInActive();
        log.info("GET /api/school/discounts/types/inactive succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{discountTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long discountTypeId) throws Exception {
        log.info("GET /api/school/discounts/types by id called");
        DiscountTypeResponseDTO resources = discountTypeFacade.getById(discountTypeId);
        log.info("GET /api/school/discounts/types by id succeeded, returned {} resource id", resources.getId());
        return ResponseEntity.ok().body(resources);
    }


    @DeleteMapping("/{discountTypeId}")
    public ResponseEntity<?> softDeleteById(@PathVariable Long discountTypeId) {
        log.info("DELETE /api/school/discounts/types by id called {}", discountTypeId);

        int result = discountTypeFacade.softDeleteById(discountTypeId);
        if (result == 0) {
            log.warn("delete failed — DiscountType not found: {}", discountTypeId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DiscountType not found with id: " + discountTypeId);
        }
        log.info("DiscountType deleted successfully: {}", discountTypeId);
        return ResponseEntity.ok("DiscountType deleted successfully");
    }


    @GetMapping(value = "search/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBySearch(@PathVariable String keyword) {
        log.info("GET /api/school/discounts/types/search by keyword called");
        List<DiscountTypeResponseDTO> sectionDTO = discountTypeFacade.searchByKeyword(keyword);
        log.info("GET /api/school/discounts/types/search by keyword succeeded");
        return ResponseEntity.ok().body(sectionDTO);
    }

    @PutMapping(value = "/{discountTypeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateDiscountType(@PathVariable Long discountTypeId, @RequestBody @Valid DiscountTypeRequestDTO requestDTO) {

        log.info("Received request to update Discount Type with id: {}", discountTypeId);

        DiscountTypeResponseDTO updatedDiscountType = discountTypeFacade.updateDiscountType(discountTypeId, requestDTO);

        if (updatedDiscountType == null) {
            log.warn("Discount Type not found for id: {}", discountTypeId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Discount Type not found with id: " + discountTypeId);
        }
        log.info("Discount Type updated successfully with id: {}", updatedDiscountType.getId());
        return ResponseEntity.ok(updatedDiscountType);
    }

}
