package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.discountSubType.requestDto.DiscountSubTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountSubType.responseDto.DiscountSubTypeResponseDTO;
import com.smartsolutions.eschool.school.facade.DiscountSubTypeFacade;
import com.smartsolutions.eschool.student.dtos.feeCatalogComponent.responseDto.FeeComponentResponseDTO;
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
@RequestMapping("/api/school/discounts/subtypes")
@Slf4j
public class DiscountSubTypeController {
    private final DiscountSubTypeFacade discountSubTypeFacade;

    public DiscountSubTypeController(DiscountSubTypeFacade discountSubTypeFacade) {
        this.discountSubTypeFacade = discountSubTypeFacade;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createDiscountSubType(@RequestBody @Valid DiscountSubTypeRequestDTO requestDTO) {
        log.info("Received request to create Discount Sub Type");
        DiscountSubTypeResponseDTO responseDTO = discountSubTypeFacade.createSubDiscountType(requestDTO);
        log.info("Discount Sub Type created successfully with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/school/discounts/types called");
        List<DiscountSubTypeResponseDTO> resources = discountSubTypeFacade.getAll();
        log.info("GET /api/school/discounts/types succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllActive() throws Exception {
        log.info("GET /api/school/discounts/subtypes/active called");
        List<DiscountSubTypeResponseDTO> resources = discountSubTypeFacade.getAllActive();
        log.info("GET /api/school/discounts/subtypes/active succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllInActive() throws Exception {
        log.info("GET /api/school/discounts/subtypes/inactive called");
        List<DiscountSubTypeResponseDTO> resources = discountSubTypeFacade.getAllInActive();
        log.info("GET /api/school/discounts/subtypes/inactive succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }

    @GetMapping(value = "/{discountSubTypeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long discountSubTypeId) throws Exception {
        log.info("GET /api/school/discounts/subtypes by id called");
        DiscountSubTypeResponseDTO resources = discountSubTypeFacade.getById(discountSubTypeId);
        log.info("GET /api/school/discounts/subtypes by id succeeded, returned {} resource id", resources.getId());
        return ResponseEntity.ok().body(resources);
    }


    @DeleteMapping("/{discountSubTypeId}")
    public ResponseEntity<?> softDeleteById(@PathVariable Long discountSubTypeId) {
        log.info("DELETE /api/school/discounts/subtypes by id called {}", discountSubTypeId);

        int result = discountSubTypeFacade.softDeleteById(discountSubTypeId);
        if (result == 0) {
            log.warn("delete failed — DiscountSubType not found: {}", discountSubTypeId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("DiscountSubType not found with id: " + discountSubTypeId);
        }
        log.info("DiscountSubType deleted successfully: {}", discountSubTypeId);
        return ResponseEntity.ok("DiscountSubType deleted successfully");

    }


    @DeleteMapping("/all")
    public ResponseEntity<?> softDeleteAll() {
        log.info("API Request: delete ALL DiscountSubTypes");
        try {
            int rows = discountSubTypeFacade.softDeleteAll();
            log.info("Deleted ALL DiscountSubTypes. Count: {}", rows);
            return ResponseEntity.ok(rows + " DiscountSubTypes deleted");
        } catch (Exception ex) {
            log.error("Error deleting ALL DiscountSubTypes", ex);
            return ResponseEntity.internalServerError().body("Failed to delete all DiscountSubTypes");
        }
    }

//    @GetMapping(value = "search/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getBySearch(@PathVariable String keyword) {
//        log.info("GET /api/school/discounts/subtypes/search by keyword called");
//        List<DiscountSubTypeResponseDTO> sectionDTO = discountSubTypeFacade.searchByKeyword(keyword);
//        log.info("GET /api/school/discounts/subtypes/search by keyword succeeded");
//        return ResponseEntity.ok().body(sectionDTO);
//    }

    @PatchMapping(value = "/{discountSubTypeId}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> markAsActive(@PathVariable Long discountSubTypeId) {
        log.info("PATCH /api/school/discounts/subtypes/{}/activate called", discountSubTypeId);
        int updatedCount = discountSubTypeFacade.markAsActive(discountSubTypeId);
        log.info("DiscountSubType marked as active successfully: {}", discountSubTypeId);
        return ResponseEntity.ok("DiscountSubType marked as active successfully");
    }

    @PatchMapping(value = "/{discountSubTypeId}/deactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> markAsInactive(@PathVariable Long discountSubTypeId) {
        log.info("PATCH /api/school/discounts/subtypes/{}/deactivate called", discountSubTypeId);
        int updatedCount = discountSubTypeFacade.markAsInactive(discountSubTypeId);
        log.info("DiscountSubType marked as inactive successfully: {}", discountSubTypeId);
        return ResponseEntity.ok("DiscountSubType marked as inactive successfully");
    }

    @GetMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBySearch(@RequestParam(required = false) Long discountTypeId, @RequestParam(required = false) String keyword) {
        log.info("GET /api/fee/component/search by keyword called");
        List<DiscountSubTypeResponseDTO> responseDTOS = discountSubTypeFacade.searchDiscountComponents(discountTypeId,keyword);
        log.info("GET /api/fee/component/search by keyword succeeded");
        return ResponseEntity.ok().body(responseDTOS);
    }
}
