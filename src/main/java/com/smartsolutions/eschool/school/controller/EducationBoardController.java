package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.educationBoards.requestDto.EducationBoardRequestDTO;
import com.smartsolutions.eschool.school.dtos.educationBoards.responseDto.EducationBoardResponseDTO;
import com.smartsolutions.eschool.school.facade.EducationBoardFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/institute/education-boards")
@Slf4j
public class EducationBoardController {

    private final EducationBoardFacade educationBoardFacade;

    public EducationBoardController(EducationBoardFacade educationBoardFacade) {
        this.educationBoardFacade = educationBoardFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EducationBoardResponseDTO>> getAll() {
        log.info("[Controller:EducationBoardController] getAll() called - Request to get all education boards");
        List<EducationBoardResponseDTO> resources = educationBoardFacade.getAll();
        log.info("[Controller:EducationBoardController] getAll() succeeded - Found {} education boards", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EducationBoardResponseDTO>> getAllActive() {
        log.info("[Controller:EducationBoardController] getAllActive() called - Request to get all active education boards");
        List<EducationBoardResponseDTO> resources = educationBoardFacade.getAllActive();
        log.info("[Controller:EducationBoardController] getAllActive() succeeded - Found {} active education boards", resources.size());
        return ResponseEntity.ok(resources);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationBoardResponseDTO> getById(@PathVariable Long id) {
        log.info("[Controller:EducationBoardController] getById() called - Request to fetch education board with id: {}", id);
        EducationBoardResponseDTO board = educationBoardFacade.getById(id);
        log.info("[Controller:EducationBoardController] getById() succeeded - Found education board: {}", id);
        return ResponseEntity.ok(board);
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EducationBoardResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("[Controller:EducationBoardController] search() called - Request to search education boards with keyword: {}", keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<EducationBoardResponseDTO> responseDTOs = educationBoardFacade.searchByKeyword(keyword.trim());
        log.info("[Controller:EducationBoardController] search() succeeded - Found {} education boards matching keyword: {}", responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        log.info("[Controller:EducationBoardController] delete() called - Request to delete education board: {}", id);
        educationBoardFacade.softDeleteById(id);
        log.info("[Controller:EducationBoardController] delete() succeeded - Education board: {} deleted successfully", id);
        return ResponseEntity.ok(Map.of("message", "Education board deleted successfully"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationBoardResponseDTO> create(@Valid @RequestBody EducationBoardRequestDTO requestDTO) {
        log.info("[Controller:EducationBoardController] create() called - Request to create education board: {}", requestDTO.getName());
        EducationBoardResponseDTO responseDTO = educationBoardFacade.createEducationBoard(requestDTO);
        log.info("[Controller:EducationBoardController] create() succeeded - Education board created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationBoardResponseDTO> update(@PathVariable Long id, @Valid @RequestBody EducationBoardRequestDTO requestDTO) {
        log.info("[Controller:EducationBoardController] update() called - Request to update education board: {}", id);
        EducationBoardResponseDTO responseDTO = educationBoardFacade.updateEducationBoard(id, requestDTO);
        log.info("[Controller:EducationBoardController] update() succeeded - Education board: {} updated successfully", id);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Long>> getStatistics() {
        log.info("[Controller:EducationBoardController] getStatistics() called");
        Map<String, Long> statistics = educationBoardFacade.getStatistics();
        log.info("[Controller:EducationBoardController] getStatistics() succeeded");
        return ResponseEntity.ok(statistics);
    }
}
