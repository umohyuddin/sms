package com.smartsolutions.eschool.lookups.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.TaxTypeErrors;
import com.smartsolutions.eschool.lookups.dtos.taxType.requestDto.TaxTypeRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.taxType.responseDto.TaxTypeResponseDTO;
import com.smartsolutions.eschool.lookups.model.TaxTypeEntity;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for TaxTypeEntity to DTOs and vice versa.
 */
public class TaxTypeMapper {

    private TaxTypeMapper() {
        // prevent instantiation
    }

    public static TaxTypeResponseDTO toResponseDTO(TaxTypeEntity entity) {
        if (entity == null) {
            return null;
        }

        TaxTypeResponseDTO dto = new TaxTypeResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setTaxPercentage(entity.getTaxPercentage());
        dto.setIsActive(entity.getIsActive());

        if (entity.getCountry() != null) {
            dto.setCountryId(entity.getCountry().getId());
            dto.setCountryName(entity.getCountry().getCountryName());
        }

        // Audit fields
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<TaxTypeResponseDTO> toResponseDTOList(List<TaxTypeEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(TaxTypeMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static TaxTypeEntity toEntity(TaxTypeRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getCode() == null || dto.getCode().trim().isEmpty()) {
            throw new ApiException(TaxTypeErrors.INVALID_TAX_TYPE_DATA, "Tax type code is required",
                    HttpStatus.BAD_REQUEST);
        }

        TaxTypeEntity entity = new TaxTypeEntity();
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName() != null ? dto.getName().trim() : null);
        entity.setTaxPercentage(dto.getTaxPercentage() != null ? dto.getTaxPercentage() : BigDecimal.ZERO);
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);
        // Country entity should be set by the service

        return entity;
    }

    public static void updateEntityFromDTO(TaxTypeEntity entity, TaxTypeRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getCode() != null) {
            if (dto.getCode().trim().isEmpty()) {
                throw new ApiException(TaxTypeErrors.INVALID_TAX_TYPE_DATA, "Tax type code cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setCode(dto.getCode().trim());
        }

        if (dto.getName() != null) {
            entity.setName(dto.getName().trim());
        }

        if (dto.getTaxPercentage() != null) {
            entity.setTaxPercentage(dto.getTaxPercentage());
        }

        if (dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }

        // Country entity should be updated by the service
    }
}
