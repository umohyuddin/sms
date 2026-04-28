package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto.SchoolTypeCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.schoolTypes.responseDto.SchoolTypeResponseDTO;
import com.smartsolutions.eschool.school.model.SchoolTypeEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for SchoolTypeEntity to DTOs and vice versa.
 */
public class SchoolTypeMapper {

    private SchoolTypeMapper() {
        // prevent instantiation
    }

    public static SchoolTypeResponseDTO toResponseDTO(SchoolTypeEntity entity) {
        if (entity == null) {
            return null;
        }
        return SchoolTypeResponseDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .isActive(entity.isActive())
                .deleted(entity.isDeleted())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static List<SchoolTypeResponseDTO> toResponseDTOList(List<SchoolTypeEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(SchoolTypeMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static SchoolTypeEntity toEntity(SchoolTypeCreateRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        SchoolTypeEntity entity = new SchoolTypeEntity();
        entity.setCode(dto.getCode() != null ? dto.getCode().trim() : null);
        entity.setName(dto.getName() != null ? dto.getName().trim() : null);
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setDeleted(false);
        return entity;
    }

    public static void updateEntityFromDTO(SchoolTypeEntity entity, SchoolTypeCreateRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }
        if (dto.getCode() != null && !dto.getCode().isBlank()) {
            entity.setCode(dto.getCode().trim());
        }
        if (dto.getName() != null && !dto.getName().isBlank()) {
            entity.setName(dto.getName().trim());
        }
        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }
        if (dto.getIsActive() != null) {
            entity.setActive(dto.getIsActive());
        }
    }
}
