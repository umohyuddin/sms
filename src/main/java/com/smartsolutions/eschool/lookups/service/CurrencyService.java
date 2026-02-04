package com.smartsolutions.eschool.lookups.service;

import com.smartsolutions.eschool.global.exception.CustomServiceException;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.lookups.dtos.currency.requestDto.CurrencyRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.currency.responseDto.CurrencyResponseDTO;
import com.smartsolutions.eschool.lookups.model.CurrencyEntity;
import com.smartsolutions.eschool.lookups.repository.CurrencyRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Transactional
    public CurrencyResponseDTO createCurrency(@Valid CurrencyRequestDTO requestDTO) {
        log.info("Creating new Currency: {}", requestDTO.getName());
        try {
            CurrencyEntity entity = MapperUtil.mapObject(requestDTO, CurrencyEntity.class);
            currencyRepository.save(entity);
            return MapperUtil.mapObject(entity, CurrencyResponseDTO.class);
        } catch (DataAccessException dae) {
            log.error("Database error while creating Currency", dae);
            throw new CustomServiceException("Failed to create Currency due to database error");
        } catch (Exception e) {
            log.error("Unexpected error while creating Currency", e);
            throw new CustomServiceException("Failed to create Currency");
        }
    }

    public List<CurrencyResponseDTO> getAllActive() {
        try {
            log.info("Fetching active Currencies");
            List<CurrencyEntity> result = currencyRepository.findAllActive();
            return MapperUtil.mapList(result, CurrencyResponseDTO.class);
        } catch (Exception e) {
            log.error("Error fetching active currencies", e);
            throw new CustomServiceException("Failed to fetch active Currencies", e);
        }
    }

    public CurrencyResponseDTO getById(Integer id) {
        log.info("Fetching Currency with id={}", id);
        CurrencyEntity entity = currencyRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Currency not found with id=" + id));
        return MapperUtil.mapObject(entity, CurrencyResponseDTO.class);
    }

    @Transactional
    public CurrencyResponseDTO updateCurrency(Integer id, @Valid CurrencyRequestDTO requestDTO) {
        log.info("Updating Currency id={}", id);
        CurrencyEntity entity = currencyRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Currency not found with id=" + id));
        
        entity.setName(requestDTO.getName());
        entity.setIsoCode(requestDTO.getIsoCode());
        entity.setSymbol(requestDTO.getSymbol());
        entity.setIsActive(requestDTO.getIsActive());
        
        currencyRepository.save(entity);
        return MapperUtil.mapObject(entity, CurrencyResponseDTO.class);
    }

    @Transactional
    public int softDeleteById(Integer id) {
        log.info("Soft delete request for Currency id={}", id);
        return currencyRepository.softDeleteById(id);
    }
}
