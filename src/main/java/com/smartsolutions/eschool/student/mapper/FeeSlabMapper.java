package com.smartsolutions.eschool.student.mapper;

import com.smartsolutions.eschool.student.dtos.feeSlab.FeeSlabCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeSlab.FeeSlabResponseDTO;
import com.smartsolutions.eschool.student.model.FeeSlabEntity;

import java.util.List;
import java.util.stream.Collectors;

public class FeeSlabMapper {

    private FeeSlabMapper() {
    }

    public static FeeSlabResponseDTO toResponseDTO(FeeSlabEntity entity) {
        if (entity == null)
            return null;

        FeeSlabResponseDTO dto = new FeeSlabResponseDTO();
        dto.setId(entity.getId());

        if (entity.getSlabGroup() != null) {
            dto.setSlabGroupId(entity.getSlabGroup().getId());
            dto.setSlabGroupName(entity.getSlabGroup().getName());
        }

        dto.setMinValue(entity.getMinValue());
        dto.setMaxValue(entity.getMaxValue());
        dto.setAmount(entity.getAmount());
        dto.setCurrency(entity.getCurrency());
        dto.setActive(entity.isActive());
        dto.setDeleted(entity.isDeleted());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setDeletedAt(entity.getDeletedAt());

        return dto;
    }

    public static List<FeeSlabResponseDTO> toResponseDTOList(List<FeeSlabEntity> entities) {
        if (entities == null)
            return java.util.Collections.emptyList();
        return entities.stream().map(FeeSlabMapper::toResponseDTO).collect(Collectors.toList());
    }

    public static FeeSlabEntity toEntity(FeeSlabCreateRequestDTO dto) {
        if (dto == null)
            return null;

        FeeSlabEntity entity = new FeeSlabEntity();
        entity.setMinValue(dto.getMinValue());
        entity.setMaxValue(dto.getMaxValue());
        entity.setAmount(dto.getAmount());
        entity.setCurrency(dto.getCurrency());
        entity.setActive(dto.isActive());
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(FeeSlabEntity entity, FeeSlabCreateRequestDTO dto) {
        if (entity == null || dto == null)
            return;

        if (dto.getMinValue() != null)
            entity.setMinValue(dto.getMinValue());
        if (dto.getMaxValue() != null)
            entity.setMaxValue(dto.getMaxValue());
        if (dto.getAmount() != null)
            entity.setAmount(dto.getAmount());
        if (dto.getCurrency() != null)
            entity.setCurrency(dto.getCurrency());
        entity.setActive(dto.isActive());
    }
}
