package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.responseDto.InstituteAccreditationResponseDTO;
import java.util.List;

public interface InstituteAccreditationService {
    InstituteAccreditationResponseDTO createAccreditation(InstituteAccreditationCreateRequestDTO requestDTO);

    List<InstituteAccreditationResponseDTO> getAll();

    List<InstituteAccreditationResponseDTO> getByInstituteId(Long instituteId);

    List<InstituteAccreditationResponseDTO> getAllActive();

    InstituteAccreditationResponseDTO getById(Long id);

    InstituteAccreditationResponseDTO updateAccreditation(Long id, InstituteAccreditationUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<InstituteAccreditationResponseDTO> searchByKeyword(String keyword);

    InstituteAccreditationResponseDTO activate(Long id);

    InstituteAccreditationResponseDTO deactivate(Long id);
}
