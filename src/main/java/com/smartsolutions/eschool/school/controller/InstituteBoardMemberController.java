package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.boardMembers.request.InstituteBoardMemberRequestDTO;
import com.smartsolutions.eschool.school.dtos.boardMembers.response.InstituteBoardMemberResponseDTO;
import com.smartsolutions.eschool.school.facade.InstituteBoardMemberFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institute/board-members")
@Tag(name = "Institute Board Members", description = "Endpoints for managing institute-level board members")
@Slf4j
public class InstituteBoardMemberController {

    private final InstituteBoardMemberFacade memberFacade;

    public InstituteBoardMemberController(InstituteBoardMemberFacade memberFacade) {
        this.memberFacade = memberFacade;
    }

    @GetMapping
    @Operation(summary = "Get all board members", description = "Retrieves a list of all active board members for the current organization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "403", description = "Access denied")
    })
    public List<InstituteBoardMemberResponseDTO> getAll() {
        log.info("[Controller:InstituteBoardMemberController] GET /api/institute/board-members - Fetching all");
        return memberFacade.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a board member by ID", description = "Retrieves details of a specific board member")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved member"),
            @ApiResponse(responseCode = "404", description = "Member not found")
    })
    public InstituteBoardMemberResponseDTO getById(
            @Parameter(description = "ID of the member", example = "1") @PathVariable Long id) {
        log.info("[Controller:InstituteBoardMemberController] GET /api/institute/board-members/{} - Fetching by ID", id);
        return memberFacade.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new board member", description = "Registers a new board member for the current organization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    public InstituteBoardMemberResponseDTO create(
            @Valid @RequestBody InstituteBoardMemberRequestDTO requestDTO) {
        log.info("[Controller:InstituteBoardMemberController] POST /api/institute/board-members - Adding member");
        return memberFacade.create(requestDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing board member", description = "Updates the details of an existing board member")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "404", description = "Member not found")
    })
    public InstituteBoardMemberResponseDTO update(
            @Parameter(description = "ID of the member to update", example = "1") @PathVariable Long id,
            @Valid @RequestBody InstituteBoardMemberRequestDTO requestDTO) {
        log.info("[Controller:InstituteBoardMemberController] PUT /api/institute/board-members/{} - Updating member", id);
        return memberFacade.update(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Soft delete a board member", description = "Marks a board member as deleted")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Member not found")
    })
    public void delete(
            @Parameter(description = "ID of the member to delete", example = "1") @PathVariable Long id) {
        log.info("[Controller:InstituteBoardMemberController] DELETE /api/institute/board-members/{} - Deleting member", id);
        memberFacade.delete(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Search board members", description = "Searches for board members by keyword (name or email)")
    public List<InstituteBoardMemberResponseDTO> search(
            @Parameter(description = "Keyword to search for", example = "Doe") @RequestParam String keyword) {
        log.info("[Controller:InstituteBoardMemberController] GET /api/institute/board-members/search?keyword={} - Searching", keyword);
        return memberFacade.search(keyword);
    }
}
