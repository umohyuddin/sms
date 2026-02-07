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
        log.info("Creating new Permission: {}", dto.getName());
        
        PermissionEntity entity = PermissionMapper.toEntity(dto);
        
        loadEntityRelationships(entity, dto);

        PermissionEntity saved = permissionRepository.save(entity);
        return PermissionMapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<PermissionResponseDTO> getAll(Long organizationId) {
        log.info("Fetching all Permissions for organization: {}", organizationId);
        List<PermissionEntity> entities = permissionRepository.findByOrganizationId(organizationId);
        return PermissionMapper.toResponseDTOList(entities);
    }

    @Transactional(readOnly = true)
    public List<PermissionResponseDTO> searchByKeyword(Long organizationId, String keyword) {
        log.info("Searching Permissions with keyword: {} for organization: {}", keyword, organizationId);
        List<PermissionEntity> result = permissionRepository.searchByKeyword(organizationId, keyword == null ? "" : keyword.trim());
        return PermissionMapper.toResponseDTOList(result);
    }

    @Transactional(readOnly = true)
    public PermissionResponseDTO getById(Long id, Long organizationId) {
        log.info("Fetching Permission with id: {} and organizationId: {}", id, organizationId);
        PermissionEntity entity = permissionRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found with id: " + id + " for organizationId: " + organizationId));
        return PermissionMapper.toResponseDTO(entity);
    }

    @Transactional
    public PermissionResponseDTO updatePermission(Long id, Long organizationId, PermissionRequestDTO dto) {
        log.info("Updating Permission with id: {} for organizationId: {}", id, organizationId);
        PermissionEntity existing = permissionRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found with id: " + id + " for organizationId: " + organizationId));

        PermissionMapper.updateEntityFromDTO(existing, dto);
        loadEntityRelationships(existing, dto);

        PermissionEntity updated = permissionRepository.save(existing);
        return PermissionMapper.toResponseDTO(updated);
    }

    @Transactional
    public void deleteById(Long id, Long organizationId) {
        log.info("Deleting Permission with ID: {} and organizationId: {}", id, organizationId);
        PermissionEntity existing = permissionRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found with id: " + id + " for organizationId: " + organizationId));
        existing.setDeleted(true);
        permissionRepository.save(existing);
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
