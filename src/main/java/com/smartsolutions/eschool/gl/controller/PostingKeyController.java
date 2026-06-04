package com.smartsolutions.eschool.gl.controller;

import com.smartsolutions.eschool.gl.dtos.postingKey.request.PostingKeyRequestDTO;
import com.smartsolutions.eschool.gl.dtos.postingKey.response.PostingKeyResponseDTO;
import com.smartsolutions.eschool.gl.facade.PostingKeyFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/gl/posting-keys")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "GL Posting Key Management", description = "Endpoints for managing GL Posting Keys.")
public class PostingKeyController {

    private final PostingKeyFacade postingKeyFacade;

    @Operation(summary = "Get all posting keys")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PostingKeyResponseDTO>> getAll() {
        log.info("[Controller:PostingKeyController] getAll() called");
        return ResponseEntity.ok(postingKeyFacade.getAll());
    }

    @Operation(summary = "Get posting key by ID")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostingKeyResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:PostingKeyController] getById() called - ID: {}", id);
        return ResponseEntity.ok(postingKeyFacade.getById(id));
    }

    @Operation(summary = "Create posting key")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostingKeyResponseDTO> create(@Valid @RequestBody PostingKeyRequestDTO requestDTO) {
        log.info("[Controller:PostingKeyController] create() called");
        return ResponseEntity.status(HttpStatus.CREATED).body(postingKeyFacade.create(requestDTO));
    }

    @Operation(summary = "Update posting key")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PostingKeyResponseDTO> update(@PathVariable Long id, @Valid @RequestBody PostingKeyRequestDTO requestDTO) {
        log.info("[Controller:PostingKeyController] update() called - ID: {}", id);
        return ResponseEntity.ok(postingKeyFacade.update(id, requestDTO));
    }

    @Operation(summary = "Delete posting key")
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:PostingKeyController] delete() called - ID: {}", id);
        postingKeyFacade.delete(id);
        return ResponseEntity.ok(Map.of("message", "Posting key deleted successfully"));
    }

    @Operation(summary = "Search posting keys")
    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PostingKeyResponseDTO>> search(@RequestParam String keyword) {
        log.info("[Controller:PostingKeyController] search() called - Keyword: {}", keyword);
        return ResponseEntity.ok(postingKeyFacade.search(keyword));
    }
}
