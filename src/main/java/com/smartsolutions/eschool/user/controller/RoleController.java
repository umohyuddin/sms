package com.smartsolutions.eschool.user.controller;


import com.smartsolutions.eschool.user.dtos.roles.request.RoleRequestDTO;
import com.smartsolutions.eschool.user.dtos.roles.response.RoleResponseDTO;
import com.smartsolutions.eschool.user.facade.RoleFacade;
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
@RequestMapping("/api/v1/roles")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Role Management", description = "Endpoints for managing user roles")
public class RoleController {

    private final RoleFacade roleFacade;

    @Operation(summary = "Create a new role")
    @PostMapping
    public ResponseEntity<RoleResponseDTO> createRole(@Valid @RequestBody RoleRequestDTO requestDTO) {
        log.info("POST /api/v1/roles called for role: {}", requestDTO.getName());
        RoleResponseDTO result = roleFacade.createRole(requestDTO);
        log.info("POST /api/v1/roles succeeded, created role with ID: {}", result.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(summary = "Get all roles for an organization")
    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles(@PathVariable Long organizationId) {
        log.info("GET /api/v1/roles/organization/{} called", organizationId);
        List<RoleResponseDTO> resources = roleFacade.getAll(organizationId);
        log.info("GET /api/v1/roles/organization/{} succeeded, returned {} resources", organizationId, resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get role by ID and organization ID")
    @GetMapping("/{id}/organization/{organizationId}")
    public ResponseEntity<?> getRoleById(@PathVariable Long id, @PathVariable Long organizationId) {
        log.info("GET /api/v1/roles/{}/organization/{} called", id, organizationId);
        RoleResponseDTO resource = roleFacade.getById(id, organizationId);
        log.info("GET /api/v1/roles/{}/organization/{} succeeded", id, organizationId);
        return ResponseEntity.ok(resource);
    }

    @Operation(summary = "Update role")
    @PutMapping("/{id}/organization/{organizationId}")
    public ResponseEntity<?> updateRole(@PathVariable Long id, @PathVariable Long organizationId, @Valid @RequestBody RoleRequestDTO requestDTO) {
        log.info("PUT /api/v1/roles/{}/organization/{} called", id, organizationId);
        RoleResponseDTO result = roleFacade.updateRole(id, organizationId, requestDTO);
        log.info("PUT /api/v1/roles/{}/organization/{} succeeded", id, organizationId);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Delete role")
    @DeleteMapping("/{id}/organization/{organizationId}")
    public ResponseEntity<?> deleteRole(@PathVariable Long id, @PathVariable Long organizationId) {
        log.info("DELETE /api/v1/roles/{}/organization/{} called", id, organizationId);
        roleFacade.deleteById(id, organizationId);
        log.info("DELETE /api/v1/roles/{}/organization/{} succeeded", id, organizationId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Search roles")
    @GetMapping("/search")
    public ResponseEntity<?> searchRoles(@RequestParam Long organizationId, @RequestParam(name = "keyword") String keyword) {
        log.info("GET /api/v1/roles/search called for organization: {} with keyword: {}", organizationId, keyword);
        List<RoleResponseDTO> resources = roleFacade.searchByKeyword(organizationId, keyword);
        log.info("GET /api/v1/roles/search succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }
}
