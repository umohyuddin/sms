package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.ExamTypeRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.ExamTypeResponseDTO;

import java.util.List;

public interface ExamTypeService {
    ExamTypeResponseDTO create(ExamTypeRequestDTO dto);

    ExamTypeResponseDTO update(Long id, ExamTypeRequestDTO dto);

    ExamTypeResponseDTO getById(Long id);

    List<ExamTypeResponseDTO> getAllActive();

    List<ExamTypeResponseDTO> searchByKeyword(String keyword);

    void delete(Long id);
}
