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
        EducationBoardResponseDTO responseDTO = educationBoardFacade.createEducationBoard(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EducationBoardResponseDTO>> getAll() {
        return ResponseEntity.ok(educationBoardFacade.getAll());
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EducationBoardResponseDTO>> getAllActive() {
        return ResponseEntity.ok(educationBoardFacade.getAllActive());
    }

    @GetMapping(value = "/{educationBoardId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationBoardResponseDTO> getById(@PathVariable Long educationBoardId) {
        return ResponseEntity.ok(educationBoardFacade.getById(educationBoardId));
    }

    @PutMapping(value = "/{educationBoardId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationBoardResponseDTO> updateEducationBoard(@PathVariable Long educationBoardId, @Valid @RequestBody EducationBoardUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(educationBoardFacade.updateEducationBoard(educationBoardId, requestDTO));
    }

    @DeleteMapping("/{educationBoardId}")
    public ResponseEntity<String> deleteEducationBoard(@PathVariable Long educationBoardId) {
        educationBoardFacade.deleteById(educationBoardId);
        return ResponseEntity.ok("EducationBoard deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EducationBoardResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(educationBoardFacade.searchByKeyword(keyword.trim()));
    }

    @PutMapping(value = "/{educationBoardId}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationBoardResponseDTO> activate(@PathVariable Long educationBoardId) {
        return ResponseEntity.ok(educationBoardFacade.activate(educationBoardId));
    }

    @PutMapping(value = "/{educationBoardId}/deactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EducationBoardResponseDTO> deactivate(@PathVariable Long educationBoardId) {
        return ResponseEntity.ok(educationBoardFacade.deactivate(educationBoardId));
    }
}
