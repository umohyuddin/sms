package com.smartsolutions.eschool.lookups.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.CountryErrors;
import com.smartsolutions.eschool.lookups.dtos.country.request.CountryRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.country.response.CountryResponseDTO;
import com.smartsolutions.eschool.lookups.model.CountryEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CountryMapper {

    private CountryMapper() {
    }

    public static CountryResponseDTO toResponseDTO(CountryEntity entity) {
        if (entity == null) {
            return null;
        }

        CountryResponseDTO dto = new CountryResponseDTO();
        dto.setId(entity.getId());
        dto.setCountryCode(entity.getCountryCode());
        dto.setCountryName(entity.getCountryName());
        dto.setIsoCode(entity.getIsoCode());
        dto.setPhoneCode(entity.getPhoneCode());
        dto.setIsActive(entity.getIsActive());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<CountryResponseDTO> toResponseDTOList(List<CountryEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(CountryMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static CountryEntity toEntity(CountryRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getCountryName() == null || dto.getCountryName().trim().isEmpty()) {
            throw new ApiException(CountryErrors.INVALID_COUNTRY_DATA, "Country name is required", HttpStatus.BAD_REQUEST);
        }
        if (dto.getCountryCode() == null || dto.getCountryCode().trim().isEmpty()) {
            throw new ApiException(CountryErrors.INVALID_COUNTRY_DATA, "Country code is required", HttpStatus.BAD_REQUEST);
        }

        CountryEntity entity = new CountryEntity();
        
        entity.setCountryCode(dto.getCountryCode().trim());
        entity.setCountryName(dto.getCountryName().trim());
        
        if (dto.getIsoCode() != null && !dto.getIsoCode().trim().isEmpty()) {
            entity.setIsoCode(dto.getIsoCode().trim());
        }
        
        if (dto.getPhoneCode() != null && !dto.getPhoneCode().trim().isEmpty()) {
            entity.setPhoneCode(dto.getPhoneCode().trim());
        }
        
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(CountryEntity entity, CountryRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getCountryName() != null) {
            if (dto.getCountryName().trim().isEmpty()) {
                throw new ApiException(CountryErrors.INVALID_COUNTRY_DATA, "Country name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setCountryName(dto.getCountryName().trim());
        }

        if (dto.getCountryCode() != null) {
            if (dto.getCountryCode().trim().isEmpty()) {
                throw new ApiException(CountryErrors.INVALID_COUNTRY_DATA, "Country code cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setCountryCode(dto.getCountryCode().trim());
        }

        if (dto.getIsoCode() != null) {
            entity.setIsoCode(dto.getIsoCode().trim().isEmpty() ? null : dto.getIsoCode().trim());
        }

        if (dto.getPhoneCode() != null) {
            entity.setPhoneCode(dto.getPhoneCode().trim().isEmpty() ? null : dto.getPhoneCode().trim());
        }

        if (dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }
    }
}
