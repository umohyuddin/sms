package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.currency.requestDto.CurrencyRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.currency.responseDto.CurrencyResponseDTO;
import com.smartsolutions.eschool.lookups.service.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class CurrencyFacade {
    private final CurrencyService currencyService;

    public CurrencyFacade(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    public List<CurrencyResponseDTO> getAll() {
        log.info("[Facade:CurrencyFacade] getAll() called");
        return currencyService.getAll();
    }

    public List<CurrencyResponseDTO> getAllActive() {
        log.info("[Facade:CurrencyFacade] getAllActive() called");
        return currencyService.getAllActive();
    }

    public CurrencyResponseDTO getById(Integer id) {
        log.info("[Facade:CurrencyFacade] getById() called - id: {}", id);
        return currencyService.getById(id);
    }

    public List<CurrencyResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:CurrencyFacade] searchByKeyword() called - keyword: {}", keyword);
        return currencyService.searchByKeyword(keyword);
    }

    public void softDeleteById(Integer id) {
        log.info("[Facade:CurrencyFacade] softDeleteById() called - id: {}", id);
        currencyService.softDeleteById(id);
    }

    public CurrencyResponseDTO createCurrency(CurrencyRequestDTO dto) {
        log.info("[Facade:CurrencyFacade] createCurrency() called");
        return currencyService.createCurrency(dto);
    }

    public CurrencyResponseDTO updateCurrency(Integer id, CurrencyRequestDTO dto) {
        log.info("[Facade:CurrencyFacade] updateCurrency() called - id: {}", id);
        return currencyService.updateCurrency(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:CurrencyFacade] getStatistics() called");
        return currencyService.getStatistics();
    }
}
