package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.PromotionRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.PromotionResponseDTO;

import java.util.List;

public interface PromotionService {
    List<PromotionResponseDTO> previewPromotion(PromotionRequestDTO request);
    List<PromotionResponseDTO> processPromotion(PromotionRequestDTO request);
    List<PromotionResponseDTO> getNextYearStudents(PromotionRequestDTO request);
}
