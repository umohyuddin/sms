package com.smartsolutions.eschool.auth.controller;

import com.smartsolutions.eschool.auth.dtos.auth.requestDto.LoginRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.responseDto.LoginResponseDTO;
import com.smartsolutions.eschool.auth.facade.AuthFacade;
import com.smartsolutions.eschool.school.dtos.academicYear.requestDto.AcademicYearRequestDTO;
import com.smartsolutions.eschool.school.dtos.academicYear.responseDto.AcademicYearResponseDTO;
import com.smartsolutions.eschool.school.facade.AcademicYearFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.smartsolutions.eschool.global.error.ErrorResponse;

import com.smartsolutions.eschool.global.error.ErrorResponse;

@Transactional
@RestController
@RequestMapping("sms/auth")
@Slf4j
@Tag(name = "Authentication", description = "Endpoints for user authentication and login.")
public class AuthController {
    private final AuthFacade authFacade;

    public AuthController(AuthFacade authFacade) {
        this.authFacade = authFacade;
    }

    @Operation(summary = "User Login", description = "Authenticate user with email and password to receive a JWT token.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully authenticated",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LoginResponseDTO.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized - Invalid credentials",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO requestDTO) {
        log.info("POST /sms/auth (JSON) called for user: {}", requestDTO.getEmail());
        LoginResponseDTO result = authFacade.authenticateUser(requestDTO);
        log.info("POST /sms/auth (JSON) succeeded for user: {}", requestDTO.getEmail());
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "User Login (Form)", description = "OAuth2 compatible login endpoint for Swagger UI.")
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginResponseDTO> loginForm(
            @Parameter(description = "Username or Email") @RequestParam("username") String username,
            @Parameter(description = "User Password") @RequestParam("password") String password) {
        log.info("POST /sms/auth (Form) called for user: {}", username);
        LoginRequestDTO requestDTO = new LoginRequestDTO();
        requestDTO.setEmail(username);
        requestDTO.setPassword(password);
        LoginResponseDTO result = authFacade.authenticateUser(requestDTO);
        log.info("POST /sms/auth (Form) succeeded for user: {}", username);
        return ResponseEntity.ok(result);
    }
}
