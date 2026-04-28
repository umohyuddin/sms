package com.smartsolutions.eschool.lookups.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.LanguageErrors;
import com.smartsolutions.eschool.lookups.dtos.language.requestDto.LanguageRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.language.responseDto.LanguageResponseDTO;
import com.smartsolutions.eschool.lookups.model.LanguageEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for LanguageEntity to DTOs and vice versa.
 */
public class LanguageMapper {

    private LanguageMapper() {
        // prevent instantiation
    }

    public static LanguageResponseDTO toResponseDTO(LanguageEntity entity) {
        if (entity == null) {
            return null;
        }

        LanguageResponseDTO dto = new LanguageResponseDTO();
        dto.setId(entity.getId());
        dto.setIsoCode(entity.getIsoCode());
        dto.setName(entity.getName());
        dto.setIsActive(entity.getIsActive());

        // Audit fields
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<LanguageResponseDTO> toResponseDTOList(List<LanguageEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(LanguageMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static LanguageEntity toEntity(LanguageRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(LanguageErrors.INVALID_LANGUAGE_DATA, "Language name is required", HttpStatus.BAD_REQUEST);
        }

        LanguageEntity entity = new LanguageEntity();
        
        if (dto.getIsoCode() != null && !dto.getIsoCode().trim().isEmpty()) {
            entity.setIsoCode(dto.getIsoCode().trim());
        }
        
        entity.setName(dto.getName().trim());
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(LanguageEntity entity, LanguageRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(LanguageErrors.INVALID_LANGUAGE_DATA, "Language name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getIsoCode() != null) {
            entity.setIsoCode(dto.getIsoCode().trim().isEmpty() ? null : dto.getIsoCode().trim());
        }

        if (dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }
    }
}
