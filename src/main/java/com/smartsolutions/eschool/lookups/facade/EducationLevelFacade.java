package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.educationLevel.requestDto.EducationLevelRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.educationLevel.responseDto.EducationLevelResponseDTO;
import com.smartsolutions.eschool.lookups.service.EducationLevelService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EducationLevelFacade {
    private final EducationLevelService educationLevelService;

    public EducationLevelFacade(EducationLevelService educationLevelService) {
        this.educationLevelService = educationLevelService;
    }

    public EducationLevelResponseDTO create(@Valid EducationLevelRequestDTO dto) {
        return educationLevelService.create(dto);
    }

    public List<EducationLevelResponseDTO> getAllActive() {
        return educationLevelService.getAllActive();
    }

    public EducationLevelResponseDTO getById(Long id) {
        return educationLevelService.getById(id);
    }

    public EducationLevelResponseDTO update(Long id, @Valid EducationLevelRequestDTO dto) {
        return educationLevelService.update(id, dto);
    }

    public int softDeleteById(Long id) {
        return educationLevelService.softDeleteById(id);
    }
}
