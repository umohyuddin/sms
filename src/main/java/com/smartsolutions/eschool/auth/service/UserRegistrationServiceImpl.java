package com.smartsolutions.eschool.auth.service;

import com.smartsolutions.eschool.auth.dtos.auth.requestDto.EmployeeRegistrationRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.requestDto.StudentRegistrationRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.responseDto.UserRegistrationResponseDTO;
import com.smartsolutions.eschool.employee.model.EmployeeMasterEntity;
import com.smartsolutions.eschool.employee.repository.EmployeeMasterRepository;
import com.smartsolutions.eschool.global.exception.ResourceNotFoundException;
import com.smartsolutions.eschool.student.model.StudentEntity;
import com.smartsolutions.eschool.student.repository.StudentRepository;
import com.smartsolutions.eschool.user.model.SystemUserEntity;
import com.smartsolutions.eschool.user.repository.SystemUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserRegistrationServiceImpl implements UserRegistrationService {

    private final SystemUserRepository systemUserRepository;
    private final StudentRepository studentRepository;
    private final EmployeeMasterRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserRegistrationResponseDTO registerStudent(StudentRegistrationRequestDTO requestDTO) {
        log.info("Registering student user for student ID: {}", requestDTO.getStudentId());
        
        // Validate student exists
        StudentEntity student = studentRepository.findById(requestDTO.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + requestDTO.getStudentId()));
        
        // Check if student already has a user account
        if (systemUserRepository.existsByStudentId(requestDTO.getStudentId())) {
            throw new IllegalStateException("User account already exists for this student");
        }
        
        // Validate email and username uniqueness
        if (systemUserRepository.existsByEmail(requestDTO.getEmail())) {
            throw new IllegalStateException("Email already exists");
        }
        if (systemUserRepository.existsByUsername(requestDTO.getUsername())) {
            throw new IllegalStateException("Username already exists");
        }
        
        // Create system user
        SystemUserEntity systemUser = new SystemUserEntity();
        //systemUser.setOrganizationId(student.getOrganizationId());
        systemUser.setUsername(requestDTO.getUsername());
        systemUser.setEmail(requestDTO.getEmail());
        systemUser.setPhone(requestDTO.getPhone());
        systemUser.setPasswordHash(passwordEncoder.encode(requestDTO.getPassword()));
        systemUser.setStudent(student);
        systemUser.setUserType(SystemUserEntity.UserType.STUDENT);
        systemUser.setIsActive(true);
        systemUser.setIsVerified(false);
        
        SystemUserEntity savedUser = systemUserRepository.save(systemUser);
        log.info("Student user account created successfully for student ID: {}", requestDTO.getStudentId());
        
        return mapToResponse(savedUser, student.getStudentCode(), null);
    }

    @Override
    @Transactional
    public UserRegistrationResponseDTO registerEmployee(EmployeeRegistrationRequestDTO requestDTO) {
        log.info("Registering employee user for employee ID: {}", requestDTO.getEmployeeId());
        
        // Validate employee exists
        EmployeeMasterEntity employee = employeeRepository.findById(requestDTO.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with ID: " + requestDTO.getEmployeeId()));
        
        // Check if employee already has a user account
        if (systemUserRepository.existsByEmployeeId(requestDTO.getEmployeeId())) {
            throw new IllegalStateException("User account already exists for this employee");
        }
        
        // Validate email and username uniqueness
        if (systemUserRepository.existsByEmail(requestDTO.getEmail())) {
            throw new IllegalStateException("Email already exists");
        }
        if (systemUserRepository.existsByUsername(requestDTO.getUsername())) {
            throw new IllegalStateException("Username already exists");
        }
        
        // Create system user
        SystemUserEntity systemUser = new SystemUserEntity();
        systemUser.setOrganizationId(employee.getOrganizationId());
        systemUser.setUsername(requestDTO.getUsername());
        systemUser.setEmail(requestDTO.getEmail());
        systemUser.setPhone(requestDTO.getPhone());
        systemUser.setPasswordHash(passwordEncoder.encode(requestDTO.getPassword()));
        systemUser.setEmployee(employee);
        systemUser.setUserType(SystemUserEntity.UserType.EMPLOYEE);
        systemUser.setIsActive(true);
        systemUser.setIsVerified(false);
        
        SystemUserEntity savedUser = systemUserRepository.save(systemUser);
        log.info("Employee user account created successfully for employee ID: {}", requestDTO.getEmployeeId());
        
        return mapToResponse(savedUser, null, employee.getEmployeeCode());
    }

    @Override
    public boolean emailExists(String email) {
        return systemUserRepository.existsByEmail(email);
    }

    @Override
    public boolean usernameExists(String username) {
        return systemUserRepository.existsByUsername(username);
    }

    private UserRegistrationResponseDTO mapToResponse(SystemUserEntity user, String studentCode, String employeeCode) {
        UserRegistrationResponseDTO response = new UserRegistrationResponseDTO();
        response.setUserId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setUserType(user.getUserType());
        response.setIsActive(user.getIsActive());
        response.setIsVerified(user.getIsVerified());
        
        if (user.getEmployee() != null) {
            response.setEmployeeId(user.getEmployee().getId());
            response.setEmployeeCode(employeeCode);
        }
        if (user.getStudent() != null) {
            response.setStudentId(user.getStudent().getId());
            response.setStudentCode(studentCode);
        }
        
        response.setMessage("User account created successfully. Please verify your email.");
        return response;
    }
}
