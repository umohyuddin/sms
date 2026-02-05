package com.smartsolutions.eschool.institute.service;

import com.smartsolutions.eschool.institute.dtos.financialSettings.requestDto.FinancialSettingsRequestDTO;
import com.smartsolutions.eschool.institute.dtos.financialSettings.responseDto.FinancialSettingsResponseDTO;

public interface InstituteFinancialSettingsService {

    FinancialSettingsResponseDTO getByInstituteAndAcademicYear(Long instituteId, Long academicYearId);

    FinancialSettingsResponseDTO create(FinancialSettingsRequestDTO requestDTO);

    FinancialSettingsResponseDTO update(Long id, FinancialSettingsRequestDTO requestDTO);

    void softDeleteById(Long id);
}
