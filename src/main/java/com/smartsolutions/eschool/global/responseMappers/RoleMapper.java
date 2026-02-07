package com.smartsolutions.eschool.global.responseMappers;

import com.smartsolutions.eschool.user.dtos.roles.request.RoleRequestDTO;
import com.smartsolutions.eschool.user.dtos.roles.response.RoleResponseDTO;
import com.smartsolutions.eschool.user.model.RoleEntity;

import java.util.List;
import java.util.stream.Collectors;

public class RoleMapper {

    private RoleMapper() {
        // prevent instantiation
    }

    public static RoleEntity toEntity(RoleRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        RoleEntity entity = new RoleEntity();
        entity.setOrganizationId(dto.getOrganizationId());
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        if (dto.getSystemRole() != null) {
            entity.setSystemRole(dto.getSystemRole());
        }
        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }
        return entity;
    }

    public static RoleResponseDTO toResponseDTO(RoleEntity entity) {
        if (entity == null) {
            return null;
        }

        RoleResponseDTO dto = new RoleResponseDTO();
        dto.setId(entity.getId());
        dto.setOrganizationId(entity.getOrganizationId());
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setSystemRole(entity.getSystemRole());
        dto.setActive(entity.getActive());
        dto.setDeleted(entity.getDeleted());

        if (entity.getPermissions() != null) {
            dto.setPermissions(entity.getPermissions().stream()
                    .map(PermissionMapper::toResponseDTO)
                    .collect(Collectors.toSet()));
        }

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());

        return dto;
    }

    public static List<RoleResponseDTO> toResponseDTOList(List<RoleEntity> entities) {
        if (entities == null) {
            return java.util.Collections.emptyList();
        }
        return entities.stream()
                .map(RoleMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static void updateEntityFromDTO(RoleEntity entity, RoleRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getOrganizationId() != null) entity.setOrganizationId(dto.getOrganizationId());
        if (dto.getCode() != null) entity.setCode(dto.getCode());
        if (dto.getName() != null) entity.setName(dto.getName());
        if (dto.getDescription() != null) entity.setDescription(dto.getDescription());
        if (dto.getSystemRole() != null) entity.setSystemRole(dto.getSystemRole());
        if (dto.getActive() != null) entity.setActive(dto.getActive());
    }
}
