package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteLanguages.requestDto.InstituteLanguageCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteLanguages.responseDto.InstituteLanguageResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InstituteLanguageService {
    InstituteLanguageResponseDTO addLanguage(InstituteLanguageCreateRequestDTO requestDTO);

    InstituteLanguageResponseDTO getById(Long instituteId, Long languageId);

    Page<InstituteLanguageResponseDTO> getByInstituteId(Long instituteId, Pageable pageable);

    void delete(Long instituteId, Long languageId);
}
