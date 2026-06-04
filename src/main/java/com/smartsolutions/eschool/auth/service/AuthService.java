package com.smartsolutions.eschool.auth.service;

import com.smartsolutions.eschool.auth.dtos.auth.requestDto.LoginRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.responseDto.LoginResponseDTO;
import com.smartsolutions.eschool.auth.facade.AuthFacade;
import com.smartsolutions.eschool.school.dtos.academicYear.requestDto.AcademicYearRequestDTO;
import com.smartsolutions.eschool.util.jwt.JwtUtil;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class AuthService {

    private final JwtUtil jwtUtil;

    public AuthService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public String auth(@Valid LoginResponseDTO requestDTO) {
        log.info("Creating JWT token for user ID: {} and organization ID: {}", requestDTO.getUserId(), requestDTO.getOrganizationId());
        Map<String, Object> claims = new HashMap<>();
        claims.put("organizationId", requestDTO.getOrganizationId());
        claims.put("userId", requestDTO.getUserId());
        claims.put("email", requestDTO.getEmail());
        String jwtToken = jwtUtil.createToken(claims);
        log.info("JWT token created successfully");
        return jwtToken;
    }
}
