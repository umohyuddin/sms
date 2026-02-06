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
        log.info("Creating new Role: {}", requestDTO.getName());
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

    public List<RoleResponseDTO> getAll(Long organizationId) {
        try {
            log.info("Fetching all Roles for organizationId: {} from database", organizationId);
            List<RoleEntity> result = roleRepository.findByOrganizationId(organizationId);
            List<RoleResponseDTO> responseDTOS = MapperUtil.mapList(result, RoleResponseDTO.class);
            log.info("Successfully fetched {} Roles for organizationId: {}", responseDTOS.size(), organizationId);
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Roles for organizationId: {}", organizationId, dae);
        } catch (MappingException me) {
            log.error("Error mapping RoleEntity to RoleResponseDTO for organizationId: {}", organizationId, me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Roles for organizationId: {}", organizationId, e);
        }
        return Collections.emptyList();
    }

    public RoleResponseDTO getById(Long id, Long organizationId) {
        log.info("Fetching Role with id: {} and organizationId: {}", id, organizationId);
        RoleEntity entity = roleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id + " for organizationId: " + organizationId));
        RoleResponseDTO responseDTO = MapperUtil.mapObject(entity, RoleResponseDTO.class);
        log.info("Successfully fetched Role: id={}", responseDTO.getId());
        return responseDTO;
    }

    public RoleResponseDTO updateRole(Long id, Long organizationId, RoleRequestDTO requestDTO) {
        log.info("Updating Role with id {} for organizationId {} using DTO {}", id, organizationId, requestDTO);
        RoleEntity existing = roleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id + " for organizationId: " + organizationId));

        if (requestDTO.getCode() != null && !requestDTO.getCode().isBlank()) {
            existing.setCode(requestDTO.getCode());
        }
        if (requestDTO.getName() != null && !requestDTO.getName().isBlank()) {
            existing.setName(requestDTO.getName());
        }
        if (requestDTO.getDescription() != null) {
            existing.setDescription(requestDTO.getDescription());
        }
        if (requestDTO.getSystemRole() != null) {
            existing.setSystemRole(requestDTO.getSystemRole());
        }
        if (requestDTO.getActive() != null) {
            existing.setActive(requestDTO.getActive());
        }

        RoleEntity updated = roleRepository.save(existing);
        RoleResponseDTO response = MapperUtil.mapObject(updated, RoleResponseDTO.class);
        log.info("Role updated successfully: {}", response.getId());
        return response;
    }

    public void deleteById(Long id, Long organizationId) {
        log.info("Delete request received for Role ID: {} and organizationId: {}", id, organizationId);
        RoleEntity existing = roleRepository.findByIdAndOrganizationId(id, organizationId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id + " for organizationId: " + organizationId));
        roleRepository.delete(existing);
    }

    public List<RoleResponseDTO> searchByKeyword(Long organizationId, String keyword) {
        log.info("Searching Roles with keyword: {} for organizationId: {}", keyword, organizationId);
        List<RoleEntity> result = roleRepository.searchByKeyword(organizationId, keyword == null ? "" : keyword.trim());
        return MapperUtil.mapList(result, RoleResponseDTO.class);
    }
    public List<RoleResponseDTO> getByOrganizationId(Long organizationId) {
        log.info("Fetching Roles for organizationId: {}", organizationId);

        try {
            List<RoleEntity> roles = roleRepository.findByOrganizationId(organizationId);

            if (roles == null || roles.isEmpty()) {
                log.warn("No Roles found for organizationId: {}", organizationId);
                return Collections.emptyList();
            }

            List<RoleResponseDTO> responseDTOS =
                    MapperUtil.mapList(roles, RoleResponseDTO.class);

            log.info("Successfully fetched {} Roles for organizationId: {}",
                    responseDTOS.size(), organizationId);

            return responseDTOS;

        } catch (DataAccessException dae) {
            log.error("Database error while fetching Roles for organizationId: {}", organizationId, dae);
            throw dae;
        } catch (MappingException me) {
            log.error("Error mapping RoleEntity to RoleResponseDTO for organizationId: {}", organizationId, me);
            throw me;
        } catch (Exception ex) {
            log.error("Unexpected error while fetching Roles for organizationId: {}", organizationId, ex);
            throw ex;
        }
    }

}
