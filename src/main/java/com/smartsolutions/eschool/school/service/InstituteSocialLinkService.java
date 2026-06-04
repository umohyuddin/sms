package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.responseDto.InstituteSocialLinkResponseDTO;
import java.util.List;

public interface InstituteSocialLinkService {
    InstituteSocialLinkResponseDTO createSocialLink(InstituteSocialLinkCreateRequestDTO requestDTO);

    List<InstituteSocialLinkResponseDTO> getAll();

    List<InstituteSocialLinkResponseDTO> getByInstituteId();

    InstituteSocialLinkResponseDTO getById(Long id);

    InstituteSocialLinkResponseDTO updateSocialLink(Long id, InstituteSocialLinkUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<InstituteSocialLinkResponseDTO> searchByKeyword(String keyword);
}
