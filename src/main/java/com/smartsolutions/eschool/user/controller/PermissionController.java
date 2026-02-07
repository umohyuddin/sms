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
    //@PreAuthorize("hasAuthority('ADMIN_PERMISSIONS_CREATE')")
    public ResponseEntity<PermissionResponseDTO> createPermission(@Valid @RequestBody PermissionRequestDTO requestDTO) {
        log.info("Received request to create Permission");
        PermissionResponseDTO responseDTO = permissionFacade.createPermission(requestDTO);
        return new ResponseEntity<>((responseDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all permissions for an organization")
    @GetMapping("/organization/{organizationId}")
    public ResponseEntity<List<PermissionResponseDTO>> getAllPermissions(@PathVariable Long organizationId) {
        log.info("Fetching all permissions for organization: {}", organizationId);
        return ResponseEntity.ok(permissionFacade.getAll(organizationId));
    }

    @Operation(summary = "Get a permission by ID and organization ID")
    @GetMapping("/{id}/organization/{organizationId}")
    public ResponseEntity<PermissionResponseDTO> getPermissionById(@PathVariable Long id, @PathVariable Long organizationId) {
        log.info("Fetching permission with id: {} and organization: {}", id, organizationId);
        return ResponseEntity.ok(permissionFacade.getById(id, organizationId));
    }

    @Operation(summary = "Update a permission")
    @PutMapping("/{id}/organization/{organizationId}")
    public ResponseEntity<PermissionResponseDTO> updatePermission(@PathVariable Long id, @PathVariable Long organizationId, @Valid @RequestBody PermissionRequestDTO requestDTO) {
        log.info("Updating permission with id: {} for organization: {}", id, organizationId);
        return ResponseEntity.ok(permissionFacade.updatePermission(id, organizationId, requestDTO));
    }

    @Operation(summary = "Delete a permission")
    @DeleteMapping("/{id}/organization/{organizationId}")
    public ResponseEntity<?> deletePermission(@PathVariable Long id, @PathVariable Long organizationId) {
        log.info("Deleting permission with id: {} for organization: {}", id, organizationId);
        permissionFacade.deleteById(id, organizationId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Search permissions by keyword")
    @GetMapping("/search")
    public ResponseEntity<?> searchPermissions(@RequestParam Long organizationId, @RequestParam(required = false) String keyword) {
        log.info("Searching permissions with keyword: {} for organization: {}", keyword, organizationId);
        return ResponseEntity.ok(permissionFacade.searchByKeyword(organizationId, keyword));
    }
}
