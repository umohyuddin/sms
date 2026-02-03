package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.responseDto.InstituteSocialLinkResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteSocialLinkService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class InstituteSocialLinkFacade {

    private final InstituteSocialLinkService instituteSocialLinkService;

    public InstituteSocialLinkFacade(InstituteSocialLinkService instituteSocialLinkService) {
        this.instituteSocialLinkService = instituteSocialLinkService;
    }

    public InstituteSocialLinkResponseDTO createSocialLink(InstituteSocialLinkCreateRequestDTO requestDTO) {
        return instituteSocialLinkService.createSocialLink(requestDTO);
    }

    public List<InstituteSocialLinkResponseDTO> getAll() {
        return instituteSocialLinkService.getAll();
    }

    public List<InstituteSocialLinkResponseDTO> getByInstituteId(Long instituteId) {
        return instituteSocialLinkService.getByInstituteId(instituteId);
    }

    public InstituteSocialLinkResponseDTO getById(Long id) {
        return instituteSocialLinkService.getById(id);
    }

    public InstituteSocialLinkResponseDTO updateSocialLink(Long id, InstituteSocialLinkUpdateRequestDTO requestDTO) {
        return instituteSocialLinkService.updateSocialLink(id, requestDTO);
    }

    public void deleteById(Long id) {
        instituteSocialLinkService.deleteById(id);
    }

    public List<InstituteSocialLinkResponseDTO> searchByKeyword(String keyword) {
        return instituteSocialLinkService.searchByKeyword(keyword);
    }
}
