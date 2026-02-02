package com.smartsolutions.eschool.user.facade;

import com.smartsolutions.eschool.user.dtos.resources.request.ResourceRequestDTO;
import com.smartsolutions.eschool.user.dtos.resources.response.ResourceResponseDTO;
import com.smartsolutions.eschool.user.service.ResourceService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class ResourceFacade {

    private final ResourceService resourceService;

    public ResourceFacade(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    public ResourceResponseDTO createResource(ResourceRequestDTO requestDTO) {
        return resourceService.createResource(requestDTO);
    }

    public List<ResourceResponseDTO> getAll() {
        return resourceService.getAll();
    }

    public ResourceResponseDTO getById(Long id) {
        return resourceService.getById(id);
    }

    public ResourceResponseDTO updateResource(Long id, ResourceRequestDTO requestDTO) {
        return resourceService.updateResource(id, requestDTO);
    }

    public void deleteById(Long id) {
        resourceService.deleteById(id);
    }

    public List<ResourceResponseDTO> searchByKeyword(String keyword) {
        return resourceService.searchByKeyword(keyword);
    }
}
