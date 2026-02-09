package com.smartsolutions.eschool.auth.service;

import com.smartsolutions.eschool.auth.dtos.auth.requestDto.EmployeeRegistrationRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.requestDto.StudentRegistrationRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.responseDto.UserRegistrationResponseDTO;

public interface UserRegistrationService {
    
    /**
     * Register a student user account
     */
    UserRegistrationResponseDTO registerStudent(StudentRegistrationRequestDTO requestDTO);
    
    /**
     * Register an employee user account
     */
    UserRegistrationResponseDTO registerEmployee(EmployeeRegistrationRequestDTO requestDTO);
    
    /**
     * Check if email already exists
     */
    boolean emailExists(String email);
    
    /**
     * Check if username already exists
     */
    boolean usernameExists(String username);
}
