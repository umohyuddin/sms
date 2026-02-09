package com.smartsolutions.eschool.util;

import com.smartsolutions.eschool.util.jwt.UserDetailsImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

class SecurityUtilsTest {

    private SecurityContext securityContext;
    private Authentication authentication;
    private UserDetailsImp userDetails;

    @BeforeEach
    void setUp() {
        securityContext = mock(SecurityContext.class);
        authentication = mock(Authentication.class);
        userDetails = mock(UserDetailsImp.class);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    void getCurrentOrganizationId_ShouldReturnOrgId_WhenUserIsAuthenticated() {
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(userDetails.getOrganizationId()).thenReturn(100L);

        Long orgId = SecurityUtils.getCurrentOrganizationId();

        assertEquals(100L, orgId);
    }

    @Test
    void getCurrentOrganizationId_ShouldReturnNull_WhenNotAuthenticated() {
        when(securityContext.getAuthentication()).thenReturn(null);

        Long orgId = SecurityUtils.getCurrentOrganizationId();

        assertNull(orgId);
    }

    @Test
    void getCurrentUserId_ShouldReturnUserId_WhenUserIsAuthenticated() {
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getPrincipal()).thenReturn(userDetails);
        when(userDetails.getId()).thenReturn(1L);

        Long userId = SecurityUtils.getCurrentUserId();

        assertEquals(1L, userId);
    }

    @Test
    void getCurrentUserId_ShouldReturnDefault_WhenNotAuthenticated() {
        when(securityContext.getAuthentication()).thenReturn(null);

        Long userId = SecurityUtils.getCurrentUserId();

        assertEquals(1L, userId); // Default value set in SecurityUtils
    }
}
