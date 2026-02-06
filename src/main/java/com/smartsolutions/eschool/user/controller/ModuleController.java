package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.user.dtos.modules.request.ModuleRequestDTO;
import com.smartsolutions.eschool.user.dtos.modules.response.ModuleResponseDTO;
import com.smartsolutions.eschool.user.facade.ModuleFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/modules")
@Slf4j
public class ModuleController {

    private final ModuleFacade moduleFacade;

    public ModuleController(ModuleFacade moduleFacade) {
        this.moduleFacade = moduleFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ModuleResponseDTO> createModule(@Valid @RequestBody ModuleRequestDTO requestDTO) {
        log.info("POST /api/users/modules called");
        ModuleResponseDTO responseDTO = moduleFacade.createModule(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ModuleResponseDTO>> getAllModules() {
        log.info("GET /api/users/modules called");
        return ResponseEntity.ok(moduleFacade.getAll());
    }

    @GetMapping(value = "/{moduleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ModuleResponseDTO> getModuleById(@PathVariable Long moduleId) {
        log.info("GET /api/users/modules/{} called", moduleId);
        return ResponseEntity.ok(moduleFacade.getById(moduleId));
    }

    @PutMapping(value = "/{moduleId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ModuleResponseDTO> updateModule(@PathVariable Long moduleId, @Valid @RequestBody ModuleRequestDTO requestDTO) {
        log.info("PUT /api/users/modules/{} called", moduleId);
        return ResponseEntity.ok(moduleFacade.updateModule(moduleId, requestDTO));
    }

    @DeleteMapping("/{moduleId}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long moduleId) {
        log.info("DELETE /api/users/modules/{} called", moduleId);
        moduleFacade.deleteById(moduleId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ModuleResponseDTO>> searchModules(@RequestParam(name = "keyword") String keyword) {
        log.info("GET /api/users/modules/search called with keyword: {}", keyword);
        return ResponseEntity.ok(moduleFacade.searchByKeyword(keyword));
    }
}
