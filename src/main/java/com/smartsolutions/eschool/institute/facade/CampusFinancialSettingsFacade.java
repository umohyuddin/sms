package com.smartsolutions.eschool.institute.facade;

import com.smartsolutions.eschool.institute.dtos.financialSettings.requestDto.CampusFinancialSettingsRequestDTO;
import com.smartsolutions.eschool.institute.dtos.financialSettings.responseDto.CampusFinancialSettingsResponseDTO;
import com.smartsolutions.eschool.institute.service.CampusFinancialSettingsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CampusFinancialSettingsFacade {

    private final CampusFinancialSettingsService service;

    public CampusFinancialSettingsResponseDTO getByCampusAndAcademicYear(Long campusId, Long academicYearId) {
        log.info(
                "[Facade:CampusFinancialSettingsFacade] getByCampusAndAcademicYear() called - campus: {}, year: {}",
                campusId, academicYearId);
        return service.getByCampusAndAcademicYear(campusId, academicYearId);
    }

    public CampusFinancialSettingsResponseDTO create(CampusFinancialSettingsRequestDTO requestDTO) {
        log.info("[Facade:CampusFinancialSettingsFacade] create() called - campus: {}",
                requestDTO.getCampusId());
        return service.create(requestDTO);
    }

    public CampusFinancialSettingsResponseDTO update(Long id, CampusFinancialSettingsRequestDTO requestDTO) {
        log.info("[Facade:CampusFinancialSettingsFacade] update() called - ID: {}", id);
        return service.update(id, requestDTO);
    }

    public void softDeleteById(Long id) {
        log.info("[Facade:CampusFinancialSettingsFacade] softDeleteById() called - ID: {}", id);
        service.softDeleteById(id);
    }
}
