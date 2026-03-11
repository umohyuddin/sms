package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.user.dtos.actions.request.ActionRequestDTO;
import com.smartsolutions.eschool.user.dtos.actions.response.ActionResponseDTO;
import com.smartsolutions.eschool.user.facade.ActionFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user/actions/v1")
@Slf4j
public class ActionController {

    private final ActionFacade actionFacade;

    public ActionController(ActionFacade actionFacade) {
        this.actionFacade = actionFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActionResponseDTO>> getAll() {
        log.info("[Controller:ActionController] getAll() called - Request to get all actions");
        List<ActionResponseDTO> resources = actionFacade.getAll();
        log.info("[Controller:ActionController] getAll() succeeded - Found {} actions", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActionResponseDTO>> getAllActive() {
        log.info("[Controller:ActionController] getAllActive() called - Request to get all active actions");
        List<ActionResponseDTO> resources = actionFacade.getAllActive();
        log.info("[Controller:ActionController] getAllActive() succeeded - Found {} active actions", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActionResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:ActionController] getById() called - Request to fetch action with id: {}", id);
        ActionResponseDTO action = actionFacade.getById(id);
        log.info("[Controller:ActionController] getById() succeeded - Found action: {}", id);
        return ResponseEntity.ok(action);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ActionResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:ActionController] search() called - Request to search actions with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<ActionResponseDTO> responseDTOs = actionFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:ActionController] search() succeeded - Found {} actions matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:ActionController] delete() called - Request to delete action: {}", id);
        actionFacade.softDeleteById(id);
        log.info("[Controller:ActionController] delete() succeeded - Action: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Action deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActionResponseDTO> create(@Valid @RequestBody ActionRequestDTO requestDTO) {
        log.info("[Controller:ActionController] create() called - Request to create action: {}", requestDTO.getName());
        ActionResponseDTO responseDTO = actionFacade.create(requestDTO);
        log.info("[Controller:ActionController] create() succeeded - Action created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ActionResponseDTO> update(@PathVariable Long id, @Valid @RequestBody ActionRequestDTO requestDTO) {
        log.info("[Controller:ActionController] update() called - Request to update action: {}", id);
        ActionResponseDTO responseDTO = actionFacade.update(id, requestDTO);
        log.info("[Controller:ActionController] update() succeeded - Action: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:ActionController] getStatistics() called");
        Map<String, Long> statistics = actionFacade.getStatistics();
        log.info("[Controller:ActionController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
