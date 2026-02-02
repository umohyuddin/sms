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

    public List<RoleResponseDTO> getAll() {
        return roleService.getAll();
    }

    public RoleResponseDTO getById(Long id) {
        return roleService.getById(id);
    }

    public RoleResponseDTO updateRole(Long id, RoleRequestDTO requestDTO) {
        return roleService.updateRole(id, requestDTO);
    }

    public void deleteById(Long id) {
        roleService.deleteById(id);
    }

    public List<RoleResponseDTO> searchByKeyword(String keyword) {
        return roleService.searchByKeyword(keyword);
    }
}
