package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.user.dtos.roles.request.RoleRequestDTO;
import com.smartsolutions.eschool.user.dtos.roles.response.RoleResponseDTO;
import com.smartsolutions.eschool.user.model.RoleEntity;
import com.smartsolutions.eschool.user.repository.RoleRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleResponseDTO createRole(RoleRequestDTO requestDTO) {
        log.info("Creating new Role: {}", requestDTO.getRoleName());
        try {
            RoleEntity entity = MapperUtil.mapObject(requestDTO, RoleEntity.class);
            entity.setId(null);
            RoleEntity saved = roleRepository.save(entity);
            RoleResponseDTO response = MapperUtil.mapObject(saved, RoleResponseDTO.class);
            log.info("Role created successfully with ID: {}", response.getId());
            return response;
        } catch (DataAccessException dae) {
            log.error("Database error while creating Role", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating Role", ex);
            throw ex;
        }
    }

    public List<RoleResponseDTO> getAll() {
        try {
            log.info("Fetching all Roles from database");
            List<RoleEntity> result = roleRepository.findAll();
            List<RoleResponseDTO> responseDTOS = MapperUtil.mapList(result, RoleResponseDTO.class);
            log.info("Successfully fetched {} Roles", responseDTOS.size());
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Roles", dae);
        } catch (MappingException me) {
            log.error("Error mapping RoleEntity to RoleResponseDTO", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Roles", e);
        }
        return Collections.emptyList();
    }

    public RoleResponseDTO getById(Long id) {
        log.info("Fetching Role with id: {}", id);
        RoleEntity entity = roleRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));
        RoleResponseDTO responseDTO = MapperUtil.mapObject(entity, RoleResponseDTO.class);
        log.info("Successfully fetched Role: id={}", responseDTO.getId());
        return responseDTO;
    }

    public RoleResponseDTO updateRole(Long id, RoleRequestDTO requestDTO) {
        log.info("Updating Role with id {} using DTO {}", id, requestDTO);
        RoleEntity existing = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));

        if (requestDTO.getRoleName() != null && !requestDTO.getRoleName().isBlank()) {
            existing.setRoleName(requestDTO.getRoleName());
        }
        if (requestDTO.getDescription() != null) {
            existing.setDescription(requestDTO.getDescription());
        }

        RoleEntity updated = roleRepository.save(existing);
        RoleResponseDTO response = MapperUtil.mapObject(updated, RoleResponseDTO.class);
        log.info("Role updated successfully: {}", response.getId());
        return response;
    }

    public void deleteById(Long id) {
        log.info("Delete request received for Role ID: {}", id);
        if (!roleRepository.existsById(id)) {
            throw new ResourceNotFoundException("Role not found with id: " + id);
        }
        roleRepository.deleteById(id);
    }

    public List<RoleResponseDTO> searchByKeyword(String keyword) {
        log.info("Searching Roles with keyword: {}", keyword);
        List<RoleEntity> result = roleRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return MapperUtil.mapList(result, RoleResponseDTO.class);
    }
}
