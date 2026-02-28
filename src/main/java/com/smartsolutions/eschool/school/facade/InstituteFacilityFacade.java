package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.requestDto.InstituteFacilityUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteFacilities.responseDto.InstituteFacilityResponseDTO;
import com.smartsolutions.eschool.school.service.InstituteFacilityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class InstituteFacilityFacade {

    private final InstituteFacilityService instituteFacilityService;

    public InstituteFacilityFacade(InstituteFacilityService instituteFacilityService) {
        this.instituteFacilityService = instituteFacilityService;
    }

    public List<InstituteFacilityResponseDTO> createFacility(InstituteFacilityCreateRequestDTO requestDTO) {
        log.info("[Facade:InstituteFacilityFacade] createFacility() called - Request to create/replace facilities");
        return instituteFacilityService.createFacility(requestDTO);
    }

    public List<InstituteFacilityResponseDTO> getAll() {
        log.info("[Facade:InstituteFacilityFacade] getAll() called - Request to get all facilities");
        return instituteFacilityService.getAll();
    }

    public List<InstituteFacilityResponseDTO> getByInstituteId(Long instituteId) {
        log.info(
                "[Facade:InstituteFacilityFacade] getByInstituteId() called - Request to get facilities for institute: {}",
                instituteId);
        return instituteFacilityService.getByInstituteId(instituteId);
    }

    public InstituteFacilityResponseDTO getById(Long id) {
        log.info("[Facade:InstituteFacilityFacade] getById() called - Request to get facility by id: {}", id);
        return instituteFacilityService.getById(id);
    }

    public InstituteFacilityResponseDTO updateFacility(Long id, InstituteFacilityUpdateRequestDTO requestDTO) {
        log.info("[Facade:InstituteFacilityFacade] updateFacility() called - Request to update facility: {}", id);
        return instituteFacilityService.updateFacility(id, requestDTO);
    }

    public void deleteById(Long id) {
        log.info("[Facade:InstituteFacilityFacade] deleteById() called - Request to delete facility: {}", id);
        instituteFacilityService.deleteById(id);
    }

    public List<InstituteFacilityResponseDTO> searchByKeyword(String keyword) {
        log.info(
                "[Facade:InstituteFacilityFacade] searchByKeyword() called - Request to search facilities with keyword: {}",
                keyword);
        return instituteFacilityService.searchByKeyword(keyword);
    }
}
