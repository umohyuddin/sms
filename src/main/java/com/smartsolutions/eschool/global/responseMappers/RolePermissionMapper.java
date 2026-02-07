package com.smartsolutions.eschool.global.responseMappers;

import com.smartsolutions.eschool.user.dtos.rolepermissions.response.RolePermissionResponseDTO;
import com.smartsolutions.eschool.user.model.RolePermissionEntity;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class RolePermissionMapper {

    public static RolePermissionResponseDTO toResponseDTO(RolePermissionEntity entity) {
        if (entity == null) {
            return null;
        }
        RolePermissionResponseDTO dto = new RolePermissionResponseDTO();
        dto.setRoleId(entity.getId().getRoleId());
        dto.setPermissionId(entity.getId().getPermissionId());
        if (entity.getRole() != null) {
            dto.setRoleName(entity.getRole().getName());
        }
        if (entity.getPermission() != null) {
            dto.setPermissionName(entity.getPermission().getName());
        }
        return dto;
    }

    public static List<RolePermissionResponseDTO> toResponseDTOList(List<RolePermissionEntity> entities) {
        if (entities == null) {
            return null;
        }
        return entities.stream()
                .map(RolePermissionMapper::toResponseDTO)
                .collect(Collectors.toList());
    }
}
