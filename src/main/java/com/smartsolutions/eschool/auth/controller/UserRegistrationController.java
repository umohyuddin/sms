package com.smartsolutions.eschool.auth.controller;

import com.smartsolutions.eschool.auth.dtos.auth.requestDto.EmployeeRegistrationRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.requestDto.StudentRegistrationRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.responseDto.UserRegistrationResponseDTO;
import com.smartsolutions.eschool.auth.service.UserRegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.smartsolutions.eschool.global.error.ErrorResponse;

@Transactional
@RestController
@RequestMapping("sms/user-registration")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "User Registration", description = "Endpoints for student and employee self-registration and account checks.")
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;

    @Operation(summary = "Register Student", description = "Register a new student user account.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student registered successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserRegistrationResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid registration data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRegistrationResponseDTO> registerStudent(
            @RequestBody @Valid StudentRegistrationRequestDTO requestDTO) {
        log.info("POST /sms/user-registration/student called for student ID: {}", requestDTO.getStudentId());
        UserRegistrationResponseDTO response = userRegistrationService.registerStudent(requestDTO);
        log.info("Student user registration succeeded");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Register Employee", description = "Register a new employee user account.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee registered successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserRegistrationResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid registration data",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRegistrationResponseDTO> registerEmployee(
            @RequestBody @Valid EmployeeRegistrationRequestDTO requestDTO) {
        log.info("POST /sms/user-registration/employee called for employee ID: {}", requestDTO.getEmployeeId());
        UserRegistrationResponseDTO response = userRegistrationService.registerEmployee(requestDTO);
        log.info("Employee user registration succeeded");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(summary = "Check Email Existence", description = "Verify if an email is already registered in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Check completed successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/check-email", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> checkEmailExists(
            @Parameter(description = "Email address to check", example = "user@example.com") @RequestParam String email) {
        boolean exists = userRegistrationService.emailExists(email);
        return ResponseEntity.ok(exists);
    }

    @Operation(summary = "Check Username Existence", description = "Verify if a username is already taken.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Check completed successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping(value = "/check-username", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> checkUsernameExists(
            @Parameter(description = "Username to check", example = "john_doe") @RequestParam String username) {
        boolean exists = userRegistrationService.usernameExists(username);
        return ResponseEntity.ok(exists);
    }
}
