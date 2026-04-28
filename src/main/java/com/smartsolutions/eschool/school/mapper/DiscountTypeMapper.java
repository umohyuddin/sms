package com.smartsolutions.eschool.school.mapper;

import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import com.smartsolutions.eschool.school.dtos.discountType.requestDto.DiscountTypeRequestDTO;
import com.smartsolutions.eschool.school.dtos.discountType.responseDto.DiscountTypeResponseDTO;
import com.smartsolutions.eschool.school.model.DiscountTypeEntity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DiscountTypeMapper {

    private DiscountTypeMapper() {
    }

    public static DiscountTypeResponseDTO toDto(DiscountTypeEntity entity) {
        if (entity == null)
            return null;

        DiscountTypeResponseDTO dto = new DiscountTypeResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.getActive());
        dto.setPriority(entity.getPriority());
        dto.setDisplayOrder(entity.getDisplayOrder());

        if (entity.getChargeType() != null) {
            dto.setChargeType(ChargeTypeMapper.toResponseDTO(entity.getChargeType()));
        }

        if (entity.getRecurrenceRule() != null) {
            FeeRecurrenceRuleResponseDTO rr = new FeeRecurrenceRuleResponseDTO();
            rr.setId(entity.getRecurrenceRule().getId());
            rr.setCode(entity.getRecurrenceRule().getCode());
            rr.setName(entity.getRecurrenceRule().getName());
            dto.setRecurrenceRule(rr);
        }

        return dto;
    }

    public static List<DiscountTypeResponseDTO> toDtoList(List<DiscountTypeEntity> entities) {
        if (entities == null || entities.isEmpty())
            return Collections.emptyList();
        return entities.stream().map(DiscountTypeMapper::toDto).collect(Collectors.toList());
    }

    public static DiscountTypeEntity toEntity(DiscountTypeRequestDTO dto) {
        if (dto == null)
            return null;
        DiscountTypeEntity entity = new DiscountTypeEntity();
        entity.setCode(dto.getCode() != null ? dto.getCode().trim() : null);
        entity.setName(dto.getName() != null ? dto.getName().trim() : null);
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.getActive() != null ? dto.getActive() : true);
        entity.setPriority(dto.getPriority() != null ? dto.getPriority() : 0);
        entity.setDisplayOrder(dto.getDisplayOrder() != null ? dto.getDisplayOrder() : 0);
        entity.setDeleted(false);
        return entity;
    }

    public static void updateEntityFromDto(DiscountTypeEntity entity, DiscountTypeRequestDTO dto) {
        if (entity == null || dto == null)
            return;
        if (dto.getCode() != null && !dto.getCode().isBlank())
            entity.setCode(dto.getCode().trim());
        if (dto.getName() != null && !dto.getName().isBlank())
            entity.setName(dto.getName().trim());
        if (dto.getDescription() != null)
            entity.setDescription(dto.getDescription());
        if (dto.getActive() != null)
            entity.setActive(dto.getActive());
        if (dto.getPriority() != null)
            entity.setPriority(dto.getPriority());
        if (dto.getDisplayOrder() != null)
            entity.setDisplayOrder(dto.getDisplayOrder());
    }
}
