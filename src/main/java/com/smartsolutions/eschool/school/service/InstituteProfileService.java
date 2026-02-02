package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteProfiles.requestDto.InstituteProfileCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteProfiles.requestDto.InstituteProfileUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteProfiles.responseDto.InstituteProfileResponseDTO;

import java.util.List;

public interface InstituteProfileService {
    InstituteProfileResponseDTO createProfile(InstituteProfileCreateRequestDTO requestDTO);

    InstituteProfileResponseDTO getById(Long id);

    InstituteProfileResponseDTO getByInstituteId(Long instituteId);

    InstituteProfileResponseDTO updateProfile(Long id, InstituteProfileUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<InstituteProfileResponseDTO> searchByKeyword(String keyword);
}
