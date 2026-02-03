package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteLanguages.requestDto.InstituteLanguageCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteLanguages.responseDto.InstituteLanguageResponseDTO;
import java.util.List;

public interface InstituteLanguageService {
    InstituteLanguageResponseDTO addLanguage(InstituteLanguageCreateRequestDTO requestDTO);

    InstituteLanguageResponseDTO getById(Long instituteId, Long languageId);

    List<InstituteLanguageResponseDTO> getByInstituteId(Long instituteId);

    void delete(Long instituteId, Long languageId);
}
