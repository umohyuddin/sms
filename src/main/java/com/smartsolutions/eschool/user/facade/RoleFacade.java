package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.roles.request.RoleRequestDTO;
import com.smartsolutions.eschool.user.dtos.roles.response.RoleResponseDTO;
import com.smartsolutions.eschool.user.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class RoleFacade {

    private final RoleService roleService;

    public RoleFacade(RoleService roleService) {
        this.roleService = roleService;
    }

    public RoleResponseDTO createRole(RoleRequestDTO requestDTO) {
        log.info("Facade: Request to create Role: {}", requestDTO.getName());
        RoleResponseDTO result = roleService.createRole(requestDTO);
        log.info("Facade: Role created successfully with ID: {}", result.getId());
        return result;
    }

    public List<RoleResponseDTO> getAll(Long organizationId) {
        log.info("Facade: Request to fetch all Roles for organization: {}", organizationId);
        List<RoleResponseDTO> result = roleService.getAll(organizationId);
        log.info("Facade: Successfully fetched {} Roles", result.size());
        return result;
    }

    public RoleResponseDTO getById(Long id, Long organizationId) {
        log.info("Facade: Request to fetch Role ID: {} for organization: {}", id, organizationId);
        RoleResponseDTO result = roleService.getById(id, organizationId);
        log.info("Facade: Successfully fetched Role ID: {}", id);
        return result;
    }

    public RoleResponseDTO updateRole(Long id, Long organizationId, RoleRequestDTO requestDTO) {
        log.info("Facade: Request to update Role ID: {} for organization: {}", id, organizationId);
        RoleResponseDTO result = roleService.updateRole(id, organizationId, requestDTO);
        log.info("Facade: Successfully updated Role ID: {}", id);
        return result;
    }

    public void deleteById(Long id, Long organizationId) {
        log.info("Facade: Request to delete Role ID: {} for organization: {}", id, organizationId);
        roleService.deleteById(id, organizationId);
        log.info("Facade: Successfully deleted Role ID: {}", id);
    }

    public List<RoleResponseDTO> searchByKeyword(Long organizationId, String keyword) {
        log.info("Facade: Request to search Roles with keyword: '{}' for organization: {}", keyword, organizationId);
        List<RoleResponseDTO> result = roleService.searchByKeyword(organizationId, keyword);
        log.info("Facade: Search completed, found {} Roles", result.size());
        return result;
    }

    public List<RoleResponseDTO> getByOrganizationId(Long organizationId) {
        log.info("Facade: Request to fetch all Roles for organization ID: {}", organizationId);
        return roleService.getByOrganizationId(organizationId);
    }
}
