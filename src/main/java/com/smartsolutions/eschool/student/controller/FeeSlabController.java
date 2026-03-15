package com.smartsolutions.eschool.student.controller;

import com.smartsolutions.eschool.student.dtos.feeSlab.FeeSlabCreateRequestDTO;
import com.smartsolutions.eschool.student.dtos.feeSlab.FeeSlabResponseDTO;
import com.smartsolutions.eschool.student.facade.FeeSlabFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/fee-slabs")
@Slf4j
public class FeeSlabController {

    private final FeeSlabFacade facade;

    public FeeSlabController(FeeSlabFacade facade) {
        this.facade = facade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeSlabResponseDTO>> getAll() {
        log.info("[Controller:FeeSlabController] getAll() called");
        List<FeeSlabResponseDTO> resources = facade.getAll();
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeSlabResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:FeeSlabController] getById() called with id: {}", id);
        FeeSlabResponseDTO resource = facade.getById(id);
        return ResponseEntity.ok(resource);
    }

    @GetMapping(value = "/group/{groupId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FeeSlabResponseDTO>> getByGroupId(@PathVariable Long groupId) {
        log.info("[Controller:FeeSlabController] getByGroupId() called with groupId: {}", groupId);
        return ResponseEntity.ok(facade.getByGroupId(groupId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeSlabResponseDTO> create(@Valid @RequestBody FeeSlabCreateRequestDTO dto) {
        log.info("[Controller:FeeSlabController] create() called");
        FeeSlabResponseDTO created = facade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FeeSlabResponseDTO> update(@PathVariable Long id,
            @Valid @RequestBody FeeSlabCreateRequestDTO dto) {
        log.info("[Controller:FeeSlabController] update() called with id: {}", id);
        FeeSlabResponseDTO updated = facade.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("[Controller:FeeSlabController] delete() called with id: {}", id);
        facade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
