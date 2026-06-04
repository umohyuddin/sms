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
    public ResponseEntity<InstituteSocialLinkResponseDTO> createSocialLink(
            @Valid @RequestBody InstituteSocialLinkCreateRequestDTO requestDTO) {
        log.info(
                "[Controller:InstituteSocialLinkController] createSocialLink() called - Request to create social link");
        InstituteSocialLinkResponseDTO responseDTO = instituteSocialLinkFacade.createSocialLink(requestDTO);
        log.info(
                "[Controller:InstituteSocialLinkController] createSocialLink() succeeded - Social link created successfully: {}",
                responseDTO.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteSocialLinkResponseDTO>> getAll() {
        log.info("[Controller:InstituteSocialLinkController] getAll() called - Request to get all social links");
        List<InstituteSocialLinkResponseDTO> responseDTOs = instituteSocialLinkFacade.getAll();
        log.info("[Controller:InstituteSocialLinkController] getAll() succeeded - Found {} social links",
                responseDTOs.size());
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping(value = "/institute", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteSocialLinkResponseDTO>> getByInstituteId() {
        log.info("Request to get social links by institute");
        List<InstituteSocialLinkResponseDTO> responseDTOs = instituteSocialLinkFacade.getByInstituteId();
        log.info("Found {} social links by instituteId", responseDTOs.size());
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping(value = "/{socialLinkId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteSocialLinkResponseDTO> getById(@PathVariable Long socialLinkId) {
        log.info("[Controller:InstituteSocialLinkController] getById() called - Request to get social link by id: {}",
                socialLinkId);
        InstituteSocialLinkResponseDTO responseDTO = instituteSocialLinkFacade.getById(socialLinkId);
        log.info("[Controller:InstituteSocialLinkController] getById() succeeded - Found social link: {}",
                socialLinkId);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping(value = "/{socialLinkId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteSocialLinkResponseDTO> updateSocialLink(@PathVariable Long socialLinkId,
                                                                           @Valid @RequestBody InstituteSocialLinkUpdateRequestDTO requestDTO) {
        log.info(
                "[Controller:InstituteSocialLinkController] updateSocialLink() called - Request to update social link: {} with data: {}",
                socialLinkId, requestDTO);
        InstituteSocialLinkResponseDTO responseDTO = instituteSocialLinkFacade.updateSocialLink(socialLinkId,
                requestDTO);
        log.info(
                "[Controller:InstituteSocialLinkController] updateSocialLink() succeeded - Social link: {} updated successfully",
                socialLinkId);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{socialLinkId}")
    public ResponseEntity<String> deleteSocialLink(@PathVariable Long socialLinkId) {
        log.info(
                "[Controller:InstituteSocialLinkController] deleteSocialLink() called - Request to delete social link: {}",
                socialLinkId);
        instituteSocialLinkFacade.deleteById(socialLinkId);
        log.info(
                "[Controller:InstituteSocialLinkController] deleteSocialLink() succeeded - Social link: {} deleted successfully",
                socialLinkId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteSocialLinkResponseDTO>> search(
            @RequestParam(name = "keyword") String keyword) {
        log.info(
                "[Controller:InstituteSocialLinkController] search() called - Request to search social links with keyword: {}",
                keyword);
        if (keyword == null || keyword.trim().isEmpty()) {
            log.warn("[Controller:InstituteSocialLinkController] search() failed - Search keyword is null or empty");
            return ResponseEntity.badRequest().build();
        }
        List<InstituteSocialLinkResponseDTO> responseDTOs = instituteSocialLinkFacade
                .searchByKeyword(keyword.trim());
        log.info(
                "[Controller:InstituteSocialLinkController] search() succeeded - Found {} social links matching keyword: {}",
                responseDTOs.size(), keyword);
        return ResponseEntity.ok(responseDTOs);
    }
}
