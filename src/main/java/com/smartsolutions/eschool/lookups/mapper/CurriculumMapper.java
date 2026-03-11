package com.smartsolutions.eschool.lookups.mapper;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.CurriculumErrors;
import com.smartsolutions.eschool.lookups.dtos.curriculum.requestDto.CurriculumRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.curriculum.responseDto.CurriculumResponseDTO;
import com.smartsolutions.eschool.lookups.model.CurriculumEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CurriculumMapper {

    private CurriculumMapper() {
    }

    public static CurriculumResponseDTO toResponseDTO(CurriculumEntity entity) {
        if (entity == null) {
            return null;
        }

        CurriculumResponseDTO dto = new CurriculumResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setIsActive(entity.getIsActive());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());

        return dto;
    }

    public static List<CurriculumResponseDTO> toResponseDTOList(List<CurriculumEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(CurriculumMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static CurriculumEntity toEntity(CurriculumRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(CurriculumErrors.INVALID_CURRICULUM_DATA, "Curriculum name is required", HttpStatus.BAD_REQUEST);
        }
        if (dto.getCode() == null || dto.getCode().trim().isEmpty()) {
            throw new ApiException(CurriculumErrors.INVALID_CURRICULUM_DATA, "Curriculum code is required", HttpStatus.BAD_REQUEST);
        }

        CurriculumEntity entity = new CurriculumEntity();
        
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName().trim());
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(CurriculumEntity entity, CurriculumRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(CurriculumErrors.INVALID_CURRICULUM_DATA, "Curriculum name cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getCode() != null) {
            if (dto.getCode().trim().isEmpty()) {
                throw new ApiException(CurriculumErrors.INVALID_CURRICULUM_DATA, "Curriculum code cannot be empty", HttpStatus.BAD_REQUEST);
            }
            entity.setCode(dto.getCode().trim());
        }

        if (dto.getIsActive() != null) {
            entity.setIsActive(dto.getIsActive());
        }
    }
}
