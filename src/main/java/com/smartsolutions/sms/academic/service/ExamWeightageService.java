package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.ExamWeightageRequestDTO;
import com.smartsolutions.sms.academic.dto.response.ExamWeightageResponseDTO;

import java.util.List;

public interface ExamWeightageService {
    void saveWeightages(List<ExamWeightageRequestDTO> dtos);
    List<ExamWeightageResponseDTO> getByStandard(Long standardId, Long academicYearId);
}
