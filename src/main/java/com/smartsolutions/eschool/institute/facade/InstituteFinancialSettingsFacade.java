package com.smartsolutions.eschool.institute.facade;

import com.smartsolutions.eschool.institute.dtos.financialSettings.requestDto.FinancialSettingsRequestDTO;
import com.smartsolutions.eschool.institute.dtos.financialSettings.responseDto.FinancialSettingsResponseDTO;
import com.smartsolutions.eschool.institute.service.InstituteFinancialSettingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class InstituteFinancialSettingsFacade {

    private final InstituteFinancialSettingsService service;

    public FinancialSettingsResponseDTO getByInstituteAndAcademicYear(Long instituteId, Long academicYearId) {
        log.info("Facade: Fetching financial settings for institute: {} and academic year: {}", instituteId, academicYearId);
        return service.getByInstituteAndAcademicYear(instituteId, academicYearId);
    }

    public FinancialSettingsResponseDTO create(FinancialSettingsRequestDTO requestDTO) {
        log.info("Facade: Creating financial settings for institute: {}", requestDTO.getInstituteId());
        return service.create(requestDTO);
    }

    public FinancialSettingsResponseDTO update(Long id, FinancialSettingsRequestDTO requestDTO) {
        log.info("Facade: Updating financial settings with ID: {}", id);
        return service.update(id, requestDTO);
    }

    public void softDeleteById(Long id) {
        log.info("Facade: Soft deleting financial settings with ID: {}", id);
        service.softDeleteById(id);
    }
}
