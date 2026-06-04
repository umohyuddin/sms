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
import java.util.Map;

@RestController
@RequestMapping("/api/user/modules/v1")
@Slf4j
public class ModuleController {

    private final ModuleFacade moduleFacade;

    public ModuleController(ModuleFacade moduleFacade) {
        this.moduleFacade = moduleFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ModuleResponseDTO>> getAll() {
        log.info("[Controller:ModuleController] getAll() called - Request to get all modules");
        List<ModuleResponseDTO> resources = moduleFacade.getAll();
        log.info("[Controller:ModuleController] getAll() succeeded - Found {} modules", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ModuleResponseDTO>> getAllActive() {
        log.info("[Controller:ModuleController] getAllActive() called - Request to get all active modules");
        List<ModuleResponseDTO> resources = moduleFacade.getAllActive();
        log.info("[Controller:ModuleController] getAllActive() succeeded - Found {} active modules", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ModuleResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:ModuleController] getById() called - Request to fetch module with id: {}", id);
        ModuleResponseDTO module = moduleFacade.getById(id);
        log.info("[Controller:ModuleController] getById() succeeded - Found module: {}", id);
        return ResponseEntity.ok(module);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ModuleResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:ModuleController] search() called - Request to search modules with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<ModuleResponseDTO> responseDTOs = moduleFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:ModuleController] search() succeeded - Found {} modules matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:ModuleController] delete() called - Request to delete module: {}", id);
        moduleFacade.softDeleteById(id);
        log.info("[Controller:ModuleController] delete() succeeded - Module: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Module deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ModuleResponseDTO> create(@Valid @RequestBody ModuleRequestDTO requestDTO) {
        log.info("[Controller:ModuleController] create() called - Request to create module: {}", requestDTO.getName());
        ModuleResponseDTO responseDTO = moduleFacade.create(requestDTO);
        log.info("[Controller:ModuleController] create() succeeded - Module created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ModuleResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ModuleRequestDTO requestDTO) {
        log.info("[Controller:ModuleController] update() called - Request to update module: {}", id);
        ModuleResponseDTO responseDTO = moduleFacade.update(id, requestDTO);
        log.info("[Controller:ModuleController] update() succeeded - Module: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:ModuleController] getStatistics() called");
        Map<String, Long> statistics = moduleFacade.getStatistics();
        log.info("[Controller:ModuleController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
