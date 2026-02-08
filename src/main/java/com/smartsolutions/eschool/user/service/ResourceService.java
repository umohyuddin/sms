package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.global.responseMappers.ResourceMapper;
import com.smartsolutions.eschool.user.dtos.resources.request.ResourceRequestDTO;
import com.smartsolutions.eschool.user.dtos.resources.response.ResourceResponseDTO;
import com.smartsolutions.eschool.user.model.ModuleEntity;
import com.smartsolutions.eschool.user.model.ResourceEntity;
import com.smartsolutions.eschool.user.repository.ModuleRepository;
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
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final ModuleRepository moduleRepository;

    @Transactional
    public ResourceResponseDTO createResource(ResourceRequestDTO requestDTO) {
        log.info("Creating new Resource in database: {}", requestDTO.getResourceName());
        try {
            ResourceEntity entity = ResourceMapper.toEntity(requestDTO);
            
            if (requestDTO.getModuleId() != null) {
                ModuleEntity module = moduleRepository.findById(requestDTO.getModuleId())
                        .orElseThrow(() -> {
                            log.warn("Module not found: {}", requestDTO.getModuleId());
                            return new ResourceNotFoundException("Module not found: " + requestDTO.getModuleId());
                        });
                entity.setModule(module);
            }

            ResourceEntity saved = resourceRepository.save(entity);
            log.info("Successfully created Resource with ID: {}", saved.getId());
            return ResourceMapper.toResponseDTO(saved);
        } catch (Exception e) {
            log.error("Unexpected error while creating Resource", e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ResourceResponseDTO> getAll() {
        log.info("Fetching all active Resources from database");
        try {
            List<ResourceEntity> result = resourceRepository.findAll();
            log.info("Successfully fetched {} Resources", result.size());
            return ResourceMapper.toResponseDTOList(result);
        } catch (Exception e) {
            log.error("Unexpected error while fetching Resources", e);
            return Collections.emptyList();
        }
    }

    @Transactional(readOnly = true)
    public ResourceResponseDTO getById(Long id) {
        log.info("Fetching Resource with ID: {} from database", id);
        try {
            ResourceEntity entity = resourceRepository.findById(id)
                    .orElseThrow(() -> {
                        log.warn("Resource not found with ID: {}", id);
                        return new ResourceNotFoundException("Resource not found with id: " + id);
                    });
            log.info("Successfully fetched Resource: id={}", entity.getId());
            return ResourceMapper.toResponseDTO(entity);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while fetching Resource ID: {}", id, e);
            throw e;
        }
    }

    @Transactional
    public ResourceResponseDTO updateResource(Long id, ResourceRequestDTO requestDTO) {
        log.info("Updating Resource with ID: {} in database", id);
        try {
            ResourceEntity existing = resourceRepository.findById(id)
                    .orElseThrow(() -> {
                        log.warn("Resource not found for update with ID: {}", id);
                        return new ResourceNotFoundException("Resource not found with id: " + id);
                    });

            ResourceMapper.updateEntityFromDTO(existing, requestDTO);

            if (requestDTO.getModuleId() != null) {
                ModuleEntity module = moduleRepository.findById(requestDTO.getModuleId())
                        .orElseThrow(() -> {
                            log.warn("Module not found for resource update: {}", requestDTO.getModuleId());
                            return new ResourceNotFoundException("Module not found: " + requestDTO.getModuleId());
                        });
                existing.setModule(module);
            }

            ResourceEntity updated = resourceRepository.save(existing);
            log.info("Successfully updated Resource ID: {}", id);
            return ResourceMapper.toResponseDTO(updated);
        } catch (Exception e) {
            log.error("Unexpected error while updating Resource ID: {}", id, e);
            throw e;
        }
    }

    @Transactional
    public void deleteById(Long id) {
        log.info("Soft delete request received for Resource ID: {}", id);
        try {
            ResourceEntity existing = resourceRepository.findById(id)
                    .orElseThrow(() -> {
                        log.warn("Resource not found for deletion with ID: {}", id);
                        return new ResourceNotFoundException("Resource not found with id: " + id);
                    });
            existing.setDeleted(true);
            resourceRepository.save(existing);
            log.info("Resource ID: {} marked as deleted successfully", id);
        } catch (Exception e) {
            log.error("Error while soft deleting Resource with ID: {}", id, e);
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ResourceResponseDTO> searchByKeyword(String keyword) {
        try {
            String searchKey = keyword == null ? "" : keyword.trim();
            log.info("Fetching Resources based on search from database with keyword: '{}'", searchKey);
            List<ResourceEntity> result = resourceRepository.searchByKeyword(searchKey);
            log.info("Successfully fetched {} Resources based on search", result.size());
            return ResourceMapper.toResponseDTOList(result);
        } catch (Exception e) {
            log.error("Unexpected error while searching Resources", e);
            return Collections.emptyList();
        }
    }
}
