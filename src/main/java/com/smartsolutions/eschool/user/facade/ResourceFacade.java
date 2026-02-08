package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.resources.request.ResourceRequestDTO;
import com.smartsolutions.eschool.user.dtos.resources.response.ResourceResponseDTO;
import com.smartsolutions.eschool.user.service.ResourceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
@RequiredArgsConstructor
public class ResourceFacade {

    private final ResourceService resourceService;

    public ResourceResponseDTO createResource(ResourceRequestDTO requestDTO) {
        log.info("Facade: Request to create Resource: {}", requestDTO.getResourceName());
        ResourceResponseDTO result = resourceService.createResource(requestDTO);
        log.info("Facade: Resource created successfully with ID: {}", result.getId());
        return result;
    }

    public List<ResourceResponseDTO> getAll() {
        log.info("Facade: Request to fetch all Resources");
        List<ResourceResponseDTO> result = resourceService.getAll();
        log.info("Facade: Successfully fetched {} Resources", result.size());
        return result;
    }

    public ResourceResponseDTO getById(Long id) {
        log.info("Facade: Request to fetch Resource ID: {}", id);
        ResourceResponseDTO result = resourceService.getById(id);
        log.info("Facade: Successfully fetched Resource ID: {}", id);
        return result;
    }

    public ResourceResponseDTO updateResource(Long id, ResourceRequestDTO requestDTO) {
        log.info("Facade: Request to update Resource ID: {}", id);
        ResourceResponseDTO result = resourceService.updateResource(id, requestDTO);
        log.info("Facade: Successfully updated Resource ID: {}", id);
        return result;
    }

    public void deleteById(Long id) {
        log.info("Facade: Request to delete Resource ID: {}", id);
        resourceService.deleteById(id);
        log.info("Facade: Successfully deleted Resource ID: {}", id);
    }

    public List<ResourceResponseDTO> searchByKeyword(String keyword) {
        log.info("Facade: Request to search Resources with keyword: '{}'", keyword);
        List<ResourceResponseDTO> result = resourceService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} Resources", result.size());
        return result;
    }
}
