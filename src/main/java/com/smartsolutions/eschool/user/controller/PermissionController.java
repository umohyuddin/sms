package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.user.dtos.permissions.request.PermissionRequestDTO;
import com.smartsolutions.eschool.user.dtos.permissions.response.PermissionResponseDTO;
import com.smartsolutions.eschool.user.facade.PermissionFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/permissions")
@Slf4j
public class PermissionController {

    private final PermissionFacade permissionFacade;

    public PermissionController(PermissionFacade permissionFacade) {
        this.permissionFacade = permissionFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PermissionResponseDTO> createPermission(@Valid @RequestBody PermissionRequestDTO requestDTO) {
        log.info("Received request to create Permission");
        PermissionResponseDTO responseDTO = permissionFacade.createPermission(requestDTO);
        log.info("Permission created successfully with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PermissionResponseDTO>> getAllPermissions(@RequestParam Long organizationId) {
        log.info("GET /api/users/permissions called for organizationId: {}", organizationId);
        List<PermissionResponseDTO> permissions = permissionFacade.getAll(organizationId);
        log.info("Returned {} permissions for organizationId: {}", permissions.size(), organizationId);
        return ResponseEntity.ok(permissions);
    }

    @GetMapping(value = "/{permissionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PermissionResponseDTO> getPermissionById(@PathVariable Long permissionId, @RequestParam Long organizationId) {
        log.info("GET /api/users/permissions/{} called for organizationId: {}", permissionId, organizationId);
        PermissionResponseDTO permission = permissionFacade.getById(permissionId, organizationId);
        return ResponseEntity.ok(permission);
    }

    @PutMapping(value = "/{permissionId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PermissionResponseDTO> updatePermission(@PathVariable Long permissionId, @RequestParam Long organizationId, @Valid @RequestBody PermissionRequestDTO requestDTO) {
        log.info("Received request to update Permission with id: {} for organizationId: {}", permissionId, organizationId);
        PermissionResponseDTO updated = permissionFacade.updatePermission(permissionId, organizationId, requestDTO);
        log.info("Permission updated successfully with id: {}", updated.getId());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{permissionId}")
    public ResponseEntity<String> deletePermission(@PathVariable Long permissionId, @RequestParam Long organizationId) {
        log.info("DELETE /api/users/permissions/{} called for organizationId: {}", permissionId, organizationId);
        permissionFacade.deleteById(permissionId, organizationId);
        log.info("Permission deleted successfully with id: {}", permissionId);
        return ResponseEntity.ok("Permission deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PermissionResponseDTO>> searchPermissions(@RequestParam(name = "keyword") String keyword, @RequestParam Long organizationId) {
        log.info("Searching Permissions with keyword: {} for organizationId: {}", keyword, organizationId);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<PermissionResponseDTO> results = permissionFacade.searchByKeyword(organizationId, keyword.trim());
        log.info("Found {} permissions matching keyword '{}' for organizationId: {}", results.size(), keyword, organizationId);
        return ResponseEntity.ok(results);
    }
}
