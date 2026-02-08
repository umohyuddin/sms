package com.smartsolutions.eschool.auth.controller;

import com.smartsolutions.eschool.auth.dtos.auth.requestDto.LoginRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.responseDto.LoginResponseDTO;
import com.smartsolutions.eschool.auth.facade.AuthFacade;
import com.smartsolutions.eschool.school.dtos.academicYear.requestDto.AcademicYearRequestDTO;
import com.smartsolutions.eschool.school.dtos.academicYear.responseDto.AcademicYearResponseDTO;
import com.smartsolutions.eschool.school.facade.AcademicYearFacade;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@RequestMapping("sms/auth")
@Slf4j
public class AuthController {
    private final AuthFacade authFacade;

    public AuthController(AuthFacade authFacade) {
        this.authFacade = authFacade;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO requestDTO) {
        log.info("POST /sms/auth called for user: {}", requestDTO.getEmail());
        LoginResponseDTO result = authFacade.authenticateUser(requestDTO);
        log.info("POST /sms/auth succeeded for user: {}", requestDTO.getEmail());
        return ResponseEntity.ok(result);
    }
}