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
        log.info("Creating resource");
        return ResponseEntity.status(HttpStatus.CREATED).body(resourceFacade.createResource(requestDTO));
    }

    @Operation(summary = "Get all resources")
    @GetMapping
    public ResponseEntity<?>getAllResources() {
        log.info("Fetching all resources");
        return ResponseEntity.ok(resourceFacade.getAll());
    }

    @Operation(summary = "Get resource by ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getResourceById(@PathVariable Long id) {
        log.info("Fetching resource by id: {}", id);
        return ResponseEntity.ok(resourceFacade.getById(id));
    }

    @Operation(summary = "Update resource")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateResource(@PathVariable Long id, @Valid @RequestBody ResourceRequestDTO requestDTO) {
        log.info("Updating resource by id: {}", id);
        return ResponseEntity.ok(resourceFacade.updateResource(id, requestDTO));
    }

    @Operation(summary = "Delete resource")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResource(@PathVariable Long id) {
        log.info("Deleting resource by id: {}", id);
        resourceFacade.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Search resources")
    @GetMapping("/search")
    public ResponseEntity<?> searchResources(@RequestParam(name = "keyword") String keyword) {
        log.info("Searching resources with keyword: {}", keyword);
        return ResponseEntity.ok(resourceFacade.searchByKeyword(keyword));
    }
}
