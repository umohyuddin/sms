package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.user.dtos.permissions.request.PermissionRequestDTO;
import com.smartsolutions.eschool.user.dtos.permissions.response.PermissionResponseDTO;
import com.smartsolutions.eschool.user.facade.PermissionFacade;
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
@RequestMapping("/api/v1/permissions")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Permission Management", description = "Endpoints for managing permissions")
public class PermissionController {

    private final PermissionFacade permissionFacade;

    @Operation(summary = "Create a new permission")
    @PostMapping
    public ResponseEntity<PermissionResponseDTO> createPermission(@Valid @RequestBody PermissionRequestDTO requestDTO) {
        log.info("POST /api/v1/permissions called for permission: {}", requestDTO.getName());
        PermissionResponseDTO result = permissionFacade.createPermission(requestDTO);
        log.info("POST /api/v1/permissions succeeded, created permission with ID: {}", result.getId());
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all permissions for an organization")
    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<PermissionResponseDTO>> getAllPermissions(@PathVariable Long organizationId) {
        log.info("GET /api/v1/permissions/organization/{} called", organizationId);
        List<PermissionResponseDTO> resources = permissionFacade.getAll(organizationId);
        log.info("GET /api/v1/permissions/organization/{} succeeded, returned {} resources", organizationId, resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get a permission by ID and organization ID")
    @GetMapping("/{id}/organization/{organizationId}")
    public ResponseEntity<PermissionResponseDTO> getPermissionById(@PathVariable Long id, @PathVariable Long organizationId) {
        log.info("GET /api/v1/permissions/{}/organization/{} called", id, organizationId);
        PermissionResponseDTO resource = permissionFacade.getById(id, organizationId);
        log.info("GET /api/v1/permissions/{}/organization/{} succeeded", id, organizationId);
        return ResponseEntity.ok(resource);
    }

    @Operation(summary = "Update a permission")
    @PutMapping("/{id}/organization/{organizationId}")
    public ResponseEntity<PermissionResponseDTO> updatePermission(@PathVariable Long id, @PathVariable Long organizationId, @Valid @RequestBody PermissionRequestDTO requestDTO) {
        log.info("PUT /api/v1/permissions/{}/organization/{} called", id, organizationId);
        PermissionResponseDTO result = permissionFacade.updatePermission(id, organizationId, requestDTO);
        log.info("PUT /api/v1/permissions/{}/organization/{} succeeded", id, organizationId);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Delete a permission")
    @DeleteMapping("/{id}/organization/{organizationId}")
    public ResponseEntity<?> deletePermission(@PathVariable Long id, @PathVariable Long organizationId) {
        log.info("DELETE /api/v1/permissions/{}/organization/{} called", id, organizationId);
        permissionFacade.deleteById(id, organizationId);
        log.info("DELETE /api/v1/permissions/{}/organization/{} succeeded", id, organizationId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Search permissions by keyword")
    @GetMapping("/search")
    public ResponseEntity<?> searchPermissions(@RequestParam Long organizationId, @RequestParam(required = false) String keyword) {
        log.info("GET /api/v1/permissions/search called for organization: {} with keyword: {}", organizationId, keyword);
        List<PermissionResponseDTO> resources = permissionFacade.searchByKeyword(organizationId, keyword);
        log.info("GET /api/v1/permissions/search succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }
}
