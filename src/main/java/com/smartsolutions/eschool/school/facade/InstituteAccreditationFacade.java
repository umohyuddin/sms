package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.responseDto.InstituteAccreditationResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteAccreditationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class InstituteAccreditationFacade {

    private final InstituteAccreditationService instituteAccreditationService;

    public InstituteAccreditationFacade(InstituteAccreditationService instituteAccreditationService) {
        this.instituteAccreditationService = instituteAccreditationService;
    }

    public InstituteAccreditationResponseDTO createAccreditation(InstituteAccreditationCreateRequestDTO requestDTO) {
        log.info(
                "[Facade:InstituteAccreditationFacade] createAccreditation() called - Request to create accreditation");
        return instituteAccreditationService.createAccreditation(requestDTO);
    }

    public List<InstituteAccreditationResponseDTO> getAll() {
        log.info("[Facade:InstituteAccreditationFacade] getAll() called - Request to get all accreditations");
        return instituteAccreditationService.getAll();
    }

    public List<InstituteAccreditationResponseDTO> getByInstituteId(Long instituteId) {
        log.info(
                "[Facade:InstituteAccreditationFacade] getByInstituteId() called - Request to get accreditations for institute: {}",
                instituteId);
        return instituteAccreditationService.getByInstituteId(instituteId);
    }

    public List<InstituteAccreditationResponseDTO> getAllActive() {
        log.info(
                "[Facade:InstituteAccreditationFacade] getAllActive() called - Request to get all active accreditations");
        return instituteAccreditationService.getAllActive();
    }

    public InstituteAccreditationResponseDTO getById(Long id) {
        log.info("[Facade:InstituteAccreditationFacade] getById() called - Request to get accreditation by id: {}", id);
        return instituteAccreditationService.getById(id);
    }

    public InstituteAccreditationResponseDTO updateAccreditation(Long id,
            InstituteAccreditationUpdateRequestDTO requestDTO) {
        log.info(
                "[Facade:InstituteAccreditationFacade] updateAccreditation() called - Request to update accreditation: {}",
                id);
        return instituteAccreditationService.updateAccreditation(id, requestDTO);
    }

    public void deleteById(Long id) {
        log.info("[Facade:InstituteAccreditationFacade] deleteById() called - Request to delete accreditation: {}", id);
        instituteAccreditationService.deleteById(id);
    }

    public List<InstituteAccreditationResponseDTO> searchByKeyword(String keyword) {
        log.info(
                "[Facade:InstituteAccreditationFacade] searchByKeyword() called - Request to search accreditations with keyword: {}",
                keyword);
        return instituteAccreditationService.searchByKeyword(keyword);
    }

    public InstituteAccreditationResponseDTO activate(Long id) {
        log.info("[Facade:InstituteAccreditationFacade] activate() called - Request to activate accreditation: {}", id);
        return instituteAccreditationService.activate(id);
    }

    public InstituteAccreditationResponseDTO deactivate(Long id) {
        log.info("[Facade:InstituteAccreditationFacade] deactivate() called - Request to deactivate accreditation: {}",
                id);
        return instituteAccreditationService.deactivate(id);
    }
}
