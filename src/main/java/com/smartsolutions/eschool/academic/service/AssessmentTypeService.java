package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.AssessmentTypeRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.AssessmentTypeResponseDTO;

import java.util.List;

public interface AssessmentTypeService {
    AssessmentTypeResponseDTO create(AssessmentTypeRequestDTO dto);
    AssessmentTypeResponseDTO update(Long id, AssessmentTypeRequestDTO dto);
    List<AssessmentTypeResponseDTO> getAllActive();
    void delete(Long id);
}
