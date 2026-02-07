package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.auth.dtos.auth.requestDto.LoginRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.responseDto.LoginResponseDTO;
import com.smartsolutions.eschool.user.model.RoleEntity;
import com.smartsolutions.eschool.user.model.SystemUserEntity;
import com.smartsolutions.eschool.user.model.UserRoleId;
import com.smartsolutions.eschool.user.model.UserRolesEntity;
import com.smartsolutions.eschool.user.repository.RoleRepository;
import com.smartsolutions.eschool.user.repository.SystemUserRepository;
import com.smartsolutions.eschool.user.repository.UserRolesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SystemUserService {
    private final SystemUserRepository systemUserRepository;
    private final UserRolesRepository userRolesRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public SystemUserService(SystemUserRepository systemUserRepository, 
                             UserRolesRepository userRolesRepository,
                             RoleRepository roleRepository,
                             PasswordEncoder passwordEncoder) {
        this.systemUserRepository = systemUserRepository;
        this.userRolesRepository = userRolesRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @jakarta.transaction.Transactional
    public void assignRoles(Long userId, java.util.Set<Long> roleIds) {
        log.info("Assigning roles {} to user {}", roleIds, userId);
        SystemUserEntity user = systemUserRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + userId));

        // Remove existing roles
        userRolesRepository.deleteByUserId(userId);

        if (roleIds != null && !roleIds.isEmpty()) {
            java.util.List<UserRolesEntity> newRoles = roleIds.stream()
                    .map(roleId -> {
                        RoleEntity role = roleRepository.findById(roleId)
                                .orElseThrow(() -> new RuntimeException("Role not found with id: " + roleId));
                        UserRolesEntity userRole = new UserRolesEntity();
                        userRole.setUser(user);
                        userRole.setRole(role);
                        userRole.setId(new UserRoleId(userId, roleId));
                        return userRole;
                    })
                    .toList();
            userRolesRepository.saveAll(newRoles);
        }
    }

    public LoginResponseDTO getUserByUserName(LoginRequestDTO loginRequestDTO) {
        SystemUserEntity result = systemUserRepository.findByEmail(loginRequestDTO.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        // ... existing code ...
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        responseDTO.setEmail(result.getEmail());
        responseDTO.setOrganizationId(result.getOrganizationId());
        responseDTO.setUserId(result.getId().toString());
        return responseDTO;
    }
}
