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
        log.info("Creating module");
        return ResponseEntity.status(HttpStatus.CREATED).body(moduleFacade.createModule(requestDTO));
    }

    @Operation(summary = "Get all modules")
    @GetMapping
    public ResponseEntity<?> getAllModules() {
        log.info("Fetching all modules");
        return ResponseEntity.ok(moduleFacade.getAll());
    }

    @Operation(summary = "Get module by ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> getModuleById(@PathVariable Long id) {
        log.info("Fetching module by id: {}", id);
        return ResponseEntity.ok(moduleFacade.getById(id));
    }

    @Operation(summary = "Update module")
    @PutMapping("/{id}")
    public ResponseEntity<?> updateModule(@PathVariable Long id, @Valid @RequestBody ModuleRequestDTO requestDTO) {
        log.info("Updating module by id: {}", id);
        return ResponseEntity.ok(moduleFacade.updateModule(id, requestDTO));
    }

    @Operation(summary = "Delete module")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteModule(@PathVariable Long id) {
        log.info("Deleting module by id: {}", id);
        moduleFacade.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Search modules")
    @GetMapping("/search")
    public ResponseEntity<?> searchModules(@RequestParam(name = "keyword") String keyword) {
        log.info("Searching modules with keyword: {}", keyword);
        return ResponseEntity.ok(moduleFacade.searchByKeyword(keyword));
    }
}
