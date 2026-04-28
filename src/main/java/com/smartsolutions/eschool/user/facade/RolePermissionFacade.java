package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.permissions.response.PermissionResponseDTO;
import com.smartsolutions.eschool.user.dtos.rolepermissions.request.RolePermissionRequestDTO;
import com.smartsolutions.eschool.user.dtos.rolepermissions.response.RolePermissionResponseDTO;
import com.smartsolutions.eschool.user.service.RolePermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class RolePermissionFacade {

    private final RolePermissionService rolePermissionService;

    public List<RolePermissionResponseDTO> assignPermissionsToRole(RolePermissionRequestDTO requestDTO) {
        return rolePermissionService.assignPermissionsToRole(requestDTO);
    }

    public List<PermissionResponseDTO> getPermissionsByRoleId(Long roleId) {
        return rolePermissionService.getPermissionsByRoleId(roleId);
    }

    public void removePermissionFromRole(Long roleId, Long permissionId) {
        rolePermissionService.removePermissionFromRole(roleId, permissionId);
    }

    public void removeAllPermissionsFromRole(Long roleId) {
        rolePermissionService.removeAllPermissionsFromRole(roleId);
    }
}
