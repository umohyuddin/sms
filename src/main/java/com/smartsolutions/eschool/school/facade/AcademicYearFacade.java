package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.academicYear.requestDto.AcademicYearRequestDTO;
import com.smartsolutions.eschool.school.dtos.academicYear.responseDto.AcademicYearResponseDTO;
import com.smartsolutions.eschool.school.service.AcademicYearService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class AcademicYearFacade {


    private final AcademicYearService academicYearService;

    public AcademicYearFacade(AcademicYearService academicYearService) {
        this.academicYearService = academicYearService;
    }

    public AcademicYearResponseDTO createAcademicYear(@Valid AcademicYearRequestDTO requestDTO) {
        log.info("Facade: Request to create Academic Year: {}", requestDTO.getName());
        AcademicYearResponseDTO result = academicYearService.createAcademicYear(requestDTO);
        log.info("Facade: Academic Year created successfully with ID: {}", result.getId());
        return result;
    }

    public List<AcademicYearResponseDTO> getAll() {
        log.info("Facade: Request to fetch all Academic Years");
        List<AcademicYearResponseDTO> result = academicYearService.getAll();
        log.info("Facade: Successfully fetched {} Academic Years", result.size());
        return result;
    }

    public AcademicYearResponseDTO getCurrentAcademicYear() {
        log.info("Facade: Request to fetch current Academic Year");
        AcademicYearResponseDTO result = academicYearService.getCurrentAcademicYear();
        log.info("Facade: Successfully fetched current Academic Year ID: {}", result.getId());
        return result;
    }

    public List<AcademicYearResponseDTO> searchAcademicYears(String keyword) {
        log.info("Facade: Request to search Academic Years with keyword: '{}'", keyword);
        List<AcademicYearResponseDTO> result = academicYearService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} Academic Years", result.size());
        return result;
    }

    public AcademicYearResponseDTO getAcademicYearById(Long id) {
        log.info("Facade: Request to fetch Academic Year ID: {}", id);
        AcademicYearResponseDTO result = academicYearService.getAcademicYearById(id);
        log.info("Facade: Successfully fetched Academic Year ID: {}", id);
        return result;
    }

    public AcademicYearResponseDTO updateAcademicYear(Long id, @Valid AcademicYearRequestDTO requestDTO) {
        log.info("Facade: Request to update Academic Year ID: {}", id);
        AcademicYearResponseDTO result = academicYearService.updateAcademicYear(id, requestDTO);
        log.info("Facade: Successfully updated Academic Year ID: {}", id);
        return result;
    }

    public void makeAcademicYearCurrent(Long academicYearId) {
        log.info("Facade: Request to activate Academic Year ID: {}", academicYearId);
        academicYearService.makeAcademicYearCurrent(academicYearId);
        log.info("Facade: Successfully activated Academic Year ID: {}", academicYearId);
    }

    public void deleteAcademicYear(Long academicYearId) {
        log.info("Facade: Request to delete Academic Year ID: {}", academicYearId);
        academicYearService.deleteAcademicYear(academicYearId);
        log.info("Facade: Successfully deleted Academic Year ID: {}", academicYearId);
    }

    public void lockAcademicYear(Long id, AcademicYearRequestDTO request) {
        log.info("Facade: Request to lock Academic Year ID: {}", id);
        academicYearService.lockAcademicYear(id,request);
        log.info("Facade: Successfully locked Academic Year ID: {}", id);
    }

    public void archiveAcademicYear(Long id, AcademicYearRequestDTO request) {
        log.info("Facade: Request to archive Academic Year ID: {}", id);
        academicYearService.archiveAcademicYear(id,request);
        log.info("Facade: Successfully archived Academic Year ID: {}", id);
    }

    public void closeAcademicYear(Long id, AcademicYearRequestDTO request) {
        log.info("Facade: Request to close Academic Year ID: {}", id);
        academicYearService.closeAcademicYear(id, request);
        log.info("Facade: Successfully closed Academic Year ID: {}", id);
    }

    public AcademicYearResponseDTO createDefaultAcademicYear() {
        log.info("Facade: Request to create default Academic Year");
        AcademicYearResponseDTO result = academicYearService.createDefaultAcademicYear();
        if (result != null) {
            log.info("Facade: Default Academic Year created successfully with ID: {}", result.getId());
        } else {
            log.info("Facade: Default Academic Year creation skipped, year already exists");
        }
        return result;
    }
}
