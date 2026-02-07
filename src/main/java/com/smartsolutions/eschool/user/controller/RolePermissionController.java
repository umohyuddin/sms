package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.user.dtos.rolepermissions.request.RolePermissionRequestDTO;
import com.smartsolutions.eschool.user.dtos.rolepermissions.response.RolePermissionResponseDTO;
import com.smartsolutions.eschool.user.facade.RolePermissionFacade;
import com.smartsolutions.eschool.user.model.PermissionEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role-permissions")
@RequiredArgsConstructor
public class RolePermissionController {

    private final RolePermissionFacade rolePermissionFacade;

    @PostMapping("/assign")
    public ResponseEntity<List<RolePermissionResponseDTO>> assignPermissionsToRole(@RequestBody RolePermissionRequestDTO requestDTO) {
        return ResponseEntity.ok(rolePermissionFacade.assignPermissionsToRole(requestDTO));
    }

    @GetMapping("/role/{roleId}")
    public ResponseEntity<List<PermissionEntity>> getPermissionsByRoleId(@PathVariable Long roleId) {
        return ResponseEntity.ok(rolePermissionFacade.getPermissionsByRoleId(roleId));
    }

    @DeleteMapping("/role/{roleId}/permission/{permissionId}")
    public ResponseEntity<Void> removePermissionFromRole(@PathVariable Long roleId, @PathVariable Long permissionId) {
        rolePermissionFacade.removePermissionFromRole(roleId, permissionId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/role/{roleId}")
    public ResponseEntity<Void> removeAllPermissionsFromRole(@PathVariable Long roleId) {
        rolePermissionFacade.removeAllPermissionsFromRole(roleId);
        return ResponseEntity.noContent().build();
    }
}
