package com.smartsolutions.eschool.global.responseMappers;

import com.smartsolutions.eschool.user.dtos.permissions.request.PermissionRequestDTO;
import com.smartsolutions.eschool.user.dtos.permissions.response.PermissionResponseDTO;
import com.smartsolutions.eschool.user.model.PermissionEntity;
import com.smartsolutions.eschool.user.model.ModuleEntity;
import com.smartsolutions.eschool.user.model.ResourceEntity;
import com.smartsolutions.eschool.user.model.ActionEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PermissionMapper {
    private PermissionMapper() {
        // prevent instantiation
    }

    public static PermissionResponseDTO toResponseDTO(PermissionEntity entity) {
        if (entity == null) {
            return null;
        }

        PermissionResponseDTO dto = new PermissionResponseDTO();
        dto.setId(entity.getId());
        dto.setOrganizationId(entity.getOrganizationId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setDescription(entity.getDescription());
        //dto.setSystemPermission(entity.getSystemPermission());
        dto.setActive(entity.getActive());
        dto.setDeleted(entity.getDeleted());

        if (entity.getModule() != null) {
            dto.setModule(ModuleMapper.toResponseDTO(entity.getModule()));
        }
        if (entity.getResource() != null) {
            dto.setResource(ResourceMapper.toResponseDTO(entity.getResource()));
        }
        if (entity.getAction() != null) {
            dto.setAction(ActionMapper.toResponseDTO(entity.getAction()));
        }

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());

        return dto;
    }

    public static List<PermissionResponseDTO> toResponseDTOList(List<PermissionEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(PermissionMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static PermissionEntity toEntity(PermissionRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        PermissionEntity entity = new PermissionEntity();
        entity.setOrganizationId(dto.getOrganizationId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setDescription(dto.getDescription());
        if (dto.getSystemPermission() != null) {
            //entity.setSystemPermission(dto.getSystemPermission());
        }
        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }

        if (dto.getModuleId() != null) {
            ModuleEntity module = new ModuleEntity();
            module.setId(dto.getModuleId());
            entity.setModule(module);
        }
        if (dto.getResourceId() != null) {
            ResourceEntity resource = new ResourceEntity();
            resource.setId(dto.getResourceId());
            entity.setResource(resource);
        }
        if (dto.getActionId() != null) {
            ActionEntity action = new ActionEntity();
            action.setId(dto.getActionId());
            entity.setAction(action);
        }

        return entity;
    }

    public static void updateEntityFromDTO(PermissionEntity entity, PermissionRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getCode() != null) entity.setCode(dto.getCode());
        if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
        //if (dto.getSystemPermission() != null) entity.setSystemPermission(dto.getSystemPermission());
        if (dto.getActive() != null) entity.setActive(dto.getActive());

        if (dto.getModuleId() != null) {
            ModuleEntity module = new ModuleEntity();
            module.setId(dto.getModuleId());
            entity.setModule(module);
        }
        if (dto.getResourceId() != null) {
            ResourceEntity resource = new ResourceEntity();
            resource.setId(dto.getResourceId());
            entity.setResource(resource);
        }
        if (dto.getActionId() != null) {
            ActionEntity action = new ActionEntity();
            action.setId(dto.getActionId());
            entity.setAction(action);
        }
    }
}
