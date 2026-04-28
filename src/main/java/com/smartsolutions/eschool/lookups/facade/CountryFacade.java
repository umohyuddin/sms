package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.country.request.CountryRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.country.response.CountryResponseDTO;
import com.smartsolutions.eschool.lookups.service.CountryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class CountryFacade {
    private final CountryService countryService;

    public CountryFacade(CountryService countryService) {
        this.countryService = countryService;
    }

    public List<CountryResponseDTO> getAll() {
        log.info("[Facade:CountryFacade] getAll() called");
        return countryService.getAll();
    }

    public CountryResponseDTO getById(Long id) {
        log.info("[Facade:CountryFacade] getById() called - id: {}", id);
        return countryService.getById(id);
    }

    public List<CountryResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:CountryFacade] searchByKeyword() called - keyword: {}", keyword);
        return countryService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:CountryFacade] softDeleteById() called - id: {}", id);
        countryService.softDeleteById(id);
    }

    public CountryResponseDTO create(CountryRequestDTO dto) {
        log.info("[Facade:CountryFacade] create() called");
        return countryService.create(dto);
    }

    public CountryResponseDTO update(Long id, CountryRequestDTO dto) {
        log.info("[Facade:CountryFacade] update() called - id: {}", id);
        return countryService.update(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:CountryFacade] getStatistics() called");
        return countryService.getStatistics();
    }
}
