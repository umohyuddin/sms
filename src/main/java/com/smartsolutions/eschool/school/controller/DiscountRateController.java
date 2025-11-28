package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.discountRate.requestDto.DiscountRateRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountRate.responseDto.DiscountRateResponseDTO;
import com.smartsolutions.eschool.school.facade.DiscountRateFacade;
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
@RequestMapping("/api/school/discounts/rates")
@Slf4j
public class DiscountRateController {

    private final DiscountRateFacade discountRateFacade;

    public DiscountRateController(DiscountRateFacade discountRateFacade) {
        this.discountRateFacade = discountRateFacade;
    }

    // -------------------------------------------------------------------------
    // CREATE
    // -------------------------------------------------------------------------
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createDiscountRate(@RequestBody @Valid DiscountRateRequestDTO requestDTO) {
        log.info("Received request to create Discount Rate");
        DiscountRateResponseDTO responseDTO = discountRateFacade.createDiscountRate(requestDTO);
        log.info("Discount Rate created successfully with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    // -------------------------------------------------------------------------
    // GET ALL
    // -------------------------------------------------------------------------
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        log.info("GET /api/school/discounts/rates called");
        List<DiscountRateResponseDTO> list = discountRateFacade.getAll();
        log.info("GET /api/school/discounts/rates succeeded, returned {} resources", list.size());
        return ResponseEntity.ok().body(list);
    }

//    // -------------------------------------------------------------------------
//    // GET ACTIVE
//    // -------------------------------------------------------------------------
//    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getAllActive() {
//        log.info("GET /api/school/discounts/rates/active called");
//        List<DiscountRateResponseDTO> list = discountRateFacade.getAllActive();
//        log.info("GET /api/school/discounts/rates/active succeeded, returned {} resources", list.size());
//        return ResponseEntity.ok().body(list);
//    }
//
//    // -------------------------------------------------------------------------
//    // GET INACTIVE
//    // -------------------------------------------------------------------------
//    @GetMapping(value = "/inactive", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> getAllInactive() {
//        log.info("GET /api/school/discounts/rates/inactive called");
//        List<DiscountRateResponseDTO> list = discountRateFacade.getAllInactive();
//        log.info("GET /api/school/discounts/rates/inactive succeeded, returned {} resources", list.size());
//        return ResponseEntity.ok().body(list);
//    }

    // -------------------------------------------------------------------------
    // GET BY ID
    // -------------------------------------------------------------------------
    @GetMapping(value = "/{discountRateId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable Long discountRateId) {
        log.info("GET /api/school/discounts/rates/{} called", discountRateId);
        DiscountRateResponseDTO dto = discountRateFacade.getById(discountRateId);
        log.info("GET /api/school/discounts/rates succeeded, returned resource id {}", dto.getId());
        return ResponseEntity.ok().body(dto);
    }

//    // -------------------------------------------------------------------------
//    // DELETE BY ID (Soft Delete)
//    // -------------------------------------------------------------------------
//    @DeleteMapping("/{discountRateId}")
//    public ResponseEntity<?> softDeleteById(@PathVariable Long discountRateId) {
//        log.info("DELETE /api/school/discounts/rates/{} called", discountRateId);
//
//        int result = discountRateFacade.softDelete(discountRateId);
//        if (result == 0) {
//            log.warn("Delete failed — DiscountRate not found: {}", discountRateId);
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("DiscountRate not found with id: " + discountRateId);
//        }
//
//        log.info("DiscountRate deleted successfully: {}", discountRateId);
//        return ResponseEntity.ok("DiscountRate deleted successfully");
//    }

    // -------------------------------------------------------------------------
    // DELETE ALL
    // -------------------------------------------------------------------------
    @DeleteMapping("/all")
    public ResponseEntity<?> softDeleteAll() {
        log.info("DELETE ALL /api/school/discounts/rates called");
        int count = discountRateFacade.softDeleteAll();
        log.info("Deleted ALL DiscountRates. Count: {}", count);
        return ResponseEntity.ok(count + " DiscountRates deleted");
    }

//    // -------------------------------------------------------------------------
//    // SEARCH
//    // -------------------------------------------------------------------------
//    @GetMapping(value = "search/{keyword}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> search(@PathVariable String keyword) {
//        log.info("GET /api/school/discounts/rates/search/{} called", keyword);
//        List<DiscountRateResponseDTO> list = discountRateFacade.search(keyword);
//        log.info("Search succeeded, returned {} results", list.size());
//        return ResponseEntity.ok().body(list);
//    }

    // -------------------------------------------------------------------------
    // ACTIVATE
    // -------------------------------------------------------------------------
    @PatchMapping(value = "/{discountRateId}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> activate(@PathVariable Long discountRateId) {
        log.info("PATCH /api/school/discounts/rates/{}/activate called", discountRateId);
        discountRateFacade.markAsActive(discountRateId);
        return ResponseEntity.ok("DiscountRate marked as active successfully");
    }

    // -------------------------------------------------------------------------
    // DEACTIVATE
    // -------------------------------------------------------------------------
    @PatchMapping(value = "/{discountRateId}/deactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deactivate(@PathVariable Long discountRateId) {
        log.info("PATCH /api/school/discounts/rates/{}/deactivate called", discountRateId);
        discountRateFacade.markAsInactive(discountRateId);
        return ResponseEntity.ok("DiscountRate marked as inactive successfully");
    }
}
