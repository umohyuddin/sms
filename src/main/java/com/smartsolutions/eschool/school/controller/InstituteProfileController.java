package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.instituteProfiles.requestDto.InstituteProfileCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteProfiles.requestDto.InstituteProfileUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteProfiles.responseDto.InstituteProfileResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteProfileFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/profiles")
@Slf4j
public class InstituteProfileController {

    private final InstituteProfileFacade instituteProfileFacade;

    public InstituteProfileController(InstituteProfileFacade instituteProfileFacade) {
        this.instituteProfileFacade = instituteProfileFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteProfileResponseDTO> createProfile(@Valid @RequestBody InstituteProfileCreateRequestDTO requestDTO) {
        InstituteProfileResponseDTO responseDTO = instituteProfileFacade.createProfile(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(value = "/{profileId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteProfileResponseDTO> getById(@PathVariable Long profileId) {
        return ResponseEntity.ok(instituteProfileFacade.getById(profileId));
    }

    @GetMapping(value = "/institute/{instituteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteProfileResponseDTO> getByInstituteId(@PathVariable Long instituteId) {
        return ResponseEntity.ok(instituteProfileFacade.getByInstituteId(instituteId));
    }

    @PutMapping(value = "/{profileId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteProfileResponseDTO> updateProfile(@PathVariable Long profileId, @Valid @RequestBody InstituteProfileUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(instituteProfileFacade.updateProfile(profileId, requestDTO));
    }

    @DeleteMapping("/{profileId}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long profileId) {
        instituteProfileFacade.deleteById(profileId);
        return ResponseEntity.ok("Institute profile deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteProfileResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(instituteProfileFacade.searchByKeyword(keyword.trim()));
    }
}
