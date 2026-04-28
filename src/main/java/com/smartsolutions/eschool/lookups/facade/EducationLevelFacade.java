package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.educationLevel.requestDto.EducationLevelRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.educationLevel.responseDto.EducationLevelResponseDTO;
import com.smartsolutions.eschool.lookups.service.EducationLevelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class EducationLevelFacade {
    private final EducationLevelService educationLevelService;

    public EducationLevelFacade(EducationLevelService educationLevelService) {
        this.educationLevelService = educationLevelService;
    }

    public List<EducationLevelResponseDTO> getAll() {
        log.info("[Facade:EducationLevelFacade] getAll() called");
        return educationLevelService.getAll();
    }

    public List<EducationLevelResponseDTO> getAllActive() {
        log.info("[Facade:EducationLevelFacade] getAllActive() called");
        return educationLevelService.getAllActive();
    }

    public EducationLevelResponseDTO getById(Long id) {
        log.info("[Facade:EducationLevelFacade] getById() called - id: {}", id);
        return educationLevelService.getById(id);
    }

    public List<EducationLevelResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:EducationLevelFacade] searchByKeyword() called - keyword: {}", keyword);
        return educationLevelService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:EducationLevelFacade] softDeleteById() called - id: {}", id);
        educationLevelService.softDeleteById(id);
    }

    public EducationLevelResponseDTO create(EducationLevelRequestDTO dto) {
        log.info("[Facade:EducationLevelFacade] create() called");
        return educationLevelService.create(dto);
    }

    public EducationLevelResponseDTO update(Long id, EducationLevelRequestDTO dto) {
        log.info("[Facade:EducationLevelFacade] update() called - id: {}", id);
        return educationLevelService.update(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:EducationLevelFacade] getStatistics() called");
        return educationLevelService.getStatistics();
    }
}
