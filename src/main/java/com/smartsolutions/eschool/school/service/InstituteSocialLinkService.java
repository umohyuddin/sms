package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.responseDto.InstituteSocialLinkResponseDTO;
import java.util.List;

public interface InstituteSocialLinkService {
    InstituteSocialLinkResponseDTO createSocialLink(InstituteSocialLinkCreateRequestDTO requestDTO);

    List<InstituteSocialLinkResponseDTO> getAll(Long instituteId);

    List<InstituteSocialLinkResponseDTO> getByInstituteId(Long instituteId);

    InstituteSocialLinkResponseDTO getById(Long id, Long instituteId);

    InstituteSocialLinkResponseDTO updateSocialLink(Long id, Long instituteId, InstituteSocialLinkUpdateRequestDTO requestDTO);

    void deleteById(Long id, Long instituteId);

    List<InstituteSocialLinkResponseDTO> searchByKeyword(String keyword, Long instituteId);
}
