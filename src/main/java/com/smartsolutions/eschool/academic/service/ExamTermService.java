package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.ExamTermRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.ExamTermResponseDTO;

import java.util.List;

public interface ExamTermService {
    ExamTermResponseDTO create(ExamTermRequestDTO dto);

    ExamTermResponseDTO update(Long id, ExamTermRequestDTO dto);

    ExamTermResponseDTO getById(Long id);

    List<ExamTermResponseDTO> getActiveByYear(Long academicYearId);

    List<ExamTermResponseDTO> getActiveByYearAndTenant(Long academicYearId);

    List<ExamTermResponseDTO> searchByKeyword(String keyword);

    void delete(Long id);
}
