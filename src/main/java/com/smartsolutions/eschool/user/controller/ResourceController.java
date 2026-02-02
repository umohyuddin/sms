package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.user.dtos.resources.request.ResourceRequestDTO;
import com.smartsolutions.eschool.user.dtos.resources.response.ResourceResponseDTO;
import com.smartsolutions.eschool.user.facade.ResourceFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/resources")
@Slf4j
public class ResourceController {

    private final ResourceFacade resourceFacade;

    public ResourceController(ResourceFacade resourceFacade) {
        this.resourceFacade = resourceFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceResponseDTO> createResource(@Valid @RequestBody ResourceRequestDTO requestDTO) {
        log.info("Received request to create Resource");
        ResourceResponseDTO responseDTO = resourceFacade.createResource(requestDTO);
        log.info("Resource created successfully with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ResourceResponseDTO>> getAllResources() {
        log.info("GET /api/users/resources called");
        List<ResourceResponseDTO> resources = resourceFacade.getAll();
        log.info("Returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{resourceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceResponseDTO> getResourceById(@PathVariable Long resourceId) {
        log.info("GET /api/users/resources/{} called", resourceId);
        ResourceResponseDTO resource = resourceFacade.getById(resourceId);
        return ResponseEntity.ok(resource);
    }

    @PutMapping(value = "/{resourceId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResourceResponseDTO> updateResource(@PathVariable Long resourceId, @Valid @RequestBody ResourceRequestDTO requestDTO) {
        log.info("Received request to update Resource with id: {}", resourceId);
        ResourceResponseDTO updated = resourceFacade.updateResource(resourceId, requestDTO);
        log.info("Resource updated successfully with id: {}", updated.getId());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{resourceId}")
    public ResponseEntity<String> deleteResource(@PathVariable Long resourceId) {
        log.info("DELETE /api/users/resources/{} called", resourceId);
        resourceFacade.deleteById(resourceId);
        log.info("Resource deleted successfully with id: {}", resourceId);
        return ResponseEntity.ok("Resource deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ResourceResponseDTO>> searchResources(@RequestParam(name = "keyword") String keyword) {
        log.info("Searching Resources with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<ResourceResponseDTO> results = resourceFacade.searchByKeyword(keyword.trim());
        log.info("Found {} resources matching keyword '{}'", results.size(), keyword);
        return ResponseEntity.ok(results);
    }
}
