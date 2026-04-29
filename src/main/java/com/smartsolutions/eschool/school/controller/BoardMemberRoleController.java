package com.smartsolutions.eschool.school.controller;

import com.smartsolutions.eschool.school.dtos.boardMemberRoles.request.BoardMemberRoleRequestDTO;
import com.smartsolutions.eschool.school.dtos.boardMemberRoles.response.BoardMemberRoleResponseDTO;
import com.smartsolutions.eschool.school.facade.BoardMemberRoleFacade;
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
@RequestMapping("/api/institute/board-member-roles")
@Tag(name = "Board Member Roles", description = "Endpoints for managing board member roles within an organization")
@Slf4j
public class BoardMemberRoleController {

    private final BoardMemberRoleFacade roleFacade;

    public BoardMemberRoleController(BoardMemberRoleFacade roleFacade) {
        this.roleFacade = roleFacade;
    }

    @GetMapping
    @Operation(summary = "Get all board member roles", description = "Retrieves a list of all active board member roles for the current organization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "403", description = "Access denied")
    })
    public List<BoardMemberRoleResponseDTO> getAll() {
        log.info("[Controller:BoardMemberRoleController] GET /api/institute/board-member-roles - Fetching all");
        return roleFacade.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a board member role by ID", description = "Retrieves details of a specific board member role by its unique identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved role"),
            @ApiResponse(responseCode = "404", description = "Role not found")
    })
    public BoardMemberRoleResponseDTO getById(
            @Parameter(description = "ID of the role", example = "1") @PathVariable Long id) {
        log.info("[Controller:BoardMemberRoleController] GET /api/institute/board-member-roles/{} - Fetching by ID", id);
        return roleFacade.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new board member role", description = "Registers a new board member role for the current organization")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid request data"),
            @ApiResponse(responseCode = "409", description = "Role code already exists")
    })
    public BoardMemberRoleResponseDTO create(
            @Valid @RequestBody BoardMemberRoleRequestDTO requestDTO) {
        log.info("[Controller:BoardMemberRoleController] POST /api/institute/board-member-roles - Creating role");
        return roleFacade.create(requestDTO);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing board member role", description = "Updates the details of an existing board member role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated"),
            @ApiResponse(responseCode = "404", description = "Role not found"),
            @ApiResponse(responseCode = "409", description = "Role code already exists")
    })
    public BoardMemberRoleResponseDTO update(
            @Parameter(description = "ID of the role to update", example = "1") @PathVariable Long id,
            @Valid @RequestBody BoardMemberRoleRequestDTO requestDTO) {
        log.info("[Controller:BoardMemberRoleController] PUT /api/institute/board-member-roles/{} - Updating role", id);
        return roleFacade.update(id, requestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Soft delete a board member role", description = "Marks a board member role as deleted without removing it from the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Role not found")
    })
    public void delete(
            @Parameter(description = "ID of the role to delete", example = "1") @PathVariable Long id) {
        log.info("[Controller:BoardMemberRoleController] DELETE /api/institute/board-member-roles/{} - Deleting role", id);
        roleFacade.delete(id);
    }

    @GetMapping("/search")
    @Operation(summary = "Search board member roles", description = "Searches for board member roles by keyword (name or code)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Search results retrieved")
    })
    public List<BoardMemberRoleResponseDTO> search(
            @Parameter(description = "Keyword to search for", example = "Chair") @RequestParam String keyword) {
        log.info("[Controller:BoardMemberRoleController] GET /api/institute/board-member-roles/search?keyword={} - Searching", keyword);
        return roleFacade.search(keyword);
    }
}
