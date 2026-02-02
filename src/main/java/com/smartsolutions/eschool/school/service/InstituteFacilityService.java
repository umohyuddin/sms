package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.responseDto.InstituteFacilityResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InstituteFacilityService {
    InstituteFacilityResponseDTO createFacility(InstituteFacilityCreateRequestDTO requestDTO);

    Page<InstituteFacilityResponseDTO> getAll(Pageable pageable);

    Page<InstituteFacilityResponseDTO> getByInstituteId(Long instituteId, Pageable pageable);

    InstituteFacilityResponseDTO getById(Long id);

    InstituteFacilityResponseDTO updateFacility(Long id, InstituteFacilityUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<InstituteFacilityResponseDTO> searchByKeyword(String keyword);
}
