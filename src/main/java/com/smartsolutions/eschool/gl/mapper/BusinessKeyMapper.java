package com.smartsolutions.eschool.gl.mapper;

import com.smartsolutions.eschool.gl.dtos.businessKey.request.BusinessKeyRequestDTO;
import com.smartsolutions.eschool.gl.dtos.businessKey.response.BusinessKeyResponseDTO;
import com.smartsolutions.eschool.gl.model.BusinessKeyEntity;

import java.util.List;
import java.util.stream.Collectors;

public class BusinessKeyMapper {

    public static BusinessKeyEntity toEntity(BusinessKeyRequestDTO dto) {
        if (dto == null) return null;
        return BusinessKeyEntity.builder()
                .code(dto.getCode().trim())
                .name(dto.getName().trim())
                .module(dto.getModule())
                .description(dto.getDescription())
                .isActive(dto.isActive())
                .build();
    }

    public static BusinessKeyResponseDTO toResponseDTO(BusinessKeyEntity entity) {
        if (entity == null) return null;
        return BusinessKeyResponseDTO.builder()
                .id(entity.getId())
                .code(entity.getCode())
                .name(entity.getName())
                .module(entity.getModule())
                .description(entity.getDescription())
                .active(entity.isActive())
                .createdAt(entity.getCreatedAt())
                .build();
    }

    public static void updateEntityFromDTO(BusinessKeyEntity entity, BusinessKeyRequestDTO dto) {
        if (dto == null) return;
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName().trim());
        entity.setModule(dto.getModule());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.isActive());
    }

    public static List<BusinessKeyResponseDTO> toResponseDTOList(List<BusinessKeyEntity> entities) {
        return entities.stream().map(BusinessKeyMapper::toResponseDTO).collect(Collectors.toList());
    }
}
