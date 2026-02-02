package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.user.dtos.resources.request.ResourceRequestDTO;
import com.smartsolutions.eschool.user.dtos.resources.response.ResourceResponseDTO;
import com.smartsolutions.eschool.user.model.ResourceEntity;
import com.smartsolutions.eschool.user.repository.ResourceRepository;
import com.smartsolutions.eschool.util.MapperUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.MappingException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public ResourceResponseDTO createResource(ResourceRequestDTO requestDTO) {
        log.info("Creating new Resource: {}", requestDTO.getResourceName());
        try {
            ResourceEntity entity = MapperUtil.mapObject(requestDTO, ResourceEntity.class);
            entity.setId(null);
            ResourceEntity saved = resourceRepository.save(entity);
            ResourceResponseDTO response = MapperUtil.mapObject(saved, ResourceResponseDTO.class);
            log.info("Resource created successfully with ID: {}", response.getId());
            return response;
        } catch (DataAccessException dae) {
            log.error("Database error while creating Resource", dae);
            throw dae;
        } catch (Exception ex) {
            log.error("Unexpected error creating Resource", ex);
            throw ex;
        }
    }

    public List<ResourceResponseDTO> getAll() {
        try {
            log.info("Fetching all Resources from database");
            List<ResourceEntity> result = resourceRepository.findAll();
            List<ResourceResponseDTO> responseDTOS = MapperUtil.mapList(result, ResourceResponseDTO.class);
            log.info("Successfully fetched {} Resources", responseDTOS.size());
            return responseDTOS;
        } catch (DataAccessException dae) {
            log.error("Database error while fetching Resources", dae);
        } catch (MappingException me) {
            log.error("Error mapping ResourceEntity to ResourceResponseDTO", me);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Resources", e);
        }
        return Collections.emptyList();
    }

    public ResourceResponseDTO getById(Long id) {
        log.info("Fetching Resource with id: {}", id);
        ResourceEntity entity = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));
        ResourceResponseDTO responseDTO = MapperUtil.mapObject(entity, ResourceResponseDTO.class);
        log.info("Successfully fetched Resource: id={}", responseDTO.getId());
        return responseDTO;
    }

    public ResourceResponseDTO updateResource(Long id, ResourceRequestDTO requestDTO) {
        log.info("Updating Resource with id {} using DTO {}", id, requestDTO);
        ResourceEntity existing = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));

        if (requestDTO.getResourceName() != null && !requestDTO.getResourceName().isBlank()) {
            existing.setResourceName(requestDTO.getResourceName());
        }
        if (requestDTO.getResourceEndpoint() != null && !requestDTO.getResourceEndpoint().isBlank()) {
            existing.setResourceEndpoint(requestDTO.getResourceEndpoint());
        }
        if (requestDTO.getVersion() != null && !requestDTO.getVersion().isBlank()) {
            existing.setVersion(requestDTO.getVersion());
        }
        if (requestDTO.getIsActive() != null) {
            existing.setActive(requestDTO.getIsActive());
        }
        if (requestDTO.getMethodType() != null && !requestDTO.getMethodType().isBlank()) {
            existing.setMethodType(requestDTO.getMethodType());
        }
        if (requestDTO.getDescription() != null) {
            existing.setDescription(requestDTO.getDescription());
        }
        if (requestDTO.getIsAuthRequired() != null) {
            existing.setAuthRequired(requestDTO.getIsAuthRequired());
        }
        if (requestDTO.getRateLimit() != null) {
            existing.setRateLimit(requestDTO.getRateLimit());
        }
        if (requestDTO.getIsDeprecated() != null) {
            existing.setDeprecated(requestDTO.getIsDeprecated());
        }
        if (requestDTO.getDocumentationUrl() != null) {
            existing.setDocumentationUrl(requestDTO.getDocumentationUrl());
        }
        if (requestDTO.getOwner() != null) {
            existing.setOwner(requestDTO.getOwner());
        }

        ResourceEntity updated = resourceRepository.save(existing);
        ResourceResponseDTO response = MapperUtil.mapObject(updated, ResourceResponseDTO.class);
        log.info("Resource updated successfully: {}", response.getId());
        return response;
    }

    public void deleteById(Long id) {
        log.info("Delete request received for Resource ID: {}", id);
        if (!resourceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found with id: " + id);
        }
        resourceRepository.deleteById(id);
    }

    public List<ResourceResponseDTO> searchByKeyword(String keyword) {
        log.info("Searching Resources with keyword: {}", keyword);
        List<ResourceEntity> result = resourceRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return MapperUtil.mapList(result, ResourceResponseDTO.class);
    }
}
