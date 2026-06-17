package com.smartsolutions.eschool.academic.facade;

import com.smartsolutions.eschool.academic.dto.request.PromotionRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.PromotionResponseDTO;
import com.smartsolutions.eschool.academic.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class PromotionFacade {

    private final PromotionService promotionService;

    public List<PromotionResponseDTO> previewPromotion(PromotionRequestDTO request) {
        return promotionService.previewPromotion(request);
    }

    public List<PromotionResponseDTO> processPromotion(PromotionRequestDTO request) {
        return promotionService.processPromotion(request);
    }
    public List<PromotionResponseDTO> getNextYearStudents(PromotionRequestDTO request) {
        return promotionService.getNextYearStudents(request);
    }
}
