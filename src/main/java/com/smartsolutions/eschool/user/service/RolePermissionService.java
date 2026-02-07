package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.user.dtos.rolepermissions.request.RolePermissionRequestDTO;
import com.smartsolutions.eschool.user.dtos.rolepermissions.response.RolePermissionResponseDTO;
import com.smartsolutions.eschool.user.model.PermissionEntity;

import java.util.List;

public interface RolePermissionService {
    List<RolePermissionResponseDTO> assignPermissionsToRole(RolePermissionRequestDTO requestDTO);
    List<PermissionEntity> getPermissionsByRoleId(Long roleId);
    void removePermissionFromRole(Long roleId, Long permissionId);
    void removeAllPermissionsFromRole(Long roleId);
}
