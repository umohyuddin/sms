package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.requestDto.InstituteAcademicOfferingCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.requestDto.InstituteAcademicOfferingUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.responseDto.InstituteAcademicOfferingResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteAcademicOfferingService;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class InstituteAcademicOfferingFacade {

    private final InstituteAcademicOfferingService instituteAcademicOfferingService;

    public InstituteAcademicOfferingFacade(InstituteAcademicOfferingService instituteAcademicOfferingService) {
        this.instituteAcademicOfferingService = instituteAcademicOfferingService;
    }

    public InstituteAcademicOfferingResponseDTO createOffering(InstituteAcademicOfferingCreateRequestDTO requestDTO) {
        return instituteAcademicOfferingService.createOffering(requestDTO);
    }

    public Page<InstituteAcademicOfferingResponseDTO> getAll(Pageable pageable) {
        return instituteAcademicOfferingService.getAll(pageable);
    }

    public Page<InstituteAcademicOfferingResponseDTO> getByInstituteId(Long instituteId, Pageable pageable) {
        return instituteAcademicOfferingService.getByInstituteId(instituteId, pageable);
    }

    public InstituteAcademicOfferingResponseDTO getById(Long id) {
        return instituteAcademicOfferingService.getById(id);
    }

    public InstituteAcademicOfferingResponseDTO updateOffering(Long id, InstituteAcademicOfferingUpdateRequestDTO requestDTO) {
        return instituteAcademicOfferingService.updateOffering(id, requestDTO);
    }

    public void deleteById(Long id) {
        instituteAcademicOfferingService.deleteById(id);
    }

    public List<InstituteAcademicOfferingResponseDTO> searchByKeyword(String keyword) {
        return instituteAcademicOfferingService.searchByKeyword(keyword);
    }
}
