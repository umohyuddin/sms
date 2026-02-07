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
        log.info("Creating role");
        return ResponseEntity.status(HttpStatus.CREATED).body(roleFacade.createRole(requestDTO));
    }

    @Operation(summary = "Get all roles for an organization")
    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles(@PathVariable Long organizationId) {
        log.info("Fetching all roles for organization: {}", organizationId);
        return ResponseEntity.ok(roleFacade.getAll(organizationId));
    }

    @Operation(summary = "Get role by ID and organization ID")
    @GetMapping("/{id}/organization/{organizationId}")
    public ResponseEntity<?> getRoleById(@PathVariable Long id, @PathVariable Long organizationId) {
        log.info("Fetching role by id: {} for organization: {}", id, organizationId);
        return ResponseEntity.ok(roleFacade.getById(id, organizationId));
    }

    @Operation(summary = "Update role")
    @PutMapping("/{id}/organization/{organizationId}")
    public ResponseEntity<?> updateRole(@PathVariable Long id, @PathVariable Long organizationId, @Valid @RequestBody RoleRequestDTO requestDTO) {
        log.info("Updating role by id: {} for organization: {}", id, organizationId);
        return ResponseEntity.ok(roleFacade.updateRole(id, organizationId, requestDTO));
    }

    @Operation(summary = "Delete role")
    @DeleteMapping("/{id}/organization/{organizationId}")
    public ResponseEntity<?> deleteRole(@PathVariable Long id, @PathVariable Long organizationId) {
        log.info("Deleting role by id: {} for organization: {}", id, organizationId);
        roleFacade.deleteById(id, organizationId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Search roles")
    @GetMapping("/search")
    public ResponseEntity<?> searchRoles(@RequestParam Long organizationId, @RequestParam(name = "keyword") String keyword) {
        log.info("Searching roles with keyword: {} for organization: {}", keyword, organizationId);
        return ResponseEntity.ok(roleFacade.searchByKeyword(organizationId, keyword));
    }
}
