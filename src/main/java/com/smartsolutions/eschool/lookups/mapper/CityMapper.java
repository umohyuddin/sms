package com.smartsolutions.eschool.lookups.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.CityErrors;
import com.smartsolutions.eschool.lookups.dtos.city.requestDto.CityRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.city.responseDto.CityResponseDTO;
import com.smartsolutions.eschool.lookups.model.CityEntity;
import com.smartsolutions.eschool.lookups.model.ProvinceEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CityMapper {

    private CityMapper() {
    }

    public static CityResponseDTO toResponseDTO(CityEntity entity) {
        if (entity == null) {
            return null;
        }

        CityResponseDTO dto = new CityResponseDTO();
        dto.setId(entity.getId());
        
        if (entity.getProvince() != null) {
            dto.setProvinceId(entity.getProvince().getId());
            dto.setProvinceName(entity.getProvince().getName());
        }
        
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setIsActive(entity.getIsActive());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<CityResponseDTO> toResponseDTOList(List<CityEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(CityMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static CityEntity toEntity(CityRequestDTO dto, ProvinceEntity provinceEntity) {
        if (dto == null) {
            return null;
        }

        if (provinceEntity == null) {
            throw new ApiException(CityErrors.INVALID_CITY_DATA, "Valid Province must be provided", HttpStatus.BAD_REQUEST);
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(CityErrors.INVALID_CITY_DATA, "City name is required", HttpStatus.BAD_REQUEST);
        }

        CityEntity entity = new CityEntity();
        
        entity.setProvince(provinceEntity);
        entity.setName(dto.getName().trim());
        entity.setCode(dto.getCode() != null ? dto.getCode().trim() : null);
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(CityEntity entity, CityRequestDTO dto, ProvinceEntity newProvince) {
        if (entity == null || dto == null) {
            return;
        }

        if (newProvince != null) {
            entity.setProvince(newProvince);
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(CityErrors.INVALID_CITY_DATA, "City name cannot be empty", HttpStatus.BAD_REQUEST);
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
