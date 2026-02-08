package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.user.service.SystemUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "User Management", description = "Endpoints for managing system users")
public class SystemUserController {

    private final SystemUserService systemUserService;

    @Operation(summary = "Assign roles to a user")
    @PutMapping("/{userId}/roles")
    public ResponseEntity<?> assignRoles(@PathVariable Long userId, @RequestBody Set<Long> roleIds) {
        log.info("PUT /api/v1/users/{}/roles called", userId);
        systemUserService.assignRoles(userId, roleIds);
        log.info("PUT /api/v1/users/{}/roles succeeded", userId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Search users")
    @GetMapping("/search")
    public ResponseEntity<?> searchUsers(@RequestParam(name = "keyword") String keyword) {
        log.info("GET /api/v1/users/search called with keyword: {}", keyword);
        java.util.List<?> resources = systemUserService.searchByKeyword(keyword);
        log.info("GET /api/v1/users/search succeeded, returned {} resources", resources.size());
        return ResponseEntity.ok(resources);
    }
}
