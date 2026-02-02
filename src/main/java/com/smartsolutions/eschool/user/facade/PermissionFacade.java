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

    public List<PermissionResponseDTO> getAll() {
        return permissionService.getAll();
    }

    public PermissionResponseDTO getById(Long id) {
        return permissionService.getById(id);
    }

    public PermissionResponseDTO updatePermission(Long id, PermissionRequestDTO requestDTO) {
        return permissionService.updatePermission(id, requestDTO);
    }

    public void deleteById(Long id) {
        permissionService.deleteById(id);
    }

    public List<PermissionResponseDTO> searchByKeyword(String keyword) {
        return permissionService.searchByKeyword(keyword);
    }
}
