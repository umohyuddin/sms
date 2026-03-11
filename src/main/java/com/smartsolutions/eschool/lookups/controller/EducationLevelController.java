package com.smartsolutions.eschool.lookups.controller;

import com.smartsolutions.eschool.lookups.dtos.educationLevel.requestDto.EducationLevelRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.educationLevel.responseDto.EducationLevelResponseDTO;
import com.smartsolutions.eschool.lookups.facade.EducationLevelFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lookups/education-levels/v1")
@Slf4j
public class EducationLevelController {

    private final EducationLevelFacade educationLevelFacade;

    public EducationLevelController(EducationLevelFacade educationLevelFacade) {
        this.educationLevelFacade = educationLevelFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EducationLevelResponseDTO>> getAll() {
        log.info("[Controller:EducationLevelController] getAll() called - Request to get all education levels");
        List<EducationLevelResponseDTO> resources = educationLevelFacade.getAll();
        log.info("[Controller:EducationLevelController] getAll() succeeded - Found {} education levels", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EducationLevelResponseDTO>> getAllActive() {
        log.info("[Controller:EducationLevelController] getAllActive() called - Request to get all active education levels");
        List<EducationLevelResponseDTO> resources = educationLevelFacade.getAllActive();
        log.info("[Controller:EducationLevelController] getAllActive() succeeded - Found {} active education levels", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationLevelResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:EducationLevelController] getById() called - Request to fetch education level with id: {}", id);
        EducationLevelResponseDTO educationLevel = educationLevelFacade.getById(id);
        log.info("[Controller:EducationLevelController] getById() succeeded - Found education level: {}", id);
        return ResponseEntity.ok(educationLevel);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EducationLevelResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:EducationLevelController] search() called - Request to search education levels with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<EducationLevelResponseDTO> responseDTOs = educationLevelFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:EducationLevelController] search() succeeded - Found {} education levels matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:EducationLevelController] delete() called - Request to delete education level: {}", id);
        educationLevelFacade.softDeleteById(id);
        log.info("[Controller:EducationLevelController] delete() succeeded - Education level: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Education level deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationLevelResponseDTO> create(@Valid @RequestBody EducationLevelRequestDTO requestDTO) {
        log.info("[Controller:EducationLevelController] create() called - Request to create education level: {}", requestDTO.getName());
        EducationLevelResponseDTO responseDTO = educationLevelFacade.create(requestDTO);
        log.info("[Controller:EducationLevelController] create() succeeded - Education level created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationLevelResponseDTO> update(@PathVariable Long id, @Valid @RequestBody EducationLevelRequestDTO requestDTO) {
        log.info("[Controller:EducationLevelController] update() called - Request to update education level: {}", id);
        EducationLevelResponseDTO responseDTO = educationLevelFacade.update(id, requestDTO);
        log.info("[Controller:EducationLevelController] update() succeeded - Education level: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:EducationLevelController] getStatistics() called");
        Map<String, Long> statistics = educationLevelFacade.getStatistics();
        log.info("[Controller:EducationLevelController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
