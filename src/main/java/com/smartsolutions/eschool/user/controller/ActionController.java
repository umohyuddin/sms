package com.smartsolutions.eschool.user.controller;


import com.smartsolutions.eschool.user.dtos.actions.request.ActionRequestDTO;
import com.smartsolutions.eschool.user.dtos.actions.response.ActionResponseDTO;
import com.smartsolutions.eschool.user.facade.ActionFacade;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/actions")
@RequiredArgsConstructor
@Tag(name = "Action Management", description = "Endpoints for managing global actions")
@Slf4j
public class ActionController {

    private final ActionFacade actionFacade;

    @PostMapping
    public ResponseEntity<?> createAction(@Valid @RequestBody ActionRequestDTO dto) {
        log.info("POST /api/v1/actions called for action: {}", dto.getName());
        ActionResponseDTO result = actionFacade.createAction(dto);
        log.info("POST /api/v1/actions succeeded, created action with ID: {}", result.getId());
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public ResponseEntity<?> getAllActions() {
        log.info("GET /api/v1/actions called");
        List<ActionResponseDTO> resources = actionFacade.getAllActions();
        log.info("GET /api/v1/actions succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchActions(@RequestParam(required = false) String keyword) {
        log.info("GET /api/v1/actions/search called with keyword: {}", keyword);
        List<ActionResponseDTO> resources = actionFacade.searchActions(keyword);
        log.info("GET /api/v1/actions/search succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActionById(@PathVariable Long id) {
        log.info("GET /api/v1/actions/{} called", id);
        ActionResponseDTO resource = actionFacade.getActionById(id);
        log.info("GET /api/v1/actions/{} succeeded", id);
        return ResponseEntity.ok(resource);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAction(@PathVariable Long id, @Valid @RequestBody ActionRequestDTO dto) {
        log.info("PUT /api/v1/actions/{} called", id);
        ActionResponseDTO result = actionFacade.updateAction(id, dto);
        log.info("PUT /api/v1/actions/{} succeeded", id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAction(@PathVariable Long id) {
        log.info("DELETE /api/v1/actions/{} called", id);
        actionFacade.deleteAction(id);
        log.info("DELETE /api/v1/actions/{} succeeded", id);
        return ResponseEntity.ok().build();
    }
}
