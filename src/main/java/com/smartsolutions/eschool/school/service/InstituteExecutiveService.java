package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteExecutives.requestDto.InstituteExecutiveCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteExecutives.requestDto.InstituteExecutiveUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteExecutives.responseDto.InstituteExecutiveResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InstituteExecutiveService {
    InstituteExecutiveResponseDTO createExecutive(InstituteExecutiveCreateRequestDTO requestDTO);

    Page<InstituteExecutiveResponseDTO> getAll(Pageable pageable);

    Page<InstituteExecutiveResponseDTO> getByInstituteId(Long instituteId, Pageable pageable);

    InstituteExecutiveResponseDTO getById(Long id);

    InstituteExecutiveResponseDTO updateExecutive(Long id, InstituteExecutiveUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<InstituteExecutiveResponseDTO> searchByKeyword(String keyword);
}
