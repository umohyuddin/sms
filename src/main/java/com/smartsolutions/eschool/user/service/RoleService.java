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
        log.info("Creating new Role in database: {}", requestDTO.getName());
        try {
            RoleEntity entity = RoleMapper.toEntity(requestDTO);
            
            if (requestDTO.getPermissionIds() != null && !requestDTO.getPermissionIds().isEmpty()) {
                log.info("Assigning {} permissions to new Role", requestDTO.getPermissionIds().size());
                java.util.Set<com.smartsolutions.eschool.user.model.PermissionEntity> permissions = 
                    new java.util.HashSet<>(permissionRepository.findAllById(requestDTO.getPermissionIds()));
                entity.setPermissions(permissions);
            }
            
            RoleEntity saved = roleRepository.save(entity);
            log.info("Successfully created Role with ID: {}", saved.getId());
            return RoleMapper.toResponseDTO(saved);
        } catch (Exception e) {
            log.error("Unexpected error while creating Role", e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RoleResponseDTO> getAll(Long organizationId) {
        log.info("Fetching all Roles for organization: {} from database", organizationId);
        try {
            List<RoleEntity> result = roleRepository.findByOrganizationId(organizationId);
            log.info("Successfully fetched {} Roles for organization: {}", result.size(), organizationId);
            return RoleMapper.toResponseDTOList(result);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Roles", e);
            return java.util.Collections.emptyList();
        }
    }

    @Transactional(readOnly = true)
    public RoleResponseDTO getById(Long id, Long organizationId) {
        log.info("Fetching Role with ID: {} and organizationId: {} from database", id, organizationId);
        RoleEntity entity = roleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> {
                    log.warn("Role not found with ID: {} and organizationId: {}", id, organizationId);
                    return new ResourceNotFoundException("Role not found with id: " + id + " for organizationId: " + organizationId);
                });
        log.info("Successfully fetched Role: id={}", entity.getId());
        return RoleMapper.toResponseDTO(entity);
    }

    @Transactional
    public RoleResponseDTO updateRole(Long id, Long organizationId, RoleRequestDTO requestDTO) {
        log.info("Updating Role with ID: {} for organizationId: {} in database", id, organizationId);
        try {
            RoleEntity existing = roleRepository.findByIdAndOrganizationId(id, organizationId)
                    .orElseThrow(() -> {
                        log.warn("Role not found for update with ID: {} and organizationId: {}", id, organizationId);
                        return new ResourceNotFoundException("Role not found with id: " + id + " for organizationId: " + organizationId);
                    });

            RoleMapper.updateEntityFromDTO(existing, requestDTO);
            
            if (requestDTO.getPermissionIds() != null) {
                log.info("Updating permissions for Role ID: {}", id);
                java.util.Set<com.smartsolutions.eschool.user.model.PermissionEntity> permissions = 
                    new java.util.HashSet<>(permissionRepository.findAllById(requestDTO.getPermissionIds()));
                existing.setPermissions(permissions);
            }

            RoleEntity updated = roleRepository.save(existing);
            log.info("Successfully updated Role ID: {}", id);
            return RoleMapper.toResponseDTO(updated);
        } catch (Exception e) {
            log.error("Unexpected error while updating Role ID: {}", id, e);
            throw e;
        }
    }

    @Transactional
    public void deleteById(Long id, Long organizationId) {
        log.info("Soft delete request received for Role ID: {} and organizationId: {}", id, organizationId);
        try {
            RoleEntity existing = roleRepository.findByIdAndOrganizationId(id, organizationId)
                    .orElseThrow(() -> {
                        log.warn("Role not found for deletion with ID: {} and organizationId: {}", id, organizationId);
                        return new ResourceNotFoundException("Role not found with id: " + id + " for organizationId: " + organizationId);
                    });
            existing.setDeleted(true);
            roleRepository.save(existing);
            log.info("Role ID: {} marked as deleted successfully", id);
        } catch (Exception e) {
            log.error("Error while soft deleting Role with ID: {}", id, e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RoleResponseDTO> searchByKeyword(Long organizationId, String keyword) {
        try {
            String searchKey = keyword == null ? "" : keyword.trim();
            log.info("Fetching Roles based on search from database for organization: {} with keyword: '{}'", organizationId, searchKey);
            List<RoleEntity> result = roleRepository.searchByKeyword(organizationId, searchKey);
            log.info("Successfully fetched {} Roles based on search", result.size());
            return RoleMapper.toResponseDTOList(result);
        } catch (Exception e) {
            log.error("Unexpected error while searching Roles", e);
            return java.util.Collections.emptyList();
        }
    }

    @Transactional(readOnly = true)
    public List<RoleResponseDTO> getByOrganizationId(Long organizationId) {
        return getAll(organizationId);
    }
}
