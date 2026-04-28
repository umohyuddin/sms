package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.facilityType.requestDto.FacilityTypeRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.facilityType.responseDto.FacilityTypeResponseDTO;
import com.smartsolutions.eschool.lookups.service.FacilityTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class FacilityTypeFacade {
    private final FacilityTypeService facilityTypeService;

    public FacilityTypeFacade(FacilityTypeService facilityTypeService) {
        this.facilityTypeService = facilityTypeService;
    }

    public List<FacilityTypeResponseDTO> getAll() {
        log.info("[Facade:FacilityTypeFacade] getAll() called");
        return facilityTypeService.getAll();
    }

    public List<FacilityTypeResponseDTO> getAllActive() {
        log.info("[Facade:FacilityTypeFacade] getAllActive() called");
        return facilityTypeService.getAllActive();
    }

    public FacilityTypeResponseDTO getById(Long id) {
        log.info("[Facade:FacilityTypeFacade] getById() called - id: {}", id);
        return facilityTypeService.getById(id);
    }

    public List<FacilityTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:FacilityTypeFacade] searchByKeyword() called - keyword: {}", keyword);
        return facilityTypeService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:FacilityTypeFacade] softDeleteById() called - id: {}", id);
        facilityTypeService.softDeleteById(id);
    }

    public FacilityTypeResponseDTO create(FacilityTypeRequestDTO dto) {
        log.info("[Facade:FacilityTypeFacade] create() called");
        return facilityTypeService.create(dto);
    }

    public FacilityTypeResponseDTO update(Long id, FacilityTypeRequestDTO dto) {
        log.info("[Facade:FacilityTypeFacade] update() called - id: {}", id);
        return facilityTypeService.update(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:FacilityTypeFacade] getStatistics() called");
        return facilityTypeService.getStatistics();
    }
}
