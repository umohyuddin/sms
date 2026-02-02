package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.educationBoards.requestDto.EducationBoardCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.educationBoards.requestDto.EducationBoardUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.educationBoards.responseDto.EducationBoardResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EducationBoardService {
    EducationBoardResponseDTO createEducationBoard(EducationBoardCreateRequestDTO requestDTO);

    Page<EducationBoardResponseDTO> getAll(Pageable pageable);

    List<EducationBoardResponseDTO> getAllActive();

    EducationBoardResponseDTO getById(Long id);

    EducationBoardResponseDTO updateEducationBoard(Long id, EducationBoardUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<EducationBoardResponseDTO> searchByKeyword(String keyword);

    EducationBoardResponseDTO activate(Long id);

    EducationBoardResponseDTO deactivate(Long id);
}
