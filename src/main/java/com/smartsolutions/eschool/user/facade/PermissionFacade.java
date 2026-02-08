package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.permissions.request.PermissionRequestDTO;
import com.smartsolutions.eschool.user.dtos.permissions.response.PermissionResponseDTO;
import com.smartsolutions.eschool.user.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class PermissionFacade {

    private final PermissionService permissionService;

    public PermissionFacade(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    public PermissionResponseDTO createPermission(PermissionRequestDTO requestDTO) {
        log.info("Facade: Request to create Permission: {}", requestDTO.getName());
        PermissionResponseDTO result = permissionService.createPermission(requestDTO);
        log.info("Facade: Permission created successfully with ID: {}", result.getId());
        return result;
    }

    public List<PermissionResponseDTO> getAll(Long organizationId) {
        log.info("Facade: Request to fetch all Permissions for organization: {}", organizationId);
        List<PermissionResponseDTO> result = permissionService.getAll(organizationId);
        log.info("Facade: Successfully fetched {} Permissions", result.size());
        return result;
    }

    public PermissionResponseDTO getById(Long id, Long organizationId) {
        log.info("Facade: Request to fetch Permission ID: {} for organization: {}", id, organizationId);
        PermissionResponseDTO result = permissionService.getById(id, organizationId);
        log.info("Facade: Successfully fetched Permission ID: {}", id);
        return result;
    }

    public PermissionResponseDTO updatePermission(Long id, Long organizationId, PermissionRequestDTO requestDTO) {
        log.info("Facade: Request to update Permission ID: {} for organization: {}", id, organizationId);
        PermissionResponseDTO result = permissionService.updatePermission(id, organizationId, requestDTO);
        log.info("Facade: Successfully updated Permission ID: {}", id);
        return result;
    }

    public void deleteById(Long id, Long organizationId) {
        log.info("Facade: Request to delete Permission ID: {} for organization: {}", id, organizationId);
        permissionService.deleteById(id, organizationId);
        log.info("Facade: Successfully deleted Permission ID: {}", id);
    }

    public List<PermissionResponseDTO> searchByKeyword(Long organizationId, String keyword) {
        log.info("Facade: Request to search Permissions with keyword: '{}' for organization: {}", keyword, organizationId);
        List<PermissionResponseDTO> result = permissionService.searchByKeyword(organizationId, keyword);
        log.info("Facade: Search completed, found {} Permissions", result.size());
        return result;
    }
}
