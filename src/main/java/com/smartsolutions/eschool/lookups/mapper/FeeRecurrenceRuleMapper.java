package com.smartsolutions.eschool.lookups.mapper;

import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.requestDto.FeeRecurrenceRuleRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.feeRecurrenceRule.responseDto.FeeRecurrenceRuleResponseDTO;
import com.smartsolutions.eschool.lookups.model.FeeRecurrenceRuleEntity;

public class FeeRecurrenceRuleMapper {

    private FeeRecurrenceRuleMapper() {
        // prevent instantiation
    }

    public static FeeRecurrenceRuleEntity toEntity(FeeRecurrenceRuleRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        FeeRecurrenceRuleEntity entity = new FeeRecurrenceRuleEntity();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setIsActive(dto.getIsActive() != null ? dto.getIsActive() : true);
        return entity;
    }

    public static FeeRecurrenceRuleResponseDTO toResponseDTO(FeeRecurrenceRuleEntity entity) {
        if (entity == null) {
            return null;
        }

        FeeRecurrenceRuleResponseDTO dto = new FeeRecurrenceRuleResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setIsActive(entity.getIsActive());
        return dto;
    }

    public static void updateEntity(FeeRecurrenceRuleEntity entity, FeeRecurrenceRuleRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getCode() != null) entity.setCode(dto.getCode());
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
        if (dto.getIsActive() != null) entity.setIsActive(dto.getIsActive());
    }
}
