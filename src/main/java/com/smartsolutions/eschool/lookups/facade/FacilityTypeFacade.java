package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.facilityType.requestDto.FacilityTypeRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.facilityType.responseDto.FacilityTypeResponseDTO;
import com.smartsolutions.eschool.lookups.service.FacilityTypeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacilityTypeFacade {
    private final FacilityTypeService facilityTypeService;

    public FacilityTypeFacade(FacilityTypeService facilityTypeService) {
        this.facilityTypeService = facilityTypeService;
    }

    public FacilityTypeResponseDTO create(@Valid FacilityTypeRequestDTO dto) {
        return facilityTypeService.create(dto);
    }

    public List<FacilityTypeResponseDTO> getAllActive() {
        return facilityTypeService.getAllActive();
    }

    public FacilityTypeResponseDTO getById(Long id) {
        return facilityTypeService.getById(id);
    }

    public FacilityTypeResponseDTO update(Long id, @Valid FacilityTypeRequestDTO dto) {
        return facilityTypeService.update(id, dto);
    }

    public int softDeleteById(Long id) {
        return facilityTypeService.softDeleteById(id);
    }
}
