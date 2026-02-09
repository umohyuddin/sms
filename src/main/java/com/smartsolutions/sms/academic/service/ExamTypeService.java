package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.ExamTypeRequestDTO;
import com.smartsolutions.sms.academic.dto.response.ExamTypeResponseDTO;

import java.util.List;

public interface ExamTypeService {
    ExamTypeResponseDTO create(ExamTypeRequestDTO dto);
    ExamTypeResponseDTO update(Long id, ExamTypeRequestDTO dto);
    ExamTypeResponseDTO getById(Long id);
    List<ExamTypeResponseDTO> getAllActive();
    void delete(Long id);
}
