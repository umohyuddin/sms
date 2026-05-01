package com.smartsolutions.eschool.institute.service;

import com.smartsolutions.eschool.institute.dtos.financialSettings.requestDto.CampusFinancialSettingsRequestDTO;
import com.smartsolutions.eschool.institute.dtos.financialSettings.responseDto.CampusFinancialSettingsResponseDTO;

public interface CampusFinancialSettingsService {

    CampusFinancialSettingsResponseDTO getByCampusAndAcademicYear(Long campusId, Long academicYearId);

    CampusFinancialSettingsResponseDTO create(CampusFinancialSettingsRequestDTO requestDTO);

    CampusFinancialSettingsResponseDTO update(Long id, CampusFinancialSettingsRequestDTO requestDTO);

    void softDeleteById(Long id);
}
