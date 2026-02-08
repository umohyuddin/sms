package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.educationBoards.requestDto.EducationBoardCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.educationBoards.requestDto.EducationBoardUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.educationBoards.responseDto.EducationBoardResponseDTO;
import com.smartsolutions.eschool.school.facade.EducationBoardFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/education-boards")
@Slf4j
public class EducationBoardController {

    private final EducationBoardFacade educationBoardFacade;

    public EducationBoardController(EducationBoardFacade educationBoardFacade) {
        this.educationBoardFacade = educationBoardFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationBoardResponseDTO> createEducationBoard(@Valid @RequestBody EducationBoardCreateRequestDTO requestDTO) {
        log.info("POST /api/institute/education-boards called for: {}", requestDTO.getName());
        EducationBoardResponseDTO responseDTO = educationBoardFacade.createEducationBoard(requestDTO);
        log.info("POST /api/institute/education-boards succeeded, created with id: {}", responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EducationBoardResponseDTO>> getAll() {
        log.info("GET /api/institute/education-boards called");
        List<EducationBoardResponseDTO> result = educationBoardFacade.getAll();
        log.info("GET /api/institute/education-boards succeeded, returned {} resources", result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EducationBoardResponseDTO>> getAllActive() {
        log.info("GET /api/institute/education-boards/active called");
        List<EducationBoardResponseDTO> result = educationBoardFacade.getAllActive();
        log.info("GET /api/institute/education-boards/active succeeded, returned {} resources", result.size());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{educationBoardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationBoardResponseDTO> getById(@PathVariable Long educationBoardId) {
        log.info("GET /api/institute/education-boards/{} called", educationBoardId);
        EducationBoardResponseDTO result = educationBoardFacade.getById(educationBoardId);
        log.info("GET /api/institute/education-boards/{} succeeded", educationBoardId);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/{educationBoardId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationBoardResponseDTO> updateEducationBoard(@PathVariable Long educationBoardId, @Valid @RequestBody EducationBoardUpdateRequestDTO requestDTO) {
        log.info("PUT /api/institute/education-boards/{} called", educationBoardId);
        EducationBoardResponseDTO result = educationBoardFacade.updateEducationBoard(educationBoardId, requestDTO);
        log.info("PUT /api/institute/education-boards/{} succeeded", educationBoardId);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{educationBoardId}")
    public ResponseEntity<String> deleteEducationBoard(@PathVariable Long educationBoardId) {
        log.info("DELETE /api/institute/education-boards/{} called", educationBoardId);
        educationBoardFacade.deleteById(educationBoardId);
        log.info("DELETE /api/institute/education-boards/{} succeeded", educationBoardId);
        return ResponseEntity.ok("EducationBoard deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EducationBoardResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        log.info("GET /api/institute/education-boards/search called with keyword: {}", keyword);
        List<EducationBoardResponseDTO> result = educationBoardFacade.searchByKeyword(keyword);
        log.info("GET /api/institute/education-boards/search succeeded, returned {} resources", result.size());
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/{educationBoardId}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationBoardResponseDTO> activate(@PathVariable Long educationBoardId) {
        log.info("PUT /api/institute/education-boards/{}/activate called", educationBoardId);
        EducationBoardResponseDTO result = educationBoardFacade.activate(educationBoardId);
        log.info("PUT /api/institute/education-boards/{}/activate succeeded", educationBoardId);
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = "/{educationBoardId}/deactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationBoardResponseDTO> deactivate(@PathVariable Long educationBoardId) {
        log.info("PUT /api/institute/education-boards/{}/deactivate called", educationBoardId);
        EducationBoardResponseDTO result = educationBoardFacade.deactivate(educationBoardId);
        log.info("PUT /api/institute/education-boards/{}/deactivate succeeded", educationBoardId);
        return ResponseEntity.ok(result);
    }
}
