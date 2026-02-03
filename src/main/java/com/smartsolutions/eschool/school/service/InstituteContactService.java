package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.responseDto.InstituteContactResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InstituteContactService {
    InstituteContactResponseDTO createContact(InstituteContactCreateRequestDTO requestDTO);

    Page<InstituteContactResponseDTO> getAll(Pageable pageable);

    Page<InstituteContactResponseDTO> getByInstituteId(Long instituteId, Pageable pageable);

    InstituteContactResponseDTO getById(Long id,Long instituteId);

    InstituteContactResponseDTO updateContact(Long id, Long instituteId,InstituteContactUpdateRequestDTO requestDTO);

    void deleteById(Long id, Long organizationId);

    List<InstituteContactResponseDTO> searchByKeyword(String keyword);
}
