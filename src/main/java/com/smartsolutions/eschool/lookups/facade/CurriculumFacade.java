package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.curriculum.requestDto.CurriculumRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.curriculum.responseDto.CurriculumResponseDTO;
import com.smartsolutions.eschool.lookups.service.CurriculumService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurriculumFacade {
    private final CurriculumService curriculumService;

    public CurriculumFacade(CurriculumService curriculumService) {
        this.curriculumService = curriculumService;
    }

    public CurriculumResponseDTO create(@Valid CurriculumRequestDTO dto) {
        return curriculumService.create(dto);
    }

    public List<CurriculumResponseDTO> getAllActive() {
        return curriculumService.getAllActive();
    }

    public CurriculumResponseDTO getById(Long id) {
        return curriculumService.getById(id);
    }

    public CurriculumResponseDTO update(Long id, @Valid CurriculumRequestDTO dto) {
        return curriculumService.update(id, dto);
    }

    public int softDeleteById(Long id) {
        return curriculumService.softDeleteById(id);
    }
}
