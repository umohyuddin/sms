package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.permissions.request.PermissionRequestDTO;
import com.smartsolutions.eschool.user.dtos.permissions.response.PermissionResponseDTO;
import com.smartsolutions.eschool.user.service.PermissionService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class PermissionFacade {

    private final PermissionService permissionService;

    public PermissionFacade(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    public PermissionResponseDTO createPermission(PermissionRequestDTO requestDTO) {
        return permissionService.createPermission(requestDTO);
    }

    public List<PermissionResponseDTO> getAll(Long organizationId) {
        return permissionService.getAll(organizationId);
    }

    public PermissionResponseDTO getById(Long id, Long organizationId) {
        return permissionService.getById(id, organizationId);
    }

    public PermissionResponseDTO updatePermission(Long id, Long organizationId, PermissionRequestDTO requestDTO) {
        return permissionService.updatePermission(id, organizationId, requestDTO);
    }

    public void deleteById(Long id, Long organizationId) {
        permissionService.deleteById(id, organizationId);
    }

    public List<PermissionResponseDTO> searchByKeyword(Long organizationId, String keyword) {
        return permissionService.searchByKeyword(organizationId, keyword);
    }
}
