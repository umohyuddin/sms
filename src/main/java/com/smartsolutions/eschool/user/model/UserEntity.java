package com.smartsolutions.eschool.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.smartsolutions.eschool.employee.model.EmployeeEntity;
import com.smartsolutions.eschool.school.model.CampusEntity;
import com.smartsolutions.eschool.student.model.StudentEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "emp_id", nullable = false)
    private Long empId;

    @Column(name = "cmp_id", nullable = false)
    private Long cmpId;

    @Column(name = "isactive")
    private boolean isActive;

    @Column(name = "account_non_expired", nullable = false)
    private boolean accountNonExpired;

    @Column(name = "account_non_locked", nullable = false)
    private boolean accountNonLocked;

    @Column(name = "credentials_non_expired", nullable = false)
    private boolean credentialsNonExpired;

    @Email
    @NotBlank
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    @Column(name = "password")
    private String password;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private UserRoleEntity role;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "emp_id", referencedColumnName = "employee_id", insertable = false, updatable = false)
    @JsonIgnore
    private EmployeeEntity employee;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cmp_id", referencedColumnName = "campus_id", insertable = false, updatable = false)
    @JsonIgnore
    private CampusEntity campus;


    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role != null && role.getRoleName() != null) {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return Collections.emptyList();
    }

    @Override
    public String getUsername() {
        return email; // Using email as username
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


}

