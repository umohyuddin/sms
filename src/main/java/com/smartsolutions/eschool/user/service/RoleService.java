package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.global.responseMappers.RoleMapper;
import com.smartsolutions.eschool.user.dtos.roles.request.RoleRequestDTO;
import com.smartsolutions.eschool.user.dtos.roles.response.RoleResponseDTO;
import com.smartsolutions.eschool.user.model.RoleEntity;
import com.smartsolutions.eschool.user.repository.PermissionRepository;
import com.smartsolutions.eschool.user.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Transactional
    public RoleResponseDTO createRole(RoleRequestDTO requestDTO) {
        log.info("Creating new Role: {}", requestDTO.getName());
        RoleEntity entity = RoleMapper.toEntity(requestDTO);
        
        if (requestDTO.getPermissionIds() != null && !requestDTO.getPermissionIds().isEmpty()) {
            java.util.Set<com.smartsolutions.eschool.user.model.PermissionEntity> permissions = 
                new java.util.HashSet<>(permissionRepository.findAllById(requestDTO.getPermissionIds()));
            entity.setPermissions(permissions);
        }
        
        RoleEntity saved = roleRepository.save(entity);
        return RoleMapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<RoleResponseDTO> getAll(Long organizationId) {
        log.info("Fetching all Roles for organization: {}", organizationId);
        List<RoleEntity> result = roleRepository.findByOrganizationId(organizationId);
        return RoleMapper.toResponseDTOList(result);
    }

    @Transactional(readOnly = true)
    public RoleResponseDTO getById(Long id, Long organizationId) {
        log.info("Fetching Role with id: {} and organizationId: {}", id, organizationId);
        RoleEntity entity = roleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id + " for organizationId: " + organizationId));
        return RoleMapper.toResponseDTO(entity);
    }

    @Transactional
    public RoleResponseDTO updateRole(Long id, Long organizationId, RoleRequestDTO requestDTO) {
        log.info("Updating Role with id: {} for organizationId: {}", id, organizationId);
        RoleEntity existing = roleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id + " for organizationId: " + organizationId));

        RoleMapper.updateEntityFromDTO(existing, requestDTO);
        
        if (requestDTO.getPermissionIds() != null) {
            java.util.Set<com.smartsolutions.eschool.user.model.PermissionEntity> permissions = 
                new java.util.HashSet<>(permissionRepository.findAllById(requestDTO.getPermissionIds()));
            existing.setPermissions(permissions);
        }

        RoleEntity updated = roleRepository.save(existing);
        return RoleMapper.toResponseDTO(updated);
    }

    @Transactional
    public void deleteById(Long id, Long organizationId) {
        log.info("Deleting Role with ID: {} and organizationId: {}", id, organizationId);
        RoleEntity existing = roleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id + " for organizationId: " + organizationId));
        existing.setDeleted(true);
        roleRepository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<RoleResponseDTO> searchByKeyword(Long organizationId, String keyword) {
        log.info("Searching Roles with keyword: {} for organizationId: {}", keyword, organizationId);
        List<RoleEntity> result = roleRepository.searchByKeyword(organizationId, keyword == null ? "" : keyword.trim());
        return RoleMapper.toResponseDTOList(result);
    }

    @Transactional(readOnly = true)
    public List<RoleResponseDTO> getByOrganizationId(Long organizationId) {
        return getAll(organizationId);
    }
}
