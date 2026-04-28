package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.taxType.requestDto.TaxTypeRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.taxType.responseDto.TaxTypeResponseDTO;
import com.smartsolutions.eschool.lookups.service.TaxTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class TaxTypeFacade {

    private final TaxTypeService taxTypeService;

    public TaxTypeFacade(TaxTypeService taxTypeService) {
        this.taxTypeService = taxTypeService;
    }

    public List<TaxTypeResponseDTO> getAll() {
        log.info("[Facade:TaxTypeFacade] getAll() called");
        return taxTypeService.getAll();
    }

    public List<TaxTypeResponseDTO> getAllActive() {
        log.info("[Facade:TaxTypeFacade] getAllActive() called");
        return taxTypeService.getAllActive();
    }

    public TaxTypeResponseDTO getById(Long id) {
        log.info("[Facade:TaxTypeFacade] getById() called - id: {}", id);
        return taxTypeService.getById(id);
    }

    public List<TaxTypeResponseDTO> getByCountryId(Long countryId) {
        log.info("[Facade:TaxTypeFacade] getByCountryId() called - countryId: {}", countryId);
        return taxTypeService.getByCountryId(countryId);
    }

    public List<TaxTypeResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:TaxTypeFacade] searchByKeyword() called - keyword: {}", keyword);
        return taxTypeService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:TaxTypeFacade] softDeleteById() called - id: {}", id);
        taxTypeService.softDeleteById(id);
    }

    public TaxTypeResponseDTO createTaxType(TaxTypeRequestDTO dto) {
        log.info("[Facade:TaxTypeFacade] createTaxType() called");
        return taxTypeService.createTaxType(dto);
    }

    public TaxTypeResponseDTO updateTaxType(Long id, TaxTypeRequestDTO dto) {
        log.info("[Facade:TaxTypeFacade] updateTaxType() called - id: {}", id);
        return taxTypeService.updateTaxType(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:TaxTypeFacade] getStatistics() called");
        return taxTypeService.getStatistics();
    }
}
