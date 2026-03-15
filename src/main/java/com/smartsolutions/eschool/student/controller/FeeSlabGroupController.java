package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.feeSlabGroup.FeeSlabGroupCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeSlabGroup.FeeSlabGroupResponseDTO;
import com.smartsolutions.eschool.student.facade.FeeSlabGroupFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/fee-slab-groups")
@Slf4j
public class FeeSlabGroupController {

    private final FeeSlabGroupFacade facade;

    public FeeSlabGroupController(FeeSlabGroupFacade facade) {
        this.facade = facade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeSlabGroupResponseDTO>> getAll() {
        log.info("[Controller:FeeSlabGroupController] getAll() called");
        List<FeeSlabGroupResponseDTO> resources = facade.getAll();
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeSlabGroupResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:FeeSlabGroupController] getById() called with id: {}", id);
        FeeSlabGroupResponseDTO resource = facade.getById(id);
        return ResponseEntity.ok(resource);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeSlabGroupResponseDTO>> search(
            @RequestParam(name = "keyword", required = false) String keyword) {
        log.info("[Controller:FeeSlabGroupController] search() called with keyword: {}", keyword);
        return ResponseEntity.ok(facade.search(keyword));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeSlabGroupResponseDTO> create(@Valid @RequestBody FeeSlabGroupCreateRequestDTO dto) {
        log.info("[Controller:FeeSlabGroupController] create() called");
        FeeSlabGroupResponseDTO created = facade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeSlabGroupResponseDTO> update(@PathVariable Long id,
            @Valid @RequestBody FeeSlabGroupCreateRequestDTO dto) {
        log.info("[Controller:FeeSlabGroupController] update() called with id: {}", id);
        FeeSlabGroupResponseDTO updated = facade.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("[Controller:FeeSlabGroupController] delete() called with id: {}", id);
        facade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
