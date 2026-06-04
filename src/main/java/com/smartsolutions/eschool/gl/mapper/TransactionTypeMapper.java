package com.smartsolutions.eschool.gl.mapper;

import com.smartsolutions.eschool.gl.dtos.transactionType.request.TransactionTypeRequestDTO;
import com.smartsolutions.eschool.gl.dtos.transactionType.response.TransactionTypeResponseDTO;
import com.smartsolutions.eschool.gl.model.TransactionTypeEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TransactionTypeMapper {

    public static TransactionTypeEntity toEntity(TransactionTypeRequestDTO dto) {
        if (dto == null) return null;
        return TransactionTypeEntity.builder()
                .code(dto.getCode().trim())
                .name(dto.getName().trim())
                .description(dto.getDescription())
                .isActive(dto.isActive())
                .build();
    }

    public static TransactionTypeResponseDTO toResponseDTO(TransactionTypeEntity entity) {
        if (entity == null) return null;
        return TransactionTypeResponseDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .description(entity.getDescription())
                .active(entity.isActive())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public static void updateEntityFromDTO(TransactionTypeEntity entity, TransactionTypeRequestDTO dto) {
        if (dto == null) return;
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName().trim());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.isActive());
    }

    public static List<TransactionTypeResponseDTO> toResponseDTOList(List<TransactionTypeEntity> entities) {
        return entities.stream().map(TransactionTypeMapper::toResponseDTO).collect(Collectors.toList());
    }
}
