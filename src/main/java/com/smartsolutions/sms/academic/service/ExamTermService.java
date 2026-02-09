package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.ExamTermRequestDTO;
import com.smartsolutions.sms.academic.dto.response.ExamTermResponseDTO;

import java.util.List;

public interface ExamTermService {
    ExamTermResponseDTO create(ExamTermRequestDTO dto);
    ExamTermResponseDTO update(Long id, ExamTermRequestDTO dto);
    List<ExamTermResponseDTO> getActiveByYear(Long academicYearId);
    void delete(Long id);
}
