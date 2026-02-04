package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.taxType.requestDto.TaxTypeRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.taxType.responseDto.TaxTypeResponseDTO;
import com.smartsolutions.eschool.lookups.service.TaxTypeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaxTypeFacade {
    private final TaxTypeService taxTypeService;

    public TaxTypeFacade(TaxTypeService taxTypeService) {
        this.taxTypeService = taxTypeService;
    }

    public TaxTypeResponseDTO create(@Valid TaxTypeRequestDTO dto) {
        return taxTypeService.create(dto);
    }

    public List<TaxTypeResponseDTO> getAllActive() {
        return taxTypeService.getAllActive();
    }

    public TaxTypeResponseDTO getById(Long id) {
        return taxTypeService.getById(id);
    }

    public TaxTypeResponseDTO update(Long id, @Valid TaxTypeRequestDTO dto) {
        return taxTypeService.update(id, dto);
    }

    public int softDeleteById(Long id) {
        return taxTypeService.softDeleteById(id);
    }
}
