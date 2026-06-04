package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.user.dtos.roles.request.RoleRequestDTO;
import com.smartsolutions.eschool.user.dtos.roles.response.RoleResponseDTO;
import com.smartsolutions.eschool.user.facade.RoleFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/roles")
@Slf4j
@Tag(name = "Role Management", description = "Endpoints for managing user roles")
public class RoleController {

    private final RoleFacade roleFacade;

    public RoleController(RoleFacade roleFacade) {
        this.roleFacade = roleFacade;
    }

    @Operation(summary = "Get all roles for current organization")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoleResponseDTO>> getAll() {
        log.info("[Controller:RoleController] getAll() called - Request to get all roles");
        List<RoleResponseDTO> resources = roleFacade.getAll();
        log.info("[Controller:RoleController] getAll() succeeded - Found {} roles", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get all roles for an organization")
    @GetMapping(value = "/organization/{organizationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoleResponseDTO>> getAllByOrganization(@PathVariable Long organizationId) {
        log.info("[Controller:RoleController] getAllByOrganization() called - organization: {}", organizationId);
        List<RoleResponseDTO> resources = roleFacade.getAll(organizationId);
        log.info("[Controller:RoleController] getAllByOrganization() succeeded - Found {} roles", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get role by ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:RoleController] getById() called - Request to fetch role with id: {}", id);
        RoleResponseDTO role = roleFacade.getById(id);
        log.info("[Controller:RoleController] getById() succeeded - Found role: {}", id);
        return ResponseEntity.ok(role);
    }

    @Operation(summary = "Get role by ID and organization ID")
    @GetMapping(value = "/{id}/organization/{organizationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleResponseDTO> getByIdAndOrganization(@PathVariable Long id,
            @PathVariable Long organizationId) {
        log.info("[Controller:RoleController] getByIdAndOrganization() called - id: {}, organization: {}", id,
                organizationId);
        RoleResponseDTO role = roleFacade.getById(id, organizationId);
        log.info("[Controller:RoleController] getByIdAndOrganization() succeeded - Found role: {}", id);
        return ResponseEntity.ok(role);
    }

    @Operation(summary = "Search roles by keyword")
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RoleResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:RoleController] search() called - Request to search roles with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<RoleResponseDTO> responseDTOs = roleFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:RoleController] search() succeeded - Found {} roles matching keyword: {}",
                responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @Operation(summary = "Delete role")
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:RoleController] delete() called - Request to delete role: {}", id);
        roleFacade.softDeleteById(id);
        log.info("[Controller:RoleController] delete() succeeded - Role: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Role deleted successfully"));
    }

    @Operation(summary = "Delete role by ID and organization")
    @DeleteMapping("/{id}/organization/{organizationId}")
    public ResponseEntity<Map<String, String>> deleteByOrganization(@PathVariable Long id,
            @PathVariable Long organizationId) {
        log.info("[Controller:RoleController] deleteByOrganization() called - id: {}, organization: {}", id,
                organizationId);
        roleFacade.deleteById(id, organizationId);
        log.info("[Controller:RoleController] deleteByOrganization() succeeded - Role: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Role deleted successfully"));
    }

    @Operation(summary = "Create a new role")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleResponseDTO> create(@Valid @RequestBody RoleRequestDTO requestDTO) {
        log.info("[Controller:RoleController] create() called - Request to create role: {}", requestDTO.getName());
        RoleResponseDTO responseDTO = roleFacade.createRole(requestDTO);
        log.info("[Controller:RoleController] create() succeeded - Role created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @Operation(summary = "Update role")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleResponseDTO> update(@PathVariable Long id,
            @Valid @RequestBody RoleRequestDTO requestDTO) {
        log.info("[Controller:RoleController] update() called - Request to update role: {}", id);
        RoleResponseDTO responseDTO = roleFacade.updateRole(id, requestDTO);
        log.info("[Controller:RoleController] update() succeeded - Role: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Update role by ID and organization")
    @PutMapping(value = "/{id}/organization/{organizationId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RoleResponseDTO> updateByOrganization(@PathVariable Long id,
            @PathVariable Long organizationId, @Valid @RequestBody RoleRequestDTO requestDTO) {
        log.info("[Controller:RoleController] updateByOrganization() called - id: {}, organization: {}", id,
                organizationId);
        RoleResponseDTO responseDTO = roleFacade.updateRole(id, organizationId, requestDTO);
        log.info("[Controller:RoleController] updateByOrganization() succeeded - Role: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @Operation(summary = "Get role statistics")
    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:RoleController] getStatistics() called");
        Map<String, Long> statistics = roleFacade.getStatistics();
        log.info("[Controller:RoleController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
