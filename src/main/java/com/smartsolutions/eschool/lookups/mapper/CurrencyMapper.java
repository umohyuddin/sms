package com.smartsolutions.eschool.lookups.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.CurrencyErrors;
import com.smartsolutions.eschool.lookups.dtos.currency.requestDto.CurrencyRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.currency.responseDto.CurrencyResponseDTO;
import com.smartsolutions.eschool.lookups.model.CurrencyEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CurrencyMapper {

    private CurrencyMapper() {
    }

    public static CurrencyResponseDTO toResponseDTO(CurrencyEntity entity) {
        if (entity == null) {
            return null;
        }

        CurrencyResponseDTO dto = new CurrencyResponseDTO();
        dto.setId(entity.getId());
        dto.setIsoCode(entity.getIsoCode());
        dto.setName(entity.getName());
        dto.setSymbol(entity.getSymbol());
        dto.setIsActive(entity.getIsActive());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<CurrencyResponseDTO> toResponseDTOList(List<CurrencyEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(CurrencyMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static CurrencyEntity toEntity(CurrencyRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(CurrencyErrors.INVALID_CURRENCY_DATA, "Currency name is required", HttpStatus.BAD_REQUEST);
        }
        if (dto.getIsoCode() == null || dto.getIsoCode().trim().isEmpty()) {
            throw new ApiException(CurrencyErrors.INVALID_CURRENCY_DATA, "Currency ISO code is required", HttpStatus.BAD_REQUEST);
        }

        CurrencyEntity entity = new CurrencyEntity();
        
        entity.setIsoCode(dto.getIsoCode().trim());
        entity.setName(dto.getName().trim());
        
        if (dto.getSymbol() != null && !dto.getSymbol().trim().isEmpty()) {
            entity.setSymbol(dto.getSymbol().trim());
        }
        
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(CurrencyEntity entity, CurrencyRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(CurrencyErrors.INVALID_CURRENCY_DATA, "Currency name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getIsoCode() != null) {
            if (dto.getIsoCode().trim().isEmpty()) {
                throw new ApiException(CurrencyErrors.INVALID_CURRENCY_DATA, "Currency ISO code cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setIsoCode(dto.getIsoCode().trim());
        }
        
        if (dto.getSymbol() != null) {
            entity.setSymbol(dto.getSymbol().trim().isEmpty() ? null : dto.getSymbol().trim());
        }

        if (dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }
    }
}
