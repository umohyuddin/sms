package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.responseDto.InstituteAccreditationResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InstituteAccreditationService {
    InstituteAccreditationResponseDTO createAccreditation(InstituteAccreditationCreateRequestDTO requestDTO);

    Page<InstituteAccreditationResponseDTO> getAll(Pageable pageable);

    Page<InstituteAccreditationResponseDTO> getByInstituteId(Long instituteId, Pageable pageable);

    List<InstituteAccreditationResponseDTO> getAllActive();

    InstituteAccreditationResponseDTO getById(Long id);

    InstituteAccreditationResponseDTO updateAccreditation(Long id, InstituteAccreditationUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<InstituteAccreditationResponseDTO> searchByKeyword(String keyword);

    InstituteAccreditationResponseDTO activate(Long id);

    InstituteAccreditationResponseDTO deactivate(Long id);
}
