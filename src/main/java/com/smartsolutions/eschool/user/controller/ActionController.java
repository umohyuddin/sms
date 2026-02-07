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
public class ActionController {

    private final ActionFacade actionFacade;

    @PostMapping
    public ResponseEntity<?> createAction(@Valid @RequestBody ActionRequestDTO dto) {
        return ResponseEntity.ok(actionFacade.createAction(dto));
    }

    @GetMapping
    public ResponseEntity<?> getAllActions() {
        return ResponseEntity.ok(actionFacade.getAllActions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActionById(@PathVariable Long id) {
        return ResponseEntity.ok(actionFacade.getActionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAction(@PathVariable Long id, @Valid @RequestBody ActionRequestDTO dto) {
        return ResponseEntity.ok(actionFacade.updateAction(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAction(@PathVariable Long id) {
        actionFacade.deleteAction(id);
        return ResponseEntity.ok().build();
    }
}
