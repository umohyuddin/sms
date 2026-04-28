package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.responseDto.InstituteSocialLinkResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteSocialLinkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class InstituteSocialLinkFacade {

    private final InstituteSocialLinkService instituteSocialLinkService;

    public InstituteSocialLinkFacade(InstituteSocialLinkService instituteSocialLinkService) {
        this.instituteSocialLinkService = instituteSocialLinkService;
    }

    public InstituteSocialLinkResponseDTO createSocialLink(InstituteSocialLinkCreateRequestDTO requestDTO) {
        log.info("[Facade:InstituteSocialLinkFacade] createSocialLink() called - Request to create social link");
        return instituteSocialLinkService.createSocialLink(requestDTO);
    }

    public List<InstituteSocialLinkResponseDTO> getAll() {
        log.info("[Facade:InstituteSocialLinkFacade] getAll() called - Request to get all social links");
        return instituteSocialLinkService.getAll();
    }

    public List<InstituteSocialLinkResponseDTO> getByInstituteId() {
        log.info(
                "[Facade:InstituteSocialLinkFacade] getByInstituteId() called - Request to get social links by instituteId");
        return instituteSocialLinkService.getByInstituteId();
    }

    public InstituteSocialLinkResponseDTO getById(Long id) {
        log.info("[Facade:InstituteSocialLinkFacade] getById() called - Request to get social link by id: {}", id);
        return instituteSocialLinkService.getById(id);
    }

    public InstituteSocialLinkResponseDTO updateSocialLink(Long id,
            InstituteSocialLinkUpdateRequestDTO requestDTO) {
        log.info("[Facade:InstituteSocialLinkFacade] updateSocialLink() called - Request to update social link: {}",
                id);
        return instituteSocialLinkService.updateSocialLink(id, requestDTO);
    }

    public void deleteById(Long id) {
        log.info("[Facade:InstituteSocialLinkFacade] deleteById() called - Request to delete social link: {}", id);
        instituteSocialLinkService.deleteById(id);
    }

    public List<InstituteSocialLinkResponseDTO> searchByKeyword(String keyword) {
        log.info(
                "[Facade:InstituteSocialLinkFacade] searchByKeyword() called - Request to search social links with keyword: {}",
                keyword);
        return instituteSocialLinkService.searchByKeyword(keyword);
    }
}
