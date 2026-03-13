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
        //dto.setDeleted(entity.getDeleted());

        dto.setCreatedAt(entity.getCreatedAt());
        //dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        //dto.setUpdatedBy(entity.getUpdatedBy());

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

    public static ModuleEntity toEntity(ModuleRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        ModuleEntity entity = new ModuleEntity();
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setIcon(dto.getIcon());
        entity.setRoute(dto.getRoute());
        entity.setDisplayOrder(dto.getDisplayOrder());
        if (dto.getSystemModule() != null) {
            entity.setSystemModule(dto.getSystemModule());
        }
        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }
        return entity;
    }

    public static void updateEntityFromDTO(ModuleEntity entity, ModuleRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getCode() != null) entity.setCode(dto.getCode());
        if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
        if (dto.getIcon() != null) entity.setIcon(dto.getIcon());
        if (dto.getRoute() != null) entity.setRoute(dto.getRoute());
        if (dto.getDisplayOrder() != null) entity.setDisplayOrder(dto.getDisplayOrder());
        if (dto.getSystemModule() != null) entity.setSystemModule(dto.getSystemModule());
        if (dto.getActive() != null) entity.setActive(dto.getActive());
    }
}
