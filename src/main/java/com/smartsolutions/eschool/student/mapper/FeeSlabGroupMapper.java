package com.smartsolutions.eschool.student.mapper;

import com.smartsolutions.eschool.student.dtos.feeSlabGroup.FeeSlabGroupCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeSlabGroup.FeeSlabGroupResponseDTO;
import com.smartsolutions.eschool.student.model.FeeSlabGroupEntity;

import java.util.List;
import java.util.stream.Collectors;

public class FeeSlabGroupMapper {

    private FeeSlabGroupMapper() {
    }

    public static FeeSlabGroupResponseDTO toResponseDTO(FeeSlabGroupEntity entity) {
        if (entity == null) {
            return null;
        }

        FeeSlabGroupResponseDTO dto = new FeeSlabGroupResponseDTO();
        dto.setId(entity.getId());

        if (entity.getFeeComponent() != null) {
            dto.setFeeComponentId(entity.getFeeComponent().getId());
            dto.setFeeComponentName(entity.getFeeComponent().getComponentName());
        }

        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.isActive());
        dto.setDeleted(entity.isDeleted());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setDeletedAt(entity.getDeletedAt());

        return dto;
    }

    public static List<FeeSlabGroupResponseDTO> toResponseDTOList(List<FeeSlabGroupEntity> entities) {
        if (entities == null)
            return java.util.Collections.emptyList();
        return entities.stream().map(FeeSlabGroupMapper::toResponseDTO).collect(Collectors.toList());
    }

    public static FeeSlabGroupEntity toEntity(FeeSlabGroupCreateRequestDTO dto) {
        if (dto == null)
            return null;

        FeeSlabGroupEntity entity = new FeeSlabGroupEntity();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.isActive());
        entity.setDeleted(false);

        return entity;
    }

    public static void updateEntityFromDTO(FeeSlabGroupEntity entity, FeeSlabGroupCreateRequestDTO dto) {
        if (entity == null || dto == null)
            return;

        if (dto.getCode() != null)
            entity.setCode(dto.getCode());
        if (dto.getName() != null)
            entity.setName(dto.getName());
        if (dto.getDescription() != null)
            entity.setDescription(dto.getDescription());
        entity.setActive(dto.isActive());
    }
}
