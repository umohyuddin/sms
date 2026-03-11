package com.smartsolutions.eschool.lookups.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.ProvinceErrors;
import com.smartsolutions.eschool.lookups.dtos.province.requestDto.ProvinceRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.province.responseDto.ProvinceResponseDTO;
import com.smartsolutions.eschool.lookups.model.CountryEntity;
import com.smartsolutions.eschool.lookups.model.ProvinceEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProvinceMapper {

    private ProvinceMapper() {
    }

    public static ProvinceResponseDTO toResponseDTO(ProvinceEntity entity) {
        if (entity == null) {
            return null;
        }

        ProvinceResponseDTO dto = new ProvinceResponseDTO();
        dto.setId(entity.getId());
        
        if (entity.getCountry() != null) {
            dto.setCountryId(entity.getCountry().getId());
            dto.setCountryName(entity.getCountry().getCountryName());
        }
        
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setIsActive(entity.getIsActive());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<ProvinceResponseDTO> toResponseDTOList(List<ProvinceEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(ProvinceMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static ProvinceEntity toEntity(ProvinceRequestDTO dto, CountryEntity countryEntity) {
        if (dto == null) {
            return null;
        }

        if (countryEntity == null) {
            throw new ApiException(ProvinceErrors.INVALID_PROVINCE_DATA, "Valid Country must be provided", HttpStatus.BAD_REQUEST);
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(ProvinceErrors.INVALID_PROVINCE_DATA, "Province name is required", HttpStatus.BAD_REQUEST);
        }

        ProvinceEntity entity = new ProvinceEntity();
        
        entity.setCountry(countryEntity);
        entity.setName(dto.getName().trim());
        entity.setCode(dto.getCode() != null ? dto.getCode().trim() : null);
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(ProvinceEntity entity, ProvinceRequestDTO dto, CountryEntity newCountry) {
        if (entity == null || dto == null) {
            return;
        }

        if (newCountry != null) {
            entity.setCountry(newCountry);
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(ProvinceErrors.INVALID_PROVINCE_DATA, "Province name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getCode() != null) {
            entity.setCode(dto.getCode().trim());
        }

        if (dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }
    }
}
