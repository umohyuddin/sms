package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.GradeScaleRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.GradeScaleResponseDTO;

import java.util.List;

public interface GradeScaleService {
    GradeScaleResponseDTO create(GradeScaleRequestDTO dto);
    GradeScaleResponseDTO update(Long id, GradeScaleRequestDTO dto);
    List<GradeScaleResponseDTO> getAllActive();
    void delete(Long id);
}
