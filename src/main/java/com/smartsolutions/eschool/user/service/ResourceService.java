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
        log.info("Creating new Resource: {}", requestDTO.getResourceName());
        ResourceEntity entity = ResourceMapper.toEntity(requestDTO);
        
        if (requestDTO.getModuleId() != null) {
            ModuleEntity module = moduleRepository.findById(requestDTO.getModuleId())
                    .orElseThrow(() -> new ResourceNotFoundException("Module not found: " + requestDTO.getModuleId()));
            entity.setModule(module);
        }

        ResourceEntity saved = resourceRepository.save(entity);
        return ResourceMapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public List<ResourceResponseDTO> getAll() {
        log.info("Fetching all Resources");
        List<ResourceEntity> result = resourceRepository.findAll();
        return ResourceMapper.toResponseDTOList(result);
    }

    @Transactional(readOnly = true)
    public ResourceResponseDTO getById(Long id) {
        log.info("Fetching Resource with id: {}", id);
        ResourceEntity entity = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));
        return ResourceMapper.toResponseDTO(entity);
    }

    @Transactional
    public ResourceResponseDTO updateResource(Long id, ResourceRequestDTO requestDTO) {
        log.info("Updating Resource with id: {}", id);
        ResourceEntity existing = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));

        ResourceMapper.updateEntityFromDTO(existing, requestDTO);

        if (requestDTO.getModuleId() != null) {
            ModuleEntity module = moduleRepository.findById(requestDTO.getModuleId())
                    .orElseThrow(() -> new ResourceNotFoundException("Module not found: " + requestDTO.getModuleId()));
            existing.setModule(module);
        }

        ResourceEntity updated = resourceRepository.save(existing);
        return ResourceMapper.toResponseDTO(updated);
    }

    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting Resource with ID: {}", id);
        ResourceEntity existing = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id: " + id));
        existing.setDeleted(true);
        resourceRepository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<ResourceResponseDTO> searchByKeyword(String keyword) {
        log.info("Searching Resources with keyword: {}", keyword);
        List<ResourceEntity> result = resourceRepository.searchByKeyword(keyword == null ? "" : keyword.trim());
        return ResourceMapper.toResponseDTOList(result);
    }
}
