package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.SubjectGroupRequestDTO;
import com.smartsolutions.sms.academic.dto.response.SubjectGroupResponseDTO;

import java.util.List;

public interface SubjectGroupService {
    SubjectGroupResponseDTO create(SubjectGroupRequestDTO dto);
    SubjectGroupResponseDTO update(Long id, SubjectGroupRequestDTO dto);
    SubjectGroupResponseDTO getById(Long id);
    List<SubjectGroupResponseDTO> getAllActive();
    void delete(Long id);
}
