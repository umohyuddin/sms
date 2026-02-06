package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.global.responseMappers.PermissionMapper;
import com.smartsolutions.eschool.user.dtos.permissions.request.PermissionRequestDTO;
import com.smartsolutions.eschool.user.dtos.permissions.response.PermissionResponseDTO;
import com.smartsolutions.eschool.user.model.PermissionEntity;
import com.smartsolutions.eschool.user.repository.PermissionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class PermissionService {

    private final PermissionRepository permissionRepository;
    private final com.smartsolutions.eschool.user.repository.ModuleRepository moduleRepository;

    public PermissionService(PermissionRepository permissionRepository, com.smartsolutions.eschool.user.repository.ModuleRepository moduleRepository) {
        this.permissionRepository = permissionRepository;
        this.moduleRepository = moduleRepository;
    }

    @Transactional
    public PermissionResponseDTO createPermission(PermissionRequestDTO requestDTO) {
        log.info("Creating new Permission: {} for organizationId: {}", requestDTO.getName(), requestDTO.getOrganizationId());
        try {
            PermissionEntity entity = PermissionMapper.toEntity(requestDTO);
            
            com.smartsolutions.eschool.user.model.ModuleEntity module = moduleRepository.findById(requestDTO.getModuleId())
                    .orElseThrow(() -> new ResourceNotFoundException("Module not found with id: " + requestDTO.getModuleId()));
            entity.setModule(module);

            PermissionEntity saved = permissionRepository.save(entity);
            PermissionResponseDTO response = PermissionMapper.toResponseDTO(saved);
            log.info("Permission created successfully with ID: {} for organizationId: {}", response.getId(), response.getOrganizationId());
            return response;
        } catch (DataAccessException dae) {
            log.error("Database error while creating Permission", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating Permission", ex);
            throw ex;
        }
    }

    @Transactional(readOnly = true)
    public List<PermissionResponseDTO> getAll(Long organizationId) {
        try {
            log.info("Fetching all Permissions for organizationId: {} from database", organizationId);
            List<PermissionEntity> result = permissionRepository.findByOrganizationId(organizationId);
            List<PermissionResponseDTO> responseDTOS = PermissionMapper.toResponseDTOList(result);
            log.info("Successfully fetched {} Permissions for organizationId: {}", responseDTOS.size(), organizationId);
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Permissions for organizationId: {}", organizationId, dae);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Permissions for organizationId: {}", organizationId, e);
        }
        return Collections.emptyList();
    }

    @Transactional(readOnly = true)
    public PermissionResponseDTO getById(Long id, Long organizationId) {
        log.info("Fetching Permission with id: {} and organizationId: {}", id, organizationId);
        PermissionEntity entity = permissionRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new com.smartsolutions.eschool.global.exception.ResourceNotFoundException("Permission not found with id: " + id + " for organizationId: " + organizationId));
        return PermissionMapper.toResponseDTO(entity);
    }

    @Transactional
    public PermissionResponseDTO updatePermission(Long id, Long organizationId, PermissionRequestDTO requestDTO) {
        log.info("Updating Permission with id {} for organizationId {} using DTO {}", id, organizationId, requestDTO);
        PermissionEntity existing = permissionRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new com.smartsolutions.eschool.global.exception.ResourceNotFoundException("Permission not found with id: " + id + " for organizationId: " + organizationId));

        PermissionMapper.updateEntity(existing, requestDTO);

        if (requestDTO.getModuleId() != null) {
            com.smartsolutions.eschool.user.model.ModuleEntity module = moduleRepository.findById(requestDTO.getModuleId())
                    .orElseThrow(() -> new com.smartsolutions.eschool.global.exception.ResourceNotFoundException("Module not found with id: " + requestDTO.getModuleId()));
            existing.setModule(module);
        }

        PermissionEntity updated = permissionRepository.save(existing);
        PermissionResponseDTO response = PermissionMapper.toResponseDTO(updated);
        log.info("Permission updated successfully: {}", response.getId());
        return response;
    }

    @Transactional
    public void deleteById(Long id, Long organizationId) {
        log.info("Delete request received for Permission ID: {} and organizationId: {}", id, organizationId);
        PermissionEntity existing = permissionRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new com.smartsolutions.eschool.global.exception.ResourceNotFoundException("Permission not found with id: " + id + " for organizationId: " + organizationId));
        permissionRepository.delete(existing);
    }

    @Transactional(readOnly = true)
    public List<PermissionResponseDTO> searchByKeyword(Long organizationId, String keyword) {
        log.info("Searching Permissions with keyword: {} for organizationId: {}", keyword, organizationId);
        List<PermissionEntity> result = permissionRepository.searchByKeyword(organizationId, keyword == null ? "" : keyword.trim());
        return PermissionMapper.toResponseDTOList(result);
    }
}
