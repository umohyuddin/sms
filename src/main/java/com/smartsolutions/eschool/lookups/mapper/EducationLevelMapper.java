package com.smartsolutions.eschool.lookups.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.EducationLevelErrors;
import com.smartsolutions.eschool.lookups.dtos.educationLevel.requestDto.EducationLevelRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.educationLevel.responseDto.EducationLevelResponseDTO;
import com.smartsolutions.eschool.lookups.model.EducationLevelEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class EducationLevelMapper {

    private EducationLevelMapper() {
    }

    public static EducationLevelResponseDTO toResponseDTO(EducationLevelEntity entity) {
        if (entity == null) {
            return null;
        }

        EducationLevelResponseDTO dto = new EducationLevelResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setIsActive(entity.getIsActive());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<EducationLevelResponseDTO> toResponseDTOList(List<EducationLevelEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(EducationLevelMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static EducationLevelEntity toEntity(EducationLevelRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(EducationLevelErrors.INVALID_EDUCATION_LEVEL_DATA, "Education level name is required", HttpStatus.BAD_REQUEST);
        }
        if (dto.getCode() == null || dto.getCode().trim().isEmpty()) {
            throw new ApiException(EducationLevelErrors.INVALID_EDUCATION_LEVEL_DATA, "Education level code is required", HttpStatus.BAD_REQUEST);
        }

        EducationLevelEntity entity = new EducationLevelEntity();
        
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName().trim());
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(EducationLevelEntity entity, EducationLevelRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(EducationLevelErrors.INVALID_EDUCATION_LEVEL_DATA, "Education level name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getCode() != null) {
            if (dto.getCode().trim().isEmpty()) {
                throw new ApiException(EducationLevelErrors.INVALID_EDUCATION_LEVEL_DATA, "Education level code cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setCode(dto.getCode().trim());
        }

        if (dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }
    }
}
