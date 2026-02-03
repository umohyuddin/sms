package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.responseDto.InstituteFacilityResponseDTO;
import java.util.List;

public interface InstituteFacilityService {
    InstituteFacilityResponseDTO createFacility(InstituteFacilityCreateRequestDTO requestDTO);

    List<InstituteFacilityResponseDTO> getAll();

    List<InstituteFacilityResponseDTO> getByInstituteId(Long instituteId);

    InstituteFacilityResponseDTO getById(Long id);

    InstituteFacilityResponseDTO updateFacility(Long id, InstituteFacilityUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<InstituteFacilityResponseDTO> searchByKeyword(String keyword);
}
