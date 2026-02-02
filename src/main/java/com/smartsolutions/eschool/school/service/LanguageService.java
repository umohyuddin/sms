package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.languages.requestDto.LanguageCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.languages.requestDto.LanguageUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.languages.responseDto.LanguageResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LanguageService {
    LanguageResponseDTO createLanguage(LanguageCreateRequestDTO requestDTO);

    Page<LanguageResponseDTO> getAll(Pageable pageable);

    LanguageResponseDTO getById(Long id);

    LanguageResponseDTO updateLanguage(Long id, LanguageUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<LanguageResponseDTO> searchByKeyword(String keyword);
}
