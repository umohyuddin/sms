package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.ExamRequestDTO;
import com.smartsolutions.sms.academic.dto.response.ExamResponseDTO;

import java.util.List;

public interface ExamService {
    ExamResponseDTO create(ExamRequestDTO dto);
    ExamResponseDTO update(Long id, ExamRequestDTO dto);
    ExamResponseDTO getById(Long id);
    List<ExamResponseDTO> getBySection(Long standardId, Long sectionId, Long academicYearId);
    void delete(Long id);
}
