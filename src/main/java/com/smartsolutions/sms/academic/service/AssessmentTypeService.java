package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.AssessmentTypeRequestDTO;
import com.smartsolutions.sms.academic.dto.response.AssessmentTypeResponseDTO;

import java.util.List;

public interface AssessmentTypeService {
    AssessmentTypeResponseDTO create(AssessmentTypeRequestDTO dto);
    AssessmentTypeResponseDTO update(Long id, AssessmentTypeRequestDTO dto);
    List<AssessmentTypeResponseDTO> getAllActive();
    void delete(Long id);
}
