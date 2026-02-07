package com.smartsolutions.eschool.user.controller;


import com.smartsolutions.eschool.user.dtos.actions.request.ActionRequestDTO;
import com.smartsolutions.eschool.user.dtos.actions.response.ActionResponseDTO;
import com.smartsolutions.eschool.user.facade.ActionFacade;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/actions")
@RequiredArgsConstructor
@Tag(name = "Action Management", description = "Endpoints for managing global actions")
@lombok.extern.slf4j.Slf4j
public class ActionController {

    private final ActionFacade actionFacade;

    @PostMapping
    public ResponseEntity<?> createAction(@Valid @RequestBody ActionRequestDTO dto) {
        log.info("[ACTION_CONTROLLER] POST /api/v1/actions - Create Action: {}", dto.getName());
        return ResponseEntity.ok(actionFacade.createAction(dto));
    }

    @GetMapping
    public ResponseEntity<?> getAllActions() {
        log.info("[ACTION_CONTROLLER] GET /api/v1/actions - Fetch all Actions");
        return ResponseEntity.ok(actionFacade.getAllActions());
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchActions(@RequestParam(required = false) String keyword) {
        log.info("[ACTION_CONTROLLER] GET /api/v1/actions/search - Search Keyword: '{}'", keyword);
        return ResponseEntity.ok(actionFacade.searchActions(keyword));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActionById(@PathVariable Long id) {
        log.info("[ACTION_CONTROLLER] GET /api/v1/actions/{} - Fetch Action by ID", id);
        return ResponseEntity.ok(actionFacade.getActionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAction(@PathVariable Long id, @Valid @RequestBody ActionRequestDTO dto) {
        log.info("[ACTION_CONTROLLER] PUT /api/v1/actions/{} - Update Action", id);
        return ResponseEntity.ok(actionFacade.updateAction(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAction(@PathVariable Long id) {
        log.info("[ACTION_CONTROLLER] DELETE /api/v1/actions/{} - Delete Action", id);
        actionFacade.deleteAction(id);
        return ResponseEntity.ok().build();
    }
}
