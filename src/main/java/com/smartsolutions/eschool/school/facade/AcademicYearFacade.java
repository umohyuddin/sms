package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.academicYear.requestDto.AcademicYearRequestDTO;
import com.smartsolutions.eschool.school.dtos.academicYear.responseDto.AcademicYearResponseDTO;
import com.smartsolutions.eschool.school.service.AcademicYearService;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class AcademicYearFacade {


    private final AcademicYearService academicYearService;

    public AcademicYearFacade(AcademicYearService academicYearService) {
        this.academicYearService = academicYearService;
    }

    public AcademicYearRequestDTO createAcademicYear(@Valid AcademicYearRequestDTO requestDTO) {
        return academicYearService.createAcademicYear(requestDTO);
    }

    public List<AcademicYearResponseDTO> getAll() {
        return academicYearService.getAll();
    }

    public AcademicYearResponseDTO getCurrentAcademicYear() {
        return academicYearService.getCurrentAcademicYear();
    }
}
