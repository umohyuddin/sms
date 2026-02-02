package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.requestDto.InstituteAcademicOfferingCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.requestDto.InstituteAcademicOfferingUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.responseDto.InstituteAcademicOfferingResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface InstituteAcademicOfferingService {
    InstituteAcademicOfferingResponseDTO createOffering(InstituteAcademicOfferingCreateRequestDTO requestDTO);

    Page<InstituteAcademicOfferingResponseDTO> getAll(Pageable pageable);

    Page<InstituteAcademicOfferingResponseDTO> getByInstituteId(Long instituteId, Pageable pageable);

    InstituteAcademicOfferingResponseDTO getById(Long id);

    InstituteAcademicOfferingResponseDTO updateOffering(Long id, InstituteAcademicOfferingUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<InstituteAcademicOfferingResponseDTO> searchByKeyword(String keyword);
}
