package com.smartsolutions.eschool.auth.controller;

import com.smartsolutions.eschool.auth.dtos.auth.requestDto.EmployeeRegistrationRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.requestDto.StudentRegistrationRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.responseDto.UserRegistrationResponseDTO;
import com.smartsolutions.eschool.auth.service.UserRegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@RequestMapping("sms/user-registration")
@Slf4j
@RequiredArgsConstructor
public class UserRegistrationController {

    private final UserRegistrationService userRegistrationService;

    @PostMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRegistrationResponseDTO> registerStudent(
            @RequestBody @Valid StudentRegistrationRequestDTO requestDTO) {
        log.info("POST /sms/user-registration/student called for student ID: {}", requestDTO.getStudentId());
        UserRegistrationResponseDTO response = userRegistrationService.registerStudent(requestDTO);
        log.info("Student user registration succeeded");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRegistrationResponseDTO> registerEmployee(
            @RequestBody @Valid EmployeeRegistrationRequestDTO requestDTO) {
        log.info("POST /sms/user-registration/employee called for employee ID: {}", requestDTO.getEmployeeId());
        UserRegistrationResponseDTO response = userRegistrationService.registerEmployee(requestDTO);
        log.info("Employee user registration succeeded");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping(value = "/check-email", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> checkEmailExists(@RequestParam String email) {
        boolean exists = userRegistrationService.emailExists(email);
        return ResponseEntity.ok(exists);
    }

    @GetMapping(value = "/check-username", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> checkUsernameExists(@RequestParam String username) {
        boolean exists = userRegistrationService.usernameExists(username);
        return ResponseEntity.ok(exists);
    }
}
