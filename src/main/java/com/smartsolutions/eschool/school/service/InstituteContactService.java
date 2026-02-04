package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.responseDto.InstituteContactResponseDTO;
import java.util.List;

public interface InstituteContactService {
    InstituteContactResponseDTO createContact(InstituteContactCreateRequestDTO requestDTO);

    List<InstituteContactResponseDTO> getAll();

    List<InstituteContactResponseDTO> getByInstituteId(Long instituteId);

    InstituteContactResponseDTO getById(Long id,Long instituteId);

    InstituteContactResponseDTO updateContact(Long id, Long instituteId,InstituteContactUpdateRequestDTO requestDTO);

    void deleteById(Long id, Long organizationId);

    List<InstituteContactResponseDTO> searchByKeyword(Long instituteId,String keyword);
}
