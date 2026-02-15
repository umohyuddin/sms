package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.AssessmentTypeRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.AssessmentTypeResponseDTO;

import java.util.List;

public interface AssessmentTypeService {
    AssessmentTypeResponseDTO create(AssessmentTypeRequestDTO dto);

    AssessmentTypeResponseDTO update(Long id, AssessmentTypeRequestDTO dto);

    AssessmentTypeResponseDTO getById(Long id);

    List<AssessmentTypeResponseDTO> getAllActive();

    List<AssessmentTypeResponseDTO> searchByKeyword(String keyword);

    void delete(Long id);
}
