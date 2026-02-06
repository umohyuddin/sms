package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.user.dtos.roles.request.RoleRequestDTO;
import com.smartsolutions.eschool.user.dtos.roles.response.RoleResponseDTO;
import com.smartsolutions.eschool.user.facade.RoleFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/roles")
@Slf4j
public class RoleController {

    private final RoleFacade roleFacade;

    public RoleController(RoleFacade roleFacade) {
        this.roleFacade = roleFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleResponseDTO> createRole(@Valid @RequestBody RoleRequestDTO requestDTO) {
        log.info("Received request to create Role");
        RoleResponseDTO responseDTO = roleFacade.createRole(requestDTO);
        log.info("Role created successfully with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles(@RequestParam Long organizationId) {
        log.info("GET /api/users/roles called for organizationId: {}", organizationId);
        List<RoleResponseDTO> roles = roleFacade.getAll(organizationId);
        log.info("Returned {} roles", roles.size());
        return ResponseEntity.ok(roles);
    }

    @GetMapping(value = "/{roleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleResponseDTO> getRoleById(@PathVariable Long roleId, @RequestParam Long organizationId) {
        log.info("GET /api/users/roles/{} called for organizationId: {}", roleId, organizationId);
        RoleResponseDTO role = roleFacade.getById(roleId, organizationId);
        return ResponseEntity.ok(role);
    }

    @PutMapping(value = "/{roleId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleResponseDTO> updateRole(@PathVariable Long roleId, @RequestParam Long organizationId, @Valid @RequestBody RoleRequestDTO requestDTO) {
        log.info("Received request to update Role with id: {} for organizationId: {}", roleId, organizationId);
        RoleResponseDTO updated = roleFacade.updateRole(roleId, organizationId, requestDTO);
        log.info("Role updated successfully with id: {}", updated.getId());
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<String> deleteRole(@PathVariable Long roleId, @RequestParam Long organizationId) {
        log.info("DELETE /api/users/roles/{} called for organizationId: {}", roleId, organizationId);
        roleFacade.deleteById(roleId, organizationId);
        log.info("Role deleted successfully with id: {}", roleId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoleResponseDTO>> searchRoles(@RequestParam(name = "keyword") String keyword, @RequestParam Long organizationId) {
        log.info("Searching Roles with keyword: {} for organizationId: {}", keyword, organizationId);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<RoleResponseDTO> results = roleFacade.searchByKeyword(organizationId, keyword.trim());
        log.info("Found {} roles matching keyword '{}'", results.size(), keyword);
        return ResponseEntity.ok(results);
    }

    @GetMapping(value = "/organization/{organizationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoleResponseDTO>> getRolesByOrganizationId(@PathVariable Long organizationId) {
        log.info("GET roles for organizationId={}", organizationId);
        List<RoleResponseDTO> roles = roleFacade.getByOrganizationId(organizationId);
        log.info("Returned {} roles for organizationId={}", roles.size(), organizationId);
        return ResponseEntity.ok(roles);
    }

}
