package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.requestDto.InstituteContactUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteContacts.responseDto.InstituteContactResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteContactFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/contacts")
@Slf4j
public class InstituteContactController {

    private final InstituteContactFacade instituteContactFacade;

    public InstituteContactController(InstituteContactFacade instituteContactFacade) {
        this.instituteContactFacade = instituteContactFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteContactResponseDTO> createContact(@Valid @RequestBody InstituteContactCreateRequestDTO requestDTO) {
        InstituteContactResponseDTO responseDTO = instituteContactFacade.createContact(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<InstituteContactResponseDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(instituteContactFacade.getAll(pageable));
    }

    @GetMapping(value = "/institute/{instituteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<InstituteContactResponseDTO>> getByInstituteId(@PathVariable Long instituteId, Pageable pageable) {
        return ResponseEntity.ok(instituteContactFacade.getByInstituteId(instituteId, pageable));
    }

    @GetMapping(value = "/{contactId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteContactResponseDTO> getById(@PathVariable Long contactId) {
        return ResponseEntity.ok(instituteContactFacade.getById(contactId));
    }

    @PutMapping(value = "/{contactId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteContactResponseDTO> updateContact(@PathVariable Long contactId, @Valid @RequestBody InstituteContactUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(instituteContactFacade.updateContact(contactId, requestDTO));
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<String> deleteContact(@PathVariable Long contactId) {
        instituteContactFacade.deleteById(contactId);
        return ResponseEntity.ok("Institute contact deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteContactResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(instituteContactFacade.searchByKeyword(keyword.trim()));
    }
}
