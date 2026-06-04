package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.province.requestDto.ProvinceRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.service.ProvinceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class ProvinceFacade {
    private final ProvinceService provinceService;

    public ProvinceFacade(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    public List<ProvinceResponseDTO> getAll() {
        log.info("[Facade:ProvinceFacade] getAll() called");
        return provinceService.getAll();
    }

    public List<ProvinceResponseDTO> getAllActive() {
        log.info("[Facade:ProvinceFacade] getAllActive() called");
        return provinceService.getAllActive();
    }

    public List<ProvinceResponseDTO> getByCountryId(Long countryId) {
        log.info("[Facade:ProvinceFacade] getByCountryId() called - countryId: {}", countryId);
        return provinceService.getByCountryId(countryId);
    }

    public ProvinceResponseDTO getById(Long id) {
        log.info("[Facade:ProvinceFacade] getById() called - id: {}", id);
        return provinceService.getById(id);
    }

    public List<ProvinceResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:ProvinceFacade] searchByKeyword() called - keyword: {}", keyword);
        return provinceService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:ProvinceFacade] softDeleteById() called - id: {}", id);
        provinceService.softDeleteById(id);
    }

    public ProvinceResponseDTO create(ProvinceRequestDTO dto) {
        log.info("[Facade:ProvinceFacade] create() called");
        return provinceService.create(dto);
    }

    public ProvinceResponseDTO update(Long id, ProvinceRequestDTO dto) {
        log.info("[Facade:ProvinceFacade] update() called - id: {}", id);
        return provinceService.update(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:ProvinceFacade] getStatistics() called");
        return provinceService.getStatistics();
    }
}
