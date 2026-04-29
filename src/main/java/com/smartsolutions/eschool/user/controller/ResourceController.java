package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.user.dtos.resources.request.ResourceRequestDTO;
import com.smartsolutions.eschool.user.dtos.resources.response.ResourceResponseDTO;
import com.smartsolutions.eschool.user.facade.ResourceFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/resources")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Resource Management", description = "Endpoints for managing application resources")
public class ResourceController {

    private final ResourceFacade resourceFacade;

    @Operation(summary = "Create a new resource")
    @PostMapping
    public ResponseEntity<?> createResource(@Valid @RequestBody ResourceRequestDTO requestDTO) {
        log.info("POST /api/v1/resources called for resource: {}", requestDTO.getResourceName());
        ResourceResponseDTO result = resourceFacade.createResource(requestDTO);
        log.info("POST /api/v1/resources succeeded, created resource with ID: {}", result.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(summary = "Get all resources")
    @GetMapping
    public ResponseEntity<?> getAllResources() {
        log.info("GET /api/v1/resources called");
        List<ResourceResponseDTO> resources = resourceFacade.getAll();
        log.info("GET /api/v1/resources succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get resource by ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getResourceById(@PathVariable Long id) {
        log.info("GET /api/v1/resources/{} called", id);
        ResourceResponseDTO resource = resourceFacade.getById(id);
        log.info("GET /api/v1/resources/{} succeeded", id);
        return ResponseEntity.ok(resource);
    }

    @Operation(summary = "Update resource")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateResource(@PathVariable Long id, @Valid @RequestBody ResourceRequestDTO requestDTO) {
        log.info("PUT /api/v1/resources/{} called", id);
        ResourceResponseDTO result = resourceFacade.updateResource(id, requestDTO);
        log.info("PUT /api/v1/resources/{} succeeded", id);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Delete resource")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResource(@PathVariable Long id) {
        log.info("DELETE /api/v1/resources/{} called", id);
        resourceFacade.deleteById(id);
        log.info("DELETE /api/v1/resources/{} succeeded", id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Search resources")
    @GetMapping("/search")
    public ResponseEntity<?> searchResources(@RequestParam(name = "keyword") String keyword) {
        log.info("GET /api/v1/resources/search called with keyword: {}", keyword);
        List<ResourceResponseDTO> resources = resourceFacade.searchByKeyword(keyword);
        log.info("GET /api/v1/resources/search succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }
}
