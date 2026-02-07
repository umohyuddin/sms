package com.smartsolutions.eschool.user.controller;

import com.smartsolutions.eschool.user.service.SystemUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class SystemUserController {

    private final SystemUserService systemUserService;

    @PutMapping("/{userId}/roles")
    @PreAuthorize("hasAuthority('USER_ASSIGN_ROLE')")
    public ResponseEntity<?> assignRoles(@PathVariable Long userId, @RequestBody Set<Long> roleIds) {
        systemUserService.assignRoles(userId, roleIds);
        return ResponseEntity.ok().build();
    }
}
