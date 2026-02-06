package com.smartsolutions.eschool.global.responseMappers;

import com.smartsolutions.eschool.user.dtos.modules.request.ModuleRequestDTO;
import com.smartsolutions.eschool.user.dtos.modules.response.ModuleResponseDTO;
import com.smartsolutions.eschool.user.model.ModuleEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ModuleMapper {
    private ModuleMapper() {
        // prevent instantiation
    }

    public static ModuleResponseDTO toResponseDTO(ModuleEntity entity) {
        if (entity == null) {
            return null;
        }

        ModuleResponseDTO dto = new ModuleResponseDTO();
        dto.setId(entity.getId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setIcon(entity.getIcon());
        dto.setRoute(entity.getRoute());
        dto.setDisplayOrder(entity.getDisplayOrder());
        dto.setSystemModule(entity.getSystemModule());
        dto.setActive(entity.getActive());
        dto.setDeleted(entity.getDeleted());

        // Standard metadata
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());

        return dto;
    }

    public static List<ModuleResponseDTO> toResponseDTOList(List<ModuleEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(ModuleMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static ModuleEntity toEntity(ModuleRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }

        ModuleEntity entity = new ModuleEntity();
        entity.setCode(requestDTO.getCode());
        entity.setName(requestDTO.getName());
        entity.setDescription(requestDTO.getDescription());
        entity.setIcon(requestDTO.getIcon());
        entity.setRoute(requestDTO.getRoute());
        entity.setDisplayOrder(requestDTO.getDisplayOrder());
        entity.setSystemModule(requestDTO.getSystemModule());
        entity.setActive(requestDTO.getActive());
        return entity;
    }

    public static void updateEntity(ModuleEntity entity, ModuleRequestDTO requestDTO) {
        if (entity == null || requestDTO == null) {
            return;
        }

        if (requestDTO.getName() != null && !requestDTO.getName().isBlank()) {
            entity.setName(requestDTO.getName());
        }
        if (requestDTO.getCode() != null && !requestDTO.getCode().isBlank()) {
            entity.setCode(requestDTO.getCode());
        }
        if (requestDTO.getDescription() != null) {
            entity.setDescription(requestDTO.getDescription());
        }
        if (requestDTO.getIcon() != null) {
            entity.setIcon(requestDTO.getIcon());
        }
        if (requestDTO.getRoute() != null) {
            entity.setRoute(requestDTO.getRoute());
        }
        if (requestDTO.getDisplayOrder() != null) {
            entity.setDisplayOrder(requestDTO.getDisplayOrder());
        }
        if (requestDTO.getSystemModule() != null) {
            entity.setSystemModule(requestDTO.getSystemModule());
        }
        if (requestDTO.getActive() != null) {
            entity.setActive(requestDTO.getActive());
        }
    }
}
