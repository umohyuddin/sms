package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.requestDto.InstituteDocumentUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteDocuments.responseDto.InstituteDocumentResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteDocumentFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/documents")
@Slf4j
public class InstituteDocumentController {

    private final InstituteDocumentFacade instituteDocumentFacade;

    public InstituteDocumentController(InstituteDocumentFacade instituteDocumentFacade) {
        this.instituteDocumentFacade = instituteDocumentFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteDocumentResponseDTO> createDocument(@Valid @RequestBody InstituteDocumentCreateRequestDTO requestDTO) {
        InstituteDocumentResponseDTO responseDTO = instituteDocumentFacade.createDocument(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteDocumentResponseDTO>> getAll() {
        return ResponseEntity.ok(instituteDocumentFacade.getAll());
    }

    @GetMapping(value = "/institute/{instituteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteDocumentResponseDTO>> getByInstituteId(@PathVariable Long instituteId) {
        return ResponseEntity.ok(instituteDocumentFacade.getByInstituteId(instituteId));
    }

    @GetMapping(value = "/{documentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteDocumentResponseDTO> getById(@PathVariable Long documentId) {
        return ResponseEntity.ok(instituteDocumentFacade.getById(documentId));
    }

    @PutMapping(value = "/{documentId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteDocumentResponseDTO> updateDocument(@PathVariable Long documentId, @Valid @RequestBody InstituteDocumentUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(instituteDocumentFacade.updateDocument(documentId, requestDTO));
    }

    @DeleteMapping("/{documentId}")
    public ResponseEntity<String> deleteDocument(@PathVariable Long documentId) {
        instituteDocumentFacade.deleteById(documentId);
        return ResponseEntity.ok("Institute document deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteDocumentResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(instituteDocumentFacade.searchByKeyword(keyword.trim()));
    }
}
