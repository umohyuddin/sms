package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.global.responseMappers.PermissionMapper;
import com.smartsolutions.eschool.user.dtos.permissions.request.PermissionRequestDTO;
import com.smartsolutions.eschool.user.dtos.permissions.response.PermissionResponseDTO;
import com.smartsolutions.eschool.user.model.ActionEntity;
import com.smartsolutions.eschool.user.model.ModuleEntity;
import com.smartsolutions.eschool.user.model.PermissionEntity;
import com.smartsolutions.eschool.user.model.ResourceEntity;
import com.smartsolutions.eschool.user.repository.ActionRepository;
import com.smartsolutions.eschool.user.repository.ModuleRepository;
import com.smartsolutions.eschool.user.repository.PermissionRepository;
import com.smartsolutions.eschool.user.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;
    private final ModuleRepository moduleRepository;
    private final ResourceRepository resourceRepository;
    private final ActionRepository actionRepository;

    @Transactional
    public PermissionResponseDTO createPermission(PermissionRequestDTO dto) {
        log.info("Creating new Permission in database: {}", dto.getName());
        try {
            PermissionEntity entity = PermissionMapper.toEntity(dto);
            
            loadEntityRelationships(entity, dto);

            PermissionEntity saved = permissionRepository.save(entity);
            log.info("Successfully created Permission with ID: {}", saved.getId());
            return PermissionMapper.toResponseDTO(saved);
        } catch (Exception e) {
            log.error("Unexpected error while creating Permission", e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PermissionResponseDTO> getAll(Long organizationId) {
        log.info("Fetching all Permissions for organization: {} from database", organizationId);
        try {
            List<PermissionEntity> entities = permissionRepository.findByOrganizationId(organizationId);
            log.info("Successfully fetched {} Permissions for organization: {}", entities.size(), organizationId);
            return PermissionMapper.toResponseDTOList(entities);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Permissions", e);
            return java.util.Collections.emptyList();
        }
    }

    @Transactional(readOnly = true)
    public List<PermissionResponseDTO> searchByKeyword(Long organizationId, String keyword) {
        try {
            String searchKey = keyword == null ? "" : keyword.trim();
            log.info("Fetching Permissions based on search from database for organization: {} with keyword: '{}'", organizationId, searchKey);
            List<PermissionEntity> result = permissionRepository.searchByKeyword(organizationId, searchKey);
            log.info("Successfully fetched {} Permissions based on search", result.size());
            return PermissionMapper.toResponseDTOList(result);
        } catch (Exception e) {
            log.error("Unexpected error while searching Permissions", e);
            return java.util.Collections.emptyList();
        }
    }

    @Transactional(readOnly = true)
    public PermissionResponseDTO getById(Long id, Long organizationId) {
        log.info("Fetching Permission with ID: {} and organizationId: {} from database", id, organizationId);
        try {
            PermissionEntity entity = permissionRepository.findByIdAndOrganizationId(id, organizationId)
                    .orElseThrow(() -> {
                        log.warn("Permission not found with ID: {} and organizationId: {}", id, organizationId);
                        return new ResourceNotFoundException("Permission not found with id: " + id + " for organizationId: " + organizationId);
                    });
            log.info("Successfully fetched Permission: id={}", entity.getId());
            return PermissionMapper.toResponseDTO(entity);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Permission ID: {}", id, e);
            throw e;
        }
    }

    @Transactional
    public PermissionResponseDTO updatePermission(Long id, Long organizationId, PermissionRequestDTO dto) {
        log.info("Updating Permission with ID: {} for organizationId: {} in database", id, organizationId);
        try {
            PermissionEntity existing = permissionRepository.findByIdAndOrganizationId(id, organizationId)
                    .orElseThrow(() -> {
                        log.warn("Permission not found for update with ID: {} and organizationId: {}", id, organizationId);
                        return new ResourceNotFoundException("Permission not found with id: " + id + " for organizationId: " + organizationId);
                    });

            PermissionMapper.updateEntityFromDTO(existing, dto);
            loadEntityRelationships(existing, dto);

            PermissionEntity updated = permissionRepository.save(existing);
            log.info("Successfully updated Permission ID: {}", id);
            return PermissionMapper.toResponseDTO(updated);
        } catch (Exception e) {
            log.error("Unexpected error while updating Permission ID: {}", id, e);
            throw e;
        }
    }

    @Transactional
    public void deleteById(Long id, Long organizationId) {
        log.info("Soft delete request received for Permission ID: {} and organizationId: {}", id, organizationId);
        try {
            PermissionEntity existing = permissionRepository.findByIdAndOrganizationId(id, organizationId)
                    .orElseThrow(() -> {
                        log.warn("Permission not found for deletion with ID: {} and organizationId: {}", id, organizationId);
                        return new ResourceNotFoundException("Permission not found with id: " + id + " for organizationId: " + organizationId);
                    });
            existing.setDeleted(true);
            permissionRepository.save(existing);
            log.info("Permission ID: {} marked as deleted successfully", id);
        } catch (Exception e) {
            log.error("Error while soft deleting Permission with ID: {}", id, e);
            throw e;
        }
    }

    private void loadEntityRelationships(PermissionEntity entity, PermissionRequestDTO dto) {
        if (dto.getModuleId() != null) {
            ModuleEntity module = moduleRepository.findById(dto.getModuleId())
                    .orElseThrow(() -> new ResourceNotFoundException("Module not found: " + dto.getModuleId()));
            entity.setModule(module);
        }
        if (dto.getResourceId() != null) {
            ResourceEntity resource = resourceRepository.findById(dto.getResourceId())
                    .orElseThrow(() -> new ResourceNotFoundException("Resource not found: " + dto.getResourceId()));
            entity.setResource(resource);
        }
        if (dto.getActionId() != null) {
            ActionEntity action = actionRepository.findById(dto.getActionId())
                    .orElseThrow(() -> new ResourceNotFoundException("Action not found: " + dto.getActionId()));
            entity.setAction(action);
        }
    }
}
