package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.facade.DiscountTypeFacade;
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
@RequestMapping("/api/school/discounts")
@Slf4j
public class DiscountTypeController {
   private final DiscountTypeFacade discountTypeFacade;

    public DiscountTypeController(DiscountTypeFacade discountTypeFacade) {
        this.discountTypeFacade = discountTypeFacade;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAcademicYear(@RequestBody @Valid DiscountTypeRequestDTO requestDTO) {
        log.info("Received request to create academic year");
        DiscountTypeRequestDTO discountTypeRequestDTO = discountTypeFacade.createDiscountType(requestDTO);
        log.info("Academic year created successfully with id: {}", discountTypeRequestDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(discountTypeRequestDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() throws Exception {
        log.info("GET /api/school/academic called");
        List<DiscountTypeResponseDTO> resources = discountTypeFacade.getAll();
        log.info("GET /api/school/academic succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok().body(resources);
    }
}
