package com.smartsolutions.sms.academic.service;

import com.smartsolutions.sms.academic.dto.request.SubjectRequestDTO;
import com.smartsolutions.sms.academic.dto.response.SubjectResponseDTO;

import java.util.List;

public interface SubjectService {
    SubjectResponseDTO create(SubjectRequestDTO dto);
    SubjectResponseDTO update(Long id, SubjectRequestDTO dto);
    SubjectResponseDTO getById(Long id);
    List<SubjectResponseDTO> getAllActive();
    List<SubjectResponseDTO> getByGroupId(Long groupId);
    void delete(Long id);
}
