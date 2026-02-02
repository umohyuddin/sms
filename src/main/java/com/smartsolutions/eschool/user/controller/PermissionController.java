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
    public ResponseEntity<List<PermissionResponseDTO>> getAllPermissions() {
        log.info("GET /api/users/permissions called");
        List<PermissionResponseDTO> permissions = permissionFacade.getAll();
        log.info("Returned {} permissions", permissions.size());
        return ResponseEntity.ok(permissions);
    }

    @GetMapping(value = "/{permissionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PermissionResponseDTO> getPermissionById(@PathVariable Long permissionId) {
        log.info("GET /api/users/permissions/{} called", permissionId);
        PermissionResponseDTO permission = permissionFacade.getById(permissionId);
        return ResponseEntity.ok(permission);
    }

    @PutMapping(value = "/{permissionId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PermissionResponseDTO> updatePermission(@PathVariable Long permissionId, @Valid @RequestBody PermissionRequestDTO requestDTO) {
        log.info("Received request to update Permission with id: {}", permissionId);
        PermissionResponseDTO updated = permissionFacade.updatePermission(permissionId, requestDTO);
        log.info("Permission updated successfully with id: {}", updated.getId());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{permissionId}")
    public ResponseEntity<String> deletePermission(@PathVariable Long permissionId) {
        log.info("DELETE /api/users/permissions/{} called", permissionId);
        permissionFacade.deleteById(permissionId);
        log.info("Permission deleted successfully with id: {}", permissionId);
        return ResponseEntity.ok("Permission deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PermissionResponseDTO>> searchPermissions(@RequestParam(name = "keyword") String keyword) {
        log.info("Searching Permissions with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<PermissionResponseDTO> results = permissionFacade.searchByKeyword(keyword.trim());
        log.info("Found {} permissions matching keyword '{}'", results.size(), keyword);
        return ResponseEntity.ok(results);
    }
}
