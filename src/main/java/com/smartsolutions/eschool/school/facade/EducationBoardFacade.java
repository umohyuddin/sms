package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.educationBoards.requestDto.EducationBoardCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.educationBoards.requestDto.EducationBoardUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.educationBoards.responseDto.EducationBoardResponseDTO;
import com.smartsolutions.eschool.school.service.EducationBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
@Slf4j
public class EducationBoardFacade {

    private final EducationBoardService educationBoardService;

    public EducationBoardFacade(EducationBoardService educationBoardService) {
        this.educationBoardService = educationBoardService;
    }

    public EducationBoardResponseDTO createEducationBoard(EducationBoardCreateRequestDTO requestDTO) {
        log.info("Facade: Request to create EducationBoard: {}", requestDTO.getName());
        EducationBoardResponseDTO result = educationBoardService.createEducationBoard(requestDTO);
        log.info("Facade: Successfully created EducationBoard with id: {}", result.getId());
        return result;
    }

    public List<EducationBoardResponseDTO> getAll() {
        log.info("Facade: Request to fetch all EducationBoards");
        List<EducationBoardResponseDTO> result = educationBoardService.getAll();
        log.info("Facade: Successfully fetched {} EducationBoards", result.size());
        return result;
    }

    public List<EducationBoardResponseDTO> getAllActive() {
        log.info("Facade: Request to fetch all active EducationBoards");
        List<EducationBoardResponseDTO> result = educationBoardService.getAllActive();
        log.info("Facade: Successfully fetched {} active EducationBoards", result.size());
        return result;
    }

    public EducationBoardResponseDTO getById(Long id) {
        log.info("Facade: Request to fetch EducationBoard by id: {}", id);
        EducationBoardResponseDTO result = educationBoardService.getById(id);
        log.info("Facade: Successfully fetched EducationBoard: id={}", id);
        return result;
    }

    public EducationBoardResponseDTO updateEducationBoard(Long id, EducationBoardUpdateRequestDTO requestDTO) {
        log.info("Facade: Request to update EducationBoard id: {}", id);
        EducationBoardResponseDTO result = educationBoardService.updateEducationBoard(id, requestDTO);
        log.info("Facade: Successfully updated EducationBoard: id={}", result.getId());
        return result;
    }

    public void deleteById(Long id) {
        log.info("Facade: Request to delete EducationBoard by id: {}", id);
        educationBoardService.deleteById(id);
        log.info("Facade: Successfully deleted EducationBoard: id={}", id);
    }

    public List<EducationBoardResponseDTO> searchByKeyword(String keyword) {
        log.info("Facade: Request to search EducationBoards with keyword: '{}'", keyword);
        List<EducationBoardResponseDTO> result = educationBoardService.searchByKeyword(keyword);
        log.info("Facade: Search completed, found {} EducationBoards", result.size());
        return result;
    }

    public EducationBoardResponseDTO activate(Long id) {
        log.info("Facade: Request to activate EducationBoard id: {}", id);
        EducationBoardResponseDTO result = educationBoardService.activate(id);
        log.info("Facade: Successfully activated EducationBoard: id={}", id);
        return result;
    }

    public EducationBoardResponseDTO deactivate(Long id) {
        log.info("Facade: Request to deactivate EducationBoard id: {}", id);
        EducationBoardResponseDTO result = educationBoardService.deactivate(id);
        log.info("Facade: Successfully deactivated EducationBoard: id={}", id);
        return result;
    }
}
