package com.smartsolutions.eschool.global.responseMappers;

import com.smartsolutions.eschool.user.model.PermissionEntity;
import com.smartsolutions.eschool.user.dtos.permissions.response.PermissionResponseDTO;
import com.smartsolutions.eschool.user.dtos.permissions.request.PermissionRequestDTO;
import com.smartsolutions.eschool.global.responseMappers.ModuleMapper;

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
        dto.setSystemPermission(entity.getSystemPermission());
        dto.setActive(entity.getActive());
        dto.setDeleted(entity.getDeleted());

        // Standard metadata
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());

        // Module relationship
        if (entity.getModule() != null) {
            dto.setModule(ModuleMapper.toResponseDTO(entity.getModule()));
        }

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

    public static PermissionEntity toEntity(PermissionRequestDTO requestDTO) {
        if (requestDTO == null) {
            return null;
        }

        PermissionEntity entity = new PermissionEntity();
        entity.setOrganizationId(requestDTO.getOrganizationId());
        entity.setName(requestDTO.getName());
        entity.setCode(requestDTO.getCode());
        entity.setDescription(requestDTO.getDescription());
        entity.setSystemPermission(requestDTO.getSystemPermission());
        entity.setActive(requestDTO.getActive());
        // moduleId is handled in service
        return entity;
    }

    public static void updateEntity(PermissionEntity entity, PermissionRequestDTO requestDTO) {
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
        if (requestDTO.getSystemPermission() != null) {
            entity.setSystemPermission(requestDTO.getSystemPermission());
        }
        if (requestDTO.getActive() != null) {
            entity.setActive(requestDTO.getActive());
        }
        // organizationId and deleted are usually not updated via standard request
        // moduleId is updated in service
    }
}
