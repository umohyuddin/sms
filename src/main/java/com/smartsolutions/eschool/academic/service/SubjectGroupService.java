package com.smartsolutions.eschool.academic.service;

import com.smartsolutions.eschool.academic.dto.request.SubjectGroupRequestDTO;
import com.smartsolutions.eschool.academic.dto.response.SubjectGroupResponseDTO;

import java.util.List;

public interface SubjectGroupService {
    SubjectGroupResponseDTO create(SubjectGroupRequestDTO dto);
    SubjectGroupResponseDTO update(Long id, SubjectGroupRequestDTO dto);
    SubjectGroupResponseDTO getById(Long id);
    List<SubjectGroupResponseDTO> getAllActive();
    void delete(Long id);
}
