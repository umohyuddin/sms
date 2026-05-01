package com.smartsolutions.eschool.institute.service.impl;

import com.smartsolutions.eschool.global.error.ApiException;
import com.smartsolutions.eschool.institute.dtos.financialSettings.requestDto.CampusFinancialSettingsRequestDTO;
import com.smartsolutions.eschool.institute.dtos.financialSettings.responseDto.CampusFinancialSettingsResponseDTO;
import com.smartsolutions.eschool.institute.entity.CampusFinancialSettings;
import com.smartsolutions.eschool.institute.error.CampusFinancialSettingsErrors;
import com.smartsolutions.eschool.institute.mapper.CampusFinancialSettingsMapper;
import com.smartsolutions.eschool.institute.repository.CampusFinancialSettingsRepository;
import com.smartsolutions.eschool.institute.service.CampusFinancialSettingsService;
import com.smartsolutions.eschool.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CampusFinancialSettingsServiceImpl implements CampusFinancialSettingsService {

    private final CampusFinancialSettingsRepository repository;

    @Override
    @Transactional(readOnly = true)
    public CampusFinancialSettingsResponseDTO getByCampusAndAcademicYear(Long campusId, Long academicYearId) {
        log.info("[Service:CampusFinancialSettingsServiceImpl] getByCampusAndAcademicYear() called - campus: {}, year: {}",
                campusId, academicYearId);

        CampusFinancialSettings settings = repository
                .findByCampusIdAndAcademicYearIdJpql(campusId, academicYearId)
                .orElseThrow(() -> new ApiException(
                        CampusFinancialSettingsErrors.CAMPUS_FINANCIAL_SETTINGS_NOT_FOUND, HttpStatus.NOT_FOUND));

        return CampusFinancialSettingsMapper.toDTO(settings);
    }

    @Override
    @Transactional
    public CampusFinancialSettingsResponseDTO create(CampusFinancialSettingsRequestDTO requestDTO) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(CampusFinancialSettingsErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info(
                "[Service:CampusFinancialSettingsServiceImpl] create() called - campus: {}, year: {}, institute_context: {}",
                requestDTO.getCampusId(), requestDTO.getAcademicYearId(), contextInstituteId);

        // Security Check: Ensure request institute matches context
        if (!contextInstituteId.equals(requestDTO.getInstituteId())) {
            throw new ApiException(CampusFinancialSettingsErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }

        // Check if settings already exist for this campus and academic year
        repository.findByCampusIdAndAcademicYearIdJpql(requestDTO.getCampusId(), requestDTO.getAcademicYearId())
                .ifPresent(existing -> {
                    throw new ApiException(CampusFinancialSettingsErrors.CAMPUS_FINANCIAL_SETTINGS_ALREADY_EXISTS,
                            HttpStatus.CONFLICT);
                });

        CampusFinancialSettings entity = CampusFinancialSettingsMapper.toEntity(requestDTO);
        CampusFinancialSettings saved = repository.save(entity);

        log.info("[Service:CampusFinancialSettingsServiceImpl] create() succeeded - ID: {}", saved.getId());
        return CampusFinancialSettingsMapper.toDTO(saved);
    }

    @Override
    @Transactional
    public CampusFinancialSettingsResponseDTO update(Long id, CampusFinancialSettingsRequestDTO requestDTO) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(CampusFinancialSettingsErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:CampusFinancialSettingsServiceImpl] update() called - ID: {}, context: {}", id,
                contextInstituteId);

        CampusFinancialSettings existing = repository.findByIdAndInstituteIdJpql(id, contextInstituteId)
                .orElseThrow(() -> new ApiException(
                        CampusFinancialSettingsErrors.CAMPUS_FINANCIAL_SETTINGS_NOT_FOUND, HttpStatus.NOT_FOUND));

        CampusFinancialSettingsMapper.updateEntityFromDTO(requestDTO, existing);
        CampusFinancialSettings updated = repository.save(existing);

        log.info("[Service:CampusFinancialSettingsServiceImpl] update() succeeded - ID: {}", id);
        return CampusFinancialSettingsMapper.toDTO(updated);
    }

    @Override
    @Transactional
    public void softDeleteById(Long id) {
        Long contextInstituteId = SecurityUtils.getCurrentOrganizationId();
        if (contextInstituteId == null) {
            throw new ApiException(CampusFinancialSettingsErrors.ORGANIZATION_ACCESS_DENIED, HttpStatus.FORBIDDEN);
        }
        log.info("[Service:CampusFinancialSettingsServiceImpl] softDeleteById() called - ID: {}, context: {}", id,
                contextInstituteId);

        CampusFinancialSettings settings = repository.findByIdAndInstituteIdJpql(id, contextInstituteId)
                .orElseThrow(() -> new ApiException(
                        CampusFinancialSettingsErrors.CAMPUS_FINANCIAL_SETTINGS_NOT_FOUND, HttpStatus.NOT_FOUND));

        settings.setIsDeleted(true);
        repository.save(settings);

        log.info("[Service:CampusFinancialSettingsServiceImpl] softDeleteById() succeeded - ID: {}", id);
    }
}
