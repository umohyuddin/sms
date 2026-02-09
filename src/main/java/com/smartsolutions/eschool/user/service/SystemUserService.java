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
import org.springframework.transaction.annotation.Transactional;

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
        log.info("Assigning roles to user ID: {} in database", userId);
        try {
            SystemUserEntity user = systemUserRepository.findById(userId)
                    .orElseThrow(() -> {
                        log.warn("User not found with ID: {}", userId);
                        return new UsernameNotFoundException("User not found with id: " + userId);
                    });

            // Remove existing roles
            log.info("Removing existing roles for user ID: {}", userId);
            userRolesRepository.deleteByUserId(userId);

            if (roleIds != null && !roleIds.isEmpty()) {
                log.info("Assigning {} new roles to user ID: {}", roleIds.size(), userId);
                java.util.List<UserRolesEntity> newRoles = roleIds.stream()
                        .map(roleId -> {
                            RoleEntity role = roleRepository.findById(roleId)
                                    .orElseThrow(() -> {
                                        log.warn("Role not found with ID: {}", roleId);
                                        return new RuntimeException("Role not found with id: " + roleId);
                                    });
                            UserRolesEntity userRole = new UserRolesEntity();
                            userRole.setUser(user);
                            userRole.setRole(role);
                            userRole.setId(new UserRoleId(userId, roleId));
                            return userRole;
                        })
                        .toList();
                userRolesRepository.saveAll(newRoles);
            }
            log.info("Successfully assigned roles to user ID: {}", userId);
        } catch (Exception e) {
            log.error("Unexpected error while assigning roles to user ID: {}", userId, e);
            throw e;
        }
    }

@Transactional(readOnly = true)
    public java.util.List<SystemUserEntity> searchByKeyword(String keyword) {
        try {
            String searchKey = keyword == null ? "" : keyword.trim();
            log.info("Fetching Users based on search from database with keyword: '{}'", searchKey);
            java.util.List<SystemUserEntity> result = systemUserRepository.searchByKeyword(searchKey);
            log.info("Successfully fetched {} Users based on search", result.size());
            return result;
        } catch (Exception e) {
            log.error("Unexpected error while searching Users", e);
            return java.util.Collections.emptyList();
        }
    }

    public LoginResponseDTO getUserByUserName(LoginRequestDTO loginRequestDTO) {
        log.info("Fetching user by email: {}", loginRequestDTO.getEmail());
        SystemUserEntity result = systemUserRepository.findByEmail(loginRequestDTO.getEmail())
                .orElseThrow(() -> {
                    log.warn("User not found with email: {}", loginRequestDTO.getEmail());
                    return new UsernameNotFoundException("User not found");
                });
        
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        responseDTO.setEmail(result.getEmail());
        responseDTO.setUsername(result.getUsername());
        responseDTO.setOrganizationId(result.getOrganizationId());
        responseDTO.setUserId(result.getId().toString());
        responseDTO.setUserType(result.getUserType());
        
        // Set employee or student information
        if (result.getEmployee() != null) {
            responseDTO.setEmployeeId(result.getEmployee().getId());
            responseDTO.setEmployeeCode(result.getEmployee().getEmployeeCode());
        }
        if (result.getStudent() != null) {
            responseDTO.setStudentId(result.getStudent().getId());
            responseDTO.setStudentCode(result.getStudent().getStudentCode());
        }
        
        log.info("Successfully fetched user data for email: {}", loginRequestDTO.getEmail());
        return responseDTO;
    }
}
