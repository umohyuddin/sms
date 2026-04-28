package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.CurrencyErrors;
import com.smartsolutions.eschool.lookups.dtos.currency.requestDto.CurrencyRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.currency.responseDto.CurrencyResponseDTO;
import com.smartsolutions.eschool.lookups.mapper.CurrencyMapper;
import com.smartsolutions.eschool.lookups.model.CurrencyEntity;
import com.smartsolutions.eschool.lookups.repository.CurrencyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<CurrencyResponseDTO> getAll() {
        log.info("[Service:CurrencyService] getAll() called - Fetching all currencies");
        List<CurrencyEntity> result = currencyRepository.findAllNotDeleted();
        List<CurrencyResponseDTO> responseDTOs = CurrencyMapper.toResponseDTOList(result);
        log.info("[Service:CurrencyService] getAll() succeeded - Found {} currencies", responseDTOs.size());
        return responseDTOs;
    }

    public List<CurrencyResponseDTO> getAllActive() {
        log.info("[Service:CurrencyService] getAllActive() called - Fetching active currencies");
        List<CurrencyEntity> result = currencyRepository.findAllActive();
        List<CurrencyResponseDTO> responseDTOs = CurrencyMapper.toResponseDTOList(result);
        log.info("[Service:CurrencyService] getAllActive() succeeded - Found {} active currencies", responseDTOs.size());
        return responseDTOs;
    }

    public CurrencyResponseDTO getById(Integer id) {
        log.info("[Service:CurrencyService] getById() called - id: {}", id);
        CurrencyEntity entity = currencyRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(CurrencyErrors.CURRENCY_NOT_FOUND, HttpStatus.NOT_FOUND));

        CurrencyResponseDTO responseDTO = CurrencyMapper.toResponseDTO(entity);
        log.info("[Service:CurrencyService] getById() succeeded - Found currency: {}", id);
        return responseDTO;
    }

    public List<CurrencyResponseDTO> searchByKeyword(String keyword) {
        log.info("[Service:CurrencyService] searchByKeyword() called - keyword: {}", keyword);
        List<CurrencyEntity> result = currencyRepository.searchByKeyword(keyword);
        List<CurrencyResponseDTO> responseDTOs = CurrencyMapper.toResponseDTOList(result);
        log.info("[Service:CurrencyService] searchByKeyword() succeeded - Found {} currencies", responseDTOs.size());
        return responseDTOs;
    }

    @Transactional
    public void softDeleteById(Integer id) {
        log.info("[Service:CurrencyService] softDeleteById() called - id: {}", id);

        int result = currencyRepository.softDeleteById(id);
        if (result == 0) {
            throw new ApiException(CurrencyErrors.CURRENCY_NOT_FOUND, HttpStatus.NOT_FOUND);
        }
        log.info("[Service:CurrencyService] softDeleteById() succeeded - id: {}", id);
    }

    @Transactional
    public CurrencyResponseDTO createCurrency(CurrencyRequestDTO requestDTO) {
        log.info("[Service:CurrencyService] createCurrency() called - Creating: {}", requestDTO.getName());

        if (requestDTO.getIsoCode() != null && !requestDTO.getIsoCode().trim().isEmpty()) {
            if (currencyRepository.existsByIsoCode(requestDTO.getIsoCode().trim())) {
                throw new ApiException(CurrencyErrors.DUPLICATE_CURRENCY_CODE, "ISO code already exists", HttpStatus.CONFLICT);
            }
        }

        CurrencyEntity entity = CurrencyMapper.toEntity(requestDTO);
        CurrencyEntity saved = currencyRepository.save(entity);

        log.info("[Service:CurrencyService] createCurrency() succeeded - Created with id: {}", saved.getId());
        return CurrencyMapper.toResponseDTO(saved);
    }

    @Transactional
    public CurrencyResponseDTO updateCurrency(Integer id, CurrencyRequestDTO requestDTO) {
        log.info("[Service:CurrencyService] updateCurrency() called - id: {}", id);

        CurrencyEntity existing = currencyRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ApiException(CurrencyErrors.CURRENCY_NOT_FOUND, HttpStatus.NOT_FOUND));

        if (requestDTO.getIsoCode() != null && !requestDTO.getIsoCode().trim().equals(existing.getIsoCode())) {
            if (currencyRepository.existsByIsoCodeAndIdNot(requestDTO.getIsoCode().trim(), id)) {
                throw new ApiException(CurrencyErrors.DUPLICATE_CURRENCY_CODE, "ISO code already exists", HttpStatus.CONFLICT);
            }
        }

        CurrencyMapper.updateEntityFromDTO(existing, requestDTO);
        CurrencyEntity updated = currencyRepository.save(existing);

        log.info("[Service:CurrencyService] updateCurrency() succeeded - id: {}", id);
        return CurrencyMapper.toResponseDTO(updated);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Service:CurrencyService] getStatistics() called");

        Map<String, Long> stats = new HashMap<>();
        stats.put("totalCurrencies", currencyRepository.countAllNotDeleted());
        stats.put("activeCurrencies", currencyRepository.countByIsActiveTrue());
        stats.put("inactiveCurrencies", currencyRepository.countByIsActiveFalse());

        log.info("[Service:CurrencyService] getStatistics() succeeded - Stats: {}", stats);
        return stats;
    }
}
