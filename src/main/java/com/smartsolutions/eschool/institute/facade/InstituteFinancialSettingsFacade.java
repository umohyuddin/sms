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
        log.info(
                "[Facade:InstituteFinancialSettingsFacade] getByInstituteAndAcademicYear() called - institute: {}, year: {}",
                instituteId, academicYearId);
        return service.getByInstituteAndAcademicYear(instituteId, academicYearId);
    }

    public FinancialSettingsResponseDTO create(FinancialSettingsRequestDTO requestDTO) {
        log.info("[Facade:InstituteFinancialSettingsFacade] create() called - institute: {}",
                requestDTO.getInstituteId());
        return service.create(requestDTO);
    }

    public FinancialSettingsResponseDTO update(Long id, FinancialSettingsRequestDTO requestDTO) {
        log.info("[Facade:InstituteFinancialSettingsFacade] update() called - ID: {}", id);
        return service.update(id, requestDTO);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:InstituteFinancialSettingsFacade] softDeleteById() called - ID: {}", id);
        service.softDeleteById(id);
    }
}
