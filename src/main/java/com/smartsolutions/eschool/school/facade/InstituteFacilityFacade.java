package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.responseDto.InstituteFacilityResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteFacilityService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class InstituteFacilityFacade {

    private final InstituteFacilityService instituteFacilityService;

    public InstituteFacilityFacade(InstituteFacilityService instituteFacilityService) {
        this.instituteFacilityService = instituteFacilityService;
    }

    public List<InstituteFacilityResponseDTO> createFacility(InstituteFacilityCreateRequestDTO requestDTO) {
        return instituteFacilityService.createFacility(requestDTO);
    }

    public List<InstituteFacilityResponseDTO> getAll() {
        return instituteFacilityService.getAll();
    }

    public List<InstituteFacilityResponseDTO> getByInstituteId(Long instituteId) {
        return instituteFacilityService.getByInstituteId(instituteId);
    }

    public InstituteFacilityResponseDTO getById(Long id) {
        return instituteFacilityService.getById(id);
    }

    public InstituteFacilityResponseDTO updateFacility(Long id, InstituteFacilityUpdateRequestDTO requestDTO) {
        return instituteFacilityService.updateFacility(id, requestDTO);
    }

    public void deleteById(Long id) {
        instituteFacilityService.deleteById(id);
    }

    public List<InstituteFacilityResponseDTO> searchByKeyword(String keyword) {
        return instituteFacilityService.searchByKeyword(keyword);
    }
}
