package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto.SchoolTypeCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.schoolTypes.requestDto.SchoolTypeUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.schoolTypes.responseDto.SchoolTypeResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SchoolTypeService {
    SchoolTypeResponseDTO createSchoolType(SchoolTypeCreateRequestDTO requestDTO);

    List<SchoolTypeResponseDTO> getAll();

    List<SchoolTypeResponseDTO> getAllActive();

    SchoolTypeResponseDTO getById(Long id);

    SchoolTypeResponseDTO updateSchoolType(Long id, SchoolTypeUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<SchoolTypeResponseDTO> searchByKeyword(String keyword);

    SchoolTypeResponseDTO activate(Long id);

    SchoolTypeResponseDTO deactivate(Long id);
}
