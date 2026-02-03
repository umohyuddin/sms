package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.languages.requestDto.LanguageCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.languages.requestDto.LanguageUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.languages.responseDto.LanguageResponseDTO;
import java.util.List;

public interface LanguageService {
    LanguageResponseDTO createLanguage(LanguageCreateRequestDTO requestDTO);

    List<LanguageResponseDTO> getAll();

    LanguageResponseDTO getById(Long id);

    LanguageResponseDTO updateLanguage(Long id, LanguageUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<LanguageResponseDTO> searchByKeyword(String keyword);
}
