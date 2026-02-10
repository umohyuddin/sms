package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.ExamTermRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.ExamTermResponseDTO;

import java.util.List;

public interface ExamTermService {
    ExamTermResponseDTO create(ExamTermRequestDTO dto);
    ExamTermResponseDTO update(Long id, ExamTermRequestDTO dto);
    List<ExamTermResponseDTO> getActiveByYear(Long academicYearId);
    void delete(Long id);
}
