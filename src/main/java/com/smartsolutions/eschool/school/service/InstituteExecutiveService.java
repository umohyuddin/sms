package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteExecutives.requestDto.InstituteExecutiveCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteExecutives.requestDto.InstituteExecutiveUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteExecutives.responseDto.InstituteExecutiveResponseDTO;
import java.util.List;

public interface InstituteExecutiveService {
    InstituteExecutiveResponseDTO createExecutive(InstituteExecutiveCreateRequestDTO requestDTO);

    List<InstituteExecutiveResponseDTO> getAll();

    List<InstituteExecutiveResponseDTO> getByInstituteId(Long instituteId);

    InstituteExecutiveResponseDTO getById(Long id);

    InstituteExecutiveResponseDTO updateExecutive(Long id, InstituteExecutiveUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<InstituteExecutiveResponseDTO> searchByKeyword(String keyword);
}
