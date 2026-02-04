package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.currency.requestDto.CurrencyRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.currency.responseDto.CurrencyResponseDTO;
import com.smartsolutions.eschool.lookups.service.CurrencyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrencyFacade {
    private final CurrencyService currencyService;

    public CurrencyFacade(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    public CurrencyResponseDTO createCurrency(@Valid CurrencyRequestDTO dto) {
        return currencyService.createCurrency(dto);
    }

    public List<CurrencyResponseDTO> getAllActive() {
        return currencyService.getAllActive();
    }

    public CurrencyResponseDTO getById(Integer id) {
        return currencyService.getById(id);
    }

    public CurrencyResponseDTO updateCurrency(Integer id, @Valid CurrencyRequestDTO dto) {
        return currencyService.updateCurrency(id, dto);
    }

    public int softDeleteById(Integer id) {
        return currencyService.softDeleteById(id);
    }
}
