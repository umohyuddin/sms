package com.smartsolutions.eschool.util.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsolutions.eschool.user.model.SystemUserEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserDetailsImp implements UserDetails {

    private long id;
    private String username;
    private String email;
    private Long organizationId;
    private Long campusId;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImp(Long id, String username, String email, String password, Long organizationId, Long campusId,
                        Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.organizationId = organizationId;
        this.campusId = campusId;
        this.authorities = authorities;
    }

    public static UserDetailsImp build(SystemUserEntity user) {
        List<GrantedAuthority> authorities = user.getUserRoles().stream()
                .flatMap(ur -> ur.getRole().getPermissions().stream())
                .map(permission -> new SimpleGrantedAuthority(permission.getCode()))
                .collect(Collectors.toList());

        Long campusId = null;
        if (user.getEmployee() != null && user.getEmployee().getAssignments() != null && !user.getEmployee().getAssignments().isEmpty()) {
            campusId = user.getEmployee().getAssignments().stream()
                    .filter(a -> a.getIsPrimary())
                    .findFirst()
                    .map(a -> a.getCampus().getId())
                    .orElse(user.getEmployee().getAssignments().get(0).getCampus().getId());
        } else if (user.getStudent() != null && user.getStudent().getCampus() != null) {
            campusId = user.getStudent().getCampus().getId();
        }

        return new UserDetailsImp(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPasswordHash(),
                user.getOrganizationId(),
                campusId,
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
