package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.roles.request.RoleRequestDTO;
import com.smartsolutions.eschool.user.dtos.roles.response.RoleResponseDTO;
import com.smartsolutions.eschool.user.service.RoleService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class RoleFacade {

    private final RoleService roleService;

    public RoleFacade(RoleService roleService) {
        this.roleService = roleService;
    }

    public RoleResponseDTO createRole(RoleRequestDTO requestDTO) {
        return roleService.createRole(requestDTO);
    }

    public List<RoleResponseDTO> getAll(Long organizationId) {
        return roleService.getAll(organizationId);
    }

    public RoleResponseDTO getById(Long id, Long organizationId) {
        return roleService.getById(id, organizationId);
    }

    public RoleResponseDTO updateRole(Long id, Long organizationId, RoleRequestDTO requestDTO) {
        return roleService.updateRole(id, organizationId, requestDTO);
    }

    public void deleteById(Long id, Long organizationId) {
        roleService.deleteById(id, organizationId);
    }

    public List<RoleResponseDTO> searchByKeyword(Long organizationId, String keyword) {
        return roleService.searchByKeyword(organizationId, keyword);
    }

    public List<RoleResponseDTO> getByOrganizationId(Long organizationId) {
        return roleService.getByOrganizationId(organizationId);
    }
}
