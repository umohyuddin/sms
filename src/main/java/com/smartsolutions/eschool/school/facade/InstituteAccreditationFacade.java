package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.requestDto.InstituteAccreditationUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAccreditations.responseDto.InstituteAccreditationResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteAccreditationService;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class InstituteAccreditationFacade {

    private final InstituteAccreditationService instituteAccreditationService;

    public InstituteAccreditationFacade(InstituteAccreditationService instituteAccreditationService) {
        this.instituteAccreditationService = instituteAccreditationService;
    }

    public InstituteAccreditationResponseDTO createAccreditation(InstituteAccreditationCreateRequestDTO requestDTO) {
        return instituteAccreditationService.createAccreditation(requestDTO);
    }

    public Page<InstituteAccreditationResponseDTO> getAll(Pageable pageable) {
        return instituteAccreditationService.getAll(pageable);
    }

    public Page<InstituteAccreditationResponseDTO> getByInstituteId(Long instituteId, Pageable pageable) {
        return instituteAccreditationService.getByInstituteId(instituteId, pageable);
    }

    public List<InstituteAccreditationResponseDTO> getAllActive() {
        return instituteAccreditationService.getAllActive();
    }

    public InstituteAccreditationResponseDTO getById(Long id) {
        return instituteAccreditationService.getById(id);
    }

    public InstituteAccreditationResponseDTO updateAccreditation(Long id, InstituteAccreditationUpdateRequestDTO requestDTO) {
        return instituteAccreditationService.updateAccreditation(id, requestDTO);
    }

    public void deleteById(Long id) {
        instituteAccreditationService.deleteById(id);
    }

    public List<InstituteAccreditationResponseDTO> searchByKeyword(String keyword) {
        return instituteAccreditationService.searchByKeyword(keyword);
    }

    public InstituteAccreditationResponseDTO activate(Long id) {
        return instituteAccreditationService.activate(id);
    }

    public InstituteAccreditationResponseDTO deactivate(Long id) {
        return instituteAccreditationService.deactivate(id);
    }
}
