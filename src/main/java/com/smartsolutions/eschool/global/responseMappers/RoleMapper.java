package com.smartsolutions.eschool.global.responseMappers;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.error.RoleErrors;
import com.smartsolutions.eschool.user.dtos.roles.request.RoleRequestDTO;
import com.smartsolutions.eschool.user.dtos.roles.response.RoleResponseDTO;
import com.smartsolutions.eschool.user.model.RoleEntity;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper for RoleEntity to DTOs and vice versa.
 */
public class RoleMapper {

    private RoleMapper() {
        // prevent instantiation
    }

    public static RoleEntity toEntity(RoleRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getName() == null || dto.getName().trim().isEmpty()) {
            throw new ApiException(RoleErrors.INVALID_ROLE_DATA, "Role name is required",
                    HttpStatus.BAD_REQUEST);
        }

        if (dto.getCode() == null || dto.getCode().trim().isEmpty()) {
            throw new ApiException(RoleErrors.INVALID_ROLE_DATA, "Role code is required",
                    HttpStatus.BAD_REQUEST);
        }

        RoleEntity entity = new RoleEntity();
        entity.setOrganizationId(dto.getOrganizationId());
        entity.setCode(dto.getCode().trim());
        entity.setName(dto.getName().trim());
        entity.setDescription(dto.getDescription());
        entity.setSystemRole(dto.getSystemRole() != null ? dto.getSystemRole() : false);
        entity.setActive(dto.getActive() != null ? dto.getActive() : true);
        entity.setDeleted(false);

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

        // Audit fields
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());

        return dto;
    }

    public static List<RoleResponseDTO> toResponseDTOList(List<RoleEntity> entities) {
        if (entities == null) {
            return Collections.emptyList();
        }
        return entities.stream()
                .map(RoleMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public static void updateEntityFromDTO(RoleEntity entity, RoleRequestDTO dto) {
        if (entity == null || dto == null) {
            return;
        }

        if (dto.getName() != null) {
            if (dto.getName().trim().isEmpty()) {
                throw new ApiException(RoleErrors.INVALID_ROLE_DATA, "Role name cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setName(dto.getName().trim());
        }

        if (dto.getCode() != null) {
            if (dto.getCode().trim().isEmpty()) {
                throw new ApiException(RoleErrors.INVALID_ROLE_DATA, "Role code cannot be empty",
                        HttpStatus.BAD_REQUEST);
            }
            entity.setCode(dto.getCode().trim());
        }

        if (dto.getDescription() != null) {
            entity.setDescription(dto.getDescription());
        }

        if (dto.getSystemRole() != null) {
            entity.setSystemRole(dto.getSystemRole());
        }

        if (dto.getActive() != null) {
            entity.setActive(dto.getActive());
        }
    }
}
