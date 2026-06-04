package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.educationBoards.requestDto.EducationBoardRequestDTO;
import com.smartsolutions.eschool.school.dtos.educationBoards.responseDto.EducationBoardResponseDTO;
import com.smartsolutions.eschool.school.service.EducationBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Scope("prototype")
@Slf4j
public class EducationBoardFacade {

    private final EducationBoardService educationBoardService;

    public EducationBoardFacade(EducationBoardService educationBoardService) {
        this.educationBoardService = educationBoardService;
    }

    public List<EducationBoardResponseDTO> getAll() {
        log.info("[Facade:EducationBoardFacade] getAll() called");
        return educationBoardService.getAll();
    }

    public List<EducationBoardResponseDTO> getAllActive() {
        log.info("[Facade:EducationBoardFacade] getAllActive() called");
        return educationBoardService.getAllActive();
    }

    public EducationBoardResponseDTO getById(Long id) {
        log.info("[Facade:EducationBoardFacade] getById() called - id: {}", id);
        return educationBoardService.getById(id);
    }

    public List<EducationBoardResponseDTO> searchByKeyword(String keyword) {
        log.info("[Facade:EducationBoardFacade] searchByKeyword() called - keyword: {}", keyword);
        return educationBoardService.searchByKeyword(keyword);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:EducationBoardFacade] softDeleteById() called - id: {}", id);
        educationBoardService.softDeleteById(id);
    }

    public EducationBoardResponseDTO createEducationBoard(EducationBoardRequestDTO dto) {
        log.info("[Facade:EducationBoardFacade] createEducationBoard() called");
        return educationBoardService.createEducationBoard(dto);
    }

    public EducationBoardResponseDTO updateEducationBoard(Long id, EducationBoardRequestDTO dto) {
        log.info("[Facade:EducationBoardFacade] updateEducationBoard() called - id: {}", id);
        return educationBoardService.updateEducationBoard(id, dto);
    }

    public Map<String, Long> getStatistics() {
        log.info("[Facade:EducationBoardFacade] getStatistics() called");
        return educationBoardService.getStatistics();
    }
}
