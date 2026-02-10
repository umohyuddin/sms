package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.ExamWeightageRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.ExamWeightageResponseDTO;

import java.util.List;

public interface ExamWeightageService {
    void saveWeightages(List<ExamWeightageRequestDTO> dtos);
    List<ExamWeightageResponseDTO> getByStandard(Long standardId, Long academicYearId);
}
