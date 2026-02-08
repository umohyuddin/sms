package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.global.responseMappers.RolePermissionMapper;
import com.smartsolutions.eschool.user.dtos.actions.response.ActionResponseDTO;
import com.smartsolutions.eschool.user.dtos.modules.response.ModuleResponseDTO;
import com.smartsolutions.eschool.user.dtos.permissions.response.PermissionResponseDTO;
import com.smartsolutions.eschool.user.dtos.resources.response.ResourceResponseDTO;
import com.smartsolutions.eschool.user.dtos.rolepermissions.request.RolePermissionRequestDTO;
import com.smartsolutions.eschool.user.dtos.rolepermissions.response.RolePermissionResponseDTO;
import com.smartsolutions.eschool.user.model.*;
import com.smartsolutions.eschool.user.repository.PermissionRepository;
import com.smartsolutions.eschool.user.repository.RolePermissionRepository;
import com.smartsolutions.eschool.user.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionRepository rolePermissionRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Override
    @Transactional
    public List<RolePermissionResponseDTO> assignPermissionsToRole(RolePermissionRequestDTO requestDTO) {
        log.info("Assigning permissions to role ID: {}", requestDTO.getRoleId());
        
        RoleEntity role = roleRepository.findById(requestDTO.getRoleId())
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + requestDTO.getRoleId()));

        List<RolePermissionEntity> savedEntries = new ArrayList<>();
        
        for (Long permissionId : requestDTO.getPermissionIds()) {
            if (!rolePermissionRepository.existsByRoleIdAndPermissionId(requestDTO.getRoleId(), permissionId)) {
                PermissionEntity permission = permissionRepository.findById(permissionId)
                        .orElseThrow(() -> new ResourceNotFoundException("Permission not found with id: " + permissionId));

                RolePermissionEntity entity = new RolePermissionEntity();
                entity.setId(new RolePermissionId(requestDTO.getRoleId(), permissionId));
                entity.setRole(role);
                entity.setPermission(permission);
                //entity.setAssignedAt(System.currentTimeMillis());
                
                savedEntries.add(rolePermissionRepository.save(entity));
            }
        }

        return RolePermissionMapper.toResponseDTOList(savedEntries);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PermissionResponseDTO> getPermissionsByRoleId(Long roleId) {
        log.info("Fetching permissions for role ID: {}", roleId);
        List<PermissionEntity> permissions = rolePermissionRepository.findPermissionsByRoleId(roleId);
        
        return permissions.stream().map(entity -> {
            PermissionResponseDTO dto = new PermissionResponseDTO();
            dto.setId(entity.getId());
            dto.setOrganizationId(entity.getOrganizationId());
            dto.setName(entity.getName());
            dto.setCode(entity.getCode());
            dto.setDescription(entity.getDescription());
            dto.setActive(entity.getActive());
            dto.setDeleted(entity.getDeleted());
            dto.setCreatedAt(entity.getCreatedAt());
            dto.setCreatedBy(entity.getCreatedBy());
            dto.setUpdatedAt(entity.getUpdatedAt());
            dto.setUpdatedBy(entity.getUpdatedBy());

            if (entity.getModule() != null) {
                ModuleResponseDTO moduleDTO = new ModuleResponseDTO();
                moduleDTO.setId(entity.getModule().getId());
                moduleDTO.setName(entity.getModule().getName());
                moduleDTO.setCode(entity.getModule().getCode());
                dto.setModule(moduleDTO);
            }

            if (entity.getResource() != null) {
                ResourceResponseDTO resourceDTO = new ResourceResponseDTO();
                resourceDTO.setId(entity.getResource().getId());
                resourceDTO.setResourceName(entity.getResource().getResourceName());
                //resourceDTO.setResourceCode(entity.getResource().getResourceCode());
                dto.setResource(resourceDTO);
            }

            if (entity.getAction() != null) {
                ActionResponseDTO actionDTO = new ActionResponseDTO();
                actionDTO.setId(entity.getAction().getId());
                actionDTO.setName(entity.getAction().getName());
                actionDTO.setCode(entity.getAction().getCode());
                dto.setAction(actionDTO);
            }

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void removePermissionFromRole(Long roleId, Long permissionId) {
        log.info("Removing permission ID: {} from role ID: {}", permissionId, roleId);
        rolePermissionRepository.deleteByRoleIdAndPermissionId(roleId, permissionId);
    }

    @Override
    @Transactional
    public void removeAllPermissionsFromRole(Long roleId) {
        log.info("Removing all permissions from role ID: {}", roleId);
        rolePermissionRepository.deleteByRoleId(roleId);
    }
}
