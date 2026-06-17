package com.smartsolutions.eschool.academic.controller;

import com.smartsolutions.eschool.academic.dto.request.PromotionRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.PromotionResponseDTO;
import com.smartsolutions.eschool.academic.facade.PromotionFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promotion")
@RequiredArgsConstructor
@Slf4j
public class PromotionController {

    private final PromotionFacade promotionFacade;

    @GetMapping("/preview")
    public ResponseEntity<List<PromotionResponseDTO>> previewPromotion(@Valid @org.springframework.web.bind.annotation.ModelAttribute PromotionRequestDTO request) {
        log.info("REST request to preview promotion: {}", request);
        return ResponseEntity.ok(promotionFacade.previewPromotion(request));
    }

    @PostMapping("/processPromotion")
    public ResponseEntity<List<PromotionResponseDTO>> processPromotion(@Valid @RequestBody PromotionRequestDTO request) {
        log.info("REST request to process promotion: {}", request);
        return ResponseEntity.ok(promotionFacade.processPromotion(request));
    }

    @GetMapping("/next-year-students")
    public ResponseEntity<List<PromotionResponseDTO>> getNextYearStudents(
            @ModelAttribute  PromotionRequestDTO request) {
        log.info("REST request to get next year students: {}", request);
        return ResponseEntity.ok(promotionFacade.getNextYearStudents(request));
    }
}

