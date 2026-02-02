package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.responseDto.InstituteSocialLinkResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InstituteSocialLinkService {
    InstituteSocialLinkResponseDTO createSocialLink(InstituteSocialLinkCreateRequestDTO requestDTO);

    Page<InstituteSocialLinkResponseDTO> getAll(Pageable pageable);

    Page<InstituteSocialLinkResponseDTO> getByInstituteId(Long instituteId, Pageable pageable);

    InstituteSocialLinkResponseDTO getById(Long id);

    InstituteSocialLinkResponseDTO updateSocialLink(Long id, InstituteSocialLinkUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<InstituteSocialLinkResponseDTO> searchByKeyword(String keyword);
}
