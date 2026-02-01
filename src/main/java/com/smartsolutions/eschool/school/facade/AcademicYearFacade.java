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

    public AcademicYearResponseDTO createAcademicYear(@Valid AcademicYearRequestDTO requestDTO) {
        return academicYearService.createAcademicYear(requestDTO);
    }

    public List<AcademicYearResponseDTO> getAll() {
        return academicYearService.getAll();
    }

    public AcademicYearResponseDTO getCurrentAcademicYear() {
        return academicYearService.getCurrentAcademicYear();
    }

    public List<AcademicYearResponseDTO> searchAcademicYears(String keyword) {
        return academicYearService.searchByKeyword(keyword);
    }

    public AcademicYearResponseDTO getAcademicYearById(Long id) {
        return academicYearService.getAcademicYearById(id);
    }

    public AcademicYearResponseDTO updateAcademicYear(Long id, @Valid AcademicYearRequestDTO requestDTO) {
        return academicYearService.updateAcademicYear(id, requestDTO);
    }

    public void makeAcademicYearCurrent(Long academicYearId) {
        academicYearService.makeAcademicYearCurrent(academicYearId);
    }

    public void deleteAcademicYear(Long academicYearId) {
        academicYearService.deleteAcademicYear(academicYearId);
    }

    public void lockAcademicYear(Long id, AcademicYearRequestDTO request) {
        academicYearService.lockAcademicYear(id,request);
    }

    public void archiveAcademicYear(Long id, AcademicYearRequestDTO request) {
        academicYearService.archiveAcademicYear(id,request);
    }

    public void closeAcademicYear(Long id, AcademicYearRequestDTO request) {
        academicYearService.closeAcademicYear(id, request);
    }

    public AcademicYearResponseDTO createDefaultAcademicYear() {
        return academicYearService.createDefaultAcademicYear();
    }
}
