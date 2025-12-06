package com.smartsolutions.eschool.auth.facade;

import com.smartsolutions.eschool.auth.dtos.auth.requestDto.LoginRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.responseDto.LoginResponseDTO;
import com.smartsolutions.eschool.auth.service.AuthService;
import com.smartsolutions.eschool.school.dtos.academicYear.requestDto.AcademicYearRequestDTO;
import com.smartsolutions.eschool.school.dtos.academicYear.responseDto.AcademicYearResponseDTO;
import com.smartsolutions.eschool.school.service.AcademicYearService;
import com.smartsolutions.eschool.user.service.SystemUserService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class AuthFacade {


    private final AuthService authService;
    private final SystemUserService systemUserService;

    public AuthFacade(AuthService authService, SystemUserService systemUserService) {

        this.authService = authService;
        this.systemUserService = systemUserService;
    }

    public LoginResponseDTO authenticateUser(@Valid LoginRequestDTO requestDTO) {
        LoginResponseDTO loginResponseDTO = systemUserService.getUserByUserName(requestDTO);
        String jwtToken =   authService.auth(requestDTO);
        loginResponseDTO.setAccessToken(jwtToken);
        return loginResponseDTO;
    }

}
