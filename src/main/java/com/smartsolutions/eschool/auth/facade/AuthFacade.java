package com.smartsolutions.eschool.auth.facade;

import com.smartsolutions.eschool.auth.dtos.auth.requestDto.LoginRequestDTO;
import com.smartsolutions.eschool.auth.dtos.auth.responseDto.LoginResponseDTO;
import com.smartsolutions.eschool.auth.service.AuthService;
import com.smartsolutions.eschool.school.dtos.academicYear.requestDto.AcademicYearRequestDTO;
import com.smartsolutions.eschool.school.dtos.academicYear.responseDto.AcademicYearResponseDTO;
import com.smartsolutions.eschool.school.service.AcademicYearService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class AuthFacade {


    private final AuthService authService;

    public AuthFacade(AuthService authService) {

        this.authService = authService;
    }

    public LoginResponseDTO createAcademicYear(@Valid LoginRequestDTO requestDTO) {
        return authService.auth(requestDTO);
    }

}
