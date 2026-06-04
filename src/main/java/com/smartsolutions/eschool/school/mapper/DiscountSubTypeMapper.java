package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.school.dtos.discountSubType.requestDto.DiscountSubTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountSubType.responseDto.DiscountSubTypeResponseDTO;
import com.smartsolutions.eschool.school.model.DiscountSubTypeEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountSubTypeMapper {

    private DiscountSubTypeMapper() {
    }

    public static DiscountSubTypeResponseDTO toDto(DiscountSubTypeEntity entity) {
        if (entity == null)
            return null;

        DiscountSubTypeResponseDTO dto = new DiscountSubTypeResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setIsActive(entity.getIsActive());
        dto.setPriority(entity.getPriority());
        dto.setDisplayOrder(entity.getDisplayOrder());

        if (entity.getDiscountType() != null) {
            dto.setDiscountType(DiscountTypeMapper.toDto(entity.getDiscountType()));
        }

        return dto;
    }

    public static List<DiscountSubTypeResponseDTO> toDtoList(List<DiscountSubTypeEntity> entities) {
        if (entities == null || entities.isEmpty())
            return Collections.emptyList();
        return entities.stream().map(DiscountSubTypeMapper::toDto).collect(Collectors.toList());
    }

    public static DiscountSubTypeEntity toEntity(DiscountSubTypeRequestDTO dto) {
        if (dto == null)
            return null;
        DiscountSubTypeEntity entity = new DiscountSubTypeEntity();
        entity.setCode(dto.getCode() != null ? dto.getCode().trim() : null);
        entity.setName(dto.getName() != null ? dto.getName().trim() : null);
        entity.setDescription(dto.getDescription());
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        entity.setPriority(dto.getPriority() != null ? dto.getPriority() : 0);
        entity.setDisplayOrder(dto.getDisplayOrder() != null ? dto.getDisplayOrder() : 0);
        entity.setDeleted(false);
        return entity;
    }

    public static void updateEntityFromDto(DiscountSubTypeEntity entity, DiscountSubTypeRequestDTO dto) {
        if (entity == null || dto == null)
            return;
        if (dto.getCode() != null && !dto.getCode().isBlank())
            entity.setCode(dto.getCode().trim());
        if (dto.getName() != null && !dto.getName().isBlank())
            entity.setName(dto.getName().trim());
        if (dto.getDescription() != null)
            entity.setDescription(dto.getDescription());
        if (dto.getIsActive() != null)
            entity.setIsActive(dto.getIsActive());
        if (dto.getPriority() != null)
            entity.setPriority(dto.getPriority());
        if (dto.getDisplayOrder() != null)
            entity.setDisplayOrder(dto.getDisplayOrder());
    }
}
