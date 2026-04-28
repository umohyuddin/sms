package com.smartsolutions.eschool.lookups.facade;

import com.smartsolutions.eschool.lookups.dtos.curriculum.requestDto.CurriculumRequestDTO;
import com.smartsolutions.eschool.lookups.dtos.curriculum.responseDto.CurriculumResponseDTO;
import com.smartsolutions.eschool.lookups.service.CurriculumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class CurriculumFacade {
    private final CurriculumService curriculumService;

    public CurriculumFacade(CurriculumService curriculumService) {
        this.curriculumService = curriculumService;
    }

    public List<CurriculumResponseDTO> getAll() {
        log.info("[Facade:CurriculumFacade] getAll() called");
        return curriculumService.getAll();
    }

    public List<CurriculumResponseDTO> getAllActive() {
        log.info("[Facade:CurriculumFacade] getAllActive() called");
        return curriculumService.getAllActive();
    }

    public CurriculumResponseDTO getById(Long id) {
        log.info("[Facade:CurriculumFacade] getById() called - id: {}", id);
        return curriculumService.getById(id);
    }

    public List<CurriculumResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:CurriculumFacade] searchByKeyword() called - keyword: {}", keyword);
        return curriculumService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:CurriculumFacade] softDeleteById() called - id: {}", id);
        curriculumService.softDeleteById(id);
    }

    public CurriculumResponseDTO create(CurriculumRequestDTO dto) {
        log.info("[Facade:CurriculumFacade] create() called");
        return curriculumService.create(dto);
    }

    public CurriculumResponseDTO update(Long id, CurriculumRequestDTO dto) {
        log.info("[Facade:CurriculumFacade] update() called - id: {}", id);
        return curriculumService.update(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:CurriculumFacade] getStatistics() called");
        return curriculumService.getStatistics();
    }
}
