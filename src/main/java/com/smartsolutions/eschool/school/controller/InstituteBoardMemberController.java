package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.instituteBoardMembers.requestDto.InstituteBoardMemberCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBoardMembers.requestDto.InstituteBoardMemberUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteBoardMembers.responseDto.InstituteBoardMemberResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteBoardMemberFacade;
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
@RequestMapping("/api/institute/board-members")
@Slf4j
public class InstituteBoardMemberController {

    private final InstituteBoardMemberFacade instituteBoardMemberFacade;

    public InstituteBoardMemberController(InstituteBoardMemberFacade instituteBoardMemberFacade) {
        this.instituteBoardMemberFacade = instituteBoardMemberFacade;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteBoardMemberResponseDTO> createBoardMember(@Valid @RequestBody InstituteBoardMemberCreateRequestDTO requestDTO) {
        InstituteBoardMemberResponseDTO responseDTO = instituteBoardMemberFacade.createBoardMember(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<InstituteBoardMemberResponseDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(instituteBoardMemberFacade.getAll(pageable));
    }

    @GetMapping(value = "/institute/{instituteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<InstituteBoardMemberResponseDTO>> getByInstituteId(@PathVariable Long instituteId, Pageable pageable) {
        return ResponseEntity.ok(instituteBoardMemberFacade.getByInstituteId(instituteId, pageable));
    }

    @GetMapping(value = "/active", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteBoardMemberResponseDTO>> getAllActive() {
        return ResponseEntity.ok(instituteBoardMemberFacade.getAllActive());
    }

    @GetMapping(value = "/{memberId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteBoardMemberResponseDTO> getById(@PathVariable Long memberId) {
        return ResponseEntity.ok(instituteBoardMemberFacade.getById(memberId));
    }

    @PutMapping(value = "/{memberId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteBoardMemberResponseDTO> updateBoardMember(@PathVariable Long memberId, @Valid @RequestBody InstituteBoardMemberUpdateRequestDTO requestDTO) {
        return ResponseEntity.ok(instituteBoardMemberFacade.updateBoardMember(memberId, requestDTO));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> deleteBoardMember(@PathVariable Long memberId) {
        instituteBoardMemberFacade.deleteById(memberId);
        return ResponseEntity.ok("Institute board member deleted successfully");
    }

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstituteBoardMemberResponseDTO>> search(@RequestParam(name = "keyword") String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(instituteBoardMemberFacade.searchByKeyword(keyword.trim()));
    }

    @PutMapping(value = "/{memberId}/activate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteBoardMemberResponseDTO> activate(@PathVariable Long memberId) {
        return ResponseEntity.ok(instituteBoardMemberFacade.activate(memberId));
    }

    @PutMapping(value = "/{memberId}/deactivate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstituteBoardMemberResponseDTO> deactivate(@PathVariable Long memberId) {
        return ResponseEntity.ok(instituteBoardMemberFacade.deactivate(memberId));
    }
}
