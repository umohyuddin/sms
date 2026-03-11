package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.roles.request.RoleRequestDTO;
import com.smartsolutions.eschool.user.dtos.roles.response.RoleResponseDTO;
import com.smartsolutions.eschool.user.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class RoleFacade {

    private final RoleService roleService;

    public RoleFacade(RoleService roleService) {
        this.roleService = roleService;
    }

    public List<RoleResponseDTO> getAll() {
        log.info("[Facade:RoleFacade] getAll() called");
        return roleService.getAll();
    }

    public List<RoleResponseDTO> getAll(Long organizationId) {
        log.info("[Facade:RoleFacade] getAll() called - organization: {}", organizationId);
        return roleService.getAll(organizationId);
    }

    public RoleResponseDTO getById(Long id) {
        log.info("[Facade:RoleFacade] getById() called - id: {}", id);
        return roleService.getById(id);
    }

    public RoleResponseDTO getById(Long id, Long organizationId) {
        log.info("[Facade:RoleFacade] getById() called - id: {}, organization: {}", id, organizationId);
        return roleService.getById(id, organizationId);
    }

    public List<RoleResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:RoleFacade] searchByKeyword() called - keyword: {}", keyword);
        return roleService.searchByKeyword(keyword);
    }

    public List<RoleResponseDTO> searchByKeyword(Long organizationId, String keyword) {
        log.info("[Facade:RoleFacade] searchByKeyword() called - keyword: {}, organization: {}", keyword,
                organizationId);
        return roleService.searchByKeyword(organizationId, keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:RoleFacade] softDeleteById() called - id: {}", id);
        roleService.softDeleteById(id);
    }

    public void deleteById(Long id, Long organizationId) {
        log.info("[Facade:RoleFacade] deleteById() called - id: {}, organization: {}", id, organizationId);
        roleService.deleteById(id, organizationId);
    }

    public RoleResponseDTO createRole(RoleRequestDTO dto) {
        log.info("[Facade:RoleFacade] createRole() called");
        return roleService.createRole(dto);
    }

    public RoleResponseDTO updateRole(Long id, RoleRequestDTO dto) {
        log.info("[Facade:RoleFacade] updateRole() called - id: {}", id);
        return roleService.updateRole(id, dto);
    }

    public RoleResponseDTO updateRole(Long id, Long organizationId, RoleRequestDTO dto) {
        log.info("[Facade:RoleFacade] updateRole() called - id: {}, organization: {}", id, organizationId);
        return roleService.updateRole(id, organizationId, dto);
    }

    public List<RoleResponseDTO> getByOrganizationId(Long organizationId) {
        log.info("[Facade:RoleFacade] getByOrganizationId() called - organization: {}", organizationId);
        return roleService.getByOrganizationId(organizationId);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:RoleFacade] getStatistics() called");
        return roleService.getStatistics();
    }
}
