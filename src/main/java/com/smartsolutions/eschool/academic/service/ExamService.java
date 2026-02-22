package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.ExamRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.ExamResponseDTO;

import java.util.List;

public interface ExamService {
    List<ExamResponseDTO> create(ExamRequestDTO dto);

    ExamResponseDTO update(Long id, ExamRequestDTO dto);

    ExamResponseDTO getById(Long id);

    ExamResponseDTO getById(Long id, Long orgId);

    List<ExamResponseDTO> getBySection(Long standardId, Long sectionId, Long academicYearId);

    List<ExamResponseDTO> search(Long academicYearId, Long campusId, Long standardId, Long sectionId, Long examTermId,
            Long examTypeId, String keyword);

    void delete(Long id);
}
