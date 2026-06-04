package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.curriculum.requestDto.CurriculumRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.curriculum.responseDto.CurriculumResponseDTO;
import com.smartsolutions.eschool.lookups.facade.CurriculumFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lookups/curricula/v1")
@Slf4j
public class CurriculumController {

    private final CurriculumFacade curriculumFacade;

    public CurriculumController(CurriculumFacade curriculumFacade) {
        this.curriculumFacade = curriculumFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurriculumResponseDTO>> getAll() {
        log.info("[Controller:CurriculumController] getAll() called - Request to get all curricula");
        List<CurriculumResponseDTO> resources = curriculumFacade.getAll();
        log.info("[Controller:CurriculumController] getAll() succeeded - Found {} curricula", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurriculumResponseDTO>> getAllActive() {
        log.info("[Controller:CurriculumController] getAllActive() called - Request to get all active curricula");
        List<CurriculumResponseDTO> resources = curriculumFacade.getAllActive();
        log.info("[Controller:CurriculumController] getAllActive() succeeded - Found {} active curricula", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurriculumResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:CurriculumController] getById() called - Request to fetch curriculum with id: {}", id);
        CurriculumResponseDTO curriculum = curriculumFacade.getById(id);
        log.info("[Controller:CurriculumController] getById() succeeded - Found curriculum: {}", id);
        return ResponseEntity.ok(curriculum);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CurriculumResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:CurriculumController] search() called - Request to search curricula with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<CurriculumResponseDTO> responseDTOs = curriculumFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:CurriculumController] search() succeeded - Found {} curricula matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:CurriculumController] delete() called - Request to delete curriculum: {}", id);
        curriculumFacade.softDeleteById(id);
        log.info("[Controller:CurriculumController] delete() succeeded - Curriculum: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Curriculum deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurriculumResponseDTO> create(@Valid @RequestBody CurriculumRequestDTO requestDTO) {
        log.info("[Controller:CurriculumController] create() called - Request to create curriculum: {}", requestDTO.getName());
        CurriculumResponseDTO responseDTO = curriculumFacade.create(requestDTO);
        log.info("[Controller:CurriculumController] create() succeeded - Curriculum created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CurriculumResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CurriculumRequestDTO requestDTO) {
        log.info("[Controller:CurriculumController] update() called - Request to update curriculum: {}", id);
        CurriculumResponseDTO responseDTO = curriculumFacade.update(id, requestDTO);
        log.info("[Controller:CurriculumController] update() succeeded - Curriculum: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:CurriculumController] getStatistics() called");
        Map<String, Long> statistics = curriculumFacade.getStatistics();
        log.info("[Controller:CurriculumController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
