package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.user.dtos.modules.request.ModuleRequestDTO;
import com.smartsolutions.eschool.user.dtos.modules.response.ModuleResponseDTO;
import com.smartsolutions.eschool.user.facade.ModuleFacade;
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
@RequestMapping("/api/v1/modules")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Module Management", description = "Endpoints for managing application modules")
public class ModuleController {

    private final ModuleFacade moduleFacade;

    @Operation(summary = "Create a new module")
    @PostMapping
    public ResponseEntity<?> createModule(@Valid @RequestBody ModuleRequestDTO requestDTO) {
        log.info("POST /api/v1/modules called for module: {}", requestDTO.getName());
        ModuleResponseDTO result = moduleFacade.createModule(requestDTO);
        log.info("POST /api/v1/modules succeeded, created module with ID: {}", result.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(summary = "Get all modules")
    @GetMapping
    public ResponseEntity<?> getAllModules() {
        log.info("GET /api/v1/modules called");
        List<ModuleResponseDTO> resources = moduleFacade.getAll();
        log.info("GET /api/v1/modules succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }

    @Operation(summary = "Get module by ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getModuleById(@PathVariable Long id) {
        log.info("GET /api/v1/modules/{} called", id);
        ModuleResponseDTO resource = moduleFacade.getById(id);
        log.info("GET /api/v1/modules/{} succeeded", id);
        return ResponseEntity.ok(resource);
    }

    @Operation(summary = "Update module")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateModule(@PathVariable Long id, @Valid @RequestBody ModuleRequestDTO requestDTO) {
        log.info("PUT /api/v1/modules/{} called", id);
        ModuleResponseDTO result = moduleFacade.updateModule(id, requestDTO);
        log.info("PUT /api/v1/modules/{} succeeded", id);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Delete module")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteModule(@PathVariable Long id) {
        log.info("DELETE /api/v1/modules/{} called", id);
        moduleFacade.deleteById(id);
        log.info("DELETE /api/v1/modules/{} succeeded", id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Search modules")
    @GetMapping("/search")
    public ResponseEntity<?> searchModules(@RequestParam(name = "keyword") String keyword) {
        log.info("GET /api/v1/modules/search called with keyword: {}", keyword);
        List<ModuleResponseDTO> resources = moduleFacade.searchByKeyword(keyword);
        log.info("GET /api/v1/modules/search succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }
}
