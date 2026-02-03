package com.smartsolutions.eschool.school.service;

import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.requestDto.InstituteAcademicOfferingCreateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.requestDto.InstituteAcademicOfferingUpdateRequestDTO;
import com.smartsolutions.eschool.school.dtos.instituteAcademicOfferings.responseDto.InstituteAcademicOfferingResponseDTO;
import java.util.List;

public interface InstituteAcademicOfferingService {
    InstituteAcademicOfferingResponseDTO createOffering(InstituteAcademicOfferingCreateRequestDTO requestDTO);

    List<InstituteAcademicOfferingResponseDTO> getAll();

    List<InstituteAcademicOfferingResponseDTO> getByInstituteId(Long instituteId);

    InstituteAcademicOfferingResponseDTO getById(Long id);

    InstituteAcademicOfferingResponseDTO updateOffering(Long id, InstituteAcademicOfferingUpdateRequestDTO requestDTO);

    void deleteById(Long id);

    List<InstituteAcademicOfferingResponseDTO> searchByKeyword(String keyword);
}
