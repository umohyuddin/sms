package com.smartsolutions.eschool.school.facade;

import com.smartsolutions.eschool.school.dtos.educationBoards.requestDto.EducationBoardCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.educationBoards.requestDto.EducationBoardUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.educationBoards.responseDto.EducationBoardResponseDTO;
import com.smartsolutions.eschool.school.service.EducationBoardService;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class EducationBoardFacade {

    private final EducationBoardService educationBoardService;

    public EducationBoardFacade(EducationBoardService educationBoardService) {
        this.educationBoardService = educationBoardService;
    }

    public EducationBoardResponseDTO createEducationBoard(EducationBoardCreateRequestDTO requestDTO) {
        return educationBoardService.createEducationBoard(requestDTO);
    }

    public Page<EducationBoardResponseDTO> getAll(Pageable pageable) {
        return educationBoardService.getAll(pageable);
    }

    public List<EducationBoardResponseDTO> getAllActive() {
        return educationBoardService.getAllActive();
    }

    public EducationBoardResponseDTO getById(Long id) {
        return educationBoardService.getById(id);
    }

    public EducationBoardResponseDTO updateEducationBoard(Long id, EducationBoardUpdateRequestDTO requestDTO) {
        return educationBoardService.updateEducationBoard(id, requestDTO);
    }

    public void deleteById(Long id) {
        educationBoardService.deleteById(id);
    }

    public List<EducationBoardResponseDTO> searchByKeyword(String keyword) {
        return educationBoardService.searchByKeyword(keyword);
    }

    public EducationBoardResponseDTO activate(Long id) {
        return educationBoardService.activate(id);
    }

    public EducationBoardResponseDTO deactivate(Long id) {
        return educationBoardService.deactivate(id);
    }
}
