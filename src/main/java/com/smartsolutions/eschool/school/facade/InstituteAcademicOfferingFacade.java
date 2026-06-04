package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.requestDto.InstituteAcademicOfferingCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.requestDto.InstituteAcademicOfferingUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.responseDto.InstituteAcademicOfferingResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteAcademicOfferingService;
import org.springframework.context.annotation.Scope;
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

    public List<InstituteAcademicOfferingResponseDTO> getAll() {
        return instituteAcademicOfferingService.getAll();
    }

    public List<InstituteAcademicOfferingResponseDTO> getByInstituteId(Long instituteId) {
        return instituteAcademicOfferingService.getByInstituteId(instituteId);
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
