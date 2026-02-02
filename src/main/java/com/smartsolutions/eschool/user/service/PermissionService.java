package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.user.dtos.permissions.request.PermissionRequestDTO;
import com.smartsolutions.eschool.user.dtos.permissions.response.PermissionResponseDTO;
import com.smartsolutions.eschool.user.model.PermissionEntity;
import com.smartsolutions.eschool.user.repository.PermissionRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public PermissionResponseDTO createPermission(PermissionRequestDTO requestDTO) {
        log.info("Creating new Permission: {}", requestDTO.getPermissionName());
        try {
            PermissionEntity entity = MapperUtil.mapObject(requestDTO, PermissionEntity.class);
            entity.setId(null);
            PermissionEntity saved = permissionRepository.save(entity);
            PermissionResponseDTO response = MapperUtil.mapObject(saved, PermissionResponseDTO.class);
            log.info("Permission created successfully with ID: {}", response.getId());
            return response;
        } catch (DataAccessException dae) {
            log.error("Database error while creating Permission", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating Permission", ex);
            throw ex;
        }
    }

    public List<PermissionResponseDTO> getAll() {
        try {
            log.info("Fetching all Permissions from database");
            List<PermissionEntity> result = permissionRepository.findAll();
            List<PermissionResponseDTO> responseDTOS = MapperUtil.mapList(result, PermissionResponseDTO.class);
            log.info("Successfully fetched {} Permissions", responseDTOS.size());
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Permissions", dae);
        } catch (MappingException me) {
            log.error("Error mapping PermissionEntity to PermissionResponseDTO", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Permissions", e);
        }
        return Collections.emptyList();
    }

    public PermissionResponseDTO getById(Long id) {
        log.info("Fetching Permission with id: {}", id);
        PermissionEntity entity = permissionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found with id: " + id));
        PermissionResponseDTO responseDTO = MapperUtil.mapObject(entity, PermissionResponseDTO.class);
        log.info("Successfully fetched Permission: id={}", responseDTO.getId());
        return responseDTO;
    }

    public PermissionResponseDTO updatePermission(Long id, PermissionRequestDTO requestDTO) {
        log.info("Updating Permission with id {} using DTO {}", id, requestDTO);
        PermissionEntity existing = permissionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Permission not found with id: " + id));

        if (requestDTO.getPermissionName() != null && !requestDTO.getPermissionName().isBlank()) {
            existing.setPermissionName(requestDTO.getPermissionName());
        }
        if (requestDTO.getCode() != null) {
            existing.setCode(requestDTO.getCode());
        }
        if (requestDTO.getModule() != null) {
            existing.setModule(requestDTO.getModule());
        }
        if (requestDTO.getDescription() != null) {
            existing.setDescription(requestDTO.getDescription());
        }

        PermissionEntity updated = permissionRepository.save(existing);
        PermissionResponseDTO response = MapperUtil.mapObject(updated, PermissionResponseDTO.class);
        log.info("Permission updated successfully: {}", response.getId());
        return response;
    }

    public void deleteById(Long id) {
        log.info("Delete request received for Permission ID: {}", id);
        if (!permissionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Permission not found with id: " + id);
        }
        permissionRepository.deleteById(id);
    }

    public List<PermissionResponseDTO> searchByKeyword(String keyword) {
        log.info("Searching Permissions with keyword: {}", keyword);
        List<PermissionEntity> result = permissionRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return MapperUtil.mapList(result, PermissionResponseDTO.class);
    }
}
