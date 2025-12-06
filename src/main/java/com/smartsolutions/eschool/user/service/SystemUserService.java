package com.smartsolutions.eschool.user.service;

import com.smartsolutions.eschool.auth.dtos.auth.requestDto.LoginRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.responseDto.LoginResponseDTO;
import com.smartsolutions.eschool.user.model.SystemUserEntity;
import com.smartsolutions.eschool.user.repository.SystemUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SystemUserService {
    private final SystemUserRepository systemUserRepository;

    private final PasswordEncoder passwordEncoder;
    public SystemUserService(SystemUserRepository systemUserRepository, PasswordEncoder passwordEncoder) {
        this.systemUserRepository = systemUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public LoginResponseDTO getUserByUserName(LoginRequestDTO loginRequestDTO) {
        SystemUserEntity result = systemUserRepository.findByEmail(loginRequestDTO.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        // Validate password
//        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), result.getPasswordHash())) {
//            throw new RuntimeException("Invalid credentials"); // you can create custom exception
//        }
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        responseDTO.setEmail(result.getEmail());
        return responseDTO;
    }
}
