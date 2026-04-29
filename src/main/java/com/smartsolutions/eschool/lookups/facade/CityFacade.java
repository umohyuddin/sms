package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.city.requestDto.CityRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class CityFacade {
    private final CityService cityService;

    public CityFacade(CityService cityService) {
        this.cityService = cityService;
    }

    public List<CityResponseDTO> getAll() {
        log.info("[Facade:CityFacade] getAll() called");
        return cityService.getAll();
    }

    public List<CityResponseDTO> getAllActive() {
        log.info("[Facade:CityFacade] getAllActive() called");
        return cityService.getAllActive();
    }

    public List<CityResponseDTO> getByProvinceId(Long provinceId) {
        log.info("[Facade:CityFacade] getByProvinceId() called - provinceId: {}", provinceId);
        return cityService.getByProvinceId(provinceId);
    }

    public CityResponseDTO getById(Long id) {
        log.info("[Facade:CityFacade] getById() called - id: {}", id);
        return cityService.getById(id);
    }

    public List<CityResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:CityFacade] searchByKeyword() called - keyword: {}", keyword);
        return cityService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:CityFacade] softDeleteById() called - id: {}", id);
        cityService.softDeleteById(id);
    }

    public CityResponseDTO create(CityRequestDTO dto) {
        log.info("[Facade:CityFacade] create() called");
        return cityService.create(dto);
    }

    public CityResponseDTO update(Long id, CityRequestDTO dto) {
        log.info("[Facade:CityFacade] update() called - id: {}", id);
        return cityService.update(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:CityFacade] getStatistics() called");
        return cityService.getStatistics();
    }
}
