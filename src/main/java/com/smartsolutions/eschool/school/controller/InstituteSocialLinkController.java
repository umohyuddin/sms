package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.requestDto.InstituteSocialLinkUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteSocialLinks.responseDto.InstituteSocialLinkResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteSocialLinkFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/social-links")
@Slf4j
public class InstituteSocialLinkController {

    private final InstituteSocialLinkFacade instituteSocialLinkFacade;

    public InstituteSocialLinkController(InstituteSocialLinkFacade instituteSocialLinkFacade) {
        this.instituteSocialLinkFacade = instituteSocialLinkFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteSocialLinkResponseDTO> createSocialLink(@Valid @RequestBody InstituteSocialLinkCreateRequestDTO requestDTO) {
        InstituteSocialLinkResponseDTO responseDTO = instituteSocialLinkFacade.createSocialLink(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteSocialLinkResponseDTO>> getAll(@RequestParam Long instituteId) {
        return ResponseEntity.ok(instituteSocialLinkFacade.getAll(instituteId));
    }

    @GetMapping(value = "/institute/{instituteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteSocialLinkResponseDTO>> getByInstituteId(@PathVariable Long instituteId) {
        return ResponseEntity.ok(instituteSocialLinkFacade.getByInstituteId(instituteId));
    }

    @GetMapping(value = "/{socialLinkId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteSocialLinkResponseDTO> getById(@PathVariable Long socialLinkId,
                                                                  @RequestParam Long instituteId) {
        return ResponseEntity.ok(instituteSocialLinkFacade.getById(socialLinkId, instituteId));
    }

    @PutMapping(value = "/{socialLinkId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteSocialLinkResponseDTO> updateSocialLink(@PathVariable Long socialLinkId,
                                                                           @RequestParam Long instituteId,
                                                                           @Valid @RequestBody InstituteSocialLinkUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(instituteSocialLinkFacade.updateSocialLink(socialLinkId, instituteId, requestDTO));
    }

    @DeleteMapping("/{socialLinkId}")
    public ResponseEntity<String> deleteSocialLink(@PathVariable Long socialLinkId,
                                                   @RequestParam Long instituteId) {
        instituteSocialLinkFacade.deleteById(socialLinkId, instituteId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteSocialLinkResponseDTO>> search(@RequestParam(name = "keyword") String keyword,
                                                                       @RequestParam Long instituteId) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(instituteSocialLinkFacade.searchByKeyword(keyword.trim(), instituteId));
    }
}
