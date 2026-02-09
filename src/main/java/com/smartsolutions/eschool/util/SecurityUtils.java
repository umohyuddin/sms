package com.smartsolutions.eschool.util;

import com.smartsolutions.eschool.util.jwt.UserDetailsImp;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {

    public static Long getCurrentOrganizationId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetailsImp) {
            UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();
            return userDetails.getOrganizationId();
        }
        return null;
    }

    public static Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetailsImp) {
            UserDetailsImp userDetails = (UserDetailsImp) authentication.getPrincipal();
            return userDetails.getId();
        }
        return null;
    }
}
