package com.smartsolutions.eschool.student.mapper;

import com.smartsolutions.eschool.school.mapper.ChargeTypeMapper;
import com.smartsolutions.eschool.lookups.mapper.FeeRecurrenceRuleMapper;
import com.smartsolutions.eschool.student.dtos.feeCatalog.requestDto.FeeCatalogRequestDTO;
import com.smartsolutions.eschool.student.dtos.responseDto.FeeCatalogDTO;
import com.smartsolutions.eschool.student.model.FeeCatalogEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for FeeCatalogEntity to DTOs and vice versa.
 */
public class FeeCatalogMapper {

    private FeeCatalogMapper() {
        // prevent instantiation
    }

    public static FeeCatalogDTO toDto(FeeCatalogEntity entity) {
        if (entity == null) {
            return null;
        }

        FeeCatalogDTO dto = new FeeCatalogDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.isActive());

        dto.setChargeType(ChargeTypeMapper.toResponseDTO(entity.getChargeType()));
        dto.setRecurrenceRule(FeeRecurrenceRuleMapper.toResponseDTO(entity.getRecurrenceRule()));

        return dto;
    }

    public static List<FeeCatalogDTO> toDtoList(List<FeeCatalogEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(FeeCatalogMapper::toDto)
                .collect(Collectors.toList());
    }

    public static FeeCatalogEntity toEntity(FeeCatalogRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        FeeCatalogEntity entity = new FeeCatalogEntity();
        entity.setCode(dto.getCode() != null ? dto.getCode().trim() : null);
        entity.setName(dto.getName() != null ? dto.getName().trim() : null);
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.getActive() != null ? dto.getActive() : true);
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDto(FeeCatalogEntity entity, FeeCatalogRequestDTO dto) {
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

        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }
    }
}
