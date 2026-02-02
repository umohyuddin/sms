package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.responseDto.InstituteFacilityResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteFacilityService;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class InstituteFacilityFacade {

    private final InstituteFacilityService instituteFacilityService;

    public InstituteFacilityFacade(InstituteFacilityService instituteFacilityService) {
        this.instituteFacilityService = instituteFacilityService;
    }

    public InstituteFacilityResponseDTO createFacility(InstituteFacilityCreateRequestDTO requestDTO) {
        return instituteFacilityService.createFacility(requestDTO);
    }

    public Page<InstituteFacilityResponseDTO> getAll(Pageable pageable) {
        return instituteFacilityService.getAll(pageable);
    }

    public Page<InstituteFacilityResponseDTO> getByInstituteId(Long instituteId, Pageable pageable) {
        return instituteFacilityService.getByInstituteId(instituteId, pageable);
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
